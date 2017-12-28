package com.mybatis3.sqlproviders;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.bean.Tutors;

public class TutuorsDynaSqlProvider {

	/**
	 * ͨ��id��ѯ��ʦ��Ϣ
	 * @param tutorid
	 * @return
	 */
	public String findtutorsByIdSql( int tutorid){
		return "select * from tutors where tid="+tutorid+"";
	}
	/**
	 * ͨ��id��ѯ��ʦ��Ϣ,д����ͬ
	 * @param tutorid
	 * @return
	 */
	public String findTutorsByIdSqlTest(final int id){
		return new SQL(){
			{
				SELECT("tid,name,email,address");
				FROM("tutors");
				WHERE("tid="+id);
				//GROUP_BY("");
				//HAVING("");
				//ORDER_BY("");
			}
		}.toString();
	}
	
	/**
	 * ��map���ݶ������
	 * ͨ����ʦ�������������ѯ��ʦ��Ϣ
	 * @param map
	 * @return
	 */
	public String getTutorsByParam(Map<String,Object>map){
		/*String name=(String)map.get("name");
		String email=(String)map.get("email");*/
		
		/*String name=(String)map.get("param1");
		String email=(String)map.get("param2");*/
		
		String name=(String)map.get("0");
		String email=(String)map.get("1");
		return new SQL(){
			{
				SELECT("tid,name,email,address");
				FROM("tutors");
				WHERE("name=#{name} and email=#{email}");
			}
		}.toString();
	}
	
	/**
	 * ��ѯ���н�ʦ��Ӧ�Ŀγ���Ϣ
	 * @return
	 */
	public String getTutorsCourse(){
		return new SQL(){
			{
				//������
				/*SELECT("*");
				FROM("tutors t,course c");
				WHERE("t.tid=c.tcid");*/
				
				//������
				/*SELECT("*");
				FROM("tutors t");
				INNER_JOIN("course c on t.tid=c.tcid");*/
				
				//������
				/*SELECT("*");
				FROM("tutors t");
				LEFT_OUTER_JOIN("course c on t.tid=c.tcid");*/
				
				//������
				//������
				SELECT("*");
				FROM("tutors t");
				RIGHT_OUTER_JOIN("course c on t.tid=c.tcid");
			}
		}.toString();
	}
	
	/**
	 * ��̬ƴ��SQL��䣬��ӽ�ʦ
	 * #{email} ��OGNL���ʽ
	 * @param t
	 * @return
	 */
	public String addTutors(final Tutors t){//1.8�汾֮ǰҪ�ó���
		return new SQL(){
			{
				INSERT_INTO("tutors");
				VALUES("tid", "#{tid}");
				if(t.getName()!=null){
					VALUES("name", "#{name}");
				}
				if(t.getAddress()!=null){
					VALUES("address", "#{address}");
				}
				if(t.getEmail()!=null){
					VALUES("email", "#{email}");
				}
			}
		}.toString();
	}
	
	/**
	 * �޸Ľ�ʦ��Ϣ
	 * @param t
	 * @return
	 */
	public String updateTutors(final Tutors t){
		return new SQL(){
			{
				UPDATE("tutors");
				if(t.getName()!=null){
					SET("name=#{name}");
				}
				if(t.getAddress()!=null){
					SET("address=#{address}");
				}
				if(t.getEmail()!=null){
					SET("email=#{email}");
				}
				WHERE("tid=#{tid}");
			}
		}.toString();
	}
	
	/**
	 * ɾ����ʦ
	 * @param tid
	 * @return
	 */
	public String deleteTutors(final Tutors t){
		return new SQL(){
			{
				DELETE_FROM("tutors");
				if(t.getAddress()!=null){
					WHERE("address=#{address}");
				}
				if(t.getName()!=null){
					WHERE("name=#{name}");
				}
			}
		}.toString();
	}
}
