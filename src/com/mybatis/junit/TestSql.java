package com.mybatis.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.session.RowBounds;
import org.junit.Before;
import org.junit.Test;

import com.bean.PhoneNumber;
import com.bean.Student;
import com.mybatis3.services.StudentSqlSessionService;

import junit.framework.TestCase;

public class TestSql extends TestCase {

	StudentSqlSessionService ss;

	/**
	 * 测试之前调用的方法，可以调用多次
	 */
	@Before
	protected void setUp() throws Exception {
		ss = new StudentSqlSessionService();
	}
	
	
	/**
	 * 自定义封装操作
	 * 测试查询所有通过ResultHandler(接口)实现自定义的封装数据操作
	 * 把学生的id作为key   学生的姓名作为value值
	 */
	@Test
	public void testGetAllStudentByIdName() {
		//泛型必须指定封装类型
		Map<Integer,String> stumap = ss.getAllStudentByIdName();
		assertNotNull(stumap);
		for(Entry<Integer, String> s:stumap.entrySet()){
			System.out.println("key:"+s.getKey()+",value:"+s.getValue());
		}
	}
	
	/**
	 * 测试查询所有通过rowbounds实现分页
	 */
	@Test
	public void testGetAllStudentByRowbounds() {
		//定义offset表示开始位置,从第0条数据之后取数据，limit限制取出的数据的条数
		int offset=2,limit=2;
		RowBounds rowbounds=new RowBounds(offset,limit);
		List<Student> stulist = ss.getAllStudentByRowbounds(rowbounds);
		assertNotNull(stulist);
		for(Student s:stulist){
			System.out.print(s.getName()+" ");
			System.out.print(s.getEmail()+" ");
			System.out.println(s.getBirth()+" ");
		}
	}

	
	
	/**
	 * 测试用selectMap方法查询所有学生
	 */
	@Test
	public void testGetAllStudentsBySelectMap() {
		Map<Integer,Student> stumap=ss.getAllStudentsBySelectMap();
		assertNotNull(stumap);
		//遍历Map
		for(Entry<Integer, Student> stu:stumap.entrySet()){
			System.out.println(stu.getKey());
			Student s=stu.getValue();
			System.out.print(s.getName()+" ");
			System.out.print(s.getEmail()+" ");
			if(s.getPhone()!=null){
				System.out.print(s.getPhone().getAsString()+" ");
			}
			System.out.println(s.getBirth());
		}
		
	}
	
	/**
	 * 测试根据id查询地址和学生信息
	 */
	@Test
	public void testgetStudentAddressById() {
		int id = 13;
		Student stu = ss.findStudentById(id);
		// assertNotNull(stu);
		assertNotNull(stu);
		System.out.println(stu.getAddress().getCity());
	}
	/**
	 * 测试添加
	 */
	@Test
	public void testAddStudent() {
		Student s = new Student();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		s.setName("倾世花");
		try {
			s.setBirth(sm.parse("2017-3-9"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.setEmail("qingshihua@qq.com");
		PhoneNumber p = new PhoneNumber();
		p.setCountryCode("86");
		p.setStateCode("3434");
		p.setNumber("12234300");
		s.setPhone(p);
		int i = ss.addStudent(s);
		assertEquals(1, i);
	}

	/**
	 * 测试修改
	 */
	@Test
	public void testupdateStudent() {
		Student s = new Student();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		s.setName("秦始皇");
		s.setId(13);
		try {
			s.setBirth(sm.parse("1999-9-9"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.setEmail("qinshihuang@qq.com");
		PhoneNumber p = new PhoneNumber();
		p.setCountryCode("86");
		p.setStateCode("2222");
		p.setNumber("11223344");
		s.setPhone(p);
		int i = ss.updateStudent(s);
		assertEquals(1, i);
	}

	/**
	 * 测试删除
	 */
	@Test
	public void testdeleteStudent() {
		int id = 2;
		int i = ss.deleteStudent(id);
		assertEquals(1, i);
	}

	/**
	 * 测试根据id查询
	 */
	@Test
	public void testfindStudentById() {
		int id = 6;
		Student stu = ss.findStudentById(id);
		// assertNotNull(stu);
		assertEquals("李三", stu.getName());
	}

	
	/**
	 * 测试根据id查询返回map
	 */
	@Test
	public void testgetStuByIdMap() {
		int id = 6;
	Map<String,Object> stu = ss.getStuByIdMap(id);
		// assertNotNull(stu);
		assertEquals("李三", stu.get("NAME"));//字段名全部要大写
	}
	/**
	 * 测试查询所有
	 */
	@Test
	public void testfindAllStudent() {
		List<Student> stulist = ss.findAllStudent();
		assertNotNull(stulist);
	}

	/**
	 * 测试分页查询所有
	 */
	@Test
	public void testfindAllStudentByPage() {
		Map<String, Integer> m = new HashMap<String, Integer>();
		int curpage = 1;
		int pagesize = 3;
		m.put("start", (curpage - 1) * pagesize);
		m.put("end", curpage * pagesize);
		List<Student> stulist = ss.findAllStudentByPage(m);
		assertNotNull(stulist);
	}
}
