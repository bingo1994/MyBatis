package com.mybatis.junit;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bean.Student;
import com.mybatis3.services.StudentService;

import junit.framework.TestCase;

public class testfenye extends TestCase {
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

}
