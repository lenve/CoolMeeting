package org.javaboy.meeting.service;

import org.javaboy.meeting.mapper.EmployeeMapper;
import org.javaboy.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨 666 ssm
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public Employee doLogin(String username, String password) {
        Employee employee = employeeMapper.loadEmpByUsername(username);
        if (employee == null || !employee.getPassword().equals(password)) {
            return null;
        }
        return employee;
    }

    public Integer doReg(Employee employee) {
        Employee emp = employeeMapper.loadEmpByUsername(employee.getUsername());
        if (emp != null) {
            return -1;
        }
        employee.setRole(1);
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }

    public List<Employee> getAllEmpsByStatus(Integer status) {
        return employeeMapper.getAllEmpsByStatus(status);
    }

    public Integer updatestatus(Integer employeeid, Integer status) {
        return employeeMapper.approveaccount(employeeid,status);
    }

    public List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize) {
        page = (page - 1) * pageSize;
        return employeeMapper.getAllEmps(employee, page, pageSize);
    }

    public Long getTotal(Employee employee) {
        return employeeMapper.getTotal(employee);
    }

    public List<Employee> getEmpsByDepId(Integer depId) {
        return employeeMapper.getEmpsByDepId(depId);
    }
}
