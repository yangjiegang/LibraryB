package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public Boolean loginService(String userName, String password){
		Boolean isExist = userDAO.login(userName, password);
		return isExist;
	}
	
	public List<Object[]> getBorrowedBooks(String userName){
		List<Object[]>infos = new ArrayList<>();
		List<?> bookInfos = userDAO.getBorrowedBooks("Alex");
		for (Object bookInfo : bookInfos) {
			Object[]objs = (Object[])bookInfo;
//			System.out.println(Arrays.toString(objs));
			infos.add(objs);
//			System.out.println(objs[0]);
		}
		return infos;
	}
	
}
