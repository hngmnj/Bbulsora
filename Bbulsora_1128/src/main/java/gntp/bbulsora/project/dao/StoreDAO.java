package gntp.bbulsora.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.StateVO;
import gntp.bbulsora.project.vo.StoreVO;

@Repository("storeDAO")
public class StoreDAO {

   @Autowired
   private SqlSession sqlSession;
   public StoreDAO() {}
   
   //주문코드별 조회
   public List<StoreVO> selectStoreByOrderCd(String orderCd) {
      List<StoreVO> list = sqlSession.selectList("mapper.store.selectStoreByOrderCd", orderCd);
      List<StateVO> stateList = null;
      for(int i=0; i<list.size(); i++) {
         String storeState = list.get(i).getStateCd();
         stateList = sqlSession.selectList("mapper.state.selectStatesForUpdateStore", storeState); 
         list.get(i).setStateList(stateList);
      }
      return list;
   }
   
   //입고상태 수정
   public int updateOne(Map<String, String> store) {
      return sqlSession.update("mapper.store.updateStoreState", store);
   }
   
   //검색결과 리턴
   public List<StoreVO> selectSearchStore(Map<String, String> data) {
      return sqlSession.selectList("mapper.store.selectSearchStore",data);
   }

   //상태 내용 리턴
   public List<StoreVO> selectStateContent() {
      return sqlSession.selectList("mapper.store.selectStateContent");
   }
   
   //주문코드 리턴
   public List<StoreVO> selectOrderCd() {
      return sqlSession.selectList("mapper.store.selectOrderCd");
   }
   
   //번호 리턴
   public StoreVO selectStoreBySeq (String storeSeq) {
      return sqlSession.selectOne("mapper.store.selectStoreBySeq", Integer.parseInt(storeSeq));
   }
   
   //전체 조회
   public List<StoreVO> selectAll() {
      List<StoreVO> list = null;
      list = sqlSession.selectList("mapper.store.selectAllStoreList");
      return list;
   }

   //로케이션 업데이트
   public int setArea(Map<String, Object> data) {
      return sqlSession.update("mapper.store.setArea", data);
   }

   public int insertStock(Map<String, String> store) {
      return sqlSession.insert("mapper.store.insertStock", store);
   }
}
