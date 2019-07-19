package com.teacher.biz;



import java.util.List;

import com.colin.entity.Student;

public interface TeacherServiceI {
	/**
	 * 添加一名学生
	 * 参数为一个从页面获取数据而new出来的学生对象
	 * @param student1
	 * @return
	 */
	public boolean addStu(Student student1);
	/**
	 * 删除一名学生
	 * 参数为一个从页面获取的id
	 * @param student1
	 * @return
	 */
	public boolean delStu(String id2);
	/**
	 * 根据state的数值 找出所有state为她的学生
	 * @param state
	 * @return
	 */
	public List<Student> findStu(int state);
	/**
	 * 根据id 找到记录修改为student4
	 * @param id
	 * @param student4
	 */
	public boolean altStudentById(String id, Student student4);

}
