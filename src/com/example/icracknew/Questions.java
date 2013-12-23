package com.example.icracknew;

public class Questions { 
		int qid;
		String category;
		String question;
		
		public Questions() {
			super();
		}
		public Questions(int qid, String category, String question) {
			super();
			this.qid = qid;
			this.category = category;
			this.question = question;
		}
		public int getQid() {
			return qid;
		}
		public void setQid(int qid) {
			this.qid = qid;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		
}
