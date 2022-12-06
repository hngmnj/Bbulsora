package gntp.bbulsora.project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.FifoVO;
import gntp.bbulsora.project.vo.StockVO;

@Repository("stockDAO")
public class StockDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	// 창고 운영사 조회
	public List<StockVO> selectAllForAdmin(Map<String, Object> map) {
		return sqlSession.selectList("mapper.stock.selectAllStockList", map);
	}

	// 고객사 조회
	public List<StockVO> selectAllForCli(Map<String, Object> map) {
		return sqlSession.selectList("mapper.stock.selectAllStockListForCli", map);
	}
	
	// 품목 조회
	public List<StockVO> selectItemList() {
		return sqlSession.selectList("mapper.stock.selectItemName");		
	}
	
	// 상태 조회
	public List<StockVO> selectStateList() {
		return sqlSession.selectList("mapper.stock.selectStateContent");		
	}
	
	// 고객사별 조회
	public Object selectClientList() {
		return sqlSession.selectList("mapper.stock.selectClient");
	}
	
	// 재고 검색
	public List<StockVO> selectSearchStock(Map<String, String> data) {
		return sqlSession.selectList("mapper.stock.selectSearchStock", data);
	}

	// 품목 로트별 검색
	public List<StockVO> selectSearchStockByLot(Map<String, Object> data) {
		return sqlSession.selectList("mapper.stock.selectSearchStockByLot", data);
	}
	
	public StockVO selectOne(String stockSeq) {
		return sqlSession.selectOne("mapper.stock.selectOne", stockSeq);
	}
	
	public int updateOne(StockVO stock) {
		return sqlSession.update("mapper.stock.updateOne", stock);
	}

	public StockVO selectForDelivery(String itemCd) {
		return sqlSession.selectOne("mapper.stock.selectForDelivery", itemCd);
	}

	public int updateRelease(FifoVO fifo) {
		return sqlSession.update("mapper.stock.subtractingFIFO", fifo);
	}
}
