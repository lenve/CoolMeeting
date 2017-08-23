package org.sang.servlet;

import org.sang.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sang on 2017/8/17.
 */
public class UpdateDepServlet extends HttpServlet {
    private DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String depName = req.getParameter("depName");
        int i = departmentService.updateDepById(depName, Integer.parseInt(id));
        PrintWriter out = resp.getWriter();
        if (i == 1) {
            out.write("修改成功");
        } else {
            out.write("修改失败");
        }
    }
}
