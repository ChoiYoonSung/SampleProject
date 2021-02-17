package controller;

import java.util.Map;

import service.BoardService;
import service.UserService;
import util.ScanUtil;
import util.View;

public class Controller {
	public static void main(String[] args) {
		/*
		 * 조 소개 - 주제 소개 - 주제 선정 이유 - 메뉴 구조 - 시연
		 * 
		 * Controller : 화면 이동
		 * Service : 화면 기능 (실질적인 기능 구현)
		 * Dao(Data Access Object) : 쿼리 작성 (JAVA - DB 연결)
		 */
		
		new Controller().start();
		
	}
	
	public static Map<String, Object> loginUser;
	
	private UserService userService = UserService.getInstance();
	private BoardService boardService = BoardService.getInstance();
	
	private void start() {
		int view = View.HOME;
		
		while(true){
			switch(view){
			case View.HOME: view = home(); break;
			case View.LOGIN: view = userService.login(); break;
			case View.JOIN: view = userService.join(); break;
			case View.BOARD_LIST: view = boardService.boardList(); break;
			}
		}
	}

	private int home() {
		System.out.println("========================================");
		System.out.println("       1.로그인       2.회원가입       0.종료");
		System.out.println("========================================");
		System.out.print(">");
		
		int input = ScanUtil.nextInt();
		
		switch(input){
		case 1: return View.LOGIN;
		case 2: return View.JOIN;
		case 0:
			System.out.println("종료");
			System.exit(0);		
		}
		return View.HOME;
	}

}




