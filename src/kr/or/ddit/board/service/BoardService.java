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
		List<BoardVO> list = null;
		
		try {
			list = dao.selectAll(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int listCount() {
		int count = 0;
		
		try {
			count = dao.listCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	@Override
	public int insertBoard(BoardVO vo) {
		int seq = 0;
		
		try {
			seq = dao.insertBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seq;
	}

}
