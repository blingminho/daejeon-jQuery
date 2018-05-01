package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVo;

public class ProdDaoImpl implements ProdDaoInf {
	
	private SqlMapClient client;
	private static ProdDaoInf dao = new ProdDaoImpl();
	
	private ProdDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static ProdDaoInf getInstance(){
		return dao;
	}
	
	@Override
	public List<ProdVo> listProdNames(String lprod_gu) throws SQLException {
		return client.queryForList("prod.listProdNames", lprod_gu);
	}

	@Override
	public ProdVo detailProd(String prod_id) throws SQLException {
		return (ProdVo) client.queryForObject("prod.detailProd", prod_id);
	}

}
