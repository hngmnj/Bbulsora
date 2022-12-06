package gntp.bbulsora.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.FifoVO;

@Repository("fifoDAO")
public class FifoDAO {
	private SqlSession sqlSession;
	
	public List<FifoVO> selectForFIFO(Map<String, Object> data) {
		return sqlSession.selectList("mapper.fifo.selectForFIFO", data);
	}
}
