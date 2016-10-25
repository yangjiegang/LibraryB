package com.library.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.library.bean.BookVO;
import com.library.bean.Borrow_Return_Book;

@Repository
public class BookDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<BookVO> findBooksByName(String bookName) {
		String sql = "from BookVO book where book.bookName like '%"+bookName+"%'";
		List<BookVO> bookList = (List<BookVO>)hibernateTemplate.find(sql);
		return bookList;
	}
	
	public BookVO findBookByID(Integer bookID){
		//final Book book = new Book();
		String hql="FROM BookVO book WHERE book.bID=?";
		@SuppressWarnings("unchecked")
		List<BookVO> bookList = (List<BookVO>)hibernateTemplate.find(hql, bookID);
//		Book book = hibernateTemplate.get(Book.class, 1);
//		System.out.println(bookList);
		if (bookList.size()==0) {
			return null;
		}
		return bookList.get(0);
	}
	
	public Integer addOneBook(final BookVO book){
//		final String sql = "insert into bookinfo(bookName,bookAuthor,count,saveDate) values(?,?,?,?)";
		Serializable res = hibernateTemplate.save(book);
		return (Integer)res;
	}
	
	public Integer borrow(final Borrow_Return_Book borrow){
		//String hql = "FROM BorrowReturn br WHERE br.";
		return (Integer)hibernateTemplate.save(borrow);
	}
	
	public String back(final Borrow_Return_Book retrn){
		Borrow_Return_Book borrow_Return_Book = hibernateTemplate.get(Borrow_Return_Book.class, retrn.getID());
		borrow_Return_Book.setReturnDate(retrn.getReturnDate());
		borrow_Return_Book.setState("reurned");
//		String queryString = "UPDATE Borrow_Return_Book brb SET(returnDate='"+retrn.getbID()+"', state='returned') WHERE uID='"+retrn.getuID()+"' AND bID='"+retrn.getbID()+"'";
		try {
			hibernateTemplate.update(borrow_Return_Book);
//			hibernateTemplate.bulkUpdate(queryString);
		} catch (Exception e) {
			e.printStackTrace();
			return "return_book_error";
		}
		return "return_book_success";
	}
	
	@SuppressWarnings("unchecked")
	public List<Borrow_Return_Book> getOverTimeBooks(){
		String hql = "FROM Borrow_Return_Book br WHERE TO_DAYS(br.backDate)<TO_DAYS(NOW())";
		List<Borrow_Return_Book>books = (List<Borrow_Return_Book>)hibernateTemplate.find(hql);
		return books;
	}
	
	@SuppressWarnings("unchecked")
//	public List<BookVO> getBooksBySaveDate(Date beginDate, Date endDate){
	public List<BookVO> getBooksBySaveDate(String date0, String date1){
		String hql = "FROM BookVO book WHERE book.saveDate BETWEEN '"+date0+"' AND '"+date1+"'";
		List<BookVO> bookList = (List<BookVO>)hibernateTemplate.find(hql);
//		List<BookVO> bookList = (List<BookVO>)hibernateTemplate.find(hql, new Object[]{date0, date1});
		return bookList;
	}
}
