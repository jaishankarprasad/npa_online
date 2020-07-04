package com.entity.result.user;

public class Attempted {
	private String candname;
	private String qnum;
	private String answer;	
	private String testid;
	private String q_no;
	private String correctoption;
	
	public String getQ_no() {
		return q_no;
	}

	public void setQ_no(String q_no) {
		this.q_no = q_no;
	}

	public String getCorrectoption() {
		return correctoption;
	}

	public void setCorrectoption(String correctoption) {
		this.correctoption = correctoption;
	}

	public String getCandname() {
		return candname;
	}

	public void setCandname(String candname) {
		this.candname = candname;
	}

	public String getQnum() {
		return qnum;
	}

	public void setQnum(String qnum) {
		this.qnum = qnum;
	}

	public String getTestid() {
		return testid;
	}

	public void setTestid(String testid) {
		this.testid = testid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
