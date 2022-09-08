package com.skillstorm.spyglass.models;

import org.springframework.stereotype.Controller;

@Controller
public class NotFound {
	
	private String message;
	
	private NotFound() { }
	
	public NotFound(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "NotFound [message=" + message + "]";
	}

	
	
}
