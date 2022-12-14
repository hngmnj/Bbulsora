package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.AdvinfoVO;
import gntp.bbulsora.project.vo.CompanyVO;

@Repository("companyDAO")
public class CompanyDAO {

	@Autowired
	private SqlSession sqlSession;
	public CompanyDAO() {}
	
	public String selectYear(Map<String, Object> data) {
		return sqlSession.selectOne("mapper.advinfo.selectYear", data);
	}
	
	public String selectMonth(Map<String, Object> data) {
		return sqlSession.selectOne("mapper.advinfo.selectMonth", data);
	}
	
	public List<AdvinfoVO> selectMonthSche(Map<String, Object> data) {
		return sqlSession.selectList("mapper.advinfo.selectMonthSche", data);
	}
	
	public int insertMonthSche(AdvinfoVO info) {
		return sqlSession.insert("mapper.advinfo.insertMonthSche", info);
	}
	
	public List<CompanyVO> selectSupName() {
		return sqlSession.selectList("mapper.company.selectSupName");
	}
	
	public List<CompanyVO> selectAllForCreateItem() {
		List<CompanyVO> list = null;
		list = sqlSession.selectList("mapper.company.selectAllForCreateItem");
		return list;
	}

	public List<CompanyVO> selectAll() {
		List<CompanyVO> list = null;
		list = sqlSession.selectList("mapper.company.selectAllCompanyList");

		return list;
	}

	public CompanyVO selectOne(String compCd) throws SQLException {
		CompanyVO company = null;
		company = sqlSession.selectOne("mapper.company.selectCompanyByCompCd", compCd); 
		return company;
	}

	public boolean insertOne(CompanyVO company) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.company.insertCompany", company);
		if(affectedCount > 0)
			flag = true;
		System.out.println("Insert company: "+flag);
		return flag;
	}

	public boolean updateOne(CompanyVO company) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.company.updateCompany", company);
		if(affectedCount > 0)
			flag = true;
		return flag;
	}

	public boolean deleteOne(String compCd) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.company.deleteCompany", compCd);
		if(affectedCount > 0)
			flag = true;
		return flag;
	}

	public AdvinfoVO selectBoolean(AdvinfoVO info) {
		return sqlSession.selectOne("mapper.advinfo.selectBoolean", info);
	}

	public int updateMonthSche(AdvinfoVO info) {
		return sqlSession.update("mapper.advinfo.updateMonthSche", info);
	}

}
