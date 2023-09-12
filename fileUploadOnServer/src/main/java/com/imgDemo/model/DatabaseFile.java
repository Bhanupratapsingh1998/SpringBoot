package com.imgDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "filesOnServer")
public class DatabaseFile {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String fileName;

	private String fileType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public DatabaseFile() {
		super();
	}
	public DatabaseFile(String fileName, String fileType) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
	}
	public DatabaseFile(String id, String fileName, String fileType) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
	}
}