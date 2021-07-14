package com.cts.service;

import com.cts.exceptions.InvalidUploadFileException;
import com.cts.model.InsertionSummary;

public interface UploadService {
	public InsertionSummary uploadData(String fileName) throws InvalidUploadFileException;
}
