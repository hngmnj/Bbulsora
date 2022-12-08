package gntp.bbulsora.project.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import gntp.bbulsora.project.dao.CompanyDAO;
import gntp.bbulsora.project.dao.ItemDAO;
import gntp.bbulsora.project.utils.CodeMakingRule;
import gntp.bbulsora.project.utils.CsvTool;
import gntp.bbulsora.project.utils.Filepaths;
import gntp.bbulsora.project.vo.AdvinfoVO;
import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.MemberVO;

@Controller("calController")
@RequestMapping("/cal")

public class CalController {
//	@Autowired
//	private AdvinfoDAO advinfoDAO;
	
	@Autowired
	private CompanyDAO companyDAO;

	
	/////////////////////    기본 메소드 형    ////////////////////////////////
	public ModelAndView basic(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		
		mav.setViewName(viewName);
		return mav;
	}

	
	@RequestMapping(value="/read.do", method=RequestMethod.GET)
	public ModelAndView read(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.addObject("supList", companyDAO.selectSupName());
		
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/csvCreate.do", method=RequestMethod.POST)
	public ModelAndView csvCreate(@RequestParam("infoCsv") MultipartFile csvFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		CsvTool tool = new CsvTool();
		if(csvFile==null || csvFile.isEmpty()) {
			throw new RuntimeException("CSV 파일을 선택해주세요");
		}
		File destFile = new File(Filepaths.UP_DOWN_PATH+csvFile.getOriginalFilename());
		csvFile.transferTo(destFile);
		ArrayList<AdvinfoVO> list = tool.getInfoData(destFile);
		for (AdvinfoVO info : list) {
//			adv.insertOne(item);
		}	
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		mav.setViewName("redirect:./list.do?compCd="+user.getCompCd());
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
		return "/cal"+fileName;
	}

}
