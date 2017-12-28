package com.mybatis3.typehandle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.bean.PhoneNumber;
/**
 * �Զ������ʹ�����
 * @author Administrator
 *
 */
public class PhoneTypeHandle extends BaseTypeHandler<PhoneNumber> {

	/**
	 * ͨ������ȡ���ݿ����phone��ֵ
	 */
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		//rs.getString("columnName")ȡ���ݿ��ֵ
		return new PhoneNumber(rs.getString(columnName));
	}

	/**
	 * ͨ���е�����(��1��ʼ)ȡ���ݱ���phone��ֵ
	 */
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return new PhoneNumber(rs.getString(columnIndex));
	}

	/**
	 * ͨ���洢��������ȡ���ݿ�phone��ֵ
	 */
	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return new PhoneNumber(cs.getString(columnIndex));
	}

	/**
	 * ����phone��ֵ
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, PhoneNumber parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		ps.setString(i, parameter.getAsString());
		
		
	}

}
