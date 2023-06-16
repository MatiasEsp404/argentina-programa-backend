package com.matias.argentinaprograma.config.security.constants;

public abstract class Paths {

	public static final String AUTH = "/api/auth";
	public static final String USERS = "/api/users";
	
	public static final String REGISTER = "/register";
	public static final String LOGIN = "/login";
	public static final String ME = "/me";
	
	public static final String ID = "/{id:^\\d+$}";
	
	public static final String PAGE = "?page={page:[\\d+]}&size={size:[\\d+]}";
	public static final String DOCUMENTATION_PATHS = "/api/docs/**";

	public static final String TRABAJO = "/api/trabajo";
	public static final String HABILIDAD = "/api/habilidad";
	public static final String ESTUDIO = "/api/estudio";
}
