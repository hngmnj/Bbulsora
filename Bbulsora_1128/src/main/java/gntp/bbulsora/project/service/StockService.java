package gntp.bbulsora.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gntp.bbulsora.project.dao.StockDAO;
import gntp.bbulsora.project.utils.CodeMakingRule;
import gntp.bbulsora.project.vo.MemberVO;
import gntp.bbulsora.project.vo.StockVO;
import gntp.bbulsora.project.vo.StoreVO;

@Service("stockService")
public class StockService {
	@Autowired
	private StockDAO stockDAO;
	
	// 권한별 조회 데이터 구분
	public Map<String, Object> getListByAccRights(HttpServletRequest request) {	
		MemberVO member = (MemberVO)request.getSession().getAttribute("user");
		String compCd = member.getCompCd();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("compCd", compCd);
		System.out.println(compCd);
		List<StockVO> list = null;
		if(compCd.equals("ADMIN")) {
			list = stockDAO.selectAllForAdmin(map);
		} else if(compCd.substring(0, 3).equals("CLI")) {
			list = stockDAO.selectAllForCli(map);
		}
		map.put("list", list);
		map.put("itemList", stockDAO.selectItemList());
		map.put("clientList", stockDAO.selectClientList());
		map.remove("compCd");
		return map;
	}
	
	public boolean insertStockList(List<StockVO> data, StoreVO store) {
		boolean flag = true;
		String lotNo = CodeMakingRule.LotNo(store);
		for(int i=0; i<data.size(); i++) {
			data.get(i).setLot(lotNo);
		}
		return flag;
	}
}
