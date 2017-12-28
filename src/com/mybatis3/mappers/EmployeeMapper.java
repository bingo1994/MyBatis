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

//使用注解的方式来对数据库的表进行增删改查操作
public interface EmployeeMapper {

	// 添加员工
	@Insert("insert into employee(eid,empname,empaddress,salary,birth) values(#{eid},#{empname},"
			+ "#{empaddress},#{salary},#{birth})")
	//statement查找序列给keyProperty赋值
	@SelectKey(statement = "select employee_seq.nextval from dual", keyProperty = "eid", resultType = Integer.class, before = true)
	public int addEmp(Employee emp);

	/**
	 * 更新员工
	 * @param emp
	 * @return
	 */
	@Update("update employee set empname=#{empname},empaddress=#{empaddress},salary=#{salary},birth=#{birth} where eid=#{eid}")
	public int updateEmp(Employee emp);

	/**
	 * 删除员工
	 * 
	 * @param eid
	 * @return
	 */
	@Delete("delete from employee where eid=#{eid}")
	public int deleteEmp(int eid);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from employee where eid=#{eid}")
	public Employee getEmpById(int id);

	/**
	 * 查询所有
	 * 
	 * @param
	 * @return
	 */
	@Select("select * from employee ")
	public List<Employee> getAllEmp();

	/**
	 * 查询所有
	 * 
	 * @Results将Javabean中的属性与数据库中的列名对应
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
	 * 查询所有，在Javabean属性名与列名不相同的情况下
	 * 要有xml
	 * @Results将Javabean中的属性与数据库中的列名对应
	 * @param
	 * @return
	 */
	@Select("select * from employee ")
	@ResultMap("com.mybatis3.mappers.EmployeeMapper.EmployeeResult") // 命名空间加resultMap的id
	public List<Employee> getAllEmpss();

	/**
	 * 分页查询所有数据
	 * 
	 * @param map
	 * @return
	 */
	@Select("select * from (select e.*,rownum rn from employee e) where rn>#{start} and rn<=#{end}")
	public List<Employee> getEmpByPage(Map<String, Object> map);

	/**
	 * 模糊分页查询所有数据
	 * 
	 * @param map
	 * @return
	 */
	@Select("select * from (select e.*,rownum rn from employee e where empname like #{empname}) where rn>#{start} and rn<=#{end}")
	public List<Employee> getEmpByLike(Map<String, Object> map);

	/**
	 * 根据id查询地址信息 一对一映射
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
		// 这里我们使用了@One 注解的 select 属性来指定一个使用了完全限定名的方法上，该方法会返回一个 Address 对象
		@Result(property = "address", column = "add_id", one = @One(select = "com.mybatis3.mappers.EmployeeMapper.getAddressById"))
		})
	public Employee getEmpAddressById(int eid);

	/**
	 * 员工表一对一
	 * 在xml中配置
	 * @param eid
	 * @return
	 */
	@Select("select * from employee e,address a where e.add_id=a.addressid and eid=#{eid}")
	@ResultMap("com.mybatis3.mappers.EmployeeMapper.EmployeeResult")
	public Employee getEmpAddressTest(int eid);
	
	
	/**
	 * 第一种，不需要配置xml
	 * 一对多映射
	 * 根据部门id查询部门信息,再找到对应下面的员工信息
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
	 *根据部门id查询对应下面的员工信息
	 * @param id
	 * @return
	 */
	@Select("select * from employee where deptid=#{did}")
	public List<Employee>getEmpByDeptId(int id);
	
	/**
	 * 一对多映射
	 * 根据部门查询所有部门信息,再找到对应下面的员工信息
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
	 * 一对多映射，联表查询
	 * 根据部门id查询对应下面的员工信息
	 * @param did
	 * @return
	 */
	@Select("select d.deptname,d.did,e.empname,e.empaddress,e.salary,e.birth from employee e,dept d where e.deptid=d.did and d.did=#{did}")
	@ResultMap("com.mybatis3.mappers.EmployeeMapper.DeptEmpResult")//xml文件中的命名空间及id
	public Dept getDeptByResult(int did);
}
