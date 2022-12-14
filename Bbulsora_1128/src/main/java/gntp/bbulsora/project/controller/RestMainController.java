package gntp.bbulsora.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gntp.bbulsora.project.dao.CompanyDAO;
import gntp.bbulsora.project.dao.DeliveryDAO;
import gntp.bbulsora.project.dao.ItemDAO;
import gntp.bbulsora.project.dao.StockDAO;
import gntp.bbulsora.project.dao.StoreDAO;
import gntp.bbulsora.project.service.HomeService;
import gntp.bbulsora.project.vo.AdvinfoVO;
import gntp.bbulsora.project.vo.DeliveryVO;
import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.MemberVO;
import gntp.bbulsora.project.vo.StockVO;
import gntp.bbulsora.project.vo.StoreVO;

@RestController("restMainController")
@RequestMapping("/rest")
public class RestMainController {
	@Autowired
	private HomeService homeService;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private StockDAO stockDAO;
	@Autowired
	private StoreDAO storeDAO;
	@Autowired
	private DeliveryDAO deliveryDAO;
	
	/*
	 * (고객사) 정보조회
	 */
	
	@RequestMapping(value="/getSupsItem.do", method=RequestMethod.GET)
	public List<ItemVO> getSupsItem(@RequestParam("compCd") String compCd) throws Exception {
		return itemDAO.selectMyItems(compCd);
	}


	
	@RequestMapping(value="/getMonthSche.do", method=RequestMethod.GET) 
	public Map<String, Map<String, Map<String, String>>> getMonthSche(@RequestParam Map<String, Object> data) {
		List<AdvinfoVO> list = new ArrayList<AdvinfoVO> ();
		list = companyDAO.selectMonthSche(data);
		Map<String, String> dayMap = new HashMap<String, String> ();
		String[] dayData = list.get(0).dayData(list.get(0));
		for(int i=0;i<dayData.length;i++) {
			dayMap.put(""+(i+1)+"", dayData[i].trim());
		}
		dayMap.put("Qtt", list.get(0).getOutput());
		System.out.println(dayMap);
		String month = companyDAO.selectMonth(data);
		Map<String, Map<String, String>> monthMap = new HashMap<String,Map<String, String>> ();
		monthMap.put(month, dayMap);
		String year = companyDAO.selectYear(data);
		Map<String, Map<String, Map<String, String>>> yearMap = new HashMap<String, Map<String, Map<String, String>>> ();
		yearMap.put(year, monthMap);
		return yearMap;
	}

	
	/* 
	 * 품목관련
	 */
	
	// 대분류 선택시 해당하는 중분류 리턴
	@RequestMapping(value="/searchMiddleCtgr.do", method=RequestMethod.GET)
	public List<ItemVO> searchMiddleCtgr(@RequestParam("major") String major){
		return itemDAO.selectMiddleByMajor(major);
	}
	
	// 중분류 선택시 해당하는 소분류 리턴
	@RequestMapping(value="/searchMinorCtgr.do", method=RequestMethod.GET)
	public List<ItemVO> searchMinorCtgr(@RequestParam("middle") String middle){
		return itemDAO.selectMinorByMiddle(middle);
	}
	
	
	/*
	 * 입고관련
	 */
	
	// 조건검색 결과 리턴
	@RequestMapping(value="/searchStore.do", method=RequestMethod.GET)
	public List<StoreVO> searchStore(HttpServletRequest req){
		Map<String,String> data = new HashMap<String, String>();
		data.put("orderCd", req.getParameter("orderCd"));
		data.put("toDate", req.getParameter("toDate"));
		data.put("fromDate", req.getParameter("fromDate"));
		data.put("stateContent", req.getParameter("stateContent"));
		return storeDAO.selectSearchStore(data);
		}
	
	/*
	 * 주문관련
	 */
	// 대분류 선택시 해당하는 중분류 리턴
	@RequestMapping(value="/searchMiddle.do", method=RequestMethod.GET)
	public List<ItemVO> searchMiddle(@RequestParam("major") String major){
		return itemDAO.selectMiddleByMajor(major);
	}
	
	// 중분류 선택시 해당하는 소분류 리턴
	@RequestMapping(value="/searchMinor.do", method=RequestMethod.GET)
	public List<ItemVO> searchMinor(@RequestParam("middle") String middle){
		return itemDAO.selectMinorByMiddle(middle);
	}
	
	// 조건검색 결과 리턴
	@RequestMapping(value="/searchItem.do", method=RequestMethod.GET)
	public List<ItemVO> searchItem(HttpServletRequest req){
		Map<String,String> data = new HashMap<String, String>();
		data.put("major", req.getParameter("major"));
		data.put("middle", req.getParameter("middle"));
		data.put("minor", req.getParameter("minor"));
		data.put("searchText", req.getParameter("searchText"));
		return itemDAO.selectSearchItem(data);
	}
	
