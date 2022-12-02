package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("itemVO")
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
	private String compName;
	private MultipartFile uploadImage;

	public ItemVO() {}
	
	public ItemVO(String data) {
		String[] temp = data.split(",");
		this.itemName  = temp[0].trim();
		this.major = temp[1].trim();
		this.middle  = temp[2].trim();
		this.minor = temp[3].trim();
		this.standard = temp[4].trim();
		this.unit = temp[5].trim();
		this.img = temp[6].trim();
		this.compCd = temp[7].trim();
	}

	public ItemVO(String itemCd, String itemName, String major, String middle, String minor, String standard,
			String unit, String img, String compCd, String compName, MultipartFile uploadImage) {
		this.itemCd = itemCd;
		this.itemName = itemName;
		this.major = major;
		this.middle = middle;
		this.minor = minor;
		this.standard = standard;
		this.unit = unit;
		this.img = img;
		this.compCd = compCd;
		this.uploadImage = uploadImage;
		this.compName = compName;
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
	
	public MultipartFile getuploadImage() {
		return uploadImage;
	}

	public void setuploadImage(MultipartFile uploadImage) {
		this.uploadImage = uploadImage;
	}

	@Override
	public String toString() {
		return "ItemVO [itemCd=" + itemCd + ", itemName=" + itemName + ", major=" + major + ", middle=" + middle
				+ ", minor=" + minor + ", standard=" + standard + ", unit=" + unit + ", img=" + img + ", compCd="
				+ compCd + "]";
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
	
}
