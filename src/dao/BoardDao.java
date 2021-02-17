package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDao {
	private BoardDao(){}
	private static BoardDao instance;
	public static BoardDao getInstance(){
		if(instance == null)
			instance = new BoardDao();
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> selectBoardList(){
		String sql = " select a.board_no, a.title, a.content, b.user_name, a.reg_date"
				   + " from tb_jdbc_board a left outer join tb_jdbc_user b on a.user_id = b.user_id"
				   + " order by a.board_no desc";
		
		return jdbc.selectList(sql);
	}

	public List<Map<String, Object>> insertBoardList() {
		return null;
	}
}
