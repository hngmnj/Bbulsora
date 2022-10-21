package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String compCd;

	public MemberVO() {}

	public MemberVO(String id, String pwd, String name, String phone, String email, String compCd) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.compCd = compCd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompCd() {
		return compCd;
	}

	public void setCompCd(String compCd) {
		this.compCd = compCd;
	}


}
