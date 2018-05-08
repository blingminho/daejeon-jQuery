package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDao implements BoardDaoInf{
	private static BoardDaoInf dao;
	private SqlMapClient smc;
	
	private BoardDao(){
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static BoardDaoInf getInstance(){
		if(dao == null)
			dao = new BoardDao();
		return dao;
	}
	
	
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		return smc.queryForList("board.selectAll");
	}

	@Override
	public List<BoardVO> selectAll(Map<String, Object> map) throws SQLException {
		return smc.queryForList("board.listpage", map);
	}

	@Override
	public int listCount() throws SQLException {
		return (int) smc.queryForObject("board.listCount");
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		return (int) smc.insert("board.insertBoard", vo);
	}

}
