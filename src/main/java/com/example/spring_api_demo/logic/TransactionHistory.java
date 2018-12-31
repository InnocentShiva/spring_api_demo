package com.example.spring_api_demo.logic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_history")
public class TransactionHistory {
	@Id
	@GeneratedValue
	@Column(name = "transaction_history_id")
	private long transactionhistoryid ;
	
	@Column(name = "transaction_history_from_wallet_username")
	private String senderemployeename;
	
	@Column(name = "transaction_history_to_wallet_username")
	private String receiveremployeename;
	
	

	@Column(name = "transaction_history_comment")
	private String comment;
	
	@Column(name = "transaction_history_amount")
	private int amount;
	
	@Column(name = "transaction_history_code")
	private String code;
	
	@Column(name = "create_time")
	Date create_time;
	
	@Column(name = "update_time")
	Date update_time;
	
	@Column(name = "redeem_status")
	int redeem_status;
	
	@Column(name = "transaction_history_multichain_response_id")
	String multichain_response_id;
	
	@Column(name = "transaction_history_type")
	String transaction_history_type;
	
	@Column(name = "token")
	String token;
	
	public long getTransactionhistoryid() {
		return transactionhistoryid;
	}

	public void setTransactionhistoryid(long transactionhistoryid) {
		this.transactionhistoryid = transactionhistoryid;
	}

	public String getSenderemployeename() {
		return senderemployeename;
	}

	public void setSenderemployeeName(String senderemployeename) {
		this.senderemployeename = senderemployeename;
	}

	public String getReceiveremployeename() {
		return receiveremployeename;
	}

	public void setReceiveremployeeName(String receiveremployeename) {
		this.receiveremployeename = receiveremployeename;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public int getRedeem_status() {
		return redeem_status;
	}

	public void setRedeem_status(int redeem_status) {
		this.redeem_status = redeem_status;
	}

	public String getMultichain_response_id() {
		return multichain_response_id;
	}

	public void setMultichain_response_id(String multichain_response_id) {
		this.multichain_response_id = multichain_response_id;
	}

	public String getTransaction_history_type() {
		return transaction_history_type;
	}

	public void setTransaction_history_type(String transaction_history_type) {
		this.transaction_history_type = transaction_history_type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
//	public long getEmployeeid() {
//		return employeeid;
//	}
//
//	public void setEmployeeid(long employeeid) {
//		this.employeeid = employeeid;
//	}

//	public String getEmployeename() {
//		return employeeName;
//	}
//
//	public void setEmployeename(String employeename) {
//		this.employeeName = employeename;
//	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

//	public String getDept() {
//		return dept;
//	}
//
//	public void setDept(String dept) {
//		this.dept = dept;
//	}

//	public Date getLogintime() {
//		return logintime;
//	}
//
//	public void setLogintime(Date logintime) {
//		this.logintime = logintime;
//	}
	
	

}
