package game.dori.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import game.dori.vo.MEMBER_VO;


@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static String namespace = "game.dori.mapper.MemberMapper.";
	
	public MEMBER_VO selectByBno(int member_idx)
	{
		return sqlSession.selectOne(namespace + "selectByBno",member_idx);
	}
	
	public int insertMember(MEMBER_VO memberVO) {
	    // 매퍼 인터페이스를 사용하여 insertMember 쿼리를 실행합니다.
		sqlSession.insert(namespace + "insertMember", memberVO);

	    // 새로 생성된 MEMBER_IDX 값을 반환합니다.
	    return memberVO.getMember_idx();
	}
	
	public MEMBER_VO Login(MEMBER_VO MemberVO)
	{
		
		return sqlSession.selectOne(namespace + "Login" , MemberVO);
	}
	
	public MEMBER_VO selectByEmail(String member_email)
	{
		return sqlSession.selectOne(namespace + "selectByEmail",member_email);
	}
	
	public int updateyn(MEMBER_VO memberVO) {
		return sqlSession.update(namespace + "updateMemberyn",memberVO);
	
	}
	
	//회원리스트
	public List<MEMBER_VO> list(){
		return sqlSession.selectList(namespace + "memberlist");
	}
	
	//회원 상태(일반, 정지) 변경
	public int updateMemberState(MEMBER_VO memberVO) {
		return sqlSession.update(namespace + "updateMemberState",memberVO);
	
	}
	
	
}
