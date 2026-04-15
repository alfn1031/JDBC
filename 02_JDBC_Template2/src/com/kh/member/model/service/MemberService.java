package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.keeper.common.JdbcTemplate.*;
import com.kh.member.exception.DuplicateMemberException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.model.dao.MemberDao;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
