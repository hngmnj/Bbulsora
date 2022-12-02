package gntp.bbulsora.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.DeliveryVO;
import gntp.bbulsora.project.vo.StateVO;
import gntp.bbulsora.project.vo.StockVO;

@Repository("deliveryDAO")
public class DeliveryDAO {
   @Autowired
   private SqlSession sqlSession;

   public List<DeliveryVO> selectSearchDelivery(Map<String, Object> data) {
      List<DeliveryVO> list = sqlSession.selectList("mapper.delivery.selectSearchDelivery", data);
      for(int i=0; i<list.size(); i++) {
         String dlvryState = list.get(i).getStateCd();
         List<StateVO> stateList = sqlSession.selectList("mapper.state.selectStatesForUpdateDelivery", dlvryState);
         list.get(i).setStateList(stateList);
      }
      return list;
   }

   public List<DeliveryVO> selectDeliveryAll() {
      List<DeliveryVO> list = sqlSession.selectList("mapper.delivery.selectDeliveryAll");
      for(int i=0; i<list.size(); i++) {
         String dlvryState = list.get(i).getStateCd();
         List<StateVO> stateList = sqlSession.selectList("mapper.state.selectStatesForUpdateDelivery", dlvryState);
         list.get(i).setStateList(stateList);
      }
      return list;
   }
   
   public int insertOne(DeliveryVO delivery) {
      return sqlSession.insert("mapper.delivery.insertDeliveryReq", delivery);
   }
   
   public int updateAllState(Map<String, Object> map) {
      return sqlSession.update("mapper.delivery.updateAllDeliveryStatus", map);
   }
   
   public int updateSepState(Map<String, Object> map) {
      return sqlSession.update("mapper.delivery.updateSepDeliveryStatus", map);
   }

   public List<DeliveryVO> searchReqInfoByCode(Map<String, Object> map) {
      List<DeliveryVO> list = sqlSession.selectList("mapper.delivery.searchReqInfoByCode", map);
      for(int i=0; i<list.size(); i++) {
         String dlvryState = list.get(i).getStateCd();
         List<StateVO> stateList = sqlSession.selectList("mapper.state.selectStatesForUpdateDelivery", dlvryState);
         list.get(i).setStateList(stateList);
      }
      return list;
   }

}