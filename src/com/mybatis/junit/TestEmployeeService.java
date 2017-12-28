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
	 * �������Ա������
	 */
	@Test
	public void testAddEmp() {
		Employee emp = new Employee();
		emp.setEmpname("��ѩ");
		emp.setEmpaddress("����");
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
	 * �����޸�Ա������
	 */
	@Test
	public void testUpdateEmp() {
		Employee emp = new Employee();
		emp.setEid(1);
		emp.setEmpname("����");
		emp.setEmpaddress("�Ϻ�");
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
	 * ����ɾ��Ա������
	 */
	@Test
	public void testDeleteEmp() {
		int eid = 2;
		int i = e.deleteEmp(eid);
		assertEquals(1, i);
	}

	/**
	 * ���Ը���id��ѯ
	 */
	@Test
	public void testGetEmpById() {
		int eid = 3;
		Employee emp = e.getEmpById(eid);
		assertNotNull(emp);
		System.out.println(emp.getEmpname() + " " + emp.getEmpaddress() + " " + emp.getSalary() + " " + emp.getBirth());
	}

	/**
	 * ���Բ�ѯ����Ա������
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
	 * ���Է�ҳ��ѯ����Ա������
	 */
	@Test
	public void testGetEmpByPage() {
		Map<String, Object> map = new HashMap<String, Object>();
		// ���嵱ǰҳ��ÿҳ��ʾ������
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
	 * ����ģ����ҳ��ѯ����Ա������
	 */
	@Test
	public void testGetEmpByLike() {
		Map<String, Object> map = new HashMap<String, Object>();
		// ���嵱ǰҳ��ÿҳ��ʾ������
		int curpage = 1, pagesize = 2;
		map.put("start", (curpage - 1) * pagesize);
		map.put("end", curpage * pagesize);
		map.put("empname", "%��%");
		List<Employee> emplist = e.getEmpByLike(map);
		assertNotNull(emplist);
		for (Employee e : emplist) {
			System.out.print(e.getEmpname() + " ");
			System.out.println(e.getEmpaddress());
		}
	}

	/**
	 * ����Ա����͵�ַ��һ��һӳ���ϵ����
	 */
	@Test
	public void testGetEmpAddressById() {
		// ���嵱ǰҳ��ÿҳ��ʾ������
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
	 * ����Ա����͵�ַ��һ��һӳ���ϵ����
	 */
	@Test
	public void testGetEmpAddressTest() {
		// ���嵱ǰҳ��ÿҳ��ʾ������
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
	 * ����һ�Զ�ӳ��
	 * ���ݲ���id��ѯ������Ϣ,���ҵ���Ӧ�����Ա����Ϣ
	 */
	@Test
	public void testGetDeptById() {
		// ���岿��id
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
	 * ����һ�Զ�ӳ��
	 * ���ݲ��Ų�ѯ���в�����Ϣ,���ҵ���Ӧ�����Ա����Ϣ
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
	 * ����һ�Զ�ӳ�䣬�����ѯ
	 * ���ݲ���id��ѯ��Ӧ�����Ա����Ϣ
	 */
	@Test
	public void testGetDeptByResult() {
		// ���岿��id
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
