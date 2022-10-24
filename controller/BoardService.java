package gntp.bbulsora.project.service;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import gntp.bbulsora.project.dao.BoardDAO;
import gntp.bbulsora.project.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	public boolean insertOne(BoardVO board) throws Exception {
		boolean flag = false;
		String fileName = null;
		String OriginalFileName = null;
		MultipartFile uploadFile = board.getUploadFile();
		if(!uploadFile.isEmpty()) {
			OriginalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(OriginalFileName);
			System.out.println(ext);
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"."+ext;
//			fileName = OriginalFileName;
			uploadFile.transferTo(new File("D:\\test\\"+fileName));
		}
		board.setFileName(OriginalFileName);
		board.setFilepath(fileName);
		flag = boardDAO.insertOne(board);
		return flag;
	}
}
