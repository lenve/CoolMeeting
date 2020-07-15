package org.javaboy.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.meeting.model.Employee;

import java.util.List;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public interface EmployeeMapper {
    Employee loadEmpByUsername(String username);

    Integer doReg(Employee employee);

    List<Employee> getAllEmpsByStatus(Integer status);

    Integer approveaccount(@Param("employeeid") Integer employeeid, @Param("status") Integer status);

    List<Employee> getAllEmps(@Param("emp") Employee employee, @Param("page") Integer page, @Param("pagesize") Integer pageSize);

    Long getTotal(Employee employee);

    List<Employee> getEmpsByDepId(Integer depId);
}
