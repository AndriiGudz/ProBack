package de.ait.shop41.security.sec_service;

import de.ait.shop41.role.Role;
import de.ait.shop41.role.RoleRepository;
import de.ait.shop41.security.AuthInfo;
import de.ait.shop41.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TokenService {

    // для хранения access
    private SecretKey accessKey;
    private SecretKey refreshKey;
    private RoleRepository roleRepository;
    private final int ACCESS_TOKEN_EXPIRATION_TIME = 7;
    private final int REFRESH_TOKEN_EXPIRATION_TIME = 30;

    public TokenService(@Value("${key.access}") String accessSecretPhrase,
                        @Value("${key.refresh}") String refreshSecretPhrase,
                        @Autowired RoleRepository roleRepository) {

        this.accessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessSecretPhrase));
        this.refreshKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(refreshSecretPhrase));
        this.roleRepository = roleRepository;
    }

    public String generateAccessToken(User user) {
// генерируем AccessToken
        return Jwts.builder()
                        .subject(user.getUsername())
                                .expiration(calcExpirationDate(ACCESS_TOKEN_EXPIRATION_TIME))
                .signWith(accessKey)
                .claim("roles", user.getAuthorities())
                .claim("name", user.getUsername())
                .compact();
    }

    public String generateRefreshToken(User user) {
// генерируем RefreshToken
        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(calcExpirationDate(REFRESH_TOKEN_EXPIRATION_TIME))
                .signWith(refreshKey)
                .claim("roles", user.getAuthorities())
                .claim("name", user.getUsername())
                .compact();
    }

    private Date calcExpirationDate(int days) {
        // считаем сколько дней будет жить наш токен
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.plusDays(days)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        return Date.from(instant);
    }

    // метод который будет пракидывать, какой из токенов валидировать
    public boolean validateAccessToken(String token) {
        return validateToken(token, accessKey);
    }

    public boolean validateRefreshToken(String token) {
        return validateToken(token, refreshKey);
    }
    /////////

    private boolean validateToken(String token, SecretKey key) {
        // валидация Токена, ключа - один метод может валидировать и AccessToken и RefreshToken
        try {
        Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);

        return true;
        } catch (Exception e) {
            return false;
        }
    }
//      ________________________ вытягиваем из токена инфу, которая там зашита
    private Claims getClaims(String token, SecretKey key) {
        // Claims - возвращает информацию из токена о пользователе
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Claims getAccessClaims(String accessToken) {
        return getClaims(accessToken, accessKey);
    }

    public Claims getRefreshClaims(String refreshToken) {
        return getClaims(refreshToken, refreshKey);
    }
//     ________________________

    public AuthInfo mapClaimsTo(Claims claims) {
        // достаем имя пользователя
        String username = claims.getSubject();

        // достаем роли пользователя
        /*
        если пользователь имеет две роли,
        тогда каждый елемен листа будет содержать эту роль
         */
        List<LinkedHashMap<String, String>> listOfRolesHashMaps = (List<LinkedHashMap<String, String>>) claims.get("roles");

//        Set<Role> roleSet = new HashSet<>();
//        for (LinkedHashMap<String, String> roleMap : listOfRolesHashMaps) {
//            String roleTitle = roleMap.get("authority");
//            Role role = roleRepository.findByTitle(roleTitle).orElse(null);
//            if (role!=null) {
//                roleSet.add(role);
//            }
//        }

        Set<Role> roles = listOfRolesHashMaps.stream().map(roleHashMap -> roleHashMap.get("authority"))
                .map(roleTitle -> roleRepository.findByTitle(roleTitle).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        return new AuthInfo(username, roles);
    }



}
