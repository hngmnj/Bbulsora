package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("ItemVO")
public class ItemVO {
	private String itemCd;
	private String itemName;
	private String major;
	private String middle;
	private String minor;
	private String standard;
	private String unit;
	private String img;
	private String compCd;

	public ItemVO() {}

	public ItemVO(String itemCd, String itemName, String major, String middle, String minor, String standard,
			String unit, String compCd) {
		this.itemCd = itemCd;
		this.itemName = itemName;
		this.major = major;
		this.middle = middle;
		this.minor = minor;
		this.standard = standard;
		this.unit = unit;
		this.compCd = compCd;
	}

	public String getItemCd() {
		return itemCd;
	}

	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCompCd() {
		return compCd;
	}

	public void setCompCd(String compCd) {
		this.compCd = compCd;
	}



}
