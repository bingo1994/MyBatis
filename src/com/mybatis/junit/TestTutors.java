package com.mybatis.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.Course;
import com.bean.Tutors;
import com.mybatis3.services.TutorsCourseService;

import junit.framework.TestCase;

public class TestTutors extends TestCase {

	TutorsCourseService t;

	@Before
	protected void setUp() throws Exception {
		t = new TutorsCourseService();
	}

	@After
	protected void tearDown() throws Exception {
		t = null;
	}

	/*
	 * //��һ��
	 * 
	 * @Test public void testGetTutuorsTalkCourse() { List<Tutors>
	 * tlist=t.getTutuorsTalkCourse(); assertNotNull(tlist);
	 * System.out.println(tlist.size()); for(Tutors ts:tlist){
	 * System.out.print(ts.getName()+" "); System.out.print(ts.getEmail()+" ");
	 * System.out.println(ts.getAddress()+" "); List<Course>
	 * clist=ts.getCourse(); for(Course c:clist){ System.out.print(c.getCname()+
	 * " "); System.out.print(c.getStart_date()+" ");
	 * System.out.println(c.getEnd_date()+" "); } System.out.println(
	 * "-----------------------------------------------------------------"); } }
	 */

	// �ڶ���
	@Test
	public void testGetTutuorsTeachCourse() {
		List<Tutors> tlist = t.getTutuorsTeachCourse();
		assertNotNull(tlist);
		System.out.println(tlist.size());
		for (Tutors ts : tlist) {
			System.out.print(ts.getName() + " ");
			System.out.print(ts.getEmail() + " ");
			System.out.println(ts.getAddress() + " ");
			// ѭ���γ�
			List<Course> clist = ts.getCourse();
			for (Course c : clist) {
				System.out.print(c.getCname() + " ");
				System.out.print(c.getStart_date() + " ");
				System.out.println(c.getEnd_date() + " ");
			}
			System.out.println("-----------------------------------------------------------------");
		}
	}

	/**
	 *���� ����if��ǩ�ж����������ѯ
	 */
	@Test
	public void testGetTutuorsByIf() {
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tid", 2);
		//map.put("coursename", "%m%");
		try {
			map.put("starttime", sm.parse("2007-8-1"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Course> clist = t.getCourseByIf(map);
		assertNotNull(clist);
		for (Course c : clist) {
			System.out.print(c.getCname()+" ");
			System.out.print(c.getStart_date()+" ");
			System.out.println(c.getEnd_date());
		}
	}

	
	/**
	 * ���� ����choose when otherwise��ѯ
	 */
	@Test
	public void testGetCourseByChoose() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("searchby", "Tutors");
		map.put("tcid", 1);
		List<Course> clist = t.getCourseByChoose(map);
		assertNotNull(clist);
		for (Course c : clist) {
			System.out.print(c.getCname()+" ");
			System.out.print(c.getStart_date()+" ");
			System.out.println(c.getEnd_date());
		}
	}

	
	/**
	 * ���Ը���where��ѯ
	 */
	@Test
	public void testGetCourseByWhere() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tutorsid", 2);
		//map.put("tcid", 1);
		List<Course> clist = t.getCourseByWhere(map);
		assertNotNull(clist);
		for (Course c : clist) {
			System.out.print(c.getCname()+" ");
			System.out.print(c.getStart_date()+" ");
			System.out.println(c.getEnd_date());
		}
	}
	
	
	/**
	 * ���Ը���foreach��ѯ
	 */
	@Test
	public void testGetCourseByForeach() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Integer> tidlist=new ArrayList<Integer>();
		tidlist.add(1);
		tidlist.add(2);
		map.put("tutorsid", tidlist);
		List<Course> clist = t.getCourseByForeach(map);
		assertNotNull(clist);
		for (Course c : clist) {
			System.out.print(c.getCname()+" ");
			System.out.print(c.getStart_date()+" ");
			System.out.println(c.getEnd_date());
		}
	}
}
