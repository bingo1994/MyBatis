package com.mybatis3.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bean.Address;
import com.bean.Dept;
import com.bean.Employee;
import com.mybatis3.factory.util.MyBatisSqlSessionFactory;
import com.mybatis3.mappers.EmployeeMapper;

public class EmployeeService {

	/**
	 * ���Ա��
	 * 
	 * @param emp
	 * @return
	 */
	public int addEmp(Employee emp) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		int i = 0;
		try {
			i = employeeMaper.addEmp(emp);
			// �����ύ
			sqlSession.commit();
		} catch (Exception e) {
			// ����ع�
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * ����Ա��
	 * 
	 * @param emp
	 * @return
	 */
	public int updateEmp(Employee emp) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		int i = 0;
		try {
			i = employeeMaper.updateEmp(emp);
			// �����ύ
			sqlSession.commit();
		} catch (Exception e) {
			// ����ع�
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * ɾ��Ա������
	 * 
	 * @param eid
	 * @return
	 */
	public int deleteEmp(int eid) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		int i = 0;
		try {
			i = employeeMaper.deleteEmp(eid);
			// �����ύ
			sqlSession.commit();
		} catch (Exception e) {
			// ����ع�
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * ����id��ѯ
	 * 
	 * @param id
	 * @return
	 */
	public Employee getEmpById(int id) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		Employee emp = null;
		try {
			emp = employeeMaper.getEmpById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return emp;
	}

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<Employee> getAllEmp() {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> emplist = null;
		try {
			emplist = employeeMaper.getAllEmp();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return emplist;
	}

	/**
	 * ��ҳ��ѯ��������
	 * 
	 * @param map
	 * @return
	 */
	public List<Employee> getEmpByPage(Map<String, Object> map) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> emplist = null;
		try {
			emplist = employeeMaper.getEmpByPage(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return emplist;
	}

	/**
	 * ģ����ҳ��ѯ��������
	 * 
	 * @param map
	 * @return
	 */
	public List<Employee> getEmpByLike(Map<String, Object> map) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> emplist = null;
		try {
			emplist = employeeMaper.getEmpByLike(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return emplist;
	}

	/**
	 * ����id��ѯ��ַ��Ϣ һ��һӳ��
	 * 
	 * @param addid
	 * @return
	 */
	public Address getAddressById(int addid) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		Address address = null;
		try {
			address = employeeMaper.getAddressById(addid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return address;
	}

	/**
	 * Ա�����ַ��һ��һӳ�䣬����SQL
	 * 
	 * @param eid
	 * @return
	 */
	public Employee getEmpAddressById(int eid) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		Employee employee = null;
		try {
			employee = employeeMaper.getEmpAddressById(eid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return employee;
	}

	/**
	 * Ա�����ַ��һ��һӳ�䣬һ��SQL
	 * 
	 * @param eid
	 * @return
	 */
	public Employee getEmpAddressTest(int eid) {
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		Employee employee = null;
		try {
			employee = employeeMaper.getEmpAddressById(eid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return employee;
	}
	
	/**
	 * һ�Զ�ӳ��
	 * ���ݲ���id��ѯ������Ϣ,���ҵ���Ӧ�����Ա����Ϣ
	 * @param id
	 * @return
	 */
	public Dept getDeptById(int did){
		// ��ȡSqlSession����
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		Dept dept = null;
		try {
				dept = employeeMaper.getDeptById(did);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			return dept;
	}
	
	/**
	 * һ�Զ�ӳ��
	 * ���ݲ��Ų�ѯ���в�����Ϣ,���ҵ���Ӧ�����Ա����Ϣ
	 * @param id
	 * @return
	 */
	public List<Dept> getAllDept(){
		// ��ȡSqlSession����
				SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
				EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
				List<Dept>  deptlist = null;
				try {
					deptlist = employeeMaper.getAllDept();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						sqlSession.close();
					}
					return deptlist;
	}
	
	/**
	 * һ�Զ�ӳ�䣬�����ѯ
	 * ���ݲ���id��ѯ��Ӧ�����Ա����Ϣ
	 * @param did
	 * @return
	 */
	public Dept getDeptByResult(int did){
		// ��ȡSqlSession����
				SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
				EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
				Dept dept = null;
				try {
						dept = employeeMaper.getDeptByResult(did);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						sqlSession.close();
					}
					return dept;
	}
}
