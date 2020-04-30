package com.app.rationwala.dto;

import com.app.rationwala.dto.enums.Status;

import lombok.Data;

public @Data class StatusInfo {
	private Status status;
	private Message message;
}
