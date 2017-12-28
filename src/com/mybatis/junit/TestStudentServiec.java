package com.mybatis.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.bean.PhoneNumber;
import com.bean.Student;
import com.mybatis3.services.StudentService;

import junit.framework.TestCase;
public class TestStudentServiec extends TestCase {

	
	
	StudentService ss;
	/**
	 * 测试之间调用的方法
	 */
	@Before
	protected void setUp() throws Exception {
		 ss=new StudentService();
	}

	
	/**
	 * 测试分页查询的方法
	 */
	@Test
	public void testGetStuByPage() {
		//定义集合
		HashMap<String, Integer> map=new HashMap<String,Integer>();
		//当前页
		int curpage=2;
		//每页显示条数
		int pagesize=3;
		map.put("start", (curpage-1)*pagesize);
		map.put("end", curpage*pagesize);
		List<Student> stulist=ss.getStuByPage(map);
		assertNotNull(stulist);
		/*for(Student s:stulist){
			System.out.println(s.getId());
			if(s.getPhone()!=null){
				System.out.println(s.getPhone().getAsString());
			}
		}*/
	}
	
	/**
	 * 测试查询所有学生的方法
	 */
	@Test
	public void testFindAllStudents() {
		List<Student> stulist=ss.findAllStudents();
		assertNotNull(stulist); 
	}
	
	/**
	 * 测试 param1, param2, param3,...传参查询数据
	 */
	@Test
	public void testSelStu() {
		String name="赵六";
		Student stu=ss.selStu(name);
		assertNotNull(stu);
		System.out.println(stu.getEmail());
	}
	
	/**
	 * 测试根据id查询学生返回map的方法
	 */
	/*@Test
	public void testgetStuByIdMap() {
		Map<String,Object> map=ss.getStuByIdMap(2);
		assertNotNull(map);

		for(Map.Entry<String, Object> v:map.entrySet()){
			System.out.println(v.getValue());//map 中key的值就是数据库表的列名
		}
		
	}*/
	/**
	 * 测试根据id查询学生的方法
	 */
	@Test
	public void testGetStuById() {
		Student stu=ss.getStuById(3);
		assertEquals("赵六", stu.getName());
	}

	/**
	 * 测试添加学生数据的方法
	 */
	@Test
	public void testInsertStudent() {
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		Student stu=new Student();
		stu.setName("李三");
		stu.setEmail("lisan@qq.com");
		try {
			stu.setBirth(sm.parse("1990-3-3"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		PhoneNumber phone=new PhoneNumber();
		phone.setCountryCode("86");
		phone.setStateCode("0551");
		phone.setNumber("65454543");
		stu.setPhone(phone);
		ss.insertStudent(stu);
		Student st=ss.getStuById(6);
		assertEquals("李三", st.getName());
	}

	/**
	 * 测试更新
	 */
	@Test
	public void updateStuById(){
		Student stu=new Student();
		PhoneNumber p=new PhoneNumber();
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		p.setCountryCode("86");
		p.setStateCode("0551");
		p.setNumber("12324343");
		stu.setId(1);
		stu.setEmail("xiaoxiao@qq.com");
		try {
			stu.setBirth(sm.parse("9999-3-3"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stu.setName("小小");
		stu.setPhone(p);
		int i=ss.updateStuById(stu);
		assertEquals(1, i);
	}
}
