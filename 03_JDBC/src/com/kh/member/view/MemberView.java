package com.kh.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.member.controller.MemberController;
import com.kh.member.exception.DuplicateMemberException;
import com.kh.member.exception.MemberIdToLargeException;
import com.kh.member.model.dto.BoardDto;
import com.kh.member.model.dto.LoginResponse;
import com.kh.member.model.dto.MemberDto;

public class MemberView {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private LoginResponse lr = null;
	
	public void mainMenu() {
		while(true) {
			System.out.println();
			System.out.println("회원 서비스에 오신걸 환영합니다");
			if(lr != null) {
				System.out.println("1. 로그아웃");
				System.out.println("2. 게시판 이동");
			} else {
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
			}
			
			System.out.println("9. 프로그램을 종료합니다");
			
			System.out.print("원하시는 메뉴를 선택해주세요 : ");
			String menu = sc.nextLine();
			
			if(lr != null) {
				switch(menu) {
				case "1" : logout(); break;
				case "2" : boardMenu(); break;
				case "9" : return;
				}
			} else {
				switch(menu) {
				case "1" : signUp(); break; 
				case "2" : login(); break; 
				case "9" : return; 
				}
			}
		}
	
	}
		

	private void signUp() {
		System.out.println("회원가입 프로그램입니다");
		String memberId;
		while(true) {
			System.out.print("사용하실 ID를 입력해주세요 : ");
			memberId = sc.nextLine();
		
			if(!mc.idCheck(memberId)) {
				break;
			}
			System.out.println("이미 존재하는 아이디입니다.");
		}
		System.out.print("사용하실 비밀번호를 입력해 주세요 : ");
		String memberPwd = sc.nextLine();
		System.out.print("사용하실 이름을 입력해주세요 : ");
		String memberName = sc.nextLine();
		
		try {
		int result = mc.signUp(new MemberDto(memberId, memberPwd, memberName));
		
		if(result > 0) {
			System.out.println("가입 성공");
		} else {
			System.out.println("가입 실패");
		}
		
	} catch(MemberIdToLargeException e) {
		
	} catch(DuplicateMemberException e) {
		
	}	
}
	
	private void login() {
		System.out.print("아이디를 입력해주세요 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String memberPwd = sc.nextLine();
		
		MemberDto loginMember = new MemberDto();
		loginMember.setMemberId(memberId);;
		loginMember.setMemberPwd(memberPwd);;
		LoginResponse lr = mc.login(loginMember);
		
		if(lr != null) {
			System.out.println("로그인에 성공했습니다.");
			this.lr = lr;
		} else {
			System.out.println("로그인에 실패했습니다");
		}
	}
		
		public void logout() {
			lr = null;
			System.out.println("로그아웃에 성공했습니다.");
	}
	
	private void boardMenu() {
		while(true) {
			System.out.println();
			System.out.println("게시판 프로그램입니다");
			System.out.println("=====================");
			System.out.println("1. 게시글 작성");
			System.out.println("2. 게시글 전체조회");
			System.out.println("3. 게시글 상세 조회");
			System.out.print("원하시는 메뉴를 선택해주세요 : ");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : insertBoard(); break;
			case "2" : selectBoardList(); break;
			case "3" : selectBoard(); break;
			case "4" : return;
			}
		}
	}
	private void insertBoard() {
		int result = mc.selectInsertCount(lr.getMemberId());
		
		if(5 < result) {
			System.out.println("게시글 작성 권한이 없습니다.");
			return;
		}
		System.out.println();
		System.out.println("========================");
		System.out.println("게시글 작성 프로그램입니다");
		System.out.print("게시글 제목을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.print("게시글 내용을 입력해주세요 : ");
		String content = sc.nextLine();
		
		int insertResult = mc.insertBoard(new BoardDto(title,
									content,
									lr.getMemberId()));
		if(insertResult > 0) {
			System.out.println("게시글 작성에 성공했습니다");
		} else {
			System.out.println("게시글 작성에 실패했습니다");
		}
	}
	private void selectBoardList() {
		System.out.println("게시글 조회 프로그램입니다");
		System.out.println("=======================");
		List<BoardDto> boards = mc.selectBoardList();
		
		if(boards.isEmpty()) {
			System.out.println("게시글이 아직 존재하지 않습니다.");
			System.out.println("게시글을 작성해보세요.");
		} else {
			System.out.println("=======================");
			for(BoardDto board : boards) {
				System.out.println("글 번호 : " + board.getBoardNo()
								 + " | 제목 | " + board.getBoardTitle()
								 + " | 작성자 | " + board.getBoardWriter());
			}
			System.out.println("=======================");
		}
	}
	private void selectBoard() {
		System.out.println();
		System.out.println("게시글 상세조회 프로그램입니다");
		selectBoardList();
		
		System.out.print("상세조회하실 게시글 번호를 입력해주세요 : ");
		String boardNo = sc.nextLine();
		
		BoardDto board = mc.selectBoard(boardNo);
		
		if(board != null) {
			System.out.println(board.getBoardNo() + "번 게시글");
			System.out.println("--------------------------------");
			System.out.println("제목 : " + board.getBoardTitle());
			System.out.println("--------------------------------");
			System.out.println("내용 : " + board.getBoardContent());
			System.out.println("--------------------------------");
			System.out.println("작성자 : " + board.getBoardWriter());
			System.out.println("================================");
		} else {
			System.out.println("존재하지 않는 게시글 번호입니다.");
		}
	}
	
	
	
	
	
	
	
	
}
