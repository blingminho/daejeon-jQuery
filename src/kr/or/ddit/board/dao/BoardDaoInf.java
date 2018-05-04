package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface BoardDaoInf {
	
	//전체데이터 가져오기
	public List<BoardVO> selectAll() throws SQLException;
	
	//페이지 별 데이터 가져오기
	public List<BoardVO> selectAll(Map<String, Object> map) throws SQLException;
	
}
