package com.teacher.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.colin.entity.Student;
import com.teacher.biz.TeacherServiceI;
import com.teacher.biz.TeacherServiceImp;

import net.sf.json.JSONObject;



/**
 * Servlet implementation class StuServlet
 */
@WebServlet("/StuServlet")
public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   TeacherServiceI teacherServiceI = new TeacherServiceImp();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("StuServlet");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//首先确定类型是添加还是删除老师修改老师信息等
		String type=request.getParameter("type");
		System.out.println(type);
		HttpSession session = request.getSession();
		switch (type) {
		case "add":
			//拿到所添加的学生id和姓名
			String id1 = request.getParameter("id");
			String name1 = request.getParameter("name");
			System.out.println(name1+id1);
			
			//接下来就是添加一名学生 首先先new一个学生出来 作为我们添加的学生
			Student student1 = new Student();
			student1.setId(id1);
			student1.setName(name1);
			//逐层向数据库insert一条记录  向Ajax回调的
			if(teacherServiceI.addStu(student1)) {
				out.write("true");
			}else {
				out.write("flase");
			}
			break;
		case "del":
			//拿到要删除学生的id
			String id2 = request.getParameter("id");
			System.out.println(id2);
			
			//逐层向数据库删除删除此学生 成功返回"true" 失败返回"flase"
			if(teacherServiceI.delStu(id2)) {
				out.write("true");
			}else {
				out.write("flase");
			}
			break;
		case "find":
			List<Student> stulist;
			//按不同状态查找学生
			String state=request.getParameter("state");
			System.out.println(state);
			//在读的    student库中state为1  毕业的为0   退学的为-1
			if("在读".equals(state)) {
				stulist=teacherServiceI.findStu(1);
				session.setAttribute("stulist", stulist);
				String info="{\"data\":[";
				for(int i=0;i<stulist.size();i++) {
					String id = stulist.get(i).getId();
					String name = stulist.get(i).getName();
					if(i!=stulist.size()-1) {
						info=info+"{\"id\":\""+id+"\",\"name\":\""+name+"\"},";
					}else {
						info=info+"{\"id\":\""+id+"\",\"name\":\""+name+"\"}]}";
					}
				}
				//JSONObject stuinfo = new JSONObject();
				//stuinfo.put("stulist", stulist);
				out.println(info);
				
			}else if("毕业".equals(state)){
				stulist=teacherServiceI.findStu(0);
				session.setAttribute("stulist", stulist);
				String info="\"{\"data\":[";
				for(int i=0;i<stulist.size();i++) {
					String id = stulist.get(i).getId();
					String name = stulist.get(i).getName();
					if(i!=stulist.size()-1) {
						info=info+" {\"id\":"+id+",\"name\":"+name+"},";
					}else {
						info=info+" {\"id\":"+id+",\"name\":"+name+"}]}";
					}
				}
				out.println(info);
			}else if("退学".equals(state)) {
				stulist=teacherServiceI.findStu(-1);
				session.setAttribute("stulist", stulist);
				String info="\"{\"data\":[";
				for(int i=0;i<stulist.size();i++) {
					String id = stulist.get(i).getId();
					String name = stulist.get(i).getName();
					if(i!=stulist.size()-1) {
						info=info+" {\"id\":"+id+",\"name\":"+name+"},";
					}else {
						info=info+" {\"id\":"+id+",\"name\":"+name+"}]}";
					}
				}
				out.println(info);
			}
			break;
		case "alt":
			//操作的目标id
			String id = request.getParameter("id");
			//要变更的信息
			String afterid = request.getParameter("afterid");
			String aftername = request.getParameter("aftername");
			String afterstate = request.getParameter("afterstate");
			//-1退学 0毕业  1在读 此时需要转化afterstate为int
			int state1 = 0;
			if("在读".equals(afterstate)) {
				state1 = 1;
			}else if("退学".equals(afterstate)) {
				state1=-1;
			}else if(("毕业".equals(afterstate)) ){
				state1=0;
			}
			System.out.println(id);
			Student student4 = new Student();
			student4.setId(afterid);
			student4.setName(aftername);
			student4.setState(state1);
			if(teacherServiceI.altStudentById(id,student4)) {
				out.write("t");
			}else {
				out.write("f");
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
