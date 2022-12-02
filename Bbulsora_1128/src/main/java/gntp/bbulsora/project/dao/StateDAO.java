package gntp.bbulsora.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.StateVO;

@Repository("stateDAO")
public class StateDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<StateVO> selectAll() {
		List<StateVO> list = null;
		list = sqlSession.selectList("mapper.state.selectAllStateList");

		return list;
	}
	
	public boolean insertOne(StateVO state) {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.state.insertState", state);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}

	public List<StateVO> selectStoreState() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.state.selectStoreStateList");
	}
}
