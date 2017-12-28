package com.mybatis3.sqlproviders;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.bean.Tutors;

public class TutuorsDynaSqlProvider {

	/**
	 * 通过id查询讲师信息
	 * @param tutorid
	 * @return
	 */
	public String findtutorsByIdSql( int tutorid){
		return "select * from tutors where tid="+tutorid+"";
	}
	/**
	 * 通过id查询讲师信息,写法不同
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
	 * 用map传递多个参数
	 * 通过讲师的姓名和邮箱查询讲师信息
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
	 * 查询所有讲师对应的课程信息
	 * @return
	 */
	public String getTutorsCourse(){
		return new SQL(){
			{
				//内连接
				/*SELECT("*");
				FROM("tutors t,course c");
				WHERE("t.tid=c.tcid");*/
				
				//内连接
				/*SELECT("*");
				FROM("tutors t");
				INNER_JOIN("course c on t.tid=c.tcid");*/
				
				//左连接
				/*SELECT("*");
				FROM("tutors t");
				LEFT_OUTER_JOIN("course c on t.tid=c.tcid");*/
				
				//右链接
				//左连接
				SELECT("*");
				FROM("tutors t");
				RIGHT_OUTER_JOIN("course c on t.tid=c.tcid");
			}
		}.toString();
	}
	
	/**
	 * 动态拼接SQL语句，添加讲师
	 * #{email} 是OGNL表达式
	 * @param t
	 * @return
	 */
	public String addTutors(final Tutors t){//1.8版本之前要用常量
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
	 * 修改讲师信息
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
	 * 删除讲师
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
