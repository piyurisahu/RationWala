package com.app.rationwala.dto;

import java.util.List;

import com.app.rationwala.dto.enums.Status;

import lombok.Data;

public @Data class StatusInfo {
	private Status status;
	private List<Message> messages;
}
