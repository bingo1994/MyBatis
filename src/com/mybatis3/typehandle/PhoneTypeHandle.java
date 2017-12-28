package com.mybatis3.typehandle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.bean.PhoneNumber;
/**
 * 自定义类型处理器
 * @author Administrator
 *
 */
public class PhoneTypeHandle extends BaseTypeHandler<PhoneNumber> {

	/**
	 * 通过列名取数据库表中phone的值
	 */
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		//rs.getString("columnName")取数据库的值
		return new PhoneNumber(rs.getString(columnName));
	}

	/**
	 * 通过列的索引(从1开始)取数据表中phone的值
	 */
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return new PhoneNumber(rs.getString(columnIndex));
	}

	/**
	 * 通过存储过程来获取数据库phone的值
	 */
	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return new PhoneNumber(cs.getString(columnIndex));
	}

	/**
	 * 设置phone的值
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, PhoneNumber parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		ps.setString(i, parameter.getAsString());
		
		
	}

}
