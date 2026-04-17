package com.kh.animal.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.dto.KeeperDto;

public class KeeperDao {
	
	public List<KeeperDto> selectKeeperList(SqlSession session) {
		return session.selectList("keeperMapper.selectKeeperList");
	}
	public List<AnimalDto> selectAnimalList(SqlSession session, String keeperId) {
		return session.selectList("keeperMapper.selectAnimalList", keeperId);
	}
	public List<KeeperDto> findKeeperAndAnimals(SqlSession session) {
		return session.selectList("keeperMapper.findKeeperAndAnimals");
	}
	public List<KeeperDto> selectKeeperByCondition(SqlSession session, Map<String, String> arguments){
		return session.selectList("keeperMapper.selectKeeperByondition", arguments);
	}
	public int updateAnimal(SqlSession session,, AnimalDto animal) {
		return session.update("animalMapper.updateAnimal", animal);
	}
	
}
