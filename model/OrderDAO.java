package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.MemberVO;
import gntp.bbulsora.project.vo.OrderVO;

@Repository("orderDAO")
public class OrderDAO {

	@Autowired
	private SqlSession sqlSession;
	public OrderDAO() {}


	public List<OrderVO> selectAll() throws SQLException{
		List<OrderVO> list = null;
		list = sqlSession.selectList("mapper.order.selectAllOrderList");

		return list;
	}

	public OrderVO selectOne(String orderCd) throws SQLException {
		OrderVO order = null;
		order = (OrderVO)sqlSession.selectOne("mapper.order.selectOrderByOrderCd", orderCd);
		return order;
	}

	public boolean insertOne(OrderVO order) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.order.insertOrder", order);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Insert order: "+flag);
		return flag;
	}

	//상태정보 수정
	public boolean updateOne(int orderSeq) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.order.updateOrderState", orderSeq);
		if(affectedCount > 0) {
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
