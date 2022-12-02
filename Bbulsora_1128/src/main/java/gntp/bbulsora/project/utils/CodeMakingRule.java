package gntp.bbulsora.project.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import gntp.bbulsora.project.vo.CompanyVO;
import gntp.bbulsora.project.vo.DeliveryVO;
import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.StoreVO;

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
		DecimalFormat df = new DecimalFormat("000");
		int number = (int) Math.round(Math.random()*1000);
		String code = df.format(number);
		ItemCd = corp + sort + code;
		return ItemCd;
	}

	public static String OrderCode(String compCd) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("kkmmss");
		String OrderCd = null;
		String corp = compCd.substring(3, 6).toUpperCase();
		String orderDate = sdfDate.format(new Date());
		int hour = Integer.parseInt(sdfTime.format(new Date()).substring(0,2));
		int minute = Integer.parseInt(sdfTime.format(new Date()).substring(2,4));
		int second = Integer.parseInt(sdfTime.format(new Date()).substring(4,6));
		String hourCode = Integer.toHexString(hour).toUpperCase();
		String minuteCode = Integer.toHexString(minute).toUpperCase();
		String secondCode = Integer.toHexString(second).toUpperCase();
		if(hour<16) {
			hourCode = "0"+Integer.toHexString(hour).toUpperCase();
		} if(minute<16) {
			minuteCode = "0"+Integer.toHexString(minute).toUpperCase();
		} if(second<16) {
			secondCode = "0"+Integer.toHexString(second).toUpperCase();
		}
		OrderCd = corp + orderDate + hourCode + minuteCode + secondCode;
		return OrderCd;
	}

	public static String LotNo(StoreVO store) {
		String lot = null;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("kkmmss");
		String compCd = store.getItemCd().substring(0, 3).toUpperCase();
		String itemCd = store.getItemCd().substring(3, 6).toUpperCase();
		String storeDate = sdfDate.format(new Date());
		int hour = Integer.parseInt(sdfTime.format(new Date()).substring(0,2));
		int minute = Integer.parseInt(sdfTime.format(new Date()).substring(2,4));
		int second = Integer.parseInt(sdfTime.format(new Date()).substring(4,6));
		DecimalFormat df = new DecimalFormat("00");
		lot = itemCd+"-"+compCd+"-"+storeDate+"-"+df.format(hour)+df.format(minute)+df.format(second);
		return lot;
	}

	public static String DeliveryCode(DeliveryVO delivery) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdfYear = new SimpleDateFormat("yy");
		String compCd = delivery.getCompCd().substring(3, 6);
		int cnt = delivery.getCnt()-1;
		int year = Integer.parseInt(sdfYear.format(cal.get(Calendar.YEAR)));
		int day = cal.get(Calendar.DAY_OF_YEAR);
		int second = cal.get(Calendar.MILLISECOND);
		DecimalFormat df = new DecimalFormat("000");
		String yearCd = df.format(year);
		String dayCd = Integer.toHexString(day).toUpperCase();
		String secondCd = df.format(second);
		if(day<16) {
			dayCd = "00" + dayCd;
		} else if (day<256) {
			dayCd = "0" + dayCd;
		}
		String deliveryCd = compCd + "MU" + yearCd + dayCd + secondCd;
		if(cnt==0) {
			deliveryCd = compCd + "SL" + yearCd + dayCd + secondCd;
		}
		return deliveryCd;
	}
}
