package gntp.bbulsora.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gntp.bbulsora.project.dao.ItemDAO;
import gntp.bbulsora.project.dao.OrderDAO;
import gntp.bbulsora.project.service.OrderService;
import gntp.bbulsora.project.vo.MemberVO;
import gntp.bbulsora.project.vo.OrderVO;

@Controller("orderController")
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView upload(@RequestParam("orderCd") String orderCd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println("명세서내보내기완료");
		
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	@RequestMapping(value="/basic.do", method=RequestMethod.POST)
	public ModelAndView basic(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Create
	@RequestMapping(value="/viewCreate.do", method=RequestMethod.GET)
	public ModelAndView viewCreate(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.addObject("itemList", itemDAO.selectAllMajor());
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	public void test(@RequestBody List<OrderVO> data, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO temp = (MemberVO)request.getSession().getAttribute("user");
		orderService.insertOrderList(data,temp.getCompCd());
	}
	
	// Read All
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		Map<String,Object> orderMap = orderService.getListByAccRights(request);
		mav.addObject("orderMap", orderMap);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Read One
	@RequestMapping(value="/read.do", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam("orderCd") String orderCd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		MemberVO vo = (MemberVO)request.getSession().getAttribute("user");
		String compCd = vo.getCompCd();
		List<OrderVO> list;
		if(compCd.substring(0, 3).equals("SUP")) {
			list = orderDAO.selectOrderByOrderCdForSup(orderCd, compCd);
		}else {
			list = orderDAO.selectByOrderCd(orderCd);
		}
		mav.addObject("list", list);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Update
		@RequestMapping(value="/update.do", method=RequestMethod.GET)
		public ModelAndView update(@RequestParam Map<String,String> order, @RequestParam("storeQtt") String storeQtt, HttpServletRequest request, HttpServletResponse response, RedirectAttributes re) throws Exception {
			ModelAndView mav = new ModelAndView();
			System.out.println(order);
			orderDAO.updateOne(order);
			//상차작업으로 변경시 입고테이블로
			if(order.get("stateCd").equals("O005")) {
				orderDAO.insertStore(order);
			}
			re.addAttribute("orderCd", order.get("orderCd"));
			re.addAttribute("storeQtt", Integer.parseInt(storeQtt));
			mav.setViewName("redirect:./read.do");
			return mav;
		}
	
//	@RequestMapping(value="/updateStatus.do", method={RequestMethod.GET,RequestMethod.POST})
//	public ModelAndView updateStatus(@RequestParam("orderSeq") String orderSeq, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		orderDAO.updateState(Integer.parseInt(orderSeq));
//		mav.setViewName("redirect:./list.do");
//		return mav;
//	}
	
	// Delete
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("orderSeq") String orderSeq, @RequestParam("orderCd") String orderCd, HttpServletRequest request, HttpServletResponse response, RedirectAttributes re) throws Exception {
		ModelAndView mav = new ModelAndView();
		orderDAO.deleteOne(orderSeq);
		re.addAttribute("orderCd", orderCd);
		mav.setViewName("redirect:./read.do");
		return mav;
	}
		
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
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
		
		return "/order"+fileName;
	}
}
