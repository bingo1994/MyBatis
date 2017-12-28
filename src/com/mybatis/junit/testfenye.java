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

}
