package org.sang.servlet;

import org.sang.bean.Employee;
import org.sang.bean.Meeting;
import org.sang.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sang on 2017/8/23.
 */
public class NotificationsServlet extends HttpServlet {
    private MeetingService meetingService = new MeetingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int loginEmpId = ((Employee) req.getSession().getAttribute("loginUser")).getEmployeeid();
        List<Meeting> mt7 = meetingService.getMeeting7Days(loginEmpId);
        List<Meeting> cm = meetingService.getCanceledMeeting(loginEmpId);
        req.setAttribute("mt7", mt7);
        req.setAttribute("cm", cm);
        req.getRequestDispatcher("/notifications.jsp").forward(req, resp);
    }
}
