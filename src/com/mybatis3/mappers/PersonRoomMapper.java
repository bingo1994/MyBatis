package com.mybatis3.mappers;

import java.util.List;

import com.bean.Person;

public interface PersonRoomMapper {

	/**
	 * ��ѯ������Աס�޵ĶԵķ���
	 * @return
	 */
	public List<Person> getPersonInRoom();
	
	/**
	 * ��ѯ������Աס�޵ĶԵķ���
	 * @return
	 */
	public List<Person>	getPersonRoomTest();
}
