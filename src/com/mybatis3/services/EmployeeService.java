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
	 * 添加员工
	 * 
	 * @param emp
	 * @return
	 */
	public int addEmp(Employee emp) {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		int i = 0;
		try {
			i = employeeMaper.addEmp(emp);
			// 事务提交
			sqlSession.commit();
		} catch (Exception e) {
			// 事务回滚
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * 更新员工
	 * 
	 * @param emp
	 * @return
	 */
	public int updateEmp(Employee emp) {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		int i = 0;
		try {
			i = employeeMaper.updateEmp(emp);
			// 事务提交
			sqlSession.commit();
		} catch (Exception e) {
			// 事务回滚
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * 删除员工数据
	 * 
	 * @param eid
	 * @return
	 */
	public int deleteEmp(int eid) {
		// 获取SqlSession对象
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		EmployeeMapper employeeMaper = sqlSession.getMapper(EmployeeMapper.class);
		int i = 0;
		try {
			i = employeeMaper.deleteEmp(eid);
			// 事务提交
			sqlSession.commit();
		} catch (Exception e) {
			// 事务回滚
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return i;
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Employee getEmpById(int id) {
		// 获取SqlSession对象
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
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Employee> getAllEmp() {
		// 获取SqlSession对象
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
	 * 分页查询所有数据
	 * 
	 * @param map
	 * @return
	 */
	public List<Employee> getEmpByPage(Map<String, Object> map) {
		// 获取SqlSession对象
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
	 * 模糊分页查询所有数据
	 * 
	 * @param map
	 * @return
	 */
	public List<Employee> getEmpByLike(Map<String, Object> map) {
		// 获取SqlSession对象
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
	 * 根据id查询地址信息 一对一映射
	 * 
	 * @param addid
	 * @return
	 */
	public Address getAddressById(int addid) {
		// 获取SqlSession对象
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
	 * 员工与地址表一对一映射，两条SQL
	 * 
	 * @param eid
	 * @return
	 */
	public Employee getEmpAddressById(int eid) {
		// 获取SqlSession对象
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
	 * 员工与地址表一对一映射，一条SQL
	 * 
	 * @param eid
	 * @return
	 */
	public Employee getEmpAddressTest(int eid) {
		// 获取SqlSession对象
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
	 * 一对多映射
	 * 根据部门id查询部门信息,再找到对应下面的员工信息
	 * @param id
	 * @return
	 */
	public Dept getDeptById(int did){
		// 获取SqlSession对象
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
	 * 一对多映射
	 * 根据部门查询所有部门信息,再找到对应下面的员工信息
	 * @param id
	 * @return
	 */
	public List<Dept> getAllDept(){
		// 获取SqlSession对象
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
	 * 一对多映射，联表查询
	 * 根据部门id查询对应下面的员工信息
	 * @param did
	 * @return
	 */
	public Dept getDeptByResult(int did){
		// 获取SqlSession对象
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
