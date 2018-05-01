package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.vo.LprodVo;

public class LprodService implements LprodServiceInf {

	private static LprodServiceInf service = new LprodService();
	
	public static LprodServiceInf getInstance() {
		if (service==null) {
			service=new LprodService();
		}
		return service;
	}
	
	LprodDaoInf dao =LprodDao.getInstance();
	@Override
	public List<LprodVo> getLprodAll() throws SQLException {
		return dao.getLprodAll();
	}

}
