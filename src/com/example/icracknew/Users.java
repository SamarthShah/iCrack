package com.example.icracknew;

public class Users {
	int uId;
	String username;
	int points;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int uId, String username, int points) {
		super();
		this.uId = uId;
		this.username = username;
		this.points = points;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
}
