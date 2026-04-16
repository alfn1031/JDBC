package com.kh.animal.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.model.dto.AnimalDto;

public class AnimalDao {
	
	public int save(SqlSession session, AnimalDto animal) {
		
		return session.insert("animalMapper.save", animal);
		
	}
	public List<AnimalDto> findAll(SqlSession session) {
		return session.selectList("animalMapper.findAll");
	}
	public AnimalDto findById(SqlSession session, String id) {
		return session.selectOne("animalMapper.findById", id);
	}
	public List<AnimalDto> findByKeyword(SqlSession session, String keyword) {
		return session.selectList("animalMapper.findByKeyword", keyword);
	}
	
	
}
