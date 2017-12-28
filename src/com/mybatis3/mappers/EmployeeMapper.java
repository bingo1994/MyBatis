package com.mybatis3.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.bean.Address;
import com.bean.Dept;
import com.bean.Employee;

//ʹ��ע��ķ�ʽ�������ݿ�ı������ɾ�Ĳ����
public interface EmployeeMapper {

	// ���Ա��
	@Insert("insert into employee(eid,empname,empaddress,salary,birth) values(#{eid},#{empname},"
			+ "#{empaddress},#{salary},#{birth})")
	//statement�������и�keyProperty��ֵ
	@SelectKey(statement = "select employee_seq.nextval from dual", keyProperty = "eid", resultType = Integer.class, before = true)
	public int addEmp(Employee emp);

	/**
	 * ����Ա��
	 * @param emp
	 * @return
	 */
	@Update("update employee set empname=#{empname},empaddress=#{empaddress},salary=#{salary},birth=#{birth} where eid=#{eid}")
	public int updateEmp(Employee emp);

	/**
	 * ɾ��Ա��
	 * 
	 * @param eid
	 * @return
	 */
	@Delete("delete from employee where eid=#{eid}")
	public int deleteEmp(int eid);

	/**
	 * ����id��ѯ
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from employee where eid=#{eid}")
	public Employee getEmpById(int id);

	/**
	 * ��ѯ����
	 * 
	 * @param
	 * @return
	 */
	@Select("select * from employee ")
	public List<Employee> getAllEmp();

	/**
	 * ��ѯ����
	 * 
	 * @Results��Javabean�е����������ݿ��е�������Ӧ
	 * @param
	 * @return
	 */
	@Select("select * from employee ")
	@Results({
		@Result(id = true, column = "eid", property = "eid"),
		@Result(column = "empname", property = "empname"),
		@Result(column = "empaddress", property = "empaddress"), 
		@Result(column = "salary", property = "salary"),
		@Result(column = "birth", property = "birth") })
	public List<Employee> getAllEmps();

	/**
	 * ��ѯ���У���Javabean����������������ͬ�������
	 * Ҫ��xml
	 * @Results��Javabean�е����������ݿ��е�������Ӧ
	 * @param
	 * @return
	 */
	@Select("select * from employee ")
	@ResultMap("com.mybatis3.mappers.EmployeeMapper.EmployeeResult") // �����ռ��resultMap��id
	public List<Employee> getAllEmpss();

	/**
	 * ��ҳ��ѯ��������
	 * 
	 * @param map
	 * @return
	 */
	@Select("select * from (select e.*,rownum rn from employee e) where rn>#{start} and rn<=#{end}")
	public List<Employee> getEmpByPage(Map<String, Object> map);

	/**
	 * ģ����ҳ��ѯ��������
	 * 
	 * @param map
	 * @return
	 */
	@Select("select * from (select e.*,rownum rn from employee e where empname like #{empname}) where rn>#{start} and rn<=#{end}")
	public List<Employee> getEmpByLike(Map<String, Object> map);

	/**
	 * ����id��ѯ��ַ��Ϣ һ��һӳ��
	 * 
	 * @param addid
	 * @return
	 */
	@Select("select * from address where addressid=#{add_id}")
	public Address getAddressById(int addid);

	@Select("select * from employee where eid=#{eid}")
	@Results({
		@Result(id = true, property = "eid", column = "eid"),
		@Result(property = "empaddress", column = "empaddress"),
		@Result(property = "empname", column = "empname"),
		@Result(property = "salary", column = "salary"), 
		@Result(property = "birth", column = "birth"),
		// ��������ʹ����@One ע��� select ������ָ��һ��ʹ������ȫ�޶����ķ����ϣ��÷����᷵��һ�� Address ����
		@Result(property = "address", column = "add_id", one = @One(select = "com.mybatis3.mappers.EmployeeMapper.getAddressById"))
		})
	public Employee getEmpAddressById(int eid);

	/**
	 * Ա����һ��һ
	 * ��xml������
	 * @param eid
	 * @return
	 */
	@Select("select * from employee e,address a where e.add_id=a.addressid and eid=#{eid}")
	@ResultMap("com.mybatis3.mappers.EmployeeMapper.EmployeeResult")
	public Employee getEmpAddressTest(int eid);
	
	
	/**
	 * ��һ�֣�����Ҫ����xml
	 * һ�Զ�ӳ��
	 * ���ݲ���id��ѯ������Ϣ,���ҵ���Ӧ�����Ա����Ϣ
	 * @param id
	 * @return
	 */
	@Select("select * from dept where did=#{did}")
	@Results({
		@Result(id=true,column="did",property="did"),
		@Result(column="deptname",property="deptname"),
		@Result(column="deptdesp",property="deptdesp"),
		@Result(column="did",property="employee",many=@Many(select="com.mybatis3.mappers.EmployeeMapper.getEmpByDeptId")),
	})
	public Dept getDeptById(int id);
	
	/**
	 *���ݲ���id��ѯ��Ӧ�����Ա����Ϣ
	 * @param id
	 * @return
	 */
	@Select("select * from employee where deptid=#{did}")
	public List<Employee>getEmpByDeptId(int id);
	
	/**
	 * һ�Զ�ӳ��
	 * ���ݲ��Ų�ѯ���в�����Ϣ,���ҵ���Ӧ�����Ա����Ϣ
	 * @param id
	 * @return
	 */
	@Select("select * from dept ")
	@Results({
		@Result(id=true,column="did",property="did"),
		@Result(column="deptname",property="deptname"),
		@Result(column="deptdesp",property="deptdesp"),
		@Result(column="did",property="employee",many=@Many(select="com.mybatis3.mappers.EmployeeMapper.getEmpByDeptId")),
	})
	public List<Dept> getAllDept();
	
	
	/**
	 * һ�Զ�ӳ�䣬�����ѯ
	 * ���ݲ���id��ѯ��Ӧ�����Ա����Ϣ
	 * @param did
	 * @return
	 */
	@Select("select d.deptname,d.did,e.empname,e.empaddress,e.salary,e.birth from employee e,dept d where e.deptid=d.did and d.did=#{did}")
	@ResultMap("com.mybatis3.mappers.EmployeeMapper.DeptEmpResult")//xml�ļ��е������ռ估id
	public Dept getDeptByResult(int did);
}
