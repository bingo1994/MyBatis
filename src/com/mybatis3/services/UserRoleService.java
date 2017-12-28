package com.mybatis3.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.UserTest;
import com.mybatis3.factory.util.MyBatisSqlSessionFactory;

public class UserRoleService {

	/**
	 * �����û���Ӧ�Ľ�ɫ
	 * @return
	 */
	public List<UserTest> getUserRole(){
		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();
		List<UserTest>ulist=sqlSession.selectList("com.mybatis3.mappers.UserRoleMapper.getUserRoles");
		sqlSession.close();
		return ulist;
	}
}
