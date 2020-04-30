package com.app.rationwala.model;

import java.util.List;

import com.app.rationwala.dto.enums.Status;

import lombok.Data;

public @Data class StatusInfo {
	private Status status;
	private List<Message> messages;
}
