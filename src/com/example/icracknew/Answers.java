package com.example.icracknew;

public class Answers {
	int qId;
	String answer;
	int uId;
	int rating;
	public Answers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answers(int qId, String answer, int uId, int rating) {
		super();
		this.qId = qId;
		this.answer = answer;
		this.uId = uId;
		this.rating = rating;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
