package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.StateVO;

@Repository("stateDAO")
public class StateDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<StateVO> selectAll() throws SQLException {
		List<StateVO> list = null;
		list = sqlSession.selectList("mapper.state.selectAllStateList");
	
		return list;
	}
	
	public StateVO selectOne(String stateCd) throws SQLException {
		StateVO state = null;
		state = sqlSession.selectOne("mapper.state.selectStateByStateCd", stateCd); 
		return state;
	}
	
	public boolean insertOne(StateVO state) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.state.insertState", state);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	public boolean updateOne(StateVO state) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.state.updateState", state);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteOne(String stateCd) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.state.deleteState", stateCd);
		if(affectedCount > 0) {
			flag = true;	
		}
		return flag;
	}
}
