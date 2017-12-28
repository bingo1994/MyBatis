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
	 * 查询讲师教授对应的课程
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
	 * 根据if分支判断添加查询条件来查询课程信息
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
	 * 根据choose when otherwise查询
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
	 * 根据where查询
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
	 * 根据foreach查询
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
