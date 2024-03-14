package com.chadium.chadiumapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.oauth2.client.oidc.authentication.OidcIdTokenDecoderFactory;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/error", "/oauth/**","/webjars/**", "login/**").permitAll()
                                .anyRequest().permitAll()
                )
                .oauth2Login(outh2->outh2.defaultSuccessUrl("/login/success"))
                ;
        return http.build();
    }


    @Bean
    public JwtDecoderFactory<ClientRegistration> idTokenDecoderFactory() {
        OidcIdTokenDecoderFactory idTokenDecoderFactory = new OidcIdTokenDecoderFactory();
        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer("accounts.google.com");
        idTokenDecoderFactory.setJwtValidatorFactory(clientRegistration -> withIssuer);
        return idTokenDecoderFactory;
    }
}