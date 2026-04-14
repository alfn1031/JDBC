package com.kh.species.model.service;

import java.util.List;

import com.kh.species.model.dao.SpeciesDao;
import com.kh.species.model.dto.SpeciesDto;

public class SpeciesService {
	private SpeciesDao speciesDao = new SpeciesDao();
	
	public int save(SpeciesDto sd) {
		// speciesName의 길이, 중복검사, 유효성검사
		return speciesDao.save(sd);
	}

	public List<SpeciesDto> findAll() {
		return speciesDao.findAll();
	}
	
	public int update(SpeciesDto sd) {
		return speciesDao.update(sd);
	}
	
	public int delete(String speciesId) {
		return speciesDao.delete(speciesId);
	}
	
	public SpeciesDto findById(String speciesId) {
		return speciesDao.findById(speciesId);
	}
	
	public List<SpeciesDto> findByKeyword(String keyword) {
		return speciesDao.findByKeyword(keyword);
	}
}


