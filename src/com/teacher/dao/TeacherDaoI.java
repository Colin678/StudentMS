package com.teacher.dao;

import java.util.List;

import com.colin.entity.Student;

public interface TeacherDaoI {
	
	boolean insertStu(Student student1);

	boolean deleteStu(String id2);

	List<Student> selectStuByState(int state);

	boolean alterStuById(String id, Student student4);

}
