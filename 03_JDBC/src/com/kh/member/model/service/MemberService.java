package com.kh.member.model.service;

import static com.kh.keeper.common.JdbcTemplate.close;
import static com.kh.keeper.common.JdbcTemplate.commit;
import static com.kh.keeper.common.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.member.exception.DuplicateMemberException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.BoardDto;
import com.kh.member.model.dto.LoginResponse;
import com.kh.member.model.dto.MemberDto;

public class MemberService {

	public boolean idCheck(String memberId) {
		Connection conn = getConnection();
		boolean result = new MemberDao().idCheck(conn, memberId);
		close(conn);
		return result;
	}
	public int signUp(MemberDto member) {
		if(member.getMemberId().length() > 30) {
			throw new MemberIdToLargeException("아이디가 너무 깁니다.");
		}
		Connection conn = getConnection();
		MemberDao md = new MemberDao();
		if(md.idCheck(conn,  member.getMemberId())) {
			throw new DuplicateMemberException("중복아이디입니다.");
		}
		int result = md.signUp(conn, member);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}
	public LoginResponse login(MemberDto member) {
		
		Connection conn = getConnection();
		
		new MemberDao().login(conn, member);
		
		LoginResponse lr = new MemberDao().login(conn, member);
		
		if(lr != null) {
			int result = new MemberDao().loginCheck(conn, member.getMemberId());
		
			if(result > 0) {
				commit(conn);
			}
		}
		close(conn);
		return lr;
	}
	public int selectInsertCount(String memberId) {
		Connection conn = getConnection();
		
		int result = new MemberDao().selectInsertCount(conn, memberId);
		
		close(conn);
		
		return result;
	}
	public int insertBoard(BoardDto board) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
	public List<BoardDto> selectBoardList() {
		Connection conn = getConnection();
		List<BoardDto> boards = new MemberDao().selectBoardList(conn);
		close(conn);
		return boards;
	}
	public BoardDto selectBoard(String boardNo) {
		Connection conn = getConnection();
		BoardDto board = new MemberDao().selectBoard(conn, Integer.parseInt(boardNo));
		close(conn);
		return board;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

