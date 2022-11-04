package gntp.bbulsora.project.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gntp.bbulsora.project.dao.StateDAO;
import gntp.bbulsora.project.vo.StateVO;

public class CsvTool {
	public ArrayList<StateVO> getFileData(File destFile) throws IOException {
		ArrayList<StateVO> list = null;
		list = new ArrayList<StateVO>();
		File file = new File(destFile.getAbsolutePath());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		StateVO state = null;
		while((line=br.readLine())!=null) {
			state = new StateVO(line);
			list.add(state);
		}
		br.close();
		fr.close();
		return list;
	}

}
