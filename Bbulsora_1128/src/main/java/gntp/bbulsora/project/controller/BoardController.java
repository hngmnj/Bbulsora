package gntp.bbulsora.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gntp.bbulsora.project.dao.BoardDAO;
import gntp.bbulsora.project.service.BoardService;
import gntp.bbulsora.project.utils.UpDownloadUtils;
import gntp.bbulsora.project.vo.BoardVO;
import gntp.bbulsora.project.vo.CommentVO;

@Controller("boardController")
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private BoardService boardService;

	// Board Part
	// Create
	@RequestMapping(value="/viewCreate.do", method=RequestMethod.GET)
	public ModelAndView viewCreate(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/create");
		return mav;
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("info") BoardVO board, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		boardService.insertOne(board);
		mav.setViewName("redirect:./list.do");
		
		return mav;
	}
	
	// Read All
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.addObject("boardObjects", boardService.listByPage(request));
		mav.setViewName(viewName);
		return mav;
	}
	
	// Read One
	@RequestMapping(value="/read.do", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam("brdSeq") String brdSeq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		BoardVO board = boardDAO.selectOne(brdSeq);
		mav.addObject("board", board);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Update
	@RequestMapping(value="/viewUpdate.do", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam("brdSeq") String brdSeq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", boardDAO.selectOne(brdSeq));
		mav.setViewName("/board/update");
		return mav;
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("info") BoardVO board, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		boardDAO.updateOne(board);
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	// Delete
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("brdSeq") String brdSeq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		boardDAO.deleteOne(brdSeq);
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	// Comment Part
	// Create
	@RequestMapping(value="/createComment.do", method=RequestMethod.POST)
	public ModelAndView createReply(@ModelAttribute("info") CommentVO comment, @RequestParam("brdSeq") String brdSeq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		boardDAO.insertComment(comment);
		mav.setViewName("redirect:./read.do?brdSeq="+brdSeq);
		return mav;
	}
	
	// Update
	@RequestMapping(value="/updateComment.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateComment(@ModelAttribute("info") CommentVO comment, @RequestParam("brdSeq") String brdSeq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		boardDAO.updateComment(comment);
		mav.setViewName("redirect:./read.do?brdSeq="+brdSeq);
		return mav;
	}
	
	// Delete
	@RequestMapping(value="/deleteComment.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteComment(@RequestParam("cmntSeq") String cmntSeq, @RequestParam("brdSeq") String brdSeq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		boardDAO.deleteComment(cmntSeq);
		mav.setViewName("redirect:./read.do?brdSeq="+brdSeq);
		return mav;
	}
	
	// Download
	@RequestMapping(value="download.do", method={RequestMethod.GET, RequestMethod.POST})
	public void download(@RequestParam("filepath") String filepath, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(filepath);
		UpDownloadUtils.download(filepath,request,response);
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
		
		return "/board"+fileName;
	}
}
