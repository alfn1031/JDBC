package com.kh.animal.controller;

import java.util.List;

import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.service.AnimalService;

public class AnimalController {
	
	public int save(AnimalDto animal) {
		return new AnimalService().save(animal);
	}
	public List<AnimalDto> findAll() {
		return new AnimalService().findAll();
	}
	public AnimalDto findById(String id) {
		return new AnimalService().findById(id);
	}
	public List<AnimalDto> findByKeyword(String keyword) {
		return new AnimalService().findByKeyword(keyword);
	}
	
}
