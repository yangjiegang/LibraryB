package com.library.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.library.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
/*	@Autowired
	private UserDAO userDAO;*/
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(@RequestParam(value="userName",required = false, defaultValue = "")String userName, @RequestParam(value="password")String password,
			HttpServletRequest request){
		Boolean isExist = userService.loginService(userName, password);
		if (isExist) {
			request.getSession().setAttribute("userName", userName);
			return "welcome";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/center.do")
//	@ResponseBody
	public String userCenter(@RequestParam String userName ,HttpServletRequest request, ModelAndView mdv) throws JSONException{
		List<Object[]> borrowedBooks = userService.getBorrowedBooks(userName);
//		String serialize = JSONUtil.serialize(borrowedBooks);
		request.setAttribute("borrowedBooks", borrowedBooks);
		mdv.addObject("borrowedBooks", borrowedBooks);
		return "userCenter";
/*		if(userName.equals(request.getSession().getAttribute("userName"))){
			List<Borrow_Return_Book> borrowedBooks = userDAO.getBorrowedBooks(userName);
			request.setAttribute("borrowedBooks", borrowedBooks);
			return "userCenter";
		} else {
			return "index";
		}*/
	}
	
}
