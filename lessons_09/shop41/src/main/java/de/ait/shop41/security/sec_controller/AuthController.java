package de.ait.shop41.security.sec_controller;

import de.ait.shop41.security.sec_dto.RefreshRequestDto;
import de.ait.shop41.security.sec_dto.TokenResponseDto;
import de.ait.shop41.security.sec_service.AuthService;
import de.ait.shop41.user.User;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody User user) {
        try {
            return service.login(user);
        } catch (AuthException e) {
            return new TokenResponseDto(null, null);
        }
    }

    @PostMapping("/refresh")
    public TokenResponseDto getAccessToken(@RequestBody RefreshRequestDto requestDto) {
        return service.getNewAccessToken(requestDto.getRefreshToken());
    }

}
