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

@Controller("boardController")
@RequestMapping("/board")
public class BoardController {
//	@Autowired
//	private BoardDAO boardDAO;
	
//	@Autowired
//	private BoardService boardService;

	@RequestMapping(value="/basic.do", method=RequestMethod.POST)
	public ModelAndView basic(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
		mav.setViewName(viewName);
		return mav;
	}

	// Board Part
	// Create
	@RequestMapping(value="/viewCreate.do", method=RequestMethod.GET)
	public ModelAndView viewCreate(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/write");
		return mav;
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	public ModelAndView create(/*@ModelAttribute("info") BoardVO board,*/ HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		boardDAO.insertOne(board);
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	// Read All
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
//		ArrayList<BoardVO> list = boardDAO.selectAll();
//		mav.addObject("list", list);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Read One
	@RequestMapping(value="/read.do", method=RequestMethod.GET)
	public ModelAndView read(@RequestParam("seq") String seq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = this.getViewName(request);
//		BoardVO board = boardDAO.selectOne(seq);
//		mav.addObject("board", board);
		mav.setViewName(viewName);
		return mav;
	}
	
	// Update
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView update(/*@ModelAttribute("info") BoardVO board,*/ HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		boardDAO.updateOne(board);
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	// Delete
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("seq") String seq, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		boardDAO.deleteOne(seq);
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	// Comment Part
	// Create
	@RequestMapping(value="/createComment.do", method=RequestMethod.POST)
	public ModelAndView createReply(/*@ModelAttribute("info") CommentVO comment,*/ HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		commentDAO.insertOne(comment);
		mav.setViewName("redirect:./list.do");
		return mav;
	}
	
	// Read
	// BoardVO에서 List로 들고 있다가 게시판 Read 페이지에서 출력
	
	// Update
	@RequestMapping(value="/updateComment.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateComment(/*@ModelAttribute("info") CommentVO comment*/ HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		boardDAO.updateReply(comment);
		mav.setViewName("redirect:./read.do?seq="/*+comment.gbSeq*/);
		return mav;
	}
	
	// Delete
	@RequestMapping(value="/deleteComment.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteComment(/*@RequestParam("comment_seq") String commentSeq, @RequestParam("seq") String seq,*/ HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		boardDAO.deleteReply(commentSeq);
		mav.setViewName("redirect:./read.do?seq="/*+seq*/);
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
		return "/board"+fileName;
	}
}
