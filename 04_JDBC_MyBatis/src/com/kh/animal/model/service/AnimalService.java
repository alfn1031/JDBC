package com.kh.animal.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.common.Template;
import com.kh.animal.model.dao.AnimalDao;
import com.kh.animal.model.dto.AnimalDto;

public class AnimalService {
	
	public int save(AnimalDto animal) {
		SqlSession session = Template.getSqlSession();
		
		int result = new AnimalDao().save(session, animal);
		
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;
	}
	public List<AnimalDto> findAll() {
		SqlSession session = Template.getSqlSession();
		
		List<AnimalDto> animals = new AnimalDao().findAll(session);
		
		session.close();
		
		return animals;
	}
	public AnimalDto findById(String id) {
		SqlSession session = Template.getSqlSession();
		
		AnimalDto animal = new AnimalDao().findById(session, id);
		
		session.close();
		
		return animal;
	}
	public List<AnimalDto> findByKeyword(String keyword) {
		
		SqlSession session = Template.getSqlSession();
		
		List<AnimalDto> animals = new AnimalDao().findByKeyword(session, keyword);
		
		session.close();
		
		return animals;
	}
}
