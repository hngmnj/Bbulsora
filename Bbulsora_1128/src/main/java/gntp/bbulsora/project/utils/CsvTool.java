package gntp.bbulsora.project.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import gntp.bbulsora.project.vo.AdvinfoVO;
import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.StateVO;

public class CsvTool {
	public ArrayList<StateVO> getStateData(File destFile) throws IOException {
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

	public ArrayList<ItemVO> getItemData(File destFile) throws IOException {
		ArrayList<ItemVO> list = null;
		list = new ArrayList<ItemVO>();
		File file = new File(destFile.getAbsolutePath());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		ItemVO item = null;
		while((line=br.readLine())!=null) {
			item = new ItemVO(line);
			list.add(item);
		}
		br.close();
		fr.close();
		return list;
	}
	
	public ArrayList<AdvinfoVO> getInfoData(File destFile) throws IOException {
		ArrayList<AdvinfoVO> list = null;
		list = new ArrayList<AdvinfoVO>();
		File file = new File(destFile.getAbsolutePath());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		AdvinfoVO info = null;
		while((line=br.readLine())!=null) {
			info = new AdvinfoVO(line);
			list.add(info);
		}
		list.remove(0);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		br.close();
		fr.close();
		return list;
	}
}
