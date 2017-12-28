package com.mybatis3.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.bean.Student;
import com.mybatis3.factory.util.MyBatisSqlSessionFactory;

public class StudentSqlSessionService {
	/**
	 * �Զ����װ���� ��ѯ����ͨ��ResultHandler(�ӿ�)ʵ���Զ���ķ�װ���ݲ��� ��ѧ����id��Ϊkey ѧ����������Ϊvalueֵ
	 * 
	 * @param stu
	 * @return
	 */
	public Map<Integer, String> getAllStudentByIdName() {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		// �����ڲ����ó���
		final Map<Integer, String> stumap = new HashMap<Integer, String>();
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ�� �ڶ��������Ƿ�ҳ��ѯ������
			sqlSession.select("com.mybatis3.mappers.StudentMapper.findAllStudents", new ResultHandler() {
				// ͨ�������ڲ���ʵ��ResultHandler�ӿ�
				@Override
				public void handleResult(ResultContext arg0) {// ѧ�����ݶ���ResultContext
					// TODO Auto-generated method stub
					// ��ResultContext����ת��Student��bean
					Student stu = (Student) arg0.getResultObject();
					stumap.put(stu.getId(), stu.getName());
				}
			});
		} finally {
			sqlSession.close();
		}
		return stumap;
	}

	/**
	 * ��ѯ����ͨ��rowboundsʵ�ַ�ҳ
	 * 
	 * @param stu
	 * @return
	 */
	public List<Student> getAllStudentByRowbounds(RowBounds rowbounds) {

		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

		List<Student> stulist;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ�� �ڶ��������Ƿ�ҳ��ѯ������
			stulist = sqlSession.selectList("com.mybatis3.mappers.StudentMapper.findAllStudents", null, rowbounds);
		} finally {
			sqlSession.close();
		}
		return stulist;
	}

	/**
	 * ��selectMap������ѯ����ѧ��
	 * 
	 * @param stu
	 * @return
	 */
	public Map<Integer, Student> getAllStudentsBySelectMap() {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		Map<Integer, Student> stumap;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ��
			stumap = sqlSession.selectMap("com.mybatis3.mappers.StudentMapper.getAllStudents", "id");
		} finally {
			sqlSession.close();
		}
		return stumap;
	}

	/**
	 * ����id��ѯѧ���͵�ַ��Ϣ��
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudentAddressById(int id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		Student stu;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ��
			stu = sqlSession.selectOne("com.mybatis3.mappers.StudentMapper.getStudentAddressById", id);
		} finally {
			sqlSession.close();
		}
		return stu;
	}

	/**
	 * ����id��ѯ����map
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> getStuByIdMap(int id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HashMap<String, Object> map;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ��
			map = sqlSession.selectOne("com.mybatis3.mappers.StudentMapper.getStuByIdMap", id);
		} finally {
			sqlSession.close();
		}
		return map;
	}

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @param stu
	 * @return
	 */
	public List<Student> findAllStudentByPage(Map<String, Integer> m) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Student> stulist;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ��
			stulist = sqlSession.selectList("com.mybatis3.mappers.StudentMapper.getStuByPage", m);
		} finally {
			sqlSession.close();
		}
		return stulist;
	}

	/**
	 * ���
	 * 
	 * @param stu
	 * @return
	 */
	public int addStudent(Student stu) {// �����������Լ�д
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		int i = 0;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ��
			i = sqlSession.insert("com.mybatis3.mappers.StudentMapper.insertStudent", stu);
			// �����ύ
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * ����
	 * 
	 * @param stu
	 * @return
	 */
	public int updateStudent(Student stu) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		int i = 0;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ��
			i = sqlSession.update("com.mybatis3.mappers.StudentMapper.updateStuById", stu);
			// �����ύ
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * ɾ��
	 * 
	 * @param stu
	 * @return
	 */
	public int deleteStudent(int id) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		int i = 0;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ��
			i = sqlSession.delete("com.mybatis3.mappers.StudentMapper.deleteStuById", id);
			// �����ύ
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * ��ѯ����
	 * 
	 * @param stu
	 * @return
	 */
	public List<Student> findAllStudent() {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Student> stulist;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ��
			stulist = sqlSession.selectList("com.mybatis3.mappers.StudentMapper.findAllStudents");
		} finally {
			sqlSession.close();
		}
		return stulist;
	}

	/**
	 * ����id��ѯ
	 * 
	 * @param stu
	 * @return
	 */
	public Student findStudentById(int id) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		Student stu;
		try {
			// ������StudentMapper.xml�ļ��е������ռ�namespace+����sql��id��ʶ��
			stu = sqlSession.selectOne("com.mybatis3.mappers.StudentMapper.getStuById", id);
		} finally {
			sqlSession.close();
		}
		return stu;
	}
}
