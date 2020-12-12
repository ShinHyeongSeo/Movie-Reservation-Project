package com.mycom.movie;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.movie.user.UserServiceImpl;
import com.mycom.movie.user.UserVO;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	UserServiceImpl service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(String t, Model model) {
		return "login";
	}
	
	@RequestMapping(value="/loginOk", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, UserVO vo) {
		String returnURL = "";
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		UserVO loginvo = service.getUser(vo);
		if(loginvo != null) { // 로그인 성공
			System.out.println("로그인 성공!");
			session.setAttribute("login", loginvo);
			//String dest = (String) session.getAttribute("dest");
			returnURL = "redirect:/board/list";
		}
		
		else {
			System.out.println("로그인 실패!");
			returnURL = "redirect:/login/login";
		}
		
		return returnURL;
	}
	
	//로그아웃 하는 부분
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/login";
	}
}
