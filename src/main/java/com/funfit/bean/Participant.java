package com.funfit.bean;

public class Participant {
	private int pid;
	private String firstName;
	private int age;
	private String phoneNumber;
	private int bid;
	
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participant(int pid, String fname, int age, String phoneNumber, int bid) {
		super();
		this.pid = pid;
		this.firstName = fname;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.bid = bid;
	}


	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Participant [pid=" + pid + ", firstName=" + firstName + ", age=" + age + ", phoneNumber=" + phoneNumber
				+ ", bid=" + bid + "]";
	}
}
