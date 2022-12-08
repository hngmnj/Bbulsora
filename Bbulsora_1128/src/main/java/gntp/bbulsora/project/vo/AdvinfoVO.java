package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("advinfoVO")
public class AdvinfoVO {
	private String output;
	private String d1;
	private String d2;
	private String d3;
	private String d4;
	private String d5;
	private String d6;
	private String d7;
	private String d8;
	private String d9;
	private String d10;
	private String d11;
	private String d12;
	private String d13;
	private String d14;
	private String d15;
	private String d16;
	private String d17;
	private String d18;
	private String d19;
	private String d20;
	private String d21;
	private String d22;
	private String d23;
	private String d24;
	private String d25;
	private String d26;
	private String d27;
	private String d28;
	private String d29;
	private String d30;
	private String d31;
	private String itemCd;
	private String year;
	private String month;
	
	public AdvinfoVO() {}
	
	public AdvinfoVO(String output, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String d9, String d10,
			String d11, String d12, String d13, String d14, String d15, String d16, String d17, String d18, String d19, String d20, String d21, String d22,
			String d23, String d24, String d25, String d26, String d27, String d28, String d29, String d30, String d31, String itemCd, String year, String month) {
		this.output = output;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
		this.d4 = d4;
		this.d5 = d5;
		this.d6 = d6;
		this.d7 = d7;
		this.d8 = d8;
		this.d9 = d9;
		this.d10 = d10;
		this.d11 = d11;
		this.d12 = d12;
		this.d13 = d13;
		this.d14 = d14;
		this.d15 = d15;
		this.d16 = d16;
		this.d17 = d17;
		this.d18 = d18;
		this.d19 = d19;
		this.d20 = d20;
		this.d21 = d21;
		this.d22 = d22;
		this.d23 = d23;
		this.d24 = d24;
		this.d25 = d25;
		this.d26 = d26;
		this.d27 = d27;
		this.d28 = d28;
		this.d29 = d29;
		this.d30 = d30;
		this.d31 = d31;
		this.itemCd = itemCd;
		this.year = year;
		this.month = month;
	}
	
	public AdvinfoVO(String data) {
		String[] temp = data.split(",");
		int size = temp.length;
		this.year = temp[0].trim();
		this.month = temp[1].trim();
		this.itemCd = temp[2].trim();
		this.output = temp[3].trim();
		this.d1 = temp[4].trim();
		this.d2 = temp[5].trim();
		this.d3 = temp[6].trim();
		this.d4 = temp[7].trim();
		this.d5 = temp[8].trim();
		this.d6 = temp[9].trim();
		this.d7 = temp[10].trim();
		this.d8 = temp[11].trim();
		this.d9 = temp[12].trim();
		this.d10 = temp[13].trim();
		this.d11 = temp[14].trim();
		this.d12 = temp[15].trim();
		this.d13 = temp[16].trim();
		this.d14 = temp[17].trim();
		this.d15 = temp[18].trim();
		this.d16 = temp[19].trim();
		this.d17 = temp[20].trim();
		this.d18 = temp[21].trim();
		this.d19 = temp[22].trim();
		this.d20 = temp[23].trim();
		this.d21 = temp[24].trim();
		this.d22 = temp[25].trim();
		this.d23 = temp[26].trim();
		this.d24 = temp[27].trim();
		this.d25 = temp[28].trim();
		this.d26 = temp[29].trim();
		this.d27 = temp[30].trim();
		this.d28 = temp[31].trim();
		this.d29 = null;
		this.d30 = null;
		this.d31 = null;
		if(size>32) {
			this.d29 = temp[32].trim();
		}
		if(size>33) {
			this.d30 = temp[33].trim();
		}
		if(size>34) {
			this.d31 = temp[34].trim();
		}
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getD1() {
		return d1;
	}

	public void setD1(String d1) {
		this.d1 = d1;
	}

	public String getD2() {
		return d2;
	}

	public void setD2(String d2) {
		this.d2 = d2;
	}

	public String getD3() {
		return d3;
	}

	public void setD3(String d3) {
		this.d3 = d3;
	}

	public String getD4() {
		return d4;
	}

	public void setD4(String d4) {
		this.d4 = d4;
	}

	public String getD5() {
		return d5;
	}

	public void setD5(String d5) {
		this.d5 = d5;
	}

	public String getD6() {
		return d6;
	}

	public void setD6(String d6) {
		this.d6 = d6;
	}

	public String getD7() {
		return d7;
	}

	public void setD7(String d7) {
		this.d7 = d7;
	}

	public String getD8() {
		return d8;
	}

	public void setD8(String d8) {
		this.d8 = d8;
	}

	public String getD9() {
		return d9;
	}

	public void setD9(String d9) {
		this.d9 = d9;
	}

	public String getD10() {
		return d10;
	}

	public void setD10(String d10) {
		this.d10 = d10;
	}

	public String getD11() {
		return d11;
	}

	public void setD11(String d11) {
		this.d11 = d11;
	}

	public String getD12() {
		return d12;
	}

	public void setD12(String d12) {
		this.d12 = d12;
	}

	public String getD13() {
		return d13;
	}

	public void setD13(String d13) {
		this.d13 = d13;
	}

	public String getD14() {
		return d14;
	}

	public void setD14(String d14) {
		this.d14 = d14;
	}

	public String getD15() {
		return d15;
	}

	public void setD15(String d15) {
		this.d15 = d15;
	}

	public String getD16() {
		return d16;
	}

	public void setD16(String d16) {
		this.d16 = d16;
	}

	public String getD17() {
		return d17;
	}

	public void setD17(String d17) {
		this.d17 = d17;
	}

	public String getD18() {
		return d18;
	}

	public void setD18(String d18) {
		this.d18 = d18;
	}

	public String getD19() {
		return d19;
	}

	public void setD19(String d19) {
		this.d19 = d19;
	}

	public String getD20() {
		return d20;
	}

	public void setD20(String d20) {
		this.d20 = d20;
	}

	public String getD21() {
		return d21;
	}

	public void setD21(String d21) {
		this.d21 = d21;
	}

	public String getD22() {
		return d22;
	}

	public void setD22(String d22) {
		this.d22 = d22;
	}

	public String getD23() {
		return d23;
	}

	public void setD23(String d23) {
		this.d23 = d23;
	}

	public String getD24() {
		return d24;
	}

	public void setD24(String d24) {
		this.d24 = d24;
	}

	public String getD25() {
		return d25;
	}

	public void setD25(String d25) {
		this.d25 = d25;
	}

	public String getD26() {
		return d26;
	}

	public void setD26(String d26) {
		this.d26 = d26;
	}

	public String getD27() {
		return d27;
	}

	public void setD27(String d27) {
		this.d27 = d27;
	}

	public String getD28() {
		return d28;
	}

	public void setD28(String d28) {
		this.d28 = d28;
	}

	public String getD29() {
		return d29;
	}

	public void setD29(String d29) {
		this.d29 = d29;
	}

	public String getD30() {
		return d30;
	}

	public void setD30(String d30) {
		this.d30 = d30;
	}

	public String getD31() {
		return d31;
	}

	public void setD31(String d31) {
		this.d31 = d31;
	}

	public String getItemCd() {
		return itemCd;
	}

	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
