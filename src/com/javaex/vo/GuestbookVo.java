package com.javaex.vo;

public class GuestbookVo {
	
	//필드
	private int no;
	private String name;
	private String content;
	private String password;
	private String regDate;
	//생성자
	public GuestbookVo() {}
	public GuestbookVo(int no, String name, String content, String password, String regDate) {
		this.no = no;
		this.name = name;
		this.content = content;
		this.password = password;
		this.regDate = regDate;
	}
	
	public GuestbookVo( String name, String content, String password) {
		this.name = name;
		this.content = content;
		this.password = password;
	}
	
	public GuestbookVo( String name, String content, String password, String regDate) {
		this.name = name;
		this.content = content;
		this.password = password;
		this.regDate = regDate;
	}
	//메소드 g/s
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	
	
	
	//메소드 일반	
	@Override
	public String toString() {
		return "GusetbookVo [no=" + no + ", name=" + name + ", content=" + content + ", password=" + password
				+ ", regDate=" + regDate + "]";
	}
	
}
