package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.OrderVO;
import gntp.bbulsora.project.vo.StateVO;

@Repository("orderDAO")
public class OrderDAO {

	@Autowired
	private SqlSession sqlSession;
	public OrderDAO() {}


	//공급사용
	public List<OrderVO> selectAllByCompCdForSup(Map<String, Object> map) {
		List<OrderVO> list = null;
		list = sqlSession.selectList("mapper.order.selectOrderByCompCdForSup",map);
		return list;
	}
	
	//고객사용
	public List<OrderVO> selectAllByCompCdForCli(Map<String, Object> map) {
		List<OrderVO> list = null;
		list = sqlSession.selectList("mapper.order.selectOrderByCompCdForCli",map);
		return list;
	}
	
	//관리자용
	public List<OrderVO> selectAll(Map<String, Object> map) {
		List<OrderVO> list = null;
		list = sqlSession.selectList("mapper.order.selectAllOrderList", map);
		return list;
	}

	public List<OrderVO> selectByOrderCd(String orderCd) {
		return sqlSession.selectList("mapper.order.selectOrderByOrderCd", orderCd);
	}
	
	public List<OrderVO> selectOrderByOrderCdForSup(String orderCd, String compCd) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("orderCd", orderCd);
		map.put("compCd", compCd);
		List<OrderVO> list = sqlSession.selectList("mapper.order.selectOrderByOrderCdForSup", map);
		for(int i=0; i<list.size(); i++) {
			String orderState = list.get(i).getStateCd();
			List<StateVO> stateList = sqlSession.selectList("mapper.state.selectStatesForUpdateOrder", orderState);
			list.get(i).setStateList(stateList);
		}
		return list;
	}

	public boolean insertOne(OrderVO order) {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.order.insertOrder", order);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Insert order: "+flag);
		return flag;
	}

	//상태정보 수정
	public boolean updateOne( Map<String,String> order) {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.order.updateOrderState", order);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	//상차작업 시 입고테이블로 데이터 전송
	public boolean insertStore(Map<String,String> order) {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.order.insertStore", order);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}

	//주문코드별 삭제
	public boolean deleteOne(String orderCd) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.order.deleteOrder", orderCd);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
}
