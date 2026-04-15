package com.kh.member.model.dto;

public class MemberDto {
	private String memberId;
	private String memberPwd;
	private String memberName;
	public MemberDto() {
		super();
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public MemberDto(String memberId, String memberPwd, String memberName) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName + "]";
	}

}
