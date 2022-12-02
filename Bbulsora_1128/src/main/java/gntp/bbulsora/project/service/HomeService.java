package gntp.bbulsora.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gntp.bbulsora.project.dao.CompanyDAO;
import gntp.bbulsora.project.dao.MemberDAO;
import gntp.bbulsora.project.vo.CompanyVO;
import gntp.bbulsora.project.vo.MemberVO;

@Service
public class HomeService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private CompanyDAO companyDAO;
	
	public boolean idCheck(String id) {
		boolean flag = false;
		MemberVO member = memberDAO.selectOne(id);
		if(member != null) {
			flag = true;
		}
		return flag;
	}
	
	public MemberVO loginCheck(String id, String pwd) {
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		return memberDAO.loginCheck(member);
	}

	public String findId(String name, String compCd, String phone) {
		MemberVO member = new MemberVO();
		member.setName(name);
		member.setPhone(phone);
		member.setCompCd(compCd);
		MemberVO result = memberDAO.findId(member);
		String formedId = "";
		if(result != null) {
			String id = result.getId();
			formedId = id.substring(0,4);
			int blindLength = id.substring(4,id.length()).length();
			for(int i=0; i<blindLength; i++) {
				formedId += "*";
			}
		}
		return formedId;
	}

	public boolean findPwd(String id, String name, String compName, String phone) {
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setName(name);
		member.setPhone(phone);
		member.setCompCd(compName);
		MemberVO result = memberDAO.findPwd(member);
		boolean flag = false;
		if(result != null) {
			flag = true;
		}
		return flag;
	}
	
	public boolean changePwd(String id, String pwd) {
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		return memberDAO.changePwd(member);
	}

	public void createMember(MemberVO member) {
		memberDAO.insertOne(member);	
	}

	public void updateMember(MemberVO member) {
		memberDAO.updateOne(member);
	}

	public List<CompanyVO> getCompList() {
		return companyDAO.selectAll();
	}
	
}