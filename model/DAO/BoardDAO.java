package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;


	public List<BoardVO> selectAll() throws SQLException{
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectAllBoardList");

		return list;
	}

	public BoardVO selectOne(String brdSeq) throws SQLException {
		BoardVO member = null;
		member = (BoardVO)sqlSession.selectOne("mapper.board.selectBoardByBrdSeq", Integer.parseInt(brdSeq));


		return member;
	}

	public boolean insertOne(BoardVO board) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.board.insertBoard", board);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Insert board: "+flag);
		return flag;
	}

	public boolean updateOne(BoardVO board) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.board.updateBoard", board);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteOne(String brdSeq) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.board.deleteBoard", Integer.parseInt(brdSeq));
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}

}
