package com.mybatis3.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bean.Tutors;
import com.mybatis3.factory.util.MyBatisSqlSessionFactory;
import com.mybatis3.mappers.TutorsMapper;

public class TutorsService {
	
	/**
	 * ͨ��id��ѯ��ʦ��Ϣ
	 * @param tutorid
	 * @return
	 */
	public Tutors getTutorsById(int tutorid){
		// ��ȡSqlSession����
				SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
				TutorsMapper tutuorsMapper = sqlSession.getMapper(TutorsMapper.class);
				Tutors tutors = null;
				try {
					tutors = tutuorsMapper.getTutorsById(tutorid);
				} catch (Exception e) {
					// ����ع�
					sqlSession.rollback();
				} finally {
					sqlSession.close();
				}
				return tutors;
	}
	
	public Tutors findTutorsByIdSqlTest( int id){
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		TutorsMapper tutuorsMapper = sqlSession.getMapper(TutorsMapper.class);
		Tutors tutors = null;
		try {
			tutors = tutuorsMapper.getTutorsById(id);
		} catch (Exception e) {
			// ����ع�
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return tutors;
	}
	
	/**
	 * ͨ����ʦ�������������ѯ��ʦ��Ϣ
	 * @param map
	 * @return
	 */
	public Tutors getTutorsByNameEamil(Map<String,Object>map){
		// ��ȡSqlSession����
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
	 * ��ѯ���н�ʦ��Ӧ�Ŀγ���Ϣ
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
	 * ��ӽ�ʦ
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
	 * �޸Ľ�ʦ
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
	 * ɾ��
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
