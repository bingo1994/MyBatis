package com.mybatis3.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.TRole;
import com.mybatis3.factory.util.MyBatisSqlSessionFactory;

public class RoleUserService {

	/**
	 * ��ѯָ����ɫ��Ӧ���û���Ϣ
	 * @param rid
	 * @return
	 */
	public TRole getRoleUsers(int rid){
		SqlSession sqlSession=MyBatisSqlSessionFactory.openSession();
		TRole tr=sqlSession.selectOne("com.mybatis3.mappers.RoleUserMapper.getRoleUsers", rid);
		sqlSession.close();
		return tr;
	}
}
