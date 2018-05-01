package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.vo.LprodVo;

public interface LprodServiceInf {
	public List<LprodVo> getLprodAll() throws SQLException;

}
