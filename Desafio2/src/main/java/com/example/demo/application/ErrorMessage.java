package com.example.demo.application;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorMessage {
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(int status){
		this.status = status;
	}
	
	public ErrorMessage(int status ,String message){
		this(status);
		this.message = message;
	}
	
	public ErrorMessage(int status, String message, String details){
		this(status, message);
		this.messageDetails = details;
	}
	
	public ErrorMessage(Exception ex){
		this.status = 500;
		this.message = ex.getMessage();
		StringWriter errorStackTrace = new StringWriter();
		ex.printStackTrace(new PrintWriter(errorStackTrace));
		this.messageDetails = errorStackTrace.toString();
	}

	private String getCauseDetails(Exception ex) {
		return ex.getCause() != null ? ex.getCause().getMessage() : "";
	}
	
	public ErrorMessage(Exception ex, int status){
		this.status = status;
		this.message = ex.getMessage();
		this.messageDetails = getCauseDetails(ex);
	}
	
	public ErrorMessage(String message, String details){
		this.status = 500;
		this.message = message;
		this.messageDetails = details;
	}
	
	public ErrorMessage(String message) {
		this.status = 500;
		this.message = message;
		this.messageDetails = "";
	}
	
	private int status;
	
	private String message;
	
	private String messageDetails;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDetails() {
		return messageDetails;
	}

	public void setMessageDetails(String messageDetails) {
		this.messageDetails = messageDetails;
	}
} 
 
