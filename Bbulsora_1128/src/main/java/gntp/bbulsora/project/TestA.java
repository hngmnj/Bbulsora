package gntp.bbulsora.project;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestA {
	public static void main(String args[]) {
		System.out.println(LotNo("BADPAI000"));
		System.out.println(data().values());
	}
static String menusArr[][]={{"삼겹살","곱창","백반","제육볶음","찌개","찜닭"}, {"파스타","피자","스테이크","햄버거"}};

	@RequestMapping(value="/data/menus", method= RequestMethod.GET)
	@ResponseBody
	
	public static Map<String, Object> data() {
		
		Map<String, Object> arrMap = new HashMap<String, Object>();
		arrMap.put("한식",menusArr[0]);
		arrMap.put("양식",menusArr[1]);
		return arrMap;
	}
	
	public static String LotNo(String itemCd) {
		String lot = null;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("kkmmss");
//		String compCd = store.getItemCd().substring(0, 3).toUpperCase();
//		String itemCd = store.getItemCd().substring(3, 6).toUpperCase();
		String storeDate = sdfDate.format(new Date());
		int hour = Integer.parseInt(sdfTime.format(new Date()).substring(0,2));
		int minute = Integer.parseInt(sdfTime.format(new Date()).substring(2,4));
		int second = Integer.parseInt(sdfTime.format(new Date()).substring(4,6));
		DecimalFormat df = new DecimalFormat("00");
		lot = itemCd+"-"+storeDate+"-"+df.format(hour)+df.format(minute)+df.format(second);
		return lot;
	}
}
