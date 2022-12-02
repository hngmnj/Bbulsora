package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	public MemberDAO() {}

	//비밀번호만 변경
	public boolean changePwd(MemberVO vo) {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.member.updatePwd", vo);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	//조건조회 findPwd
	public MemberVO findPwd(MemberVO vo) {
		MemberVO member = null;
		member = (MemberVO)sqlSession.selectOne("mapper.member.selectMemberForFindPwd", vo);
		return member;
	}
	
	//조건조회 findId
	public MemberVO findId(MemberVO vo) {
		MemberVO member = null;
		member = (MemberVO)sqlSession.selectOne("mapper.member.selectMemberForFindId", vo);
		return member;
	}
	
	//로그인
	public MemberVO loginCheck(MemberVO vo) {
		return sqlSession.selectOne("mapper.member.selectMemberForLogin", vo);
	}
	
	//전체조회
		public List<MemberVO> selectAll() throws SQLException{
			List<MemberVO> list = null;
			list = sqlSession.selectList("mapper.member.selectAllMemberList");

			return list;
		}
	
	//조건조회
	public MemberVO selectOne(String id) {
		MemberVO member = null;
		member = (MemberVO)sqlSession.selectOne("mapper.member.selectMemberById", id);


		return member;
	}
	
	//멤버정보 입력
	public boolean insertOne(MemberVO member) {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.member.insertMember", member);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println(flag);
		return flag;
	}
	
	//멤버정보 수정
	public boolean updateOne(MemberVO member) {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.member.updateMember", member);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	//멤버정보 삭제
	public boolean deleteOne(String id) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.member.deleteMember", id);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}



}
