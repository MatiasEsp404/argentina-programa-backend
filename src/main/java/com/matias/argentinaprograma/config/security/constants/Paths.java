package com.matias.argentinaprograma.config.security.constants;

public interface Paths {

	String AUTH = "/api/auth";
	String USERS = "/api/users";
	
	String REGISTER = "/register";
	String LOGIN = "/login";
	String ME = "/me";
	
	String ID = "/{id:^\\d+$}";
	
	String PAGE = "?page={page:[\\d+]}&size={size:[\\d+]}";
	String DOCUMENTATION_PATHS = "/api/docs/**";

	String TRABAJO = "/api/trabajo";
	String HABILIDAD = "/api/habilidad";
	String ESTUDIO = "/api/estudio";
}
