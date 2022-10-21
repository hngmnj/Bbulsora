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


	public List<MemberVO> selectAll() throws SQLException{
		List<MemberVO> list = null;
		list = sqlSession.selectList("mapper.member.selectAllMemberList");

		return list;
	}


	public MemberVO selectOne(String id) throws SQLException {
		MemberVO member = null;
		member = (MemberVO)sqlSession.selectOne("mapper.member.selectMemberById", id);
		return member;
	}

	public boolean insertOne(MemberVO member) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.member.insertMember", member);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Insert member: "+flag);
		return flag;
	}

	public boolean updateOne(MemberVO member) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.member.updateMember", member);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteOne(String id) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.member.deleteMember", id);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}


}
