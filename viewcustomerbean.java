package com.HSBCBank.bean;

public class viewcustomerbean {
	
	
    private String Name;
	private String password;
	private String emailid;
	private String customerid;
	private String confrimpassword;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setemailid(String emailid) {
		this.emailid = emailid;
	}
	public String getcustomerid() {
		return customerid;
	}
	public void setcustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getconfrimpassword() {
		return confrimpassword;
	}
	public void setconfrimpassword(String confrimpassword) {
		this.confrimpassword = confrimpassword;
	}
}
