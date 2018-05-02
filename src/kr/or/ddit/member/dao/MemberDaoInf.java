package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.ziptb.vo.ZipVo;

public interface MemberDaoInf {
	public List<MemberVo> getMemberAll();
	
	//id중복검사
	public String idCheck(String mem_id) throws SQLException;
	
	//번호검색
	public List<ZipVo> zipSearch(String dong) throws SQLException;
	
	//가입 - 저장 - 저장한 id를 리턴
	public String insertMember(MemberVo vo) throws SQLException;
	
}
