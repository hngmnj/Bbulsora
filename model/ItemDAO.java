package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.MemberVO;

@Repository("itemDAO")
public class ItemDAO {

	@Autowired
	private SqlSession sqlSession;
	public ItemDAO() {}

	//조건 검색 결과
	public List<ItemVO> selectSearchItem(Map<String, String> data) {
		return sqlSession.selectList("mapper.item.selectSearchItem",data);
	}
	
	//선택된 대분류에 해당하는 중분류만 리턴
	public List<ItemVO> selectMinorByMiddle(String middle) {
		return sqlSession.selectList("mapper.item.selectMinorByMiddle",middle);
	}
	
	//선택된 대분류에 해당하는 중분류만 리턴
	public List<ItemVO> selectMiddleByMajor(String major) {
		return sqlSession.selectList("mapper.item.selectMiddleByMajor",major);
	}
	
	//대분류만 리턴
	public List<ItemVO> selectAllMajor(){
		return sqlSession.selectList("mapper.item.selectAllMajor");
	}
	
	public List<ItemVO> selectAll(){
		List<ItemVO> list = null;
		list = sqlSession.selectList("mapper.item.selectAllItemList");
		return list;
	}

	public ItemVO selectOne(String itemCd) {
		ItemVO item = null;
		item = (ItemVO)sqlSession.selectOne("mapper.item.selectItemByItemCd", itemCd);
		return item;
	}

	public boolean insertOne(ItemVO item) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.item.insertItem", item);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Insert Item: "+flag);
		return flag;
	}

	public boolean updateOne(ItemVO item) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.item.updateItem", item);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteOne(String itemCd) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.item.deleteItem", itemCd);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}



}
