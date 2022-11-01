package gntp.bbulsora.project.service;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import gntp.bbulsora.project.dao.ItemDAO;
import gntp.bbulsora.project.vo.ItemVO;

@Service
public class ItemService {
	@Autowired
	private ItemDAO itemDAO;
	
	public boolean itemInsertwPic(ItemVO item) throws Exception {
		boolean flag = false;
		String filePath = null;
		String OriginalFileName = null;
		MultipartFile uploadImage = item.getuploadImage();
		if(!uploadImage.isEmpty()) {
			OriginalFileName = uploadImage.getOriginalFilename();
			String ext = FilenameUtils.getExtension(OriginalFileName);
//			System.out.println(ext);
//			UUID uuid = UUID.randomUUID();
//			fileName = uuid+"."+ext;
			filePath = "D:\\dev\\images\\"+OriginalFileName;
			uploadImage.transferTo(new File(filePath));
		}
		item.setImg(filePath);
		System.out.println(item);
		flag = itemDAO.insertOne(item);
		return flag;
	}
}
