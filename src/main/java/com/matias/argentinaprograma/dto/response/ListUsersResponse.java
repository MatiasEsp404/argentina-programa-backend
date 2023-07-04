package com.matias.argentinaprograma.dto.response;

import java.util.List;

public class ListUsersResponse {

	private List<UserResponse> users;

	public List<UserResponse> getUsers() {
		return users;
	}

	public void setUsers(List<UserResponse> users) {
		this.users = users;
	}
}
