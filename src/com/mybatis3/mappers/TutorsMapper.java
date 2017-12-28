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
	 * ͨ��id��ѯ��ʦ��Ϣ
	 * @param tutorid
	 * @return
	 */
	@SelectProvider(type=TutuorsDynaSqlProvider.class,method="findtutorsByIdSql")
	public Tutors getTutorsById(int tutorid);
	
	
	/**
	 * ͨ��id��ѯ��ʦ��Ϣ
	 * @param tutorid
	 * @return
	 */
	@SelectProvider(type=TutuorsDynaSqlProvider.class,method="findTutorsByIdSqlTest")
	public Tutors findTutorsByIdSqlTest( int id);
	
	
	/**
	 * ͨ����ʦ�������������ѯ��ʦ��Ϣ
	 * @param map
	 * @return
	 */
	@SelectProvider(type=TutuorsDynaSqlProvider.class,method="getTutorsByParam")
	public Tutors getTutorsByNameEamil(Map<String,Object>map);
	
	/**
	 * ��ѯ���н�ʦ��Ӧ�Ŀγ���Ϣ
	 * @ResultMap��Ҫxml������
	 * @return
	 */
	@SelectProvider(type=TutuorsDynaSqlProvider.class,method="getTutorsCourse")
	@ResultMap("com.mybatis3.mappers.TuTorsCourseMapper.TutorsResult")
	public List<Tutors>getTutorsCourse();
	
	/**
	 * ��ӽ�ʦ
	 * @param t
	 * @return
	 */
	@InsertProvider(type=TutuorsDynaSqlProvider.class,method="addTutors")
	@SelectKey(statement="select emp_seq.nextval from dual",keyProperty="tid",resultType=Integer.class,before=true)
	public int addTutors(Tutors t);
	
	/**
	 * �޸�
	 * @param t
	 * @return
	 */
	@UpdateProvider(type=TutuorsDynaSqlProvider.class,method="updateTutors")
	public int updateTutors(Tutors t);
	
	
	/**
	 * ɾ��
	 * @param t
	 * @return
	 */
	@DeleteProvider(type=TutuorsDynaSqlProvider.class,method="deleteTutors")
	public int deleteTutors(Tutors t);
}
