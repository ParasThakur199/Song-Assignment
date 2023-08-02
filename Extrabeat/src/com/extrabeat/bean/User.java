package com.extrabeat.bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
	private String username;
	private String email;
	private String password;
	private String preferences;
	private Role role;

	public User() {
	}

	public User(String username, String email, String password, String preferences, Role role) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.preferences = preferences;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, preferences, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(preferences, other.preferences) && role == other.role
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", preferences="
				+ preferences + ", role=" + role + "]";
	}

	

	
}
