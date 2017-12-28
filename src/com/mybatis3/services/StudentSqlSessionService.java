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
	 * 自定义封装操作 查询所有通过ResultHandler(接口)实现自定义的封装数据操作 把学生的id作为key 学生的姓名作为value值
	 * 
	 * @param stu
	 * @return
	 */
	public Map<Integer, String> getAllStudentByIdName() {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		// 匿名内部类用常量
		final Map<Integer, String> stumap = new HashMap<Integer, String>();
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名 第二个参数是分页查询的条件
			sqlSession.select("com.mybatis3.mappers.StudentMapper.findAllStudents", new ResultHandler() {
				// 通过匿名内部类实现ResultHandler接口
				@Override
				public void handleResult(ResultContext arg0) {// 学生数据都在ResultContext
					// TODO Auto-generated method stub
					// 将ResultContext对象转成Student的bean
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
	 * 查询所有通过rowbounds实现分页
	 * 
	 * @param stu
	 * @return
	 */
	public List<Student> getAllStudentByRowbounds(RowBounds rowbounds) {

		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

		List<Student> stulist;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名 第二个参数是分页查询的条件
			stulist = sqlSession.selectList("com.mybatis3.mappers.StudentMapper.findAllStudents", null, rowbounds);
		} finally {
			sqlSession.close();
		}
		return stulist;
	}

	/**
	 * 用selectMap方法查询所有学生
	 * 
	 * @param stu
	 * @return
	 */
	public Map<Integer, Student> getAllStudentsBySelectMap() {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		Map<Integer, Student> stumap;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名
			stumap = sqlSession.selectMap("com.mybatis3.mappers.StudentMapper.getAllStudents", "id");
		} finally {
			sqlSession.close();
		}
		return stumap;
	}

	/**
	 * 根据id查询学生和地址信息，
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudentAddressById(int id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		Student stu;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名
			stu = sqlSession.selectOne("com.mybatis3.mappers.StudentMapper.getStudentAddressById", id);
		} finally {
			sqlSession.close();
		}
		return stu;
	}

	/**
	 * 根据id查询返回map
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> getStuByIdMap(int id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		HashMap<String, Object> map;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名
			map = sqlSession.selectOne("com.mybatis3.mappers.StudentMapper.getStuByIdMap", id);
		} finally {
			sqlSession.close();
		}
		return map;
	}

	/**
	 * 分页查询所有
	 * 
	 * @param stu
	 * @return
	 */
	public List<Student> findAllStudentByPage(Map<String, Integer> m) {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Student> stulist;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名
			stulist = sqlSession.selectList("com.mybatis3.mappers.StudentMapper.getStuByPage", m);
		} finally {
			sqlSession.close();
		}
		return stulist;
	}

	/**
	 * 添加
	 * 
	 * @param stu
	 * @return
	 */
	public int addStudent(Student stu) {// 方法名可以自己写
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		int i = 0;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名
			i = sqlSession.insert("com.mybatis3.mappers.StudentMapper.insertStudent", stu);
			// 事务提交
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * 更新
	 * 
	 * @param stu
	 * @return
	 */
	public int updateStudent(Student stu) {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		int i = 0;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名
			i = sqlSession.update("com.mybatis3.mappers.StudentMapper.updateStuById", stu);
			// 事务提交
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * 删除
	 * 
	 * @param stu
	 * @return
	 */
	public int deleteStudent(int id) {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		int i = 0;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名
			i = sqlSession.delete("com.mybatis3.mappers.StudentMapper.deleteStuById", id);
			// 事务提交
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * 查询所有
	 * 
	 * @param stu
	 * @return
	 */
	public List<Student> findAllStudent() {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		List<Student> stulist;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名
			stulist = sqlSession.selectList("com.mybatis3.mappers.StudentMapper.findAllStudents");
		} finally {
			sqlSession.close();
		}
		return stulist;
	}

	/**
	 * 根据id查询
	 * 
	 * @param stu
	 * @return
	 */
	public Student findStudentById(int id) {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		Student stu;
		try {
			// 参数是StudentMapper.xml文件中的命名空间namespace+操作sql的id标识名
			stu = sqlSession.selectOne("com.mybatis3.mappers.StudentMapper.getStuById", id);
		} finally {
			sqlSession.close();
		}
		return stu;
	}
}
