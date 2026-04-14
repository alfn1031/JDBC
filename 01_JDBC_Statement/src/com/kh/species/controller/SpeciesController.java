package com.kh.species.controller;

import java.util.List;

import com.kh.species.model.dto.SpeciesDto;
import com.kh.species.model.service.SpeciesService;

public class SpeciesController {
	private SpeciesService speciesService = new SpeciesService();
	
	public int save(String speciesName, String speciesClass) {
		SpeciesDto sd = new SpeciesDto(speciesName, speciesClass);
		return speciesService.save(sd);
	}
	
	public List<SpeciesDto> findAll() {
		return speciesService.findAll();
	}
	
	public int update(SpeciesDto sd) {
		return speciesService.update(sd);
	}
	
	public int delete(String speciesId) {
		return speciesService.delete(speciesId);
	}
	
	public SpeciesDto findById(String speciesId) {
		return speciesService.findById(speciesId);
	}
	
	public List<SpeciesDto> findByKeyword(String keyword) {
		return speciesService.findByKeyword(keyword);
	}
	
	
	
	
	
	
}
