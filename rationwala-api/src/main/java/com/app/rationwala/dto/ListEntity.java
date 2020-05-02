package com.app.rationwala.dto;

import com.app.rationwala.model.StatusInfo;
import lombok.Data;

import java.util.List;

public @Data
class ListEntity<T> {
    private List<T> items;
    StatusInfo statusInfo;
}
