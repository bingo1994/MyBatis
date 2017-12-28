package com.mybatis.junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bean.TRole;
import com.bean.UserTest;
import com.mybatis3.services.UserRoleService;

import junit.framework.TestCase;

public class TestUserRoleService extends TestCase {

	UserRoleService ur;
	@Before
	protected void setUp() throws Exception {
		ur=new UserRoleService();
	}

	@After
	protected void tearDown() throws Exception {
		ur=null;
	}

	/**
	 * 测试查询所有用户对应的角色
	 */
	@Test
	public void testGetUserRole() {
		List<UserTest>ulist=ur.getUserRole();
		assertNotNull(ulist);
		for(UserTest u:ulist){//获取用户信息
			System.out.print(u.getUname()+" ");
			System.out.println(u.getUaddress()+" ");
			List<TRole> rlist=u.getRoles();
			for(TRole r:rlist){//获取用户所拥有的角色
				System.out.print(r.getRname()+" ");
				System.out.println(r.getRdesp());
			}
			System.out.println("------------------------------------------");
		}
	}

}
