package gntp.bbulsora.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gntp.bbulsora.project.dao.DeliveryDAO;
import gntp.bbulsora.project.utils.CodeMakingRule;
import gntp.bbulsora.project.vo.DeliveryVO;

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
}
