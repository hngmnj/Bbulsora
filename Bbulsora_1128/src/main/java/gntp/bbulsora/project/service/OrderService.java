package gntp.bbulsora.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gntp.bbulsora.project.dao.OrderDAO;
import gntp.bbulsora.project.utils.CodeMakingRule;
import gntp.bbulsora.project.vo.MemberVO;
import gntp.bbulsora.project.vo.OrderVO;

@Service("orderService")
public class OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	// 권한별 조회 데이터 구분
	public Map<String, Object> getListByAccRights(HttpServletRequest request) {	
		MemberVO member = (MemberVO)request.getSession().getAttribute("user");
		String compCd = member.getCompCd();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fromDate",  request.getParameter("fromDate"));
		map.put("toDate",  request.getParameter("toDate"));
		map.put("compCd", compCd);
		List<OrderVO> list;
		if(compCd.equals("ADMIN")) {
			list = orderDAO.selectAll(map);
		}else if(compCd.substring(0, 3).equals("CLI")) {
			list = orderDAO.selectAllByCompCdForCli(map);
		}else {
			list = orderDAO.selectAllByCompCdForSup(map);
		}
		map.put("list", list);
		map.remove("compCd");
		return map;
	} 

	// 복수 품목 처리
	public boolean insertOrderList(List<OrderVO> data, String compCd) {
		boolean flag = true;
		String orderCd = CodeMakingRule.OrderCode(compCd);
		for(int i=0; i<data.size(); i++) {
			data.get(i).setCompCd(compCd);
			data.get(i).setOrderCd(orderCd);
			if(!orderDAO.insertOne(data.get(i))) {
				flag = false;
			}
		}
		return flag;
	}	

}
