package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVo;

public class LprodDao implements LprodDaoInf {

	SqlMapClient smc;
	private static LprodDaoInf dao = new LprodDao();

	// 싱글턴 적용
	public static LprodDaoInf getInstance() {
		if (dao == null)
			dao = new LprodDao();
		return dao;
	}

	{
		smc = SqlMapClientFactory.getSqlMapClient();
	}

	@Override
	public List<LprodVo> getLprodAll() throws SQLException {
		List<LprodVo> list = null;
		list = (List<LprodVo>)smc.queryForList("lprod.listlprodAll");
		return list;
	}

	// public static void main(String[] args) {
	//
	// LprodDao dao = new LprodDao();
	// try {
	// List<LprodVo> list = dao.getLprodAll();
	// for (LprodVo lprodVo : list) {
	// System.out.println(lprodVo);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
}
