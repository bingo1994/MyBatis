package com.mybatis.junit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.Course;
import com.bean.Tutors;
import com.mybatis3.services.TutorsService;

import junit.framework.TestCase;

public class TestTutorsProvider extends TestCase {
	TutorsService t;
	@Before
	protected void setUp() throws Exception {
		t=new TutorsService();
	}

	@After
	protected void tearDown() throws Exception {
		t=null;
	}

	/**
	 * ���Ը���id��ѯ��ʦ��Ϣ�ķ���
	 */
	@Test
	public void testGetTutorsById() {
		int tutorid=1;
		Tutors tutor=t.getTutorsById(tutorid);
		assertNotNull(tutor);
		System.out.println(tutor.getName()+" "+tutor.getEmail()+tutor.getAddress());
	}

	
	/**
	 * ���Ը���id��ѯ��ʦ��Ϣ�ķ���
	 */
	@Test
	public void testFindTutorsByIdSqlTest() {
		int tutorid=2;
		Tutors tutor=t.getTutorsById(tutorid);
		assertNotNull(tutor);
		System.out.println(tutor.getName()+" "+tutor.getEmail()+tutor.getAddress());
	}
	
	
	/**
	 * ����ͨ����ʦ�������������ѯ��ʦ��Ϣ
	 */
	@Test
	public void testGetTutorsByNameEamil() {
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("name", "tom");
		map.put("email", "tom@qq.com");
		Tutors tutor=t.getTutorsByNameEamil(map);
		assertNotNull(tutor);
		System.out.println(tutor.getName()+" "+tutor.getEmail()+" "+tutor.getAddress());
	}
	
	
	

	/**
	 * ���Բ�ѯ���н�ʦ��Ӧ�Ŀγ���Ϣ
	 */
	@Test
	public void testGetTutorsCourse() {
		List<Tutors> tutorlist =t.getTutorsCourse();
		assertNotNull(tutorlist);
		for(Tutors t:tutorlist){
			System.out.println(t.getName()+" "+t.getEmail()+" "+t.getAddress());
			List<Course> clist=t.getCourse();
			for(Course c:clist){
				System.out.println(c.getCname()+" "+c.getDesp()+" "+c.getStart_date()+" "+c.getEnd_date());
			}
		}
	}
	
	
	/**
	 * ������ӽ�ʦ
	 */
	@Test
	public void testAddTutors() {
		Tutors tt=new Tutors();
		//tt.setTid(4);
		tt.setAddress("��ɽ");
		tt.setName("����");
		tt.setEmail("wang@qq.com");
		int i=t.addTutors(tt);
		assertEquals(1, i);
	}
	
	/**
	 * ������ӽ�ʦ
	 */
	@Test
	public void testUpdateTutors() {
		Tutors tt=new Tutors();
		tt.setTid(85);
		tt.setAddress("̩ɽ");
		int i=t.updateTutors(tt);
		assertEquals(1, i);
	}
	
	
	/**
	 * ����ɾ����ʦ
	 */
	@Test
	public void testDeleteTutors() {
		Tutors tt=new Tutors();
		tt.setName("����");
		tt.setAddress("��ɽ");
		int i=t.deleteTutors(tt);
		assertEquals(1, i);
	}
}
