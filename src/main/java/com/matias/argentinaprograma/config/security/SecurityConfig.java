package com.matias.argentinaprograma.config.security;

import com.matias.argentinaprograma.config.security.common.Role;
import com.matias.argentinaprograma.config.security.filter.CustomAccessDeniedHandler;
import com.matias.argentinaprograma.config.security.filter.CustomAuthenticationEntryPoint;
import com.matias.argentinaprograma.config.security.filter.JwtRequestFilter;
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

@EnableWebSecurity
@Configuration
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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

				.antMatchers(HttpMethod.POST, "/api/auth/register").permitAll()
				.antMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
				.antMatchers(HttpMethod.GET, "/api/auth/me").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
				
				.antMatchers(HttpMethod.GET, "/api/users").hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.DELETE, "/api/users/{id}").hasRole(Role.ADMIN.name())
				.antMatchers(HttpMethod.PATCH, "/api/users/{id}").hasRole(Role.ADMIN.name())

				.antMatchers(HttpMethod.GET, "/api/trabajo").permitAll()
				.antMatchers(HttpMethod.GET, "/api/trabajo/{id}").permitAll()
				.antMatchers(HttpMethod.POST, "/api/trabajo").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
				.antMatchers(HttpMethod.PUT, "/api/trabajo/{id}").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
				.antMatchers(HttpMethod.DELETE, "/api/trabajo").hasAnyRole(Role.USER.name(), Role.ADMIN.name())

				.antMatchers(HttpMethod.GET, "/api/estudio").permitAll()
				.antMatchers(HttpMethod.GET, "/api/estudio/{id}").permitAll()
				.antMatchers(HttpMethod.POST, "/api/estudio").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
				.antMatchers(HttpMethod.PUT, "/api/estudio/{id}").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
				.antMatchers(HttpMethod.DELETE, "/api/estudio").hasAnyRole(Role.USER.name(), Role.ADMIN.name())

				.antMatchers(HttpMethod.GET, "/api/habilidad").permitAll()
				.antMatchers(HttpMethod.GET, "/api/habilidad/{id}").permitAll()
				.antMatchers(HttpMethod.POST, "/api/habilidad").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
				.antMatchers(HttpMethod.PUT, "/api/habilidad/{id}").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
				.antMatchers(HttpMethod.DELETE, "/api/habilidad").hasAnyRole(Role.USER.name(), Role.ADMIN.name())

				.antMatchers(HttpMethod.GET, "/api/datos/{id}").permitAll()
				.antMatchers(HttpMethod.PUT, "/api/datos/{id}").hasAnyRole(Role.USER.name(), Role.ADMIN.name())

				.anyRequest().authenticated().and()
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class).exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(authenticationEntryPoint());
	}

}