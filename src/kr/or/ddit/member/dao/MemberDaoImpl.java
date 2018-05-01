package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVo;

public class MemberDaoImpl implements MemberDaoInf {

	private SqlMapClient smc;
	
	private static MemberDaoInf dao = new MemberDaoImpl();
	
	
	//싱글턴 적용
	public static MemberDaoInf getInstance(){
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	{//초기화 블럭
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	@Override
	public List<MemberVo> getMemberAll() {
		List<MemberVo> list = null;
		try {
			list = smc.queryForList("member.listMemberAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
