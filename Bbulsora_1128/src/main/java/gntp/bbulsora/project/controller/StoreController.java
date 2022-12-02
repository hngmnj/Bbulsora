package gntp.bbulsora.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gntp.bbulsora.project.dao.LocationDAO;
import gntp.bbulsora.project.dao.StateDAO;
import gntp.bbulsora.project.dao.StoreDAO;
import gntp.bbulsora.project.utils.CodeMakingRule;
import gntp.bbulsora.project.vo.StoreVO;

@Controller("storeController")
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreDAO storeDAO;

	@Autowired
	private StateDAO stateDAO;

	@Autowired
	private LocationDAO locationDAO;

	/////////////////////    기본 메소드 형    ////////////////////////////////
	public ModelAndView basic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);

		mav.setViewName(viewName);
		return mav;
	}

	// Read One
	@RequestMapping(value="/read.do", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam("orderCd") String orderCd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		List<StoreVO> list = storeDAO.selectStoreByOrderCd(orderCd);
		mav.addObject("stateContentList", stateDAO.selectStoreState());
		mav.addObject("list", list);
		mav.setViewName(viewName);
		return mav;
	}

	// Update
	@RequestMapping(value="/update.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView update(@ModelAttribute("info") StoreVO vo, @RequestParam Map<String, String> store, HttpServletRequest request, HttpServletResponse response, RedirectAttributes re) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println(vo);
		storeDAO.updateOne(store);
		store.put("lot", CodeMakingRule.LotNo(vo));
		System.out.println(store);
		if(vo.getStateCd().equals("I004")) {
			storeDAO.insertStock(store);
		}
		re.addAttribute("storeSeq", store.get("storeSeq"));
		mav.setViewName("redirect:./list.do");
		return mav;
	}   

	// Read All
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		List<StoreVO> list = storeDAO.selectAll();
		mav.addObject("orderCdList", storeDAO.selectOrderCd());
		mav.addObject("stateContentList", stateDAO.selectStoreState());
		mav.addObject("list", list);
		mav.setViewName(viewName);
		return mav;
	}

	// Location Page
	@RequestMapping(value="/location.do", method=RequestMethod.GET)
	public ModelAndView location(@RequestParam("storeSeq") String storeSeq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		StoreVO store = storeDAO.selectStoreBySeq(storeSeq);
		mav.addObject("store", store);
		mav.addObject("location", locationDAO.selectLocInfo());
		mav.setViewName(viewName);
		return mav;
	}

	// Location Setting
	@RequestMapping(value="/updateArea.do", method=RequestMethod.POST)
	public ModelAndView updateArea(@RequestParam("locArea") String locArea, @RequestParam("storeSeq") String storeSeq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("locArea", locArea);
		map.put("storeSeq", storeSeq);
		storeDAO.setArea(map);
		mav.setViewName("redirect:./location.do?storeSeq="+storeSeq);
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0; //
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?"); 
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf(".")); 
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		System.out.println(fileName);
		return "/store"+fileName;
	}
}
