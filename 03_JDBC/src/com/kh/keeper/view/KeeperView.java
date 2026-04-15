package com.kh.keeper.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.keeper.controller.KeeperController;
import com.kh.keeper.model.dto.KeeperDto;
import com.kh.keeper.model.vo.Keeper;
import com.kh.member.view.MemberView;

public class KeeperView {
	private Scanner sc = new Scanner(System.in);
	private KeeperController kc = new KeeperController();
	private MemberView mv = new MemberView();
	
	public void mainMenu() {
		while(true) {
			System.out.println("사육사 관리 프로그램입니다.");
			System.out.println("1. 사육사 추가하기");
			System.out.println("2. 사육사 전체 조회하기");
			System.out.println("3. 사육사 정보 수정하기");
			System.out.println("4. 사육사 정보 삭제하기");
			System.out.println("5. 회원 서비스로 이동하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("원하시는 메뉴를 선택해주세요 > ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : insertKeeper(); break;
			case "2" : selectKeeperList(); break;
			case "3" : updateKeeper(); break;
			case "4" : deleteKeeper(); break;
			case "5" : mv.mainMenu(); break;
			case "9" : sc.close(); return;
			default : System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
	}
	private void insertKeeper() {
		
		System.out.println("사육사 추가 기능입니다");
		System.out.print("추가하실 사육사 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.print("사육사의 담당구역을 입력해주세요 : ");
		String zone = sc.nextLine();
		
		int result = kc.insertKeeper(new KeeperDto(name, zone));
		
		if(result > 0) {
			System.out.println("사육사 추가에 성공했습니다");
		} else {
			System.out.println("사육사 추가에 실패했습니다");
		}
	}
	private void selectKeeperList() {
		
		System.out.println("사육사 전체조회 서비스입니다");
		
		List<Keeper> keepers = kc.selectKeeperList();
		
		if(keepers.isEmpty()) {
			System.out.println("아직 등록된 사육사가 없습니다");
		} else {
			
			keepers.stream()
				   .map(k -> "아이디 : " + k.keeperId()
						   	+ ", 이름 : " + k.keeperName()
						   	+ ", 입사일 : " + k.hireDate()
						   	+ ", 담당구역 : " + k.zoneId())
				   .forEach(System.out::println);
		}
	}
	private void updateKeeper() {
		System.out.println("사육사 정보 수정 프로그램입니다.");
		System.out.print("정보를 수정할 사육사의 ID를 입력해주세요 : ");
		String keeperId = sc.nextLine();
		System.out.print("새 이름을 입력해주세요 : ");
		String keeperName = sc.nextLine();
		System.out.print("새 담당구역을 입력해주세요 : ");
		String zoneId = sc.nextLine();
		System.out.print("새 입사일을 입력해주세요 (yyyy-MM-dd) : ");
		String hireDate = sc.nextLine();
		
		Map<String, String> keeper = new HashMap();
		keeper.put("keeperId", keeperId);
		keeper.put("keeperName", keeperName);
		keeper.put("zoneId", zoneId);
		keeper.put("hireDate", hireDate);
		
		int result = kc.updateKeeper(keeper);
		
		if(result > 0) {
			System.out.println("정보 수정에 성공했습니다");
		} else {
			System.out.println("정보 수정에 실패했습니다");
		}
	}
	
	private void deleteKeeper() {
		
		System.out.println("사육사의 정보를 삭제합니다");
		System.out.println("삭제할 사육사의 ID를 입력해주세요 : ");
		String keeperId = sc.nextLine();
		
		int result = kc.deleteKeeper(keeperId);
		
		if(result > 0) {
			System.out.println("사육사 정보삭제를 성공했습니다.");
		} else {
			System.out.println("사육사 정보삭제를 실패했습니다.");
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
