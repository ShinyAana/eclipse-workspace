package com.file.io2;

public class File {
	private String fname;
    private String content;
    private boolean reanOnly;
    private int size;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public File(String fname) {
		super();
		this.fname = fname;
		this.content = " ";
		this.size = 0;
		this.reanOnly=false;
	}
	public boolean isReanOnly() {
		return reanOnly;
	}
	public void setReanOnly(boolean reanOnly) {
		this.reanOnly = reanOnly;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
  
}
