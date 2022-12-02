package gntp.bbulsora.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpDownloadUtils {
	
	public static void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String browser = request.getHeader("User-Agent");
		if(browser.contains("MSIE")||browser.contains("Trident")||browser.contains("Chrome")) {
			fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", " ");
		} else {
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		String realFileName = Filepaths.UP_DOWN_PATH+fileName;
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
	