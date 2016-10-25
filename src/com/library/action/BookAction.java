package com.library.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.bean.BookVO;
import com.library.bean.Borrow_Return_Book;
import com.library.service.BookService;

@Controller
@RequestMapping("/book")
public class BookAction {
	@Autowired
	BookService bookService;
/*	@Autowired
	BookDAO bookDAO;*/
/*	@Autowired
	Book book;*/

	@RequestMapping("/findByID.do")
	@ResponseBody
	public String findBookByID(@RequestParam(value="queryInput") Integer bookID) throws JSONException {
		BookVO bookVO =  bookService.findByID(bookID);
		return JSONUtil.serialize(bookVO);
	}
	
	@RequestMapping("/findByName.do")
	@ResponseBody
	public String findBooksByName(@RequestParam("queryInput") String bookName, HttpServletRequest request) throws JSONException{
		List<BookVO> bookList = bookService.findByName(bookName);
		request.getSession().setAttribute("bookList", bookList);
		return JSONUtil.serialize(bookList);
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	public String addOneBook(@ModelAttribute(value="newBook") BookVO newBook, Model model){
		newBook.setSaveDate(new Date(new java.util.Date().getTime()));
		Integer bID = bookService.create(newBook);
		if(bID!=null){
			model.addAttribute("bID", bID);
			return "welcome";
		} else {
			return "addOneBook";
		}
	}
	
	@RequestMapping(value="/borrow.do")
	public String borrow(@ModelAttribute Borrow_Return_Book borrow, HttpServletRequest request){
		Date today = new Date(new java.util.Date().getTime());
		Date backDate = new Date((new java.util.Date().getTime())+30*24*60*60*1000);//expire date 30 days
		borrow.setBorrowDate(today);
		borrow.setBackDate(backDate);
		borrow.setState("out");
		Integer ID = bookService.borrowService(borrow);
		if(ID!=null){
			request.setAttribute("message", "borrow_book_success: ID="+ID);
		} else {
			request.setAttribute("message", "borrow_book_fault!");
		}
		return "borrowBook";
	}
	
	@RequestMapping(value="/return.do")
	public String back(@RequestParam Integer ID, HttpServletRequest request){
		Borrow_Return_Book retrn = new Borrow_Return_Book();
		retrn.setID(ID);
		Date returnDate = new Date(new java.util.Date().getTime());
		retrn.setReturnDate(returnDate);
		
		String res = bookService.back(retrn);
		request.setAttribute("message", res);
		return "returnBook";
	}
	
	@RequestMapping(value="/getOverTime.do")
	public String getOverTimeBooks(HttpServletRequest request){
		List<Borrow_Return_Book>books = bookService.getOverTime();
		if (books!=null) {
			request.setAttribute("books", books);
		}
		return "showOverTimeBooks";
	}
	
	@RequestMapping(value="/getBySaveDate.do")
	public String getBooksBySaveDate(@RequestParam(value="beginDate", required=true) String beginDate, @RequestParam(value="endDate", required=true)String endDate,
			HttpServletRequest request){
		if (beginDate==null||endDate==null) {
			request.setAttribute("error", "blank value!");
			return "findBook";
		} else {
			List<BookVO> bookList = bookService.getBySaveDateService(beginDate, endDate);
			if (bookList==null) {
				request.setAttribute("error", "no such book satisfiled your requirement!");
				return "findBook";
			}
			request.setAttribute("bookList", bookList);
			return "bookList";
		}
	}
	
}
