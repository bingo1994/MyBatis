package com.mybatis3.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bean.Student;
import com.mybatis3.factory.util.MyBatisSqlSessionFactory;
import com.mybatis3.mappers.StudentMapper;

public class StudentService {
	public Student selStu(String name){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			Student stu=studentMapper.selStu(name);
			sqlSession.close();
			return stu;
	}
	
	
	/**
	 * 根据id查询返回map数据
	 * @param id
	 * @return
	 *//*
	public Map<String,Object> getStuByIdMap(int id){
		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();
		Map map=null;
		try{
			StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
			map=studentMapper.getStuByIdMap(id);
		}finally{
			sqlSession.close();
		}
		return map;
	}
*/
	/**
	 * 分页查询学生数据
	 * @param m 封装当前页curpage和pagesize
	 * @return
	 */
	public List<Student> getStuByPage(Map<String,Integer> m){
		//获取SqlSession对象
		List<Student> stulist=null;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);// 得到的.class是反射对象
			 stulist = studentMapper.getStuByPage(m);
			
		} finally {
			sqlSession.close();
		}
		return stulist;
	}
	
	
	
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);// 得到的.class是反射对象
			List<Student> stulist = studentMapper.findAllStudents();
			return stulist;
		} finally {
			sqlSession.close();
		}

	}

	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public Student getStuById(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			Student stu = studentMapper.getStuById(id);
			return stu;
		} finally {
			sqlSession.close();
		}

	}

	//添加数据
	public void insertStudent(Student stu) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(stu);
			sqlSession.commit();// 框架得自己事务提交，jdbc自动事务提交
		} catch(Exception e){
			//事务回滚
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}

	/**
	 * 根据id更新stu
	 * 
	 * @param stu
	 * @return
	 */
	public int updateStuById(Student stu) {
		int i = 0;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			i = studentMapper.updateStuById(stu);
			sqlSession.commit();
		}catch(Exception e){
			//事务回滚
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * 根据id删除数据
	 * 
	 * @param id
	 * @return
	 */
	public int deleteStuById(int id) {
		int i = 0;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			i = studentMapper.deleteStuById(id);
			//事务提交
			sqlSession.commit();
		} catch(Exception e){
			//事务回滚
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return i;
	}

}
