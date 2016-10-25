package com.library.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Boolean login(String userName, String password){
/*		String sql = "select password from userinfo where username=? and password=?";
		Boolean isExist = false;
		List<?> pwdList = jdbcTemplate.queryForList(sql, new Object[]{userName, password});
		if (pwdList.size()>=1) {
			isExist=true;
		}
		return isExist;*/
		return true;
	}
	
	public List<?> getBorrowedBooks(final String userName){
		final String queryString= "SELECT brb.borrowDate,brb.backDate,brb.returnDate,brb.state,book.bookName,book.bookAuthor FROM Borrow_Return_Book brb ,UserVO usr,BookVO book WHERE brb.uID=usr.uID AND usr.userName='"+userName+"' AND book.bID=brb.bID";
//		List<Borrow_Return_Book> bookInfos = (List<Borrow_Return_Book>) hibernateTemplate.find(queryString, userName);
		List<?> bookInfos = hibernateTemplate.execute(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session){
				Query query = session.createQuery(queryString);
				return query.list();
				
			}
		});
		return bookInfos;
	}
	
}
