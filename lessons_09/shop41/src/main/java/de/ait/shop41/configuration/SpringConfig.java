package de.ait.shop41.configuration;

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

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringConfig {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(
                        auth -> auth.anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults());

        return http.build();

    }

//@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
//                .authorizeHttpRequests(
//                        auth -> auth.requestMatchers(HttpMethod.GET, "products").permitAll()
//                                .requestMatchers(HttpMethod.GET, "products/{$id}").hasAnyRole("ADMIN", "USER")
//                                .requestMatchers(HttpMethod.PUT, "customers/**").anonymous()//.hasAnyRole("ADMIN", "USER")
//                                .requestMatchers(HttpMethod.POST, "products/{$id}").hasRole("ADMIN")
//                                .anyRequest().permitAll()) //.authenticated())
//                .httpBasic(Customizer.withDefaults());
////        http.authorizeRequests().anyRequest().permitAll().and().csrf(AbstractHttpConfigurer::disable);
//
//        return http.build();
//
//    }

}
