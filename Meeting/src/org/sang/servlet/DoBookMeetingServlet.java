package org.sang.servlet;

import org.sang.bean.Employee;
import org.sang.bean.Meeting;
import org.sang.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by sang on 2017/8/21.
 */
public class DoBookMeetingServlet extends HttpServlet {
    private MeetingService meetingService = new MeetingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String meetingname = req.getParameter("meetingname");
        String numberofparticipants = req.getParameter("numberofparticipants");
        String starttime = req.getParameter("starttime");
        String endtime = req.getParameter("endtime");
        String roomid = req.getParameter("roomid");
        String description = req.getParameter("description");
        String[] selSelectedEmployees = req.getParameterValues("selSelectedEmployees");
        //获取当前登录的用户对象
        Employee loginUser = (Employee) req.getSession().getAttribute("loginUser");
        Meeting meeting = new Meeting(meetingname, Integer.parseInt(roomid), loginUser.getEmployeeid(), Integer.parseInt(numberofparticipants), Timestamp.valueOf(starttime), Timestamp.valueOf(endtime), new Timestamp(System.currentTimeMillis()), description);
        meetingService.insert(meeting, selSelectedEmployees);
        resp.sendRedirect(req.getContextPath() + "/searchmeetings.html");
    }
}
