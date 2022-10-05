package gntp.bbulsora.project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gntp.bbulsora.project.dao.EmployeeDAO;
import gntp.bbulsora.project.vo.EmployeeVO;

@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value="/basic.do", method=RequestMethod.GET)
	public ModelAndView basic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName("/employee"+viewName);
		return mav;
	}
	
	// Read All
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		ArrayList<EmployeeVO> list = employeeDAO.selectAll();
		mav.addObject("list", list);
		mav.setViewName("/employee"+viewName);
		return mav;
	}
	
	// Read One
	@RequestMapping(value="/read.do", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam("empNo") String empNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
//		EmployeeVO employee = employeeDAO.selectOne(empNo);
//		mav.addObject("employee", employee);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Create 창 띄우기
	@RequestMapping(value="/viewJoin.do", method=RequestMethod.GET)
	public ModelAndView viewJoin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName("/employee"+viewName);
		return mav;
	}
	
	// Create
	@RequestMapping(value="/create.do", method=RequestMethod.GET)
	public ModelAndView create(@ModelAttribute("info") EmployeeVO employee, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		String viewName = this.getViewName(request);
//		employeeDAO.createEmployee(employee);
		mav.setViewName("redirect:./employee/list.do");
		return mav;
	}
	
	// Update
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public ModelAndView update(@ModelAttribute("info") EmployeeVO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		String viewName = this.getViewName(request);
//		employeeDAO.updateEmployee(employee);
		mav.setViewName("redirect:./employee/list.do");
		return mav;
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("empNo") String empNo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
//		employeeDAO.deleteEmployee(empNo);
		mav.setViewName("redirect:./employee/list.do");
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
		return fileName;
	}
}
