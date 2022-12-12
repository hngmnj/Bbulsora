package gntp.bbulsora.project.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import gntp.bbulsora.project.dao.BoardDAO;
import gntp.bbulsora.project.utils.Filepaths;
import gntp.bbulsora.project.vo.BoardVO;

@Service("boardService")
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	//페이징계산 및 검색데이터 저장 후 테이블 조회
	public Map<String, Object> listByPage(HttpServletRequest req) {
		Map<String, Object> obj = new HashMap<String, Object>();
		int section = Integer.parseInt((req.getParameter("section") == null)? "1" : req.getParameter("section"));
		int pageNum = Integer.parseInt((req.getParameter("pageNum") == null)? "1" : req.getParameter("pageNum"));
		int offsetNum = (section-1)*100+(pageNum-1)*10;
		String searchText = req.getParameter("searchText");
		String searchOption = req.getParameter("searchOption");
		obj.put("searchOption", searchOption);
		obj.put("searchText", searchText);
		obj.put("section", section);
		obj.put("pageNum", pageNum);
		obj.put("offsetNum", offsetNum);
		boardDAO.selectByPage(obj);
		return obj;
	}
	
	//파일 업로드
	public boolean insertOne(BoardVO board) throws Exception {
		boolean flag = false;
		String fileName = null;
		String OriginalFileName = null; 
		MultipartFile uploadFile = board.getUploadFile();
		if(!uploadFile.isEmpty()) {
			OriginalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(OriginalFileName);
			fileName = OriginalFileName;
			for(int i=0; i<OriginalFileName.length(); i++) {
				if((int)OriginalFileName.charAt(i) > 126) {
					UUID uuid = UUID.randomUUID();
					fileName = uuid+"."+ext;
					break;
				}
			}
			uploadFile.transferTo(new File(Filepaths.UP_DOWN_PATH+fileName));
		}
		board.setFilename(OriginalFileName);
		board.setFilepath(fileName);
		flag = boardDAO.insertOne(board);
		return flag;
	}
}
