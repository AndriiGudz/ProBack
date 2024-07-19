package de.ait.shop41.security.sec_service;

import de.ait.shop41.security.sec_dto.TokenResponseDto;
import de.ait.shop41.user.User;
import de.ait.shop41.user.UserService;
import io.jsonwebtoken.Claims;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Map<String, String> refreshStorage = new HashMap<>();

    public TokenResponseDto login(User inboundUser) throws AuthException {
        String username = inboundUser.getUsername();
        User foundUser = (User)userService.loadUserByUsername(username);

        if(passwordEncoder.matches(inboundUser.getPassword(), foundUser.getPassword())) {
            // create tokens

            String accessToken = tokenService.generateAccessToken(foundUser);
            String refreshToken = tokenService.generateRefreshToken(foundUser);

            refreshStorage.put(username, refreshToken);

            return new TokenResponseDto(accessToken, refreshToken);
        } else {
            throw new AuthException("Login / Password not correct");
        }
    }

    public TokenResponseDto getNewAccessToken(String inboundRefreshToken) {
        Claims refreshClaims = tokenService.getRefreshClaims(inboundRefreshToken);
        String username = refreshClaims.getSubject();
        String savedRefreshToken = refreshStorage.get(username);

        if(savedRefreshToken != null && !refreshStorage.get(username).equals(savedRefreshToken)) {
            User user = (User) userService.loadUserByUsername(username);
            String accessToken = tokenService.generateAccessToken(user);
            return new TokenResponseDto(accessToken, null);
        } else {
            return new TokenResponseDto(null, null);
        }
    }

}
