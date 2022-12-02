package gntp.bbulsora.project.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import gntp.bbulsora.project.dao.StateDAO;
import gntp.bbulsora.project.utils.CsvTool;
import gntp.bbulsora.project.utils.Filepaths;
import gntp.bbulsora.project.vo.StateVO;

@Controller
@RequestMapping("/csv")
public class CsvContoller {
	@Autowired
	private StateDAO stateDAO;
	
	@RequestMapping(value="/basic.do", method=RequestMethod.POST)
	public ModelAndView basic(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/viewCreate.do", method=RequestMethod.GET)
	public ModelAndView viewCreate(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	public ModelAndView create(MultipartFile csv, MultipartHttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		CsvTool tool = new CsvTool();
		MultipartFile csvFile = request.getFile("csvFile");
		if(csvFile==null || csvFile.isEmpty()) {
			throw new RuntimeException("CSV 파일을 선택해주세요");
		}
		File destFile = new File(Filepaths.LOCAL_UP_DOWN_PATH+csvFile.getOriginalFilename()); 
		csvFile.transferTo(destFile);
		ArrayList<StateVO> list = tool.getStateData(destFile);
		for(StateVO state : list) {
			stateDAO.insertOne(state);
		}
		destFile.delete();
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		List<StateVO> list = stateDAO.selectAll();
		mav.addObject("list", list);
		mav.setViewName(viewName);
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
		
		return "/csv"+fileName;
	}
	
}
