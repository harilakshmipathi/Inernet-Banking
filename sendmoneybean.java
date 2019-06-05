package com.HSBCBank.bean;

public class sendmoneybean {
	private String beneficiaryname;
	private String accountnumber;
	private String amount;
	private String ifsccode;
	private String customerid;

	public String getbeneficiaryname() {
		return beneficiaryname;
	}
	public void setbeneficiaryname(String beneficiaryname) {
		this.beneficiaryname = beneficiaryname;
	}
	public String getaccountnumber() {
		return accountnumber;
	}
	public void setaccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;

	}
	public String getamount() {
		return amount;
	}
	public void setamount(String amount) {
		this.amount = amount;
	}
	public String getifsccode() {
		return ifsccode;
	}
	public void setifsccode(String ifsccode) {
		this.ifsccode = ifsccode;

	}
	public String getcustomerid() {
		return customerid;
	}
	public void setcustomerid(String customerid) {
		this.customerid = customerid;

	}
}