package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.colin.entity.Achievement;
import com.student.achievement.biz.MyAchiSericeImp;
import com.student.achievement.biz.MyAchiServiceI;

/**
 * Servlet implementation class ShowMyachServlet
 */
@WebServlet("/ShowMyachServlet")
public class ShowMyachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyAchiServiceI myAchiServiceI = new MyAchiSericeImp();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ShowMyachServlet");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//得到学生id 根据id 去achievement里面去找各科成绩
		String id = (String)session.getAttribute("stuid");
		
		//逐层查询该学生的成绩 得到该条记录的对象
		Achievement achievement= myAchiServiceI.findById(id);
		String info="{   \"chinese\":"+achievement.getChinese()+",\"math\":"+achievement.getMath()+",\"english\":"+achievement.getEnglish()+",\"sum\":"+achievement.getSum()+",\"avg\":"+achievement.getAvg()+"}";
		out.println(info);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
