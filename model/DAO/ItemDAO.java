package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.MemberVO;

@Repository("ItemDAO")
public class ItemDAO {

	@Autowired
	private SqlSession sqlSession;
	public ItemDAO() {}


	public List<ItemVO> selectAll() throws SQLException{
		List<ItemVO> list = null;
		list = sqlSession.selectList("mapper.member.selectAllItemList");
		return list;
	}

	public ItemVO selectOne(String itemCd) throws SQLException {
		ItemVO item = null;
		item = (ItemVO)sqlSession.selectOne("mapper.member.selectItemByItemCd", itemCd);
		return item;
	}

	public boolean insertOne(ItemVO item) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.member.insertItem", item);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Insert Item: "+flag);
		return flag;
	}

	public boolean updateOne(ItemVO item) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.member.updateItem", item);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteOne(String itemCd) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.member.deleteItem", itemCd);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
}
