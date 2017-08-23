package org.sang.servlet;

import org.sang.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sang on 2017/8/18.
 */
public class UpdateEmpStatusServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        String empid = req.getParameter("empid");
        int i = employeeService.updateEmpStatusById(Integer.parseInt(empid), Integer.parseInt(status));
        if (i == 1) {
            resp.sendRedirect(req.getContextPath() + "/approveaccount");
        } else {
            req.setAttribute("error", "审批失败");
            req.getRequestDispatcher("/approveaccount").forward(req, resp);
        }
    }
}
