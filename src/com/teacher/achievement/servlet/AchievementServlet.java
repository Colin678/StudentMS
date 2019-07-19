package com.teacher.achievement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.colin.entity.Achievement;
import com.teacher.achievement.biz.AchievementServiceI;
import com.teacher.achievement.biz.AchievementServiceImp;
import com.user.biz.UserServiceI;
import com.user.biz.UserServiceImp;

/**
 * Servlet implementation class AchievementServlet
 */
@WebServlet("/AchievementServlet")
public class AchievementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AchievementServiceI achievementServiceI = new AchievementServiceImp();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AchievementServlet");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//用来确定是添加一位学生的成绩还是修改成绩
		String type = request.getParameter("type");
		//目标操作的id
		String id = request.getParameter("id");
		//添加什么成绩 或者修改成什么？
		double chinese = Double.parseDouble(request.getParameter("chinese"));
		double math = Double.parseDouble(request.getParameter("math"));
		double english = Double.parseDouble(request.getParameter("english"));
		double sum = chinese+math+english;
		double avg = sum/3;
		System.out.println(chinese+" "+math+" "+english);
		//获得当前用户的名字，在自己的页面显示出来分别在添加成绩和修改成绩获取对应的name
		UserServiceI userServiceI = new UserServiceImp();
		String name=null;
		switch (type) {
		//添加成绩的操作
		case "add1":
			//new出一个要添加成绩的实例
			Achievement achievement1 = new Achievement();
			name=userServiceI.findNameByUid(id,"student");
			session.setAttribute("sname", name);
			//为他是只好从页面取出来的值
			achievement1.setId(id);
			achievement1.setName(name);
			achievement1.setChinese(chinese);
			achievement1.setMath(math);
			achievement1.setEnglish(english);
			achievement1.setSum(sum);
			achievement1.setAvg(avg);
			if(achievementServiceI.addAchi(achievement1)) {
				out.write("t");
			}else {
				out.write("f");
			}
			
			break;
			//修改成绩的操作
		case "alt1":
			name=userServiceI.findNameByUid(id,"student");
			System.out.println(name);
			session.setAttribute("sname", name);
			System.out.println(type);
			
			//new出一个要添加成绩的实例
			Achievement achievement2 = new Achievement();
			name=userServiceI.findNameByUid(id,"student");
			session.setAttribute("sname", name);
			//为他是只好从页面取出来的值
			achievement2.setId(id);
			achievement2.setName(name);
			achievement2.setChinese(chinese);
			achievement2.setMath(math);
			achievement2.setEnglish(english);
			achievement2.setSum(sum);
			achievement2.setAvg(avg);
			if(achievementServiceI.altAchi(achievement2)) {
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
