package gntp.bbulsora.project.utils;

import gntp.bbulsora.project.vo.CompanyVO;
import gntp.bbulsora.project.vo.ItemVO;

public class CodeMakingRule {
	public static String CompanyCode(CompanyVO company) {
		String compCd = null;
		String sort = company.getSort().substring(0, 3).toUpperCase();
		String corp = company.getEngName().substring(0, 3).toUpperCase();
		String phoneNo = company.getCompCall();
		String phoneCode = phoneNo.substring(phoneNo.length()-4, phoneNo.length());
		if(company.getSort().equals("admin")) {
			compCd = company.getSort();
		} else {
			compCd = sort + corp + phoneCode;
		}
		return compCd;
	}
	
	public static String ItemCode(ItemVO item) {
		String ItemCd = null;
		String corp = item.getCompCd().substring(3, 6).toUpperCase();
		String sort = item.getMinor().substring(0, 3).toUpperCase();
		String number = String.valueOf(Math.round(Math.random()*1000));
		ItemCd = corp + sort + number;
		System.out.println(number);
		return ItemCd;
	}
}

