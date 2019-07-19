package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.biz.StudentServiceI;
import com.student.biz.StudentServiceImp;
import com.util.MD5Util;

/**
 * Servlet implementation class ReMyPwdServley
 */
@WebServlet("/ReMyPwdServley")
public class ReMyPwdServley extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentServiceI studentServiceI = new StudentServiceImp();
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ReMyPwdServley");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//得到学生id 根据id 去achievement里面去找各科成绩
		String id = (String)session.getAttribute("stuid");
		String pwd = MD5Util.md5Password(request.getParameter("pwd"));
		System.out.println(id+pwd);
		if(studentServiceI.altPwdById(id,pwd)) {
			out.write("t");
		}else {
			out.write("f");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
