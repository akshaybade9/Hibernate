package com.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class FileInfo {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int fid;
	
	private String fName;

	@Lob
	private byte[] fileData;
	
	private String fileUploadDate;
	
	private long fileSize;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}



	

	public String getFileUploadDate() {
		return fileUploadDate;
	}

	public void setFileUploadDate(String fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "FileInfo [fid=" + fid + ", fName=" + fName + ", fileData=" + Arrays.toString(fileData)
				+ ", fileUploadDate=" + fileUploadDate + ", fileSize=" + fileSize + "]";
	}



	

}
