package de.ait.shop41.security.sec_config;

import de.ait.shop41.security.sec_filter.TokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringConfig {

    private final TokenFilter filter;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers(HttpMethod.GET, "products").permitAll()
                                .requestMatchers(HttpMethod.GET, "products/{$id}").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.PUT, "customers/**").anonymous()//.hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, "products/{$id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/auth/login", "/auth/refresh").permitAll()
                                .anyRequest().authenticated())
                .httpBasic(AbstractHttpConfigurer::disable)
                .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }

    //    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(
//                        auth -> auth.anyRequest().permitAll())
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//
//    }

}
