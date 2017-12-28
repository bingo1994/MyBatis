package com.mybatis3.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Person;
import com.mybatis3.factory.util.MyBatisSqlSessionFactory;
import com.mybatis3.mappers.PersonRoomMapper;
import com.mybatis3.mappers.StudentMapper;

public class PersonRoomService {

	public List<Person> getPersonInRoom() {
		// 获取SqlSession对象

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		PersonRoomMapper personRoomMapper = sqlSession.getMapper(PersonRoomMapper.class);// 得到的.class是反射对象
		List<Person> perlist = personRoomMapper.getPersonInRoom();
		sqlSession.close();
		return perlist;
	}

	public List<Person> getPersonRoomTest() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		PersonRoomMapper personRoomMapper = sqlSession.getMapper(PersonRoomMapper.class);
		List<Person> perlist = personRoomMapper.getPersonRoomTest();
		sqlSession.close();
		return perlist;
	}
}
