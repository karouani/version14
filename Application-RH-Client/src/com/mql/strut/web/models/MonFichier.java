package com.mql.strut.web.models;

import java.io.File;

public class MonFichier {
	
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;
	
	public MonFichier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonFichier(File myFile, String myFileContentType,
			String myFileFileName, String destPath) {
		super();
		this.myFile = myFile;
		this.myFileContentType = myFileContentType;
		this.myFileFileName = myFileFileName;
		this.destPath = destPath;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	@Override
	public String toString() {
		return "MonFichier [myFile=" + myFile + ", myFileContentType="
				+ myFileContentType + ", myFileFileName=" + myFileFileName
				+ ", destPath=" + destPath + "]";
	}
	
}
