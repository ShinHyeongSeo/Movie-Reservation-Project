package com.mycom.movie;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.movie.board.BoardService;
import com.mycom.movie.board.BoardVO;


@Controller
@RequestMapping(value="/board")

public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		model.addAttribute("list", boardService.getBoardList());
		return "list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPost(String seat, Model model, HttpServletResponse response) throws Exception {
		BoardVO check = boardService.getBoardSeat(seat);
		
		if(check != null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 예약된 좌석입니다.'); </script>");
			out.flush();
			model.addAttribute("list", boardService.getBoardList());
			return "list";
		}
		
		else {
			BoardVO boardVO = new BoardVO();
			boardVO.setSeat(seat);
			model.addAttribute("u", boardVO);
			return "addpostform";
		}
	}
	
	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String addPostOk(BoardVO vo, Model model, HttpServletResponse response) throws Exception {
		BoardVO check = boardService.getBoardId(vo.getUserid());
		if(check != null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('중복된 아이디입니다.'); </script>");
			out.flush();
			model.addAttribute("u", vo);
			return "addpostform";
		}
		
		else {
			if(boardService.insertBoard(vo)==0) {
				System.out.println("데이터 추가 실패 ");
			}
			else { 
				System.out.println("데이터 추가 성공!!!");
			}
			return "redirect:list";
		}
	}
	
	@RequestMapping(value = "/viewform/{id}", method = RequestMethod.GET)
	public String viewPost(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("u", boardVO);
		return "viewform";
	}
	
	@RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("u", boardVO);
		return "editform";
	}
	
	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editPostOk(BoardVO vo, Model model, HttpServletResponse response) throws Exception {
		BoardVO check_by_id = boardService.getBoardId(vo.getUserid());
		BoardVO check_by_seat = boardService.getBoardSeat(vo.getSeat());
		
		if(check_by_id != null && vo.getSeq() != check_by_id.getSeq()) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('중복된 아이디입니다.'); </script>");
			out.flush();
			
			model.addAttribute("list", boardService.getBoardList());
			return "list";
		}
		
		if(check_by_seat != null && vo.getSeq() != check_by_seat.getSeq()) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 예약된 좌석입니다.'); </script>");
			out.flush();
			
			model.addAttribute("list", boardService.getBoardList());
			return "list";
		}
		
		if(boardService.updateBoard(vo)==0) {
			System.out.println("데이터 수정 실패 ");
		}
		else { 
			System.out.println("데이터 수정 성공!!!");
		}
		return "redirect:list";
	}
	
	@RequestMapping(value="/deleteok/{id}", method = RequestMethod.GET)
	   public String deletePostOk(@PathVariable("id") int id) {
	      if(boardService.deleteBoard(id) == 0) {
	         System.out.println("데이터 삭제 실패");
	      }
	      else {
	         System.out.println("데이터 삭제 성공!!!");
	      }
	      return "redirect:../list";
	   }
	
	
}
