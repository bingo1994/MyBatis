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
	 * ����֮ǰ���õķ��������Ե��ö��
	 */
	@Before
	protected void setUp() throws Exception {
		ss = new StudentSqlSessionService();
	}
	
	
	/**
	 * �Զ����װ����
	 * ���Բ�ѯ����ͨ��ResultHandler(�ӿ�)ʵ���Զ���ķ�װ���ݲ���
	 * ��ѧ����id��Ϊkey   ѧ����������Ϊvalueֵ
	 */
	@Test
	public void testGetAllStudentByIdName() {
		//���ͱ���ָ����װ����
		Map<Integer,String> stumap = ss.getAllStudentByIdName();
		assertNotNull(stumap);
		for(Entry<Integer, String> s:stumap.entrySet()){
			System.out.println("key:"+s.getKey()+",value:"+s.getValue());
		}
	}
	
	/**
	 * ���Բ�ѯ����ͨ��rowboundsʵ�ַ�ҳ
	 */
	@Test
	public void testGetAllStudentByRowbounds() {
		//����offset��ʾ��ʼλ��,�ӵ�0������֮��ȡ���ݣ�limit����ȡ�������ݵ�����
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
	 * ������selectMap������ѯ����ѧ��
	 */
	@Test
	public void testGetAllStudentsBySelectMap() {
		Map<Integer,Student> stumap=ss.getAllStudentsBySelectMap();
		assertNotNull(stumap);
		//����Map
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
	 * ���Ը���id��ѯ��ַ��ѧ����Ϣ
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
	 * �������
	 */
	@Test
	public void testAddStudent() {
		Student s = new Student();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		s.setName("������");
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
	 * �����޸�
	 */
	@Test
	public void testupdateStudent() {
		Student s = new Student();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		s.setName("��ʼ��");
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
	 * ����ɾ��
	 */
	@Test
	public void testdeleteStudent() {
		int id = 2;
		int i = ss.deleteStudent(id);
		assertEquals(1, i);
	}

	/**
	 * ���Ը���id��ѯ
	 */
	@Test
	public void testfindStudentById() {
		int id = 6;
		Student stu = ss.findStudentById(id);
		// assertNotNull(stu);
		assertEquals("����", stu.getName());
	}

	
	/**
	 * ���Ը���id��ѯ����map
	 */
	@Test
	public void testgetStuByIdMap() {
		int id = 6;
	Map<String,Object> stu = ss.getStuByIdMap(id);
		// assertNotNull(stu);
		assertEquals("����", stu.get("NAME"));//�ֶ���ȫ��Ҫ��д
	}
	/**
	 * ���Բ�ѯ����
	 */
	@Test
	public void testfindAllStudent() {
		List<Student> stulist = ss.findAllStudent();
		assertNotNull(stulist);
	}

	/**
	 * ���Է�ҳ��ѯ����
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
