package com.mybatis.junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.TRole;
import com.bean.UserTest;
import com.mybatis3.services.RoleUserService;

import junit.framework.TestCase;

public class TestRoleUsers extends TestCase {

	RoleUserService ru;
	@Before
	protected void setUp() throws Exception {
		ru=new RoleUserService();
	}

	@After
	protected void tearDown() throws Exception {
		ru=null;
	}

	/**
	 * 测试指定角色对应的用户
	 */
	@Test
	public void testGetRoleUsers() {
		int rid=1;
		TRole t=ru.getRoleUsers(rid);
		assertNotNull(t);
		System.out.print(t.getRname());
		System.out.println(t.getRdesp());
		List<UserTest> ulist=t.getUsers();
		for(UserTest u:ulist){
			System.out.print(u.getUname()+" ");
			System.out.println(u.getUaddress());
		}
	}

}
