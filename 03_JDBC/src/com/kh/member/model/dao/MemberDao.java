package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.member.model.dto.BoardDto;
import com.kh.member.model.dto.LoginResponse;
import com.kh.member.model.dto.MemberDto;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		public boolean idCheck(Connection conn, String memberId) {
		
		String sql = prop.getProperty("idCheck");
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
		
		String sql = prop.getProperty("signUp");
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
	public LoginResponse login(Connection conn, MemberDto member) {
		LoginResponse lr = null;
		try(
			PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("login"))){
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			try(ResultSet rset = pstmt.executeQuery()){
				if(rset.next()) {
					lr = new LoginResponse(rset.getString("MEMBER_ID"),
										   rset.getString("MEMBER_NAME"));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lr;
	}
	public int loginCheck(Connection conn, String memberId) {
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("loginCheck"))){
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int selectInsertCount(Connection conn, String memberId) {
		int result = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectInsertCount"))){
			pstmt.setString(1, memberId);
			try(ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				rset.getInt("COUNT(*)");
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int insertBoard(Connection conn, BoardDto board) {
		int result = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertBoard"))){
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setString(3, board.getBoardWriter());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<BoardDto> selectBoardList(Connection conn) {
		List<BoardDto> boards = new ArrayList();
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectBoardList"));
				ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					BoardDto bd = new BoardDto(rset.getInt("BOARD_NO"),
											   rset.getString("BOARD_TITLE"),
											   null,
											   rset.getString("MEMBER_NAME"));
					boards.add(bd);
				}
				return boards;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}
	public BoardDto selectBoard(Connection conn, int boardNo) {
		BoardDto board = null;
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectBoard"))) {
			pstmt.setInt(1,  boardNo);
			try(ResultSet rset = pstmt.executeQuery()){
				if(rset.next()) {
					board = new BoardDto(rset.getInt("BOARD_NO"),
										 rset.getString("BOARD_TITLE"),
										 rset.getString("BOARD_CONTENT"),
										 rset.getString("MEMBER_NAME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
