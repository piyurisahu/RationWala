package com.app.rationwala.dto;

import lombok.Data;

public @Data class Message {
	private String code;
	private String message;

	public Message() {
	}

	public Message(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

}
