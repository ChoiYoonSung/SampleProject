package service;

import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import dao.BoardDao;

public class BoardService {
	private BoardService(){}
	private static BoardService instance;
	public static BoardService getInstance(){
		if(instance == null)
			instance = new BoardService();
		return instance;
	}
	
	private BoardDao boardDao = BoardDao.getInstance();
	
	public int boardList(){
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		
		System.out.println("======================================");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("--------------------------------------");
		for(Map<String, Object> board : boardList){
			System.out.println(board.get("BOARD_NO") + "\t"
					+ board.get("TITLE") + "\t"
					+ board.get("CONTENT") + "\t"
					+ board.get("REG_DATE") + "\t");
		}
		System.out.println("======================================");
		System.out.println("1.조회\t2.등록\t0.로그아웃");
		System.out.print(">");
		
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			break;
		case 2:
			break;
		case 0:
			System.out.println("종료");
			System.exit(0);
		}
		
		return View.BOARD_LIST;
		
	}
	
	void search(){
		System.out.println("번호를 입력하십시오");
		System.out.print(">");
		int input = ScanUtil.nextInt();
		
	}
	
	void insert(){
		
	}
}
