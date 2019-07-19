package com.manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.colin.entity.Teacher;
import com.manager.biz.ManagerServiceI;
import com.manager.biz.ManagerServiceImp;

/**
 * Servlet implementation class AddTeaServlet
 */
@WebServlet("/TeaServlet")
public class TeaServlet extends HttpServlet {
	ManagerServiceI managerServiceI = new ManagerServiceImp();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//首先确定类型是添加还是删除老师修改老师信息等
		String type=request.getParameter("type");
		System.out.println(type);
		HttpSession session = request.getSession();
		switch (type) {
		//这是添加老师所要做的操作
		case "add":
			//拿到所添加的老师id和姓名
			String id1 = request.getParameter("id");
			String name1 = request.getParameter("name");
			System.out.println(request.getParameter("name"));
			//这些操作逐层  最后向teacher和user表插入此条数据
			Teacher teacher1 = new Teacher();
			teacher1.setId(id1);
			teacher1.setName(name1);
			//向Ajax返回的
			if(managerServiceI.addTeacher(teacher1)) {
				out.write("true");
			}else{
				out.write("false");
			}
			break;
			//这是删除老师所要做的操作
		case "del":
			System.out.println("进入删除老师的case");
			//拿到要删除的老师工号
			String id2 = request.getParameter("id");
			System.out.println(id2);
			if (managerServiceI.delTeacher(id2)){
				out.write("true");
			}else{
				out.write("false");
			}
			break;
			//这是修改老师信息所要做的操作
		case "alt":
			//我们操作的id
			String id3 =request.getParameter("id");
			
			//我们想变更的信息
			String afterid =request.getParameter("afterid");
			String aftername =request.getParameter("aftername");
			Teacher teacher3 = new Teacher();
			teacher3.setId(afterid);
			teacher3.setName(aftername);
			System.out.println(id3+afterid+aftername);
			if(managerServiceI.altTeacherById(id3,teacher3)) {
				out.write("true");
			}else {
				out.write("fales");
			}
			
			break;
			//这是查找老师所要做的操作
		case "find":
			String id4 = request.getParameter("id");
			Teacher teacher4=managerServiceI.findTeacherById(id4);
			if(null!=teacher4) {
				String state = new String();
				if(teacher4.getState()==1) {
					state = "在职";
				}else {
					state = "离职";
				}
				String info ="{"+"id:"+teacher4.getId()+","+"name:"+teacher4.getName()+","+"state:"+state+"}"; 
				//设置值  用queryTeaServlet来显示
				session.setAttribute("id", teacher4.getId());
				session.setAttribute("name", teacher4.getName());
				session.setAttribute("state", state);
				out.write(info);
			}else {
				out.write("false");
			}
			break;
		default:
			break;
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
