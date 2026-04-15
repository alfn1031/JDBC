package com.kh.keeper.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.keeper.common.JdbcTemplate;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

public class KeeperDao {

	static {
		JdbcTemplate.registDriver();
	}
	
	public int insertKeeper(Connection conn, KeeperDto kd) {
		// Connection conn = null;
		// Statement stmt = null;
		int result = 0;
		String sql = """
					INSERT
				      INTO
				      		KEEPER
				     VALUES
				     		(
				     		'K' || SEQ_KEEPER.NEXTVAL
				     	  , ?
				     	  , SYSDATE
				     	  , ? 
				     	  	)
					 """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, kd.getKeeperName());
			pstmt.setString(2, kd.getZoneId());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Keeper> selectKeeperList(Connection conn) {
		List<Keeper> keepers = new ArrayList();
		String sql = """
						SELECT
								KEEPER_ID
							  , KEEPER_NAME
							  , HIRE_DATE
							  , ZONE_ID
						  FROM
						  		KEEPER
						 ORDER
						 	BY
						 		KEEPER_ID DESC
					 """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery()) {
			while(rset.next()) {
					
				Keeper keeper = new Keeper(rset.getString("KEEPER_ID")
										  ,rset.getString("KEEPER_NAME")
										  ,rset.getDate("HIRE_DATE")
										  ,rset.getString("ZONE_ID"));
				keepers.add(keeper);
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		
		return keepers;
	}
	
	public int updateKeeper(Connection conn, Map<String, String> keeper) {
		int result = 0;
		String sql = """
						UPDATE
								KEEPER
						   SET
						   		KEEPER_NAME = ?
						   	  , HIRE_DATE = ?
						   	  , ZONE_ID = ?
						  WHERE
						  		KEEPER_ID = ?
					 """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, keeper.get("keeperName"));
			pstmt.setString(2, keeper.get("hireDate"));
			pstmt.setString(3, keeper.get("zoneId"));
			pstmt.setString(4, keeper.get("keeperId"));
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteKeeper(Connection conn, String keeperId) {
		int result = 0;
		String sql = """
						DELETE
						  FROM
						  		KEEPER
						 WHERE
						 		KEEPER_ID = ?
					 """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1,  keeperId);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
