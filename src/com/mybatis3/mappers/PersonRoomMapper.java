package com.mybatis3.mappers;

import java.util.List;

import com.bean.Person;

public interface PersonRoomMapper {

	/**
	 * 查询所有人员住宿的对的房间
	 * @return
	 */
	public List<Person> getPersonInRoom();
	
	/**
	 * 查询所有人员住宿的对的房间
	 * @return
	 */
	public List<Person>	getPersonRoomTest();
}
