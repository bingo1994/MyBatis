package com.mybatis3.mappers;

import java.util.List;
import java.util.Map;

import com.bean.Student;

public interface StudentMapper {
	
	public Student selStu(String name);
	
	public List<Student> findAllStudents();

	public Student getStuById(int id);

	public void insertStudent(Student stu);
	
	public int updateStuById(Student stu);
	
	public int deleteStuById(int id);
	
	/**
	 * 根据id查询学生数据，返回map数据
	 * @param id
	 * @return
	 */
	public Map<String,Object> getStuByIdMap(int id);
	
	/**
	 * 分页查询
	 * @param m
	 * @return
	 */
	public List<Student> getStuByPage(Map<String,Integer> m);
}
