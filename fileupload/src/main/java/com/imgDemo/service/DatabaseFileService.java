package com.imgDemo.service;

import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.imgDemo.exception.FileNotFoundException;
import com.imgDemo.exception.FileStorageException;
import com.imgDemo.model.DatabaseFile;
import com.imgDemo.repository.DatabaseFileRepository;

@Service
public class DatabaseFileService {

	@Autowired
	private DatabaseFileRepository dbFileRepository;

	public DatabaseFile storeFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String extension = FilenameUtils.getExtension(fileName);

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			if (extension == null || !extension.matches("(?i)(png|jpe?g|jpg|json)")) {
				throw new FileStorageException("File type can't be matched? please try again...");
			}

			DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

			return dbFileRepository.save(dbFile);
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public DatabaseFile getFile(String fileId) {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
	}
}
