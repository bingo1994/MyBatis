package com.mybatis3.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bean.Course;
import com.bean.Tutors;
import com.mybatis3.factory.util.MyBatisSqlSessionFactory;

public class TutorsCourseService {

	/**
	 * ��ѯ��ʦ���ڶ�Ӧ�Ŀγ�
	 * @return
	 */
	public List<Tutors> getTutuorsTalkCourse(){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Tutors> tlist=sqlSession.selectList("com.mybatis3.mappers.TuTorsCourseMapper.getTutuorsTalkCourse");
		sqlSession.close();
			return tlist;
	}
	
	
	public List<Tutors> getTutuorsTeachCourse(){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Tutors> tlist=sqlSession.selectList("com.mybatis3.mappers.TuTorsCourseMapper.findTutorsById");
		sqlSession.close();
			return tlist;
	}
	
	
	/**
	 * ����if��֧�ж���Ӳ�ѯ��������ѯ�γ���Ϣ
	 * @param map
	 * @return
	 */
	public List<Course> getCourseByIf(Map<String,Object> map){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Course> t=sqlSession.selectList("com.mybatis3.mappers.TuTorsCourseMapper.getCourseByIf",map);
		sqlSession.close();
			return t;
	}
	
	/**
	 * ����choose when otherwise��ѯ
	 * @param map
	 * @return
	 */
	public List<Course> getCourseByChoose(HashMap<String, Object> map){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Course> t=sqlSession.selectList("com.mybatis3.mappers.TuTorsCourseMapper.getCourseByChoose",map);
		sqlSession.close();
			return t;
		
	}
	
	/**
	 * ����where��ѯ
	 * @param map
	 * @return
	 */
	public List<Course> getCourseByWhere(HashMap<String, Object> map){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Course> t=sqlSession.selectList("com.mybatis3.mappers.TuTorsCourseMapper.searchCourseByWhere",map);
		sqlSession.close();
			return t;
		
	}
	
	
	/**
	 * ����foreach��ѯ
	 * @param map
	 * @return
	 */
	public List<Course> getCourseByForeach(HashMap<String, Object> map){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Course> t=sqlSession.selectList("com.mybatis3.mappers.TuTorsCourseMapper.getCourseByForeach",map);
		sqlSession.close();
			return t;
		
	}
}
