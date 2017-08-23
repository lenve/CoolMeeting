package org.sang.servlet;

import org.sang.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sang on 2017/8/17.
 */
public class AddDepServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentname = req.getParameter("departmentname");
        int insert = departmentService.insert(departmentname);
        if (insert == 1) {
            resp.sendRedirect(req.getContextPath() + "/departments");
        } else {
            req.setAttribute("error", "添加失败");
            req.getRequestDispatcher("/departments").forward(req, resp);
        }
    }
}
