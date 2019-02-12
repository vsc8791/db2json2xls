package com.darkhorse.db2json2xls.pojo;

public class MyPojo {
	
	private String userid;
	private String name;
	private String dob;
	private String phoneNo;
	private String email;
	
	public MyPojo() {
		// TODO Auto-generated constructor stub
	}

	public MyPojo(String userid, String name, String dob, String phoneNo, String email) {
		super();
		this.userid = userid;
		this.name = name;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MyPojo [userid=" + userid + ", name=" + name + ", dob=" + dob + ", phoneNo=" + phoneNo + ", email="
				+ email + "]";
	}

	
	
}
