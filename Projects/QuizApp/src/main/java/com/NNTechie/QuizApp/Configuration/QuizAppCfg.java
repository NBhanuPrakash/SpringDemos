package com.NNTechie.QuizApp.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.NNTechie.QuizApp.Security.QuizAppJwtAuthFilter;
import com.NNTechie.QuizApp.Security.UserInfoUserDetailsService;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class QuizAppCfg {
	
	@Autowired
	private QuizAppJwtAuthFilter quizAppJwtAuthFilter;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserInfoUserDetailsService();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/add/user","/admin/access","/user/access","/login").permitAll()
		.requestMatchers("/admin/access/**").hasRole("ADMIN")
		.requestMatchers("/user/access/**").hasRole("USER")
//		.and().formLogin()
//		.and().build();
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider())
		.addFilterBefore(quizAppJwtAuthFilter, UsernamePasswordAuthenticationFilter.class).build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dAo = new DaoAuthenticationProvider();
		dAo.setUserDetailsService(userDetailsService());
		dAo.setPasswordEncoder(passwordEncoder());
		return dAo;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
