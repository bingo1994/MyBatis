package com.mybatis3.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bean.Tutors;
import com.mybatis3.factory.util.MyBatisSqlSessionFactory;
import com.mybatis3.mappers.TutorsMapper;

public class TutorsService {
	
	/**
	 * 通过id查询讲师信息
	 * @param tutorid
	 * @return
	 */
	public Tutors getTutorsById(int tutorid){
		// 获取SqlSession对象
				SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
				TutorsMapper tutuorsMapper = sqlSession.getMapper(TutorsMapper.class);
				Tutors tutors = null;
				try {
					tutors = tutuorsMapper.getTutorsById(tutorid);
				} catch (Exception e) {
					// 事务回滚
					sqlSession.rollback();
				} finally {
					sqlSession.close();
				}
				return tutors;
	}
	
	public Tutors findTutorsByIdSqlTest( int id){
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TutorsMapper tutuorsMapper = sqlSession.getMapper(TutorsMapper.class);
		Tutors tutors = null;
		try {
			tutors = tutuorsMapper.getTutorsById(id);
		} catch (Exception e) {
			// 事务回滚
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return tutors;
	}
	
	/**
	 * 通过讲师的姓名和邮箱查询讲师信息
	 * @param map
	 * @return
	 */
	public Tutors getTutorsByNameEamil(Map<String,Object>map){
		// 获取SqlSession对象
				SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
				TutorsMapper tutuorsMapper = sqlSession.getMapper(TutorsMapper.class);
				Tutors tutors = null;
				try {
					tutors = tutuorsMapper.getTutorsByNameEamil(map);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					sqlSession.close();
				}
				return tutors;
	}
	
	/**
	 * 查询所有讲师对应的课程信息
	 * @return
	 */
	public List<Tutors>getTutorsCourse(){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TutorsMapper tutuorsMapper = sqlSession.getMapper(TutorsMapper.class);
		List<Tutors> tutorslist = null;
		try {
			tutorslist = tutuorsMapper.getTutorsCourse();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return tutorslist;
	}
	
	/**
	 * 添加讲师
	 * @param t
	 * @return
	 */
	public int addTutors(Tutors t){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TutorsMapper tutuorsMapper = sqlSession.getMapper(TutorsMapper.class);
		int i=0;
		try {
			i = tutuorsMapper.addTutors(t);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return i;
	}
	
	/**
	 * 修改讲师
	 * @param t
	 * @return
	 */
	public int updateTutors(Tutors t){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TutorsMapper tutuorsMapper = sqlSession.getMapper(TutorsMapper.class);
		int i=0;
		try {
			i = tutuorsMapper.updateTutors(t);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return i;
	}
	
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	public int deleteTutors(Tutors t){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TutorsMapper tutuorsMapper = sqlSession.getMapper(TutorsMapper.class);
		int i=0;
		try {
			i = tutuorsMapper.deleteTutors(t);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return i;
	}
}
