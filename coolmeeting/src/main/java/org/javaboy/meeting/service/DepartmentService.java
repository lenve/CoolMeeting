package org.javaboy.meeting.service;

import org.javaboy.meeting.mapper.DepartmentMapper;
import org.javaboy.meeting.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public Department getDepById(Integer id) {
        return departmentMapper.getDepById(id);
    }

    public List<Department> getAllDeps() {
        return departmentMapper.getAllDeps();
    }

    public Integer adddepartment(String departmentname) {
        Department dep = departmentMapper.getDepByName(departmentname);
        if (dep != null) {
            return -1;
        }
        return departmentMapper.adddepartment(departmentname);
    }

    public Integer deletedep(Integer departmentid) {
        return departmentMapper.deletedep(departmentid);
    }

    public Integer updatedep(Integer id, String name) {
        return departmentMapper.updatedep(id,name);
    }
}
