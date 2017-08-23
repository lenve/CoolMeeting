package org.sang.servlet;

import org.sang.bean.Employee;
import org.sang.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sang on 2017/8/18.
 */
public class SearchEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updateStatus = req.getParameter("updateStatus");
        if (updateStatus != null && "-1".equals(updateStatus)) {
            String empid = req.getParameter("empid");
            employeeService.updateEmpStatusById(Integer.parseInt(empid), Integer.parseInt(updateStatus));
        }
        String employeename = req.getParameter("employeename");
        String username = req.getParameter("username");
        String status = req.getParameter("status");
        String page = req.getParameter("page");
        String count = req.getParameter("count");
        if (status == null || "".equals(status)) {
            status = "1";
        }
        if (page == null || "".equals(page)) {
            page = "1";
        }
        if (count == null || "".equals(count)) {
            count = "10";
        }
        List<Employee> list = employeeService.searchEmp(employeename, username, Integer.parseInt(status), Integer.parseInt(page), Integer.parseInt(count));
        int totalCount = employeeService.getCount(employeename, username, Integer.parseInt(status));
        int totalPage = totalCount / Integer.parseInt(count) + 1;
        req.setAttribute("list", list);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("page", page);
        req.setAttribute("employeename", employeename);
        req.setAttribute("username", username);
        req.setAttribute("status", status);
        req.getRequestDispatcher("/searchemployees.jsp").forward(req, resp);
    }
}
