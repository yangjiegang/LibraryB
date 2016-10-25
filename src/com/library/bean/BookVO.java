package com.library.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/*@Entity
@Table(name="bookinfo")*/
public class BookVO implements Serializable{
	private static final long serialVersionUID = -793774362674744366L;
/*	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="bID", unique=true, nullable=true)*/
	private Integer bID;
//	@Column(name="bookName")
	private String bookName;
//	@Column(name="bookAuthor")
	private String bookAuthor;
//	@Column(name="saveDate")
	private Date saveDate;
	private String imgPath;
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Integer getbID() {
		return bID;
	}
	public void setbID(Integer bID) {
		this.bID = bID;
	}
	public String getBookName() {
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
	}
	public Date getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}
}
