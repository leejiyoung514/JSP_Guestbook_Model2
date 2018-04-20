package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;

import com.javaex.dao.GuestbookDAO;
import com.javaex.vo.GuestbookVO;

@WebServlet("/Gb")
public class GuestbookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Controller");
		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("a");
		
		if("insert".equals(actionName)) {
			request.setCharacterEncoding("UTF-8");
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String content=request.getParameter("content");
			
			GuestbookVO vo=new GuestbookVO(name, pass, content);
			GuestbookDAO dao=new GuestbookDAO();				
			dao.insert(vo);		
			
			/*response.sendRedirect("/gusetbook/Gb");*/
			
			dao = new GuestbookDAO();
			List<GuestbookVO> list=dao.getlist();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
			
		}else if("deleteform".equals(actionName)) {
			request.setCharacterEncoding("UTF-8");
			
			RequestDispatcher rd = request.getRequestDispatcher("deleteform.jsp");
			rd.forward(request, response);
			
		}else if("delete".equals(actionName)) {
		
			int no=Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			String password=request.getParameter("password");
			GuestbookDAO dao = new GuestbookDAO();
			
			int result=dao.delete(no, password);
			
			System.out.println(result+"∞« ªË¡¶");
			
			//response.sendRedirect("/gusetbook/Gb");
	        dao = new GuestbookDAO();
			List<GuestbookVO> list=dao.getlist();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
		}else {
			GuestbookDAO dao = new GuestbookDAO();
			List<GuestbookVO> list=dao.getlist();
			request.setAttribute("list", list);
			System.out.println(list.toString());
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
		}
		
	}

}
