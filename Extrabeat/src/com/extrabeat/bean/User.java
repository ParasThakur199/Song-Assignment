package com.extrabeat.bean;

import java.util.HashMap;
import java.util.Map;

public class User {
	private Integer userId;
	private String username;
	private String email;
	private String password;
	private Map<String, Integer> preferences = new HashMap<>();

	public User() {
	}

	public User(Integer userId, String username, String email, String password) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public void setUserPreference(String genre, int rating) {
		if (genre == null) {
			throw new RuntimeException("Genre cannot be null.");
		}

		if (rating >= 1 || rating <= 5) {
			throw new RuntimeException("Rating must be between 1 and 5");
		}
		preferences.put(genre, rating);
	}

	public int getUserPreference(String genre) {
		if (genre == null) {
			throw new RuntimeException("Genre can't be null");
		}
		return preferences.getOrDefault(genre, 0);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ "]";
	}

}
