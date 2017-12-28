package com.mybatis.junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.Person;
import com.mybatis3.services.PersonRoomService;

import junit.framework.TestCase;

public class TestPerson extends TestCase {
 
	PersonRoomService p;
	/**
	 * ���Է���ִ��֮ǰ���ã��ɶ�ε���
	 */
	@Before
	protected void setUp() throws Exception {
		p=new PersonRoomService();
	}
	/**
	 * ���Է���ִ�����֮����ã��ɶ�ε���
	 */
	@After
	public void tearDown()throws Exception{
		p=null;
	}
	@Test
	public void testGetPersonInRoom() {
		List<Person> plist=p.getPersonInRoom();
		assertNotNull(plist);
		for(Person per:plist){
			System.out.print(per.getPid()+" ");
			System.out.print(per.getName()+" ");
			System.out.print(per.getAge()+" ");
			System.out.print(per.getAddress()+" ");
			System.out.print(per.getRoom().getRoomnum()+" ");
			System.out.println(per.getRoom().getRoomtype()+" ");
		}
	}

	@Test
	public void testGetPersonRoomTest() {
		List<Person> plist=p.getPersonRoomTest();
		assertNotNull(plist);
		for(Person per:plist){
			System.out.print(per.getPid()+" ");
			System.out.print(per.getName()+" ");
			System.out.print(per.getAge()+" ");
			System.out.print(per.getAddress()+" ");
			System.out.print(per.getRoom().getRoomnum()+" ");
			System.out.println(per.getRoom().getRoomtype()+" ");
		}
	}
}
