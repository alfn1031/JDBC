package com.kh.animal.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.animal.controller.AnimalController;
import com.kh.animal.controller.KeeperController;
import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.dto.KeeperDto;

public class AnimalView {
	private Scanner sc = new Scanner(System.in);
	private AnimalController ac = new AnimalController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("동물관리 시스템에 오신걸 화영합니다.");
			System.out.println("1. 동물 추가하기");
			System.out.println("2. 동물 전체 조회하기");
			System.out.println("3. 동물 단일 조회하기");
			System.out.println("4. 동물 이름 키워드로 조회하기");
			System.out.println("5. 사육사 및 담당 동물 조회하기");
			System.out.println("6. 사육사 검색하기");
			System.out.println("7. 동물 정보 수정하기");
			System.out.print("메뉴를 선택헤주세요 : ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : save(); break;
			case "2" : findAll(); break;
			case "3" : findById(); break;
			case "4" : findByKeyword(); break;
			case "5" : selectKeeperAndAnimals(); break;
			case "6" : selectKeeperByCondition(); break;
			case "7" : updateAnimal(); break;
			case "9" : sc.close(); return;
			}
		}
	}
	private void save() {
		
		System.out.println("동물추가 프로그램입니다.");
		System.out.print("추가할 동물의 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		System.out.print("추가할 동물의 종 번호를 입력해주세요 : ");
		String speciesId = sc.nextLine();
		
		System.out.print("추가할 동물의 구역 번호를 입력해주세요 : ");
		String zoneId = sc.nextLine();
		
		System.out.print("추가할 동물의 사육사 번호를 입력해주세요 : ");
		String keeperId = sc.nextLine();
		
		System.out.print("추가할 동물의 성별을 입력해주세요 : ");
		String gender = sc.nextLine();
		
		System.out.print("추가할 동물의 무게를 입력해주세요 : ");
		double kg = sc.nextDouble();
		
		int result = ac.save(new AnimalDto(name, speciesId, zoneId, keeperId, gender, kg));
		
		if(result > 0) {
			System.out.println(name + "추가에 성공했습니다");
		} else {
			System.out.println(name + "추가에 실패했습니다");
		}
	}
	private void findAll() {
		System.out.println("동물 전체조회 프로그램입니다.");
		List<AnimalDto> animals = ac.findAll();
		
		if(animals.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다");
		} else {
			for(AnimalDto animal : animals) {
			System.out.println("동물번호 : " + animal.getAnimalId()
							 + ", 동물이름 : " + animal.getAnimalName()
							 + ", 종 이름 : " + animal.getSpeciesId()
							 + ", 구역 이름 : " + animal.getZoneId()
							 + ", 사육사 이름 : " + animal.getKeeperId()
							 + ", 성별 : " + animal.getGender()
							 + ", 몸무게 : " + animal.getWeightKg() + "KG");
			} 
		}
	}
	private void findById() {
		
		System.out.println("동물 찾기 프로그램입니다");
		System.out.print("검색하실 동물의 ID를 입력해주세요 : ");
		String id = sc.nextLine();
		
		AnimalDto animal = ac.findById(id);
		
		if(animal != null) {
			System.out.println(animal.getAnimalId() + "의 정보");
			System.out.println("동물 이름 : " + animal.getAnimalName());
			System.out.println("종 이름 : " + animal.getSpeciesId());
			System.out.println("구역 이름 : " + animal.getZoneId());
			System.out.println("사육사 이름 : " + animal.getKeeperId());
			System.out.println("성별 : " + animal.getGender());
			System.out.println("몸무게 : " + animal.getWeightKg());
		} else {
			System.out.println("동물이 존재하지 않습니다");
		}
	}
	private void findByKeyword() {
		System.out.println("동물이름 검색 프로그램입니다");
		System.out.print("검색하실 키워드를 입력해주세요 : ");
		String keyword = sc.nextLine();
		
		List<AnimalDto> animals = ac.findByKeyword(keyword);
		
		if(animals.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다");
		} else {
			for(AnimalDto animal : animals) {
				System.out.println(animal);
			}
		}
	}
	private void selectKeeperAndAnimals() {
		
		List<KeeperDto> keepers = new KeeperController().selectKeeperAndAnimals();
		
		System.out.println(keepers);
		for(KeeperDto keeper : keepers) {
			System.out.println(keeper.getKeeperName() + "의 담당 동물들");
			System.out.println(keeper.getAnimals());
			System.out.println("=============================");
		}
		
	}
	private void selectKeeperByCondition() {
		System.out.println("사육사 검색 프로그램입니다");
		System.out.println("검색 조건을 입력해주세요");
		System.out.println("1. 사육사번호 / 2. 사육사 이름 / 3. 담당구역");
		String menuNo = sc.nextLine();
		System.out.print("검색할 키워드를 입력해주세요 : ");
		String keyword = sc.nextLine();
		
		Map<String, String> arguments = new HashMap();
		arguments.put("menuNo", menuNo);
		arguments.put("keyword", keyword);
		
		new KeeperController().selectByCondition(arguments);
	}
	private void updateAnimal() {
		System.out.println("동물 정보변경 프로그램입니다");
		findAll();
		System.out.print("정보를 변경할 동물의 번호를 입력해주세요 :");
		String animalId = sc.nextLine();
		System.out.print("변경할 구역 번호를 입력해주세요");
		String zoneId = sc.nextLine();
		System.out.print("변경할 사육사 번호를 입력해주세요 : ");
		String keeperId = sc.nextLine();
		System.out.println("변경할 몸무게를 입력해주세요 : ");
		double weightKg = sc.nextDouble();
		sc.nextLine();
		
		AnimalDto animal = new AnimalDto();
		animal.setAnimalId(animalId);
		animal.setZoneId(zoneId);
		animal.setKeeperId(keeperId);
		animal.setWeightKg(weightKg);
		
		int result = ac.updateAnimal(animal);
		
		if(result > 0) {
			System.out.println("정보 수정에 성공했습니다");
		} else {
			System.out.println("정보 수정에 실패했습니다");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
