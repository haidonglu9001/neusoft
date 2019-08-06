package com.neu.mvcweb.message;

public class ResultMessage {
	private String status=null;
	private String message=null;
	public ResultMessage(String status,String message) {
		this.status=status;
		this.message=message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
