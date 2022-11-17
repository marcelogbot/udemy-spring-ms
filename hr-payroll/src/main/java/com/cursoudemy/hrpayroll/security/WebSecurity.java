package com.cursoudemy.hrpayroll.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/payment/**")
                    .hasAuthority("SCOPE_profile")
                .anyRequest().authenticated()
                .and()
            .oauth2ResourceServer()
            .jwt();

		return http.build();
	}
   
    
}
