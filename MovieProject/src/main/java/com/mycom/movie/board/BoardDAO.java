package com.mycom.movie.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int insertBoard(BoardVO vo) {
		int result = sqlSession.insert("Board.insertBoard", vo);
		return result;
	}
	
	public int deleteBoard(int seq) {
		int result = sqlSession.delete("Board.deleteBoard", seq);
		return result;
	}
	
	public int updateBoard(BoardVO vo) {
		int result = sqlSession.update("Board.updateBoard", vo);
		return result;		
	}
	
	public BoardVO getBoard(int seq) {
		BoardVO result = sqlSession.selectOne("Board.getBoard", seq);
		return result;		
	}
	
	public BoardVO getBoardSeat(String seat) {
		BoardVO result = sqlSession.selectOne("Board.getBoardSeat", seat);
		return result;		
	}
	
	public BoardVO getBoardId(String userid) {
		BoardVO result = sqlSession.selectOne("Board.getBoardId", userid);
		return result;		
	}
	
	public List<BoardVO> getBoardList() {
		List<BoardVO> result = sqlSession.selectList("Board.getBoardList");
		return result;		
	}
}
