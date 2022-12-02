package gntp.bbulsora.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.LocationVO;

@Repository("locationDAO")
public class LocationDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//로케이션 조회
	public List<LocationVO> selectLocInfo() {
		return sqlSession.selectList("mapper.location.selectAllLocationList");
	}
}
