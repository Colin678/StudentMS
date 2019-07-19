package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.colin.entity.User;
import com.user.biz.UserServiceI;
import com.user.biz.UserServiceImp;
import com.util.MD5Util;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println(666);
		//服务端验证码的值
		String checkcodeC=request.getParameter("checkcodeid");
		//真实的验证码
		String yzm = (String)request.getSession().getAttribute("cc");
		
		System.out.println(yzm+checkcodeC);
		
		//得到登录页面的id密码身份
		String uid = request.getParameter("userid");
		String upwd =  MD5Util.md5Password(request.getParameter("userpwd"));
		String utype = request.getParameter("identity");
		
		
		//new出一个实例user
		User user = new User();
		user.setUid(uid);
		user.setUpwd(upwd);
		user.setUtype(utype);
		
		
		//逐层 查找数据库中user表有没有这一条记录有的话则跳转到对应的页面  没有的话返回登录页面
		UserServiceI userServiceI = new UserServiceImp();
		User user2 = userServiceI.findByUser(user);
		
		
		
		
		//通过判断utype 从而决定跳转到那个页面 如果为空即没找到就在去登陆页面
		String uname=null;//获得当前用户的名字，在自己的页面显示出来
		if(null!=user2&&user.getUtype().equals(user2.getUtype())&&yzm.equals(checkcodeC)) {
			System.out.println(user.getUtype()+""+user2.getUtype()+yzm+checkcodeC);
			switch (utype) {
			case "manager":
				uname = userServiceI.findNameByUid(uid,utype);
				session.setAttribute("name", uname);
				response.sendRedirect("user/manager.jsp");
				break;
			case "teacher":
				uname = userServiceI.findNameByUid(uid,utype);
				session.setAttribute("name", uname);
				//如果在职则可以进去  离职则返回登录页面
				if(userServiceI.findeStateByUid(uid,utype)) {
					response.sendRedirect("user/teacher.jsp");
				}else {
					response.sendRedirect("user/login.jsp");
				}
				break;
			case "student":
				uname = userServiceI.findNameByUid(uid,utype);
				session.setAttribute("name", uname);
				session.setAttribute("stuid", uid);
				System.out.println(uid);
				//如果在读则可以进去
				if(userServiceI.findeStateByUid(uid,utype)) {
					response.sendRedirect("user/student.jsp");
				}else {
					response.sendRedirect("user/login.jsp");
				}
				
				break;
			default:
				break;
			}
		}else {
			response.sendRedirect("user/login.jsp");
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
