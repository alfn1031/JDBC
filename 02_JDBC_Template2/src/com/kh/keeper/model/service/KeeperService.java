package com.kh.keeper.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.keeper.common.JdbcTemplate;
import com.kh.keeper.model.dao.KeeperDao;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;

public class KeeperService {
	
	public int insertKeeper(KeeperDto kd) {
		
		Connection conn = JdbcTemplate.getConnection();
		
		int result = new KeeperDao().insertKeeper(conn, kd);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		}
		JdbcTemplate.close(conn);
		
		return result;
	}
	
	public List<Keeper> selectKeeperList() {
		
		Connection conn = JdbcTemplate.getConnection();
		
		List<Keeper> keepers = new KeeperDao().selectKeeperList(conn);
		
		JdbcTemplate.close(conn);
		
		return keepers;
	}
	
	public int updateKeeper(Map<String, String> keeper) {
		Connection conn = JdbcTemplate.getConnection();
		int result = new KeeperDao().updateKeeper(conn, keeper);
		
		if(result > 0) {
			JdbcTemplate.close(conn);
		}
		return result;
	}
	public int deleteKeeper(String keeperId) {
		
		Connection conn = JdbcTemplate.getConnection();
		
		int result = new KeeperDao().deleteKeeper(conn, keeperId);
		
		if(result > 0) {
			JdbcTemplate.commit(conn);
		} 
		JdbcTemplate.close(conn);;
		
		return result;
	}
	
}
