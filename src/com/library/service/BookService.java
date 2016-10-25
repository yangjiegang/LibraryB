package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.bean.BookVO;
import com.library.bean.Borrow_Return_Book;
import com.library.dao.BookDAO;

@Service
public class BookService {
	@Autowired
	private BookDAO bookDAO;

	public BookVO findByID(Integer bookID){
		BookVO bookVO =  bookDAO.findBookByID(bookID);
		return bookVO;
	}
	
	public List<BookVO> findByName(String bookName){
		List<BookVO> bookList = bookDAO.findBooksByName(bookName);
		return bookList;
	}
	
	public Integer create(BookVO newBook){
		Integer bID = bookDAO.addOneBook(newBook);
		return bID;
	}
	
	public String back(Borrow_Return_Book retrn){
		String res = bookDAO.back(retrn);
		return res;
	}
	
	public Integer borrowService(Borrow_Return_Book borrow){
		return bookDAO.borrow(borrow);
	}
	
	public List<Borrow_Return_Book> getOverTime(){
		List<Borrow_Return_Book>books = bookDAO.getOverTimeBooks();
		return books;
	}
	
	public List<BookVO> getBySaveDateService(String beginDate, String endDate){
//		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		List<BookVO> bookVOs = new ArrayList<>();
		//			Date date0 = sdf.parse(beginDate);
//			Date date1 = sdf.parse(endDate);
		bookVOs = bookDAO.getBooksBySaveDate(beginDate, endDate);
		return bookVOs;
	}
	
}
