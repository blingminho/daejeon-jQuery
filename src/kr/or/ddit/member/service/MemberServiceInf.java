package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.ziptb.vo.ZipVo;

public interface MemberServiceInf {
	
	public List<MemberVo> getMemberAll();
	
	//id중복검사
	public String idCheck(String mem_id);
	
	//번호검색
	public List<ZipVo> zipSearch(String dong);
	
	//가입 - 저장 - 저장한 id를 리턴
	public String insertMember(MemberVo vo);
	
}
