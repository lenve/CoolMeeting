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
public class DeleteDepSerlvet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String depid = req.getParameter("depid");
        int i = departmentService.deleteDepById(Integer.parseInt(depid));
        if (i == 1) {
            resp.sendRedirect(req.getContextPath() + "/departments");
        } else {
            req.setAttribute("error", "删除失败");
            req.getRequestDispatcher("/departments").forward(req, resp);
        }
    }
}
