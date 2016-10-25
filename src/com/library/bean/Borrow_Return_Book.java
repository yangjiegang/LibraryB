package com.library.bean;

import java.io.Serializable;
import java.sql.Date;

//@Entity
//@Table(name="borrow_return_book")
public class Borrow_Return_Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4930658528951546595L;
/*	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="ID")*/
	private Integer ID;
//	@Column(name="bID")
	private Integer bID;
//	@Column(name="uID")
	private Integer uID;
//	@Column(name="borrowDate")
	private Date borrowDate;
//	@Column(name="backDate")
	private Date backDate;//the date be supposed to return book
//	@Column(name="state")
	private String state;
//	@Column(name="returnDate")
	private Date returnDate;
//	private String bookName;//do not point to database
//	private String bookAuthor;
	
	public Integer getID() {
		return ID;
	}
/*	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getbID() {
		return bID;
	}
	public void setbID(Integer bID) {
		this.bID = bID;
	}
	public Integer getuID() {
		return uID;
	}
	public void setuID(Integer uID) {
		this.uID = uID;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getBackDate() {
		return backDate;
	}
	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
}
