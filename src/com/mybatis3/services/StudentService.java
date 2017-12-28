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
	 * ����id��ѯ����map����
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
	 * ��ҳ��ѯѧ������
	 * @param m ��װ��ǰҳcurpage��pagesize
	 * @return
	 */
	public List<Student> getStuByPage(Map<String,Integer> m){
		//��ȡSqlSession����
		List<Student> stulist=null;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);// �õ���.class�Ƿ������
			 stulist = studentMapper.getStuByPage(m);
			
		} finally {
			sqlSession.close();
		}
		return stulist;
	}
	
	
	
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);// �õ���.class�Ƿ������
			List<Student> stulist = studentMapper.findAllStudents();
			return stulist;
		} finally {
			sqlSession.close();
		}

	}

	/**
	 * ͨ��id��ѯ
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

	//�������
	public void insertStudent(Student stu) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(stu);
			sqlSession.commit();// ��ܵ��Լ������ύ��jdbc�Զ������ύ
		} catch(Exception e){
			//����ع�
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}

	/**
	 * ����id����stu
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
			//����ع�
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * ����idɾ������
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
			//�����ύ
			sqlSession.commit();
		} catch(Exception e){
			//����ع�
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return i;
	}

}
