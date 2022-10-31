package gntp.bbulsora.project.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import gntp.bbulsora.project.vo.CompanyVO;
import gntp.bbulsora.project.vo.ItemVO;
import gntp.bbulsora.project.vo.OrderVO;

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
		int number = (int) Math.round(Math.random()*1000);
		String code = String.valueOf(number);
		if(number<10) {
			code = "00"+String.valueOf(number);
		} else if(number<100) {
			code = "0"+String.valueOf(number);
		}
		ItemCd = corp + sort + code;
		return ItemCd;
	}
	
	public static String OrderCode(OrderVO order) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("kkmmss");
		String OrderCd = null;
		String corp = order.getCompCd().substring(3, 6).toUpperCase();
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
		OrderCd = "O" + corp + orderDate + hourCode + minuteCode + secondCode;
		return OrderCd;
	}
	
	public static String DeliveryCode(/*DeliveryVO delivery*/) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("kkmmss");
		String DeliveryCd = null;
//		String corp = delivery.getCompCd.substring(3, 6).toUpperCase();
		String reqDate = sdfDate.format(new Date());
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
//		DeliveryCd = "D"+ corp + reqDate + hourCode + minuteCode + secondCode;
		return DeliveryCd;
	}
	
	public static String LotNo(/*StockVO stock*/) {
		String LotNo = null;
		
		return LotNo;
	}
}

