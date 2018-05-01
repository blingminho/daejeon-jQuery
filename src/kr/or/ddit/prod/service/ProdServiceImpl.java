package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.vo.ProdVo;

public class ProdServiceImpl implements ProdServiceInf {
	
	private static ProdServiceInf service = new ProdServiceImpl();
	private ProdDaoInf dao = null;
	
	private ProdServiceImpl(){
		dao = ProdDaoImpl.getInstance();
	}
	
	public static ProdServiceInf getInstance(){
		return service;
	}
	
	
	@Override
	public List<ProdVo> listProdNames(String lprod_gu) throws SQLException {
		return dao.listProdNames(lprod_gu);
	}

	@Override
	public ProdVo detailProd(String prod_id) throws SQLException {
		return dao.detailProd(prod_id);
	}

}
