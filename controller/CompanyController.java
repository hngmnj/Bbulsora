package gntp.bbulsora.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gntp.bbulsora.project.dao.CompanyDAO;
import gntp.bbulsora.project.utils.CodeMakingRule;
import gntp.bbulsora.project.vo.CompanyVO;

@Controller("companyController")
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyDAO companyDAO;
	
	@RequestMapping(value="/basic.do", method=RequestMethod.GET)
	public ModelAndView basic(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Read All
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		List<CompanyVO> list = companyDAO.selectAll();
		mav.addObject("list", list);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Read One
	@RequestMapping(value="/read.do", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam("compCd") String compCd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		CompanyVO company = companyDAO.selectOne(compCd);
		mav.addObject("company", company);
		mav.setViewName(viewName);
		return mav;
	}
	
	// create
	@RequestMapping(value="/viewCreate.do", method=RequestMethod.GET)
	public ModelAndView viewCreate(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("info") CompanyVO company, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		company.setCompCd(CodeMakingRule.CompanyCode(company));
		companyDAO.insertOne(company);
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	// update	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("info") CompanyVO company, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		companyDAO.updateOne(company);
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	// delete
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("compCd") String compCd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		companyDAO.deleteOne(compCd);
		mav.setViewName("redirect:./list.do");
		return mav;
	}
 	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		// http://localhost:8090/member/listMember.do�� ��û��
		int begin = 0; //
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length(); // ��ü ��û�� �� ���̸� ����
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";"); // ��û uri�� ';'�� ���� ��� ';'���� ��ġ�� ����
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?"); // ��û uri�� '?'�� ���� ��� '?' ���� ��ġ�� ����
		} else {
			end = uri.length();
		}

		// http://localhost:8090/member/listMember.do�� ��û�� ���� '.do'�� ������
		// http://localhost:8090/member/listMember�� ���� ��,
		// �ٽ� http://localhost:8090/member/listMember���� �������� ù��° '/' ��ġ�� ����
		// ��, �� ���� listMember�� ���Ѵ�.
		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf(".")); // ��û���� �������� ���� '.'�� ��ġ�� ������,
																			// '.do' �տ������� ���ڿ��� ����
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length()); // ��û���� �������� ���� '/'��
																							// ��ġ�� ������, '/'
																							// ���������� ���ڿ��� ����
		}
		return "/company"+fileName;
	}
	
}
