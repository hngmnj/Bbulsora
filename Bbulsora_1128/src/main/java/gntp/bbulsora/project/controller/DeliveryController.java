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

import gntp.bbulsora.project.dao.DeliveryDAO;
import gntp.bbulsora.project.dao.FifoDAO;
import gntp.bbulsora.project.service.DeliveryService;
import gntp.bbulsora.project.vo.DeliveryVO;
import gntp.bbulsora.project.vo.FifoVO;
import gntp.bbulsora.project.vo.MemberVO;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
   @Autowired
   private DeliveryDAO deliveryDAO;
   
   @Autowired
   private DeliveryService deliveryService;
   
   @Autowired
   private FifoDAO fifoDAO;
   
   @RequestMapping(value="/basic.do", method=RequestMethod.POST)
   public ModelAndView basic(HttpServletRequest request, HttpServletResponse response) throws Exception  {
      ModelAndView mav = new ModelAndView();
      String viewName = this.getViewName(request);
      mav.setViewName(viewName);
      return mav;
   }
   
   @RequestMapping(value="/create.do", method=RequestMethod.POST)
   public void create(@RequestBody List<DeliveryVO> deliver, HttpServletRequest request, HttpServletResponse response) {
      MemberVO user = (MemberVO) request.getSession().getAttribute("user");
      deliveryService.insertRequestData(deliver, user.getCompCd());
   }
   
   @RequestMapping(value="/list.do", method=RequestMethod.GET)
   public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception  {
      ModelAndView mav = new ModelAndView();
      String viewName = this.getViewName(request);
      List<DeliveryVO> list = deliveryDAO.selectDeliveryAll();
      mav.addObject("dlvryList", list);
      mav.setViewName(viewName);
      return mav;
   }
   
   @RequestMapping(value="/updateAll.do", method=RequestMethod.GET)
   public ModelAndView updateAll(@RequestParam Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception  {
      ModelAndView mav = new ModelAndView();
      deliveryDAO.updateAllState(map);
      mav.setViewName("redirect:./list.do");
      return mav;
   }
   
   @RequestMapping(value="/updateSep.do", method=RequestMethod.GET)
   public ModelAndView updateSep(@RequestParam Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception  {
      ModelAndView mav = new ModelAndView();
      deliveryDAO.updateSepState(map);
      String state = (String) map.get("stateCd");
      System.out.println(state);
      System.out.println(map);
      if(state.equals("D004")) {
    	  List<FifoVO> fifo = fifoDAO.selectForFIFO(map);
    	  for(int i=0;i<fifo.size();i++) {
    		  System.out.println(fifo.get(i));
    	  }
      }
      mav.setViewName("redirect:./list.do");
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
      
      return "/delivery"+fileName;
   }
}
