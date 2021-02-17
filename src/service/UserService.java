package service;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import dao.UserDao;
import util.ScanUtil;
import util.View;

public class UserService {
	
	private UserService(){}
	private static UserService instance;
	public static UserService getInstance(){
		if(instance == null)
			instance = new UserService();
		return instance;
	}
	
	private UserDao userDao = UserDao.getInstance();
	
	
	public int join(){
		System.out.println("==========회원가입==========");
		System.out.print("ID : ");
		String userId = ScanUtil.nextLine();
		System.out.print("Password : ");
		String password = ScanUtil.nextLine();
		System.out.print("Name : ");
		String name = ScanUtil.nextLine();
		//아이디 중복 생략
		//비밀번호 확인 생략
		//정규표현식(유효성 검사) 생략
		
		Map<String, Object> param = new HashMap<>();
		param.put("USER_ID", userId);
		param.put("USER_PASSWORD", password);
		param.put("USER_NAME", name);
				
		
		int result = userDao.insertUser(param);
		
		if(0 < result){
			System.out.println("회원가입 완료");
		}else{
			System.out.println("회원가입 실패");
		}
		
		return View.HOME;
	}


	public int login() {
		System.out.print("ID : ");
		String userId = ScanUtil.nextLine();
		System.out.print("Password : ");
		String password = ScanUtil.nextLine();
		
		Map<String, Object> user = userDao.selectUser(userId, password);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하였습니다.");
		}else{
			System.out.println("로그인 성공");
			Controller.loginUser = user;
			//로그인 성공할 때 게시판으로 들어감
			return View.BOARD_LIST;
		}
		
		//로그인 실패할 때 홈으로 돌아감
		return View.HOME;
	}
	
}
