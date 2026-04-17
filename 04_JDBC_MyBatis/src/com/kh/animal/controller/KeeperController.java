package com.kh.animal.controller;

import java.util.List;
import java.util.Map;

import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.dto.KeeperDto;
import com.kh.animal.model.service.AnimalService;
import com.kh.animal.model.service.KeeperService;

public class KeeperController {
	
	public List<KeeperDto> selectKeeperAndAnimals() {
		return new KeeperService().selectKeeperAndAnimals();
	}
	public List<KeeperDto> selectByCondition(Map<String, String> arguments) {
		return new KeeperService().selectKeeperByCondition(arguments);
	}
	public int updateAnimal(AnimalDto animal) {
		return new AnimalService().updateAnimal(animal);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