	// 대분류 리스트 리턴
	@RequestMapping(value="/selectItem.do", method=RequestMethod.GET)
	public ItemVO selectItem(@RequestParam("itemCd") String itemCd){
		return itemDAO.selectOne(itemCd);
	}
	
	/*
	 * 재고관련
	 */
	// 조건검색 결과 리턴(재고 검색)
	@RequestMapping(value="/searchStock.do", method=RequestMethod.GET)
	public List<StockVO> searchStock(HttpServletRequest req) throws Exception{
		Map<String, String> data = new HashMap<String, String>();
		String browser = req.getHeader("User-Agent");
		String item = req.getParameter("item");
		String client = req.getParameter("client");
		if(item!=null) {
			if(browser.contains("MSIE")||browser.contains("Trident")||browser.contains("Chrome")) {
				item = new String(item.getBytes("UTF-8"));
			} else {
				item = new String(item.getBytes("UTF-8"), "ISO-8859-1");
			}
		}
		if(client!=null) {
			if(browser.contains("MSIE")||browser.contains("Trident")||browser.contains("Chrome")) {
				client = new String(client.getBytes("UTF-8"));
			} else {
				client = new String(client.getBytes("UTF-8"), "ISO-8859-1");
			}
		}
		MemberVO member = (MemberVO) req.getSession().getAttribute("user");
		data.put("item", item);
		data.put("client", client);
		data.put("compCd", member.getCompCd());
		return stockDAO.selectSearchStock(data);
	}
	
	// 조건검색 결과 리턴(특정 품목 로트별 검색)
	@RequestMapping(value="/searchStockByLot.do", method=RequestMethod.GET)
	public List<StockVO> searchStockByLot(@RequestParam Map<String, Object> data, HttpServletRequest req){	
		return stockDAO.selectSearchStockByLot(data);
	}
	
	// 출고요청 품목 추가
	@RequestMapping(value="/selectForDelivery.do", method=RequestMethod.GET)
	public StockVO selectForDelivery(@RequestParam("itemCd") String itemCd, HttpServletRequest req){
		return stockDAO.selectForDelivery(itemCd);
	}
	
	/*
	 * 출고 관련 
	*/
	
	// 조건검색 결과 리턴(요청목록 검색)
	@RequestMapping(value="/searchDelivery.do", method=RequestMethod.GET)
	public List<DeliveryVO> searchDelivery(HttpServletRequest req) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		String browser = req.getHeader("User-Agent");
		String client = req.getParameter("client");
		if(client!=null) {
			if(browser.contains("MSIE")||browser.contains("Trident")||browser.contains("Chrome")) {
				client = new String(client.getBytes("UTF-8"));
			} else {
				client = new String(client.getBytes("UTF-8"), "ISO-8859-1");
			}
			data.put("client", client);
		}
		data.put("fromDate", req.getParameter("fromDate"));
		data.put("toDate", req.getParameter("toDate"));
		data.put("compCd", user.getCompCd());
		return deliveryDAO.selectSearchDelivery(data);
	}
	
	// 조건검색 결과 리턴(특정 품목 로트별 검색)
	@RequestMapping(value="/searchReqInfoByCode.do", method=RequestMethod.GET)
	public List<DeliveryVO> searchReqInfoByCode(@RequestParam Map<String, Object> data, HttpServletRequest req){
		return deliveryDAO.searchReqInfoByCode(data);
	}
	
	/*
	 *  계정 관련
	 */
	//아이디 중복체크
	@RequestMapping(value="/idCheck.do", method=RequestMethod.GET)
	public boolean idCheck(@RequestParam("id") String id) {
		boolean flag = false;
		flag = homeService.idCheck(id);
		return flag;
	}
	
	//아이디 찾기
	@RequestMapping(value="/findId.do", method=RequestMethod.GET)
	public String findId(HttpServletRequest req) {
		return homeService.findId(req.getParameter("name"), req.getParameter("compCd"), req.getParameter("phone"));
	}
	
	//비밀번호 찾기
	@RequestMapping(value="/findPwd.do", method=RequestMethod.GET)
	public String findPwd(HttpServletRequest req) {
		String status = "nag";
		System.out.println(req.getParameter("id"));
		if(homeService.findPwd(req.getParameter("id"), req.getParameter("name"), req.getParameter("compName"), req.getParameter("phone"))) {
			status = "pos";
		}
		return status;
	}
	
	//비밀번호 변경
	@RequestMapping(value="/changePwd.do", method=RequestMethod.GET)
	public String changePwd(HttpServletRequest req) {
		String status = "nag";
		if(homeService.changePwd(req.getParameter("id"), req.getParameter("pwd"))) {
			status = "pos";
		}
		return status;
	}
}
