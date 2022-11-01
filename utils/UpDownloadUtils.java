package gntp.bbulsora.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import gntp.bbulsora.project.dao.ItemDAO;
import gntp.bbulsora.project.vo.ItemVO;

@Service
public class UpDownloadUtils {
	
	
	public static void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String browser = request.getHeader("User-Agent");
		if(browser.contains("MSIE")||browser.contains("Trident")||browser.contains("Chrome")) {
			fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		} else {
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		String realFileName = "D:\\test\\"+fileName;
		System.out.println(realFileName);
		File file1 = new File(realFileName);
		if(!file1.exists()) {
			return ;
		} 
		response.setContentType("application/octer-stream");
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setHeader("content-Disposition", "attachment; fileName=\""+fileName+"\"");
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(realFileName);
		int ncount = 0;
		byte[] bytes = new byte[512];
		while((ncount = fis.read(bytes)) != -1) {
			os.write(bytes, 0, ncount);
		}
		fis.close();
		os.close();
	}
	
}
	