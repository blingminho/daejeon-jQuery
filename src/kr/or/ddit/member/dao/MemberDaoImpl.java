package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.ziptb.vo.ZipVo;

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
	
	@SuppressWarnings("unchecked")
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
	@Override
	public String idCheck(String mem_id) throws SQLException {
		String result = (String)smc.queryForObject("member.idCheck", mem_id);
		System.out.println(result);
		return result;
//		return (String)smc.queryForObject("member.idCheck", mem_id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ZipVo> zipSearch(String dong) throws SQLException {
		return (List<ZipVo>)smc.queryForList("member.zipSearch", dong);
	}
	@Override
	public String insertMember(MemberVo vo) throws SQLException {
		return (String)smc.queryForObject("member.insertMember", vo);
	}

}
