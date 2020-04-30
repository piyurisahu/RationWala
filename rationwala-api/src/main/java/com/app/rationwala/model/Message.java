package com.app.rationwala.model;

import com.app.rationwala.dto.enums.Status;

import lombok.Data;

public @Data class Message {
	private Status status;
	private String identifier;
	private String code;
	private String message;

	public Message() {
	}

	public Message(Status status, String identifier, String code, String message) {
		super();
		this.status = status;
		this.identifier = identifier;
		this.code = code;
		this.message = message;
	}

	public Message(String code, String message) {
		this(null, null, code, message);
	}
}
