package com.kh.member.controller;

import java.util.List;

import com.kh.member.model.dto.BoardDto;
import com.kh.member.model.dto.LoginResponse;
import com.kh.member.model.dto.MemberDto;
import com.kh.member.model.service.MemberService;

public class MemberController {
	
	public boolean idCheck(String memberId) {
		return new MemberService().idCheck(memberId);
	}
	public int signUp(MemberDto member) {
		return new MemberService().signUp(member);
	}
	public LoginResponse login(MemberDto member) {
		return  new MemberService().login(member);
	}
	public int selectInsertCount(String memberId) {
		return new MemberService().selectInsertCount(memberId);
	}
	public int insertBoard(BoardDto board) {
		return new MemberService().insertBoard(board);
	}
	public List<BoardDto> selectBoardList() {
		return new MemberService().selectBoardList();
	}
	public BoardDto selectBoard(String boardNo) {
		return new MemberService().selectBoard(boardNo);
	}
	
}
