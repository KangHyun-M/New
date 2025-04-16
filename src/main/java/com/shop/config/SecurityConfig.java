package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((auth)->auth 
				.requestMatchers("/","/login","/sign").permitAll()
				.requestMatchers("/admin**").hasAnyRole("ADMIN")
				.requestMatchers("/user**").hasAnyRole("ADMIN","USER")
				.anyRequest().authenticated()
		);
		
		http.sessionManagement((auth)-> auth
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				);
		
		http.formLogin((auth) -> auth
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/", true)
				.failureUrl("/login?error")
				.permitAll()
				);
		
		http.sessionManagement((auth) -> auth
				.sessionFixation()
				.changeSessionId()
				);
		
		http.logout((auth)-> auth
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				);
		
		//http.csrf((auth)-> auth.disable()); //개발 완료후 활성화
		
		return http.build();
	}
}
