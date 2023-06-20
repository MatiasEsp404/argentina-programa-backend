package com.matias.argentinaprograma.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.matias.argentinaprograma.config.security.constants.Paths;
import com.matias.argentinaprograma.config.security.common.Role;
import com.matias.argentinaprograma.config.security.filter.CustomAccessDeniedHandler;
import com.matias.argentinaprograma.config.security.filter.CustomAuthenticationEntryPoint;
import com.matias.argentinaprograma.config.security.filter.JwtRequestFilter;

@EnableWebSecurity
@Configuration
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter implements Paths {

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new CustomAuthenticationEntryPoint();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
		managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().authorizeRequests()

				.antMatchers(DOCUMENTATION_PATHS).permitAll()

				.antMatchers(HttpMethod.POST, AUTH + REGISTER).permitAll()
				.antMatchers(HttpMethod.POST, AUTH + LOGIN).permitAll()
				.antMatchers(HttpMethod.GET, AUTH + ME).hasAnyRole(Role.USER.name(), Role.ADMIN.name())
				
				.antMatchers(HttpMethod.GET, USERS).hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.DELETE, USERS + ID).hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.PATCH, USERS + ID).hasAnyRole(Role.USER.name(), Role.ADMIN.name())

				.antMatchers(HttpMethod.GET, TRABAJO).permitAll()
				.antMatchers(HttpMethod.GET, TRABAJO + ID).permitAll()
				.antMatchers(HttpMethod.POST, TRABAJO).hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.PUT, TRABAJO).hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.DELETE, TRABAJO).hasRole(Role.ADMIN.name())

				.antMatchers(HttpMethod.GET, ESTUDIO).permitAll()
				.antMatchers(HttpMethod.GET, ESTUDIO + ID).permitAll()
				.antMatchers(HttpMethod.POST, ESTUDIO).hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.PUT, ESTUDIO).hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.DELETE, ESTUDIO).hasRole(Role.ADMIN.name())

				.antMatchers(HttpMethod.GET, HABILIDAD).permitAll()
				.antMatchers(HttpMethod.GET, HABILIDAD + ID).permitAll()
				.antMatchers(HttpMethod.POST, HABILIDAD).hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.PUT, HABILIDAD).hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.DELETE, HABILIDAD).hasRole(Role.ADMIN.name())

				.anyRequest().authenticated().and()
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class).exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(authenticationEntryPoint());
	}

}