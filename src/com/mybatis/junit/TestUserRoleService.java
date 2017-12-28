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
	 * ���Բ�ѯ�����û���Ӧ�Ľ�ɫ
	 */
	@Test
	public void testGetUserRole() {
		List<UserTest>ulist=ur.getUserRole();
		assertNotNull(ulist);
		for(UserTest u:ulist){//��ȡ�û���Ϣ
			System.out.print(u.getUname()+" ");
			System.out.println(u.getUaddress()+" ");
			List<TRole> rlist=u.getRoles();
			for(TRole r:rlist){//��ȡ�û���ӵ�еĽ�ɫ
				System.out.print(r.getRname()+" ");
				System.out.println(r.getRdesp());
			}
			System.out.println("------------------------------------------");
		}
	}

}
