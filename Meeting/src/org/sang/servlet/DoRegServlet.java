package org.sang.servlet;

import org.sang.bean.Employee;
import org.sang.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sang on 2017/8/17.
 */
public class DoRegServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeename = req.getParameter("employeename");
        String accountname = req.getParameter("accountname");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String deptid = req.getParameter("deptid");
        Employee employee = new Employee(employeename, accountname, phone, email, Integer.parseInt(deptid), password);
        int reg = employeeService.reg(employee);
        if (reg == 1) {
            //注册成功，跳转到登录页面
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        } else if (reg == -1) {
            //用户名重复，注册失败
            req.setAttribute("error", "用户名重复，注册失败");
            req.getRequestDispatcher("/reg").forward(req, resp);
        } else {
            req.setAttribute("error", "不明原因，注册失败");
            req.getRequestDispatcher("/reg").forward(req, resp);
        }
    }
}
