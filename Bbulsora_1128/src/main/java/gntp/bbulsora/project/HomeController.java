package gntp.bbulsora.project;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gntp.bbulsora.project.service.HomeService;
import gntp.bbulsora.project.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewLogin(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "viewLogin";
	}
		
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		MemberVO member = homeService.loginCheck(id, pwd);
		if(member != null) {
			request.getSession().setAttribute("user", member);
			mav.setViewName("redirect:./main.do");
		}else {
			mav.setViewName("redirect:./loginError.do");
		}
		return mav;
	}

	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.getSession().invalidate();
		String viewName = "redirect:./";
		mav.setViewName(viewName);	
		return mav;
	}
	
	//???????????? ??????
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String update(@ModelAttribute("info") MemberVO member, HttpServletRequest request) {
		homeService.updateMember(member);
		request.getSession().setAttribute("user", member);
		return "redirect:./main.do";
	}
	
	//?????? ?????? ?????? ????????? ??????
	@RequestMapping(value="/viewUpdate.do", method=RequestMethod.GET)
	public String viewUpdate() {
		return "viewUpdate";
	}
	
	//????????? ?????? ????????? ??????
	@RequestMapping(value="/viewFindId.do", method=RequestMethod.GET)
	public String viewFindId() {
		return "viewFindId";
	}
	
	//???????????? ?????? ????????? ??????
	@RequestMapping(value="/viewFindPwd.do", method=RequestMethod.GET)
	public String viewFindPwd() {
		return "viewFindPwd";
	}
	
	//???????????? ????????? ??????
	@RequestMapping(value="/viewJoin.do", method=RequestMethod.GET)
	public ModelAndView viewJoin() {
		ModelAndView mav = new ModelAndView("viewJoin");
		mav.addObject("compList", homeService.getCompList());
		return mav;
	}
	
	//?????????????????? ??? ????????????????????? ??????
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(@ModelAttribute("info") MemberVO member) {
		homeService.createMember(member);
		return "viewLogin";
	}
	
	//?????? ????????? ??????
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String main() {
		return "redirect:./board/list.do";
	}
	
	//????????? ?????????
	@RequestMapping(value="/loginError.do", method=RequestMethod.GET)
	public String loginError() {
		return "loginError";
	}

}
