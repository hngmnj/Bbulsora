package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.CompanyVO;

@Repository("CompanyDAO")
public class CompanyDAO {

	@Autowired
	private SqlSession sqlSession;
	public CompanyDAO() {}
	
	public List<CompanyVO> selsectAll() throws SQLException {
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
		return flag;
	}
	
	public boolean updateOne(CompanyVO company) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.company.updateCompany", company);
		if(affectedCount > 0)
			flag = true;
		return flag;
	}
	
	public boolean deleteOne(CompanyVO company) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.company.deleteCompany", company);
		if(affectedCount > 0)
			flag = true;
		return flag;
	}
	
}
