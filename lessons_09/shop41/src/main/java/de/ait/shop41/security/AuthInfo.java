package de.ait.shop41.security;

import de.ait.shop41.role.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@EqualsAndHashCode
public class AuthInfo implements Authentication {
    // этот объект хранит информацию о нашем пользователе
    private boolean authenticated;
    private String username;
    private Set<Role> roles;

    public AuthInfo(String username, Set<Role> roles) {
        this.username = username;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        // возвращает детали авторизации
        return null;
    }

    @Override
    public Object getPrincipal() {
        // гетер для юзернаме
        return null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        // сетер для аутентификации
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        // должен вернуть реальное имя пользователя
        return username;
    }


}
