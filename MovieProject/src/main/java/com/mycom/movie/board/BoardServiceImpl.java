package com.mycom.movie.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO boardDAO;

	@Override
	public int insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.insertBoard(vo);
	}

	@Override
	public int deleteBoard(int seq) {
		// TODO Auto-generated method stub
		return boardDAO.deleteBoard(seq);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.updateBoard(vo);
	}

	@Override
	public BoardVO getBoard(int seq) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(seq);
	}
	
	@Override
	public BoardVO getBoardSeat(String seat) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardSeat(seat);
	}
	
	@Override
	public BoardVO getBoardId(String userid) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardId(userid);
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}
	
}
