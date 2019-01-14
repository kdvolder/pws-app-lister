package com.github.kdvolder.applister;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class PwsAppListerApplication extends WebSecurityConfigurerAdapter {

	@GetMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/**")
			.authorizeRequests()
	        	.antMatchers("/", "/login**", "/webjars/**", "/error**")
	        	.permitAll()
	      .anyRequest()
	        .authenticated();	
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PwsAppListerApplication.class, args);
	}

}

