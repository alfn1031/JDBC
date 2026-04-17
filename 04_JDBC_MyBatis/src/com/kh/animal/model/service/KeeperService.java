package com.kh.animal.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.common.Template;
import com.kh.animal.model.dao.AnimalDao;
import com.kh.animal.model.dao.KeeperDao;
import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.dto.KeeperDto;

public class KeeperService {
	
	public List<KeeperDto> selectKeeperAndAnimals() {
		SqlSession session = Template.getSqlSession();
		/*
		List<KeeperDto> keepers = new KeeperDao().selectKeeperList(session);
				
		for(KeeperDto keeper : keepers) {
			List<AnimalDto> animals = new KeeperDao().selectAnimalList(session, keeper.getKeeperId());
		keeper.setAnimals(animals);
		}
		*/
		List<KeeperDto> keepers = new KeeperDao().findKeeperAndAnimals(session);
		session.close();
		return keepers;
	}
	public List<KeeperDto> selectKeeperByCondition(Map<String, String> arguments) {
		SqlSession session = Template.getSqlSession();
		
		List<KeeperDto> keepers = new KeeperDao().selectKeeperByCondition(session, arguments);
		session.close();
		return keepers;
	}
	public int updateAnimal(AnimalDto animal) {
		
		SqlSession session = Template.getSqlSession();
		
		int result = new AnimalDao().updateAnimal(session, animal);
		
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
		
	}
	
	
	
}
