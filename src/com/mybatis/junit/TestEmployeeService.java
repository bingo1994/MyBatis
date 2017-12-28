package com.mybatis.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.Dept;
import com.bean.Employee;
import com.mybatis3.services.EmployeeService;

import junit.framework.TestCase;

public class TestEmployeeService extends TestCase {

	EmployeeService e;

	@Before
	protected void setUp() throws Exception {
		e = new EmployeeService();
	}

	@After
	protected void tearDown() throws Exception {
		e = null;
	}

	/**
	 * 测试添加员工方法
	 */
	@Test
	public void testAddEmp() {
		Employee emp = new Employee();
		emp.setEmpname("李雪");
		emp.setEmpaddress("苏州");
		emp.setSalary(4353.50f);
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			emp.setBirth(sm.parse("1996-6-6"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i = e.addEmp(emp);
		assertEquals(1, i);
	}

	/**
	 * 测试修改员工方法
	 */
	@Test
	public void testUpdateEmp() {
		Employee emp = new Employee();
		emp.setEid(1);
		emp.setEmpname("李四");
		emp.setEmpaddress("上海");
		emp.setSalary(4353.50f);
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			emp.setBirth(sm.parse("1994-2-4"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i = e.updateEmp(emp);
		assertEquals(1, i);
	}

	/**
	 * 测试删除员工方法
	 */
	@Test
	public void testDeleteEmp() {
		int eid = 2;
		int i = e.deleteEmp(eid);
		assertEquals(1, i);
	}

	/**
	 * 测试根据id查询
	 */
	@Test
	public void testGetEmpById() {
		int eid = 3;
		Employee emp = e.getEmpById(eid);
		assertNotNull(emp);
		System.out.println(emp.getEmpname() + " " + emp.getEmpaddress() + " " + emp.getSalary() + " " + emp.getBirth());
	}

	/**
	 * 测试查询所有员工数据
	 */
	@Test
	public void testGetAllEmp() {
		List<Employee> emplist = e.getAllEmp();
		assertNotNull(emplist);
		for (Employee e : emplist) {
			System.out.print(e.getEmpname() + " ");
			System.out.println(e.getEmpaddress());
		}
	}

	/**
	 * 测试分页查询所有员工数据
	 */
	@Test
	public void testGetEmpByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		// 定义当前页和每页显示的条数
		int curpage = 1, pagesize = 2;
		map.put("start", (curpage - 1) * pagesize);
		map.put("end", curpage * pagesize);
		List<Employee> emplist = e.getEmpByPage(map);
		assertNotNull(emplist);
		for (Employee e : emplist) {
			System.out.print(e.getEmpname() + " ");
			System.out.println(e.getEmpaddress());
		}
	}

	/**
	 * 测试模糊分页查询所有员工数据
	 */
	@Test
	public void testGetEmpByLike() {
		Map<String, Object> map = new HashMap<String, Object>();
		// 定义当前页和每页显示的条数
		int curpage = 1, pagesize = 2;
		map.put("start", (curpage - 1) * pagesize);
		map.put("end", curpage * pagesize);
		map.put("empname", "%李%");
		List<Employee> emplist = e.getEmpByLike(map);
		assertNotNull(emplist);
		for (Employee e : emplist) {
			System.out.print(e.getEmpname() + " ");
			System.out.println(e.getEmpaddress());
		}
	}

	/**
	 * 测试员工表和地址表一对一映射关系操作
	 */
	@Test
	public void testGetEmpAddressById() {
		// 定义当前页和每页显示的条数
		int eid = 1;
		Employee emp = e.getEmpAddressById(eid);
		assertNotNull(emp);
		System.out.print(emp.getEmpname() + " ");
		System.out.print(emp.getAddress().getCountry() + " ");
		System.out.print(emp.getAddress().getCity() + " ");
		System.out.print(emp.getAddress().getState() + " ");
		System.out.print(emp.getAddress().getStreet() + " ");
		System.out.print(emp.getAddress().getZip() + " ");
	}

	/**
	 * 测试员工表和地址表一对一映射关系操作
	 */
	@Test
	public void testGetEmpAddressTest() {
		// 定义当前页和每页显示的条数
		int eid = 4;
		Employee emp = e.getEmpAddressById(eid);
		assertNotNull(emp);
		System.out.print(emp.getEmpname() + " ");
		System.out.print(emp.getAddress().getCountry() + " ");
		System.out.print(emp.getAddress().getCity() + " ");
		System.out.print(emp.getAddress().getState() + " ");
		System.out.print(emp.getAddress().getStreet() + " ");
		System.out.print(emp.getAddress().getZip() + " ");
	}
	
	
	/**
	 * 测试一对多映射
	 * 根据部门id查询部门信息,再找到对应下面的员工信息
	 */
	@Test
	public void testGetDeptById() {
		// 定义部门id
		int did =2;
		Dept dept =  e.getDeptById(did);
		assertNotNull(dept);
		System.out.println(dept.getDeptname() + " ");
		List<Employee> emplist =dept.getEmployee();
		for(Employee emp:emplist){
			System.out.print(emp.getEmpname() + " ");
			System.out.print(emp.getSalary() + " ");
			System.out.print(emp.getEmpaddress() + " ");
			System.out.println(emp.getBirth() + " ");
		}
		
	}
	
	
	
	/**
	 * 测试一对多映射
	 * 根据部门查询所有部门信息,再找到对应下面的员工信息
	 */
	@Test
	public void testGetAllDept() {
		List<Dept>  deptlist = e.getAllDept();
		assertNotNull(deptlist);
		for(Dept dept:deptlist){
			System.out.println(dept.getDeptname() + " ");
			List<Employee> emplist =dept.getEmployee();
			for(Employee emp:emplist){
				System.out.print(emp.getEmpname() + " ");
				System.out.print(emp.getSalary() + " ");
				System.out.print(emp.getEmpaddress() + " ");
				System.out.println(emp.getBirth() + " ");
			}
		}
	}
	
	
	/**
	 * 测试一对多映射，联表查询
	 * 根据部门id查询对应下面的员工信息
	 */
	@Test
	public void testGetDeptByResult() {
		// 定义部门id
		int did =2;
		Dept dept =  e.getDeptByResult(did);
		assertNotNull(dept);
		System.out.println(dept.getDeptname() + " ");
		List<Employee> emplist =dept.getEmployee();
		for(Employee emp:emplist){
			System.out.print(emp.getEmpname() + " ");
			System.out.print(emp.getSalary() + " ");
			System.out.print(emp.getEmpaddress() + " ");
			System.out.println(emp.getBirth() + " ");
		}
		
	}
	
}
