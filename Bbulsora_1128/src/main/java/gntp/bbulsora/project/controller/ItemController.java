package gntp.bbulsora.project.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import gntp.bbulsora.project.dao.CompanyDAO;
import gntp.bbulsora.project.dao.ItemDAO;
import gntp.bbulsora.project.service.ItemService;
import gntp.bbulsora.project.utils.CodeMakingRule;
import gntp.bbulsora.project.utils.CsvTool;
import gntp.bbulsora.project.utils.Filepaths;
import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.MemberVO;

@Controller("itemController")
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private CompanyDAO companyDAO;
	
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
		mav.addObject("majorList", itemDAO.selectMajor());
		mav.addObject("middleList", itemDAO.selectMiddle());
		mav.addObject("minorList", itemDAO.selectMinor());
		mav.addObject("compList", companyDAO.selectAllForCreateItem());
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("info") ItemVO item, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		item.setItemCd(CodeMakingRule.ItemCode(item));
		itemService.itemInsertwPic(item);
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		mav.setViewName("redirect:./list.do?compCd="+user.getCompCd());
		return mav;
	}
	
	// Create CSV
	@RequestMapping(value="/viewCsvCreate.do", method=RequestMethod.GET)
	public ModelAndView viewCsvCreate(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/csvCreate.do", method=RequestMethod.POST)
	public ModelAndView csvCreate(@RequestParam("csvFile") MultipartFile csvFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		CsvTool tool = new CsvTool();
		if(csvFile==null || csvFile.isEmpty()) {
			throw new RuntimeException("CSV 파일을 선택해주세요");
		}
		File destFile = new File(Filepaths.UP_DOWN_PATH+csvFile.getOriginalFilename());
		csvFile.transferTo(destFile);
		ArrayList<ItemVO> list = tool.getItemData(destFile);
		for (ItemVO item : list) {
			item.setItemCd(CodeMakingRule.ItemCode(item));
			String address = Filepaths.IMG_PATH+item.getImgPath();
			item.setImgName(csvFile.getOriginalFilename());
			item.setImgPath(address);
			itemDAO.insertOne(item);
		}	
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		mav.setViewName("redirect:./list.do?compCd="+user.getCompCd());
		return mav;
	}
	
	// Read All
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list(@RequestParam("compCd") String compCd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		List<ItemVO> list = itemService.getMyItems(request, compCd);
		mav.addObject("list", list);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Read One
	@RequestMapping(value="/read.do", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam("itemCd") String itemCd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		ItemVO item = itemDAO.selectOne(itemCd);
		mav.addObject("item", item);
		mav.setViewName(viewName);
		return mav;
	}
	@RequestMapping(value="/readTop.do", method=RequestMethod.GET)
	public ModelAndView readTop(@RequestParam("itemCd") String itemCd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		ItemVO item = itemDAO.selectOne(itemCd);
		System.out.println(item.getImgName());
		mav.addObject("item", item);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Update
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("info") ItemVO item, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		itemDAO.updateOne(item);
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		mav.setViewName("redirect:./list.do?compCd="+user.getCompCd());
		return mav;
	}
	
	// Delete
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("itemCd") String itemCd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		itemDAO.deleteOne(itemCd);
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
		
		return "/item"+fileName;
	}

}
