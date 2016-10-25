package test;

import java.lang.reflect.Member;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.Constants;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.request.RequestContextListener;

import com.library.action.UserAction;

public class testDAO {
	
	private ApplicationContext appCtx;
	private MockServletContext context;
	private MockHttpServletRequest request;
//	private UserAction userAction;
	private MockHttpSession session;

	@Before
	public void setUp() throws Exception {
		appCtx= new ClassPathXmlApplicationContext("test/appCtx.xml");

	}

	@Test
	public void test() throws InterruptedException, JSONException {
//		BookDAO bookDAO = appCtx.getBean(BookDAO.class);
//		System.out.println(bookDAO.getBooksBySaveDate("2016-09-01","2016-09-02"));
//		Borrow_Return_Book borrow_Return_Book = new Borrow_Return_Book();
		
//		borrow_Return_Book.setbID(1);
//		borrow_Return_Book.setID(6);
//		borrow_Return_Book.setuID(2);
//		borrow_Return_Book.setBorrowDate(new Date(new java.util.Date().getTime()-1000*60*60*24*5));
//		borrow_Return_Book.setReturnDate(new Date(new java.util.Date().getTime()));
//		borrow_Return_Book.setBackDate(new Date(new java.util.Date().getTime()+1000*60*60*24*5));
//		borrow_Return_Book.setState("returned");
		
//		System.out.println(bookDAO.back(borrow_Return_Book));
		
/*		UserDAO userDAO = appCtx.getBean(UserDAO.class);
		List<Object[]>infos = new ArrayList<>();
		List<?> bookInfos = userDAO.getBorrowedBooks("Alex");
		for (Object bookInfo : bookInfos) {
			Object[]objs = (Object[])bookInfo;
			System.out.println(Arrays.toString(objs));
			infos.add(objs);
		}*/
//		System.out.println(infos);
//		String serialize = JSONUtil.serialize(bookInfos);
//		System.out.println(serialize);
		
		UserAction userAction = appCtx.getBean(UserAction.class);
		RequestContextListener listener = new RequestContextListener();
		context = new MockServletContext();
		request = new MockHttpServletRequest(context);
		session = new MockHttpSession();
		session.setAttribute("userName", "Alex");
		listener.requestInitialized(new ServletRequestEvent(context, request));
		String res = userAction.userCenter("Alex", request);
		System.out.println(res);
//		session.setAttribute(Constants.SESSION_USER, member);
		request.setSession(session); 
//		System.out.println(userAction.userCenter("Alex", request));
	}

}


