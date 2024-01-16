package com.example.springsecuritybasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
@EnableWebSecurity(debug=true)
public class BasicConfiguration {

    @Autowired
    private Environment env;

    @GetMapping("/favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
        System.out.println("in here");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(corsConfig -> corsConfigurationSource())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/greet").permitAll()
                        .anyRequest()
                        .authenticated()

                );
        http.csrf(csrf -> csrf.disable());
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt(jwtConfigurer -> jwtConfigurer
//                                .jwtAuthenticationConverter(jwt -> {
//                                    List<String> roles = (List<String>) jwt.getClaimAsMap("realm_access").getOrDefault("roles", List.of());
//                                    SimpleAuthorityMapper authorityMapper = new SimpleAuthorityMapper();
//                                    Set<GrantedAuthority> authorities = authorityMapper.mapAuthorities(
//                                            roles.stream().map(SimpleGrantedAuthority::new).toList()
//                                    );
//                                    return new JwtAuthenticationToken(jwt, authorities);
//                                })
//                        )
//                );
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}