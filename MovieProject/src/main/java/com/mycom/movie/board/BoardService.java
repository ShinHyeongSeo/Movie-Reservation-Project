package com.mycom.movie.board;

import java.util.List;

public interface BoardService {
	public int insertBoard(BoardVO vo);
	public int deleteBoard(int seq);
	public int updateBoard(BoardVO vo);
	public BoardVO getBoard(int seq);
	public BoardVO getBoardSeat(String seat);
	public BoardVO getBoardId(String userid);
	public List<BoardVO> getBoardList();
}
