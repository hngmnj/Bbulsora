package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.MemberVO;

@Repository("MemberDAO")
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	public MemberDAO() {}

	//전체조회
		public List<MemberVO> selectAll() throws SQLException{
			List<MemberVO> list = null;
			list = sqlSession.selectList("mapper.member.selectAllMemberList");

			return list;
		}
	
	//조건조회
	public MemberVO selectOne(String id) throws SQLException {
		MemberVO member = null;
		member = (MemberVO)sqlSession.selectOne("mapper.member.selectMemberById", id);


		return member;
	}
	
	//멤버정보 입력
	public boolean insertOne(MemberVO member) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.member.insertMember", member);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println(flag);
		return flag;
	}
	
	//멤버정보 수정
	public boolean updateOne(MemberVO member) throws SQLException {
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
