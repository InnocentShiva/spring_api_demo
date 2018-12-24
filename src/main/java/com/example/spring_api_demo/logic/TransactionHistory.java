package com.example.spring_api_demo.logic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TransactionHistory {
	@Id
	@GeneratedValue
	private long employeeid ;
	
	@Column
	private String employeeName;
	
	@Column
	private String comment;
	
	@Column
	private String dept;
	
	@Column
	Date logintime;

	public long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeeName;
	}

	public void setEmployeename(String employeename) {
		this.employeeName = employeename;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	
	

}
