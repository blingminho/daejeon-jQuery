package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.vo.BoardVO;

public class BoardService implements BoardServiceInf{
	private BoardDaoInf dao;
	private static BoardServiceInf service;
	
	private BoardService(){
		dao = BoardDao.getInstance();
	}
	public static BoardServiceInf getInstance(){
		if(service == null)
			service = new BoardService();
		return service;
	}
	
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BoardVO> selectAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
