package com.mybatis3.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.bean.Tutors;
import com.mybatis3.sqlproviders.TutuorsDynaSqlProvider;

public interface TutorsMapper {
	/**
	 * 通过id查询讲师信息
	 * @param tutorid
	 * @return
	 */
	@SelectProvider(type=TutuorsDynaSqlProvider.class,method="findtutorsByIdSql")
	public Tutors getTutorsById(int tutorid);
	
	
	/**
	 * 通过id查询讲师信息
	 * @param tutorid
	 * @return
	 */
	@SelectProvider(type=TutuorsDynaSqlProvider.class,method="findTutorsByIdSqlTest")
	public Tutors findTutorsByIdSqlTest( int id);
	
	
	/**
	 * 通过讲师的姓名和邮箱查询讲师信息
	 * @param map
	 * @return
	 */
	@SelectProvider(type=TutuorsDynaSqlProvider.class,method="getTutorsByParam")
	public Tutors getTutorsByNameEamil(Map<String,Object>map);
	
	/**
	 * 查询所有讲师对应的课程信息
	 * @ResultMap需要xml的配置
	 * @return
	 */
	@SelectProvider(type=TutuorsDynaSqlProvider.class,method="getTutorsCourse")
	@ResultMap("com.mybatis3.mappers.TuTorsCourseMapper.TutorsResult")
	public List<Tutors>getTutorsCourse();
	
	/**
	 * 添加讲师
	 * @param t
	 * @return
	 */
	@InsertProvider(type=TutuorsDynaSqlProvider.class,method="addTutors")
	@SelectKey(statement="select emp_seq.nextval from dual",keyProperty="tid",resultType=Integer.class,before=true)
	public int addTutors(Tutors t);
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	@UpdateProvider(type=TutuorsDynaSqlProvider.class,method="updateTutors")
	public int updateTutors(Tutors t);
	
	
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	@DeleteProvider(type=TutuorsDynaSqlProvider.class,method="deleteTutors")
	public int deleteTutors(Tutors t);
}
