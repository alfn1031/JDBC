package com.kh.member.model.dto;

public class LoginResponse {
	private String memberId;
	private String memberName;
	public LoginResponse(String memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getMemberNAme() {
		return memberName;
	}
	
}
