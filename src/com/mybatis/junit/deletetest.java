package com.mybatis.junit;

import org.junit.Before;
import org.junit.Test;

import com.mybatis3.services.StudentService;

import junit.framework.TestCase;

public class deletetest extends TestCase {
	StudentService ss;
	/**
	 * 测试之间调用的方法
	 */
	@Before
	protected void setUp() throws Exception {
		 ss=new StudentService();
	}

	@Test
	public void testDeleteStuById() {
		int id=14;
		int i=ss.deleteStuById(id);
		assertEquals(1, i);
	}

}
