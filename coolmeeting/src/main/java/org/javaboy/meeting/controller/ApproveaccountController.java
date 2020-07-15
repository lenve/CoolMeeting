package org.javaboy.meeting.controller;

import org.javaboy.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨 888
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Controller
@RequestMapping("/admin")
public class ApproveaccountController {

    public static final Integer PENDING_APPROVE = 0;

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/approveaccount")
    public String approveaccount(Model model) {
        model.addAttribute("emps", employeeService.getAllEmpsByStatus(PENDING_APPROVE));
        return "approveaccount";
    }

    @RequestMapping("/updatestatus")
    public String updatestatus(Integer employeeid, Integer status) {
        Integer result = employeeService.updatestatus(employeeid, status);
        return "redirect:/admin/approveaccount";
    }
}