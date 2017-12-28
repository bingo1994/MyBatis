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
	 * ����֮����õķ���
	 */
	@Before
	protected void setUp() throws Exception {
		 ss=new StudentService();
	}

	
	/**
	 * ���Է�ҳ��ѯ�ķ���
	 */
	@Test
	public void testGetStuByPage() {
		//���弯��
		HashMap<String, Integer> map=new HashMap<String,Integer>();
		//��ǰҳ
		int curpage=2;
		//ÿҳ��ʾ����
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
	 * ���Բ�ѯ����ѧ���ķ���
	 */
	@Test
	public void testFindAllStudents() {
		List<Student> stulist=ss.findAllStudents();
		assertNotNull(stulist); 
	}
	
	/**
	 * ���� param1, param2, param3,...���β�ѯ����
	 */
	@Test
	public void testSelStu() {
		String name="����";
		Student stu=ss.selStu(name);
		assertNotNull(stu);
		System.out.println(stu.getEmail());
	}
	
	/**
	 * ���Ը���id��ѯѧ������map�ķ���
	 */
	/*@Test
	public void testgetStuByIdMap() {
		Map<String,Object> map=ss.getStuByIdMap(2);
		assertNotNull(map);

		for(Map.Entry<String, Object> v:map.entrySet()){
			System.out.println(v.getValue());//map ��key��ֵ�������ݿ�������
		}
		
	}*/
	/**
	 * ���Ը���id��ѯѧ���ķ���
	 */
	@Test
	public void testGetStuById() {
		Student stu=ss.getStuById(3);
		assertEquals("����", stu.getName());
	}

	/**
	 * �������ѧ�����ݵķ���
	 */
	@Test
	public void testInsertStudent() {
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		Student stu=new Student();
		stu.setName("����");
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
		assertEquals("����", st.getName());
	}

	/**
	 * ���Ը���
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
		stu.setName("СС");
		stu.setPhone(p);
		int i=ss.updateStuById(stu);
		assertEquals(1, i);
	}
}
