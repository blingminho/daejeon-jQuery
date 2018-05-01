package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.vo.LprodVo;

public interface LprodDaoInf {
	public List<LprodVo> getLprodAll() throws SQLException;
}
