package gntp.bbulsora.project.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import gntp.bbulsora.project.dao.ItemDAO;
import gntp.bbulsora.project.utils.Filepaths;
import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.MemberVO;

@Service
public class ItemService {
	
	@Autowired
	private ItemDAO itemDAO;
	
	public List<ItemVO> getMyItems(HttpServletRequest request, String supCd) {
		MemberVO member = (MemberVO)request.getSession().getAttribute("user");
		String compCd = member.getCompCd();
		List<ItemVO> list = null;
		if(compCd.equals("ADMIN")) {
			list = itemDAO.selectAll();
		}
		else if(compCd.equals(supCd)) {
			list = itemDAO.selectMyItems(compCd);
		}
		return list;		
	}
	
	public boolean itemInsertwPic(ItemVO item) throws Exception {
		boolean flag = false;
		String filePath = null;
		String OriginalFileName = null;
		MultipartFile uploadImage = item.getuploadImage();
		if(!uploadImage.isEmpty()) {
			OriginalFileName = uploadImage.getOriginalFilename();
			System.out.println(OriginalFileName);
			filePath = Filepaths.IMG_PATH+OriginalFileName;
			uploadImage.transferTo(new File(filePath));
		}
		item.setImgName(OriginalFileName);
		item.setImgPath(filePath);
		flag = itemDAO.insertOne(item);
		return flag;
	}
}
