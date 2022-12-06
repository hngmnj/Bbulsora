package gntp.bbulsora.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gntp.bbulsora.project.dao.DeliveryDAO;
import gntp.bbulsora.project.utils.CodeMakingRule;
import gntp.bbulsora.project.vo.DeliveryVO;
import gntp.bbulsora.project.vo.FifoVO;

@Service
public class DeliveryService {
	@Autowired
	private DeliveryDAO deliveryDAO;
	
	public void insertRequestData(List<DeliveryVO> list, String compCd) {
		DeliveryVO sample = list.get(0);
		int cnt = list.size();
		sample.setCompCd(compCd);
		sample.setCnt(cnt);
		String dlvryCd = CodeMakingRule.DeliveryCode(sample);
		sample.setCompCd(null);
		for(int i=0;i<cnt;i++) {
			list.get(i).setDlvryCd(dlvryCd);
			list.get(i).setCompCd(compCd);
			list.get(i).setStateCd("D001");
			list.get(i).setCnt(cnt);
			deliveryDAO.insertOne(list.get(i));
		}
	}
	
	public List<FifoVO> MultiFIFOData(String dlvryCd) {
		List<FifoVO> result = new ArrayList<FifoVO>();
		List<DeliveryVO> dlvryList = deliveryDAO.selectReqByDeliveryCode(dlvryCd);
		for(int i=0;i<dlvryList.size();i++) {
			DeliveryVO delivery = dlvryList.get(i);
			List<FifoVO> fifoList = deliveryDAO.selectForMultiFIFO(delivery);
			for(int j=0;j<fifoList.size();j++) {
				FifoVO fifo = fifoList.get(j);
				result.add(fifo);
			}
		}
		return result;
	}
}
