package com.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.member.model.dto.MemberDto;

public class MemberDao {
	
	public boolean idCheck(Connection conn, String memberId) {
		String sql = """
						SELECT
								COUNT(*)
						  FROM
						  		JDBC_MEMBER
						 WHERE
						 		MEMBER_ID = ?
					 """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, memberId);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			return rset.getInt("COUNT(*)") > 0 ? true : false;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int signUp(Connection conn, MemberDto member) {
		int result = 0;
		String sql = """
						INSERT
						  INTO
						  		JDBC_MEMBER
						VALUES
								(
								?
							  , ?
							  , ?
								)
				""";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,  member.getMemberId());
			pstmt.setString(2,  member.getMemberPwd());
			pstmt.setString(3,  member.getMemberName());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
