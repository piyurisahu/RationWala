package com.app.rationwala.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public abstract class AbstractController {
	protected ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
}
