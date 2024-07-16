package de.ait.shop41.user;

import de.ait.shop41.role.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Schema(description = "User Entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
// implements UserDetails - говорит что этот класс будет отвечать за Спринг Сикьюрити
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier of the user", example = "1")
    private Long id;

    @Column(name = "username")
    @Schema(description = "User Name", example = "Alex")
    private String username;

    @Column(name = "password")
    @Schema(description = "User Password", example = "qwerty12!")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    // Анотация помогает считывать информацию со связанной таблицы
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    public static void main(String[] args) {
//        new BCryptPasswordEncoder().encode("qwer");
//        // генерируем хеш для пароля
//    }


    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
}
