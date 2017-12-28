package com.mybatis.junit;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import com.bean.PhoneNumber;
import com.bean.Student;
import com.mybatis3.services.StudentService;

import junit.framework.TestCase;

public class testss extends TestCase {
	StudentService ss;
	@Before
	protected void setUp() throws Exception {
		 ss=new StudentService();
	}

	@Test
	public void testUpdateStuById() {
		Student stu=new Student();
		PhoneNumber p=new PhoneNumber();
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		p.setCountryCode("86");
		p.setStateCode("0551");
		p.setNumber("88888888");
		stu.setId(1);
		stu.setEmail("xiaoxiao@qq.com");
		try {
			stu.setBirth(sm.parse("1999-9-9"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stu.setName("СС");
		stu.setPhone(p);
		int i=ss.updateStuById(stu);
		assertEquals(1, i);
	}

}
