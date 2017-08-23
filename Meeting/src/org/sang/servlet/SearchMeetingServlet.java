package org.sang.servlet;

import org.sang.bean.Meeting;
import org.sang.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sang on 2017/8/21.
 */
public class SearchMeetingServlet extends HttpServlet {
    private MeetingService meetingService = new MeetingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String meetingname = req.getParameter("meetingname");
        String roomname = req.getParameter("roomname");
        String reservername = req.getParameter("reservername");
        String reservefromdate = req.getParameter("reservefromdate");
        String reservetodate = req.getParameter("reservetodate");
        String meetingfromdate = req.getParameter("meetingfromdate");
        String meetingtodate = req.getParameter("meetingtodate");
        String page = req.getParameter("page");
        String count = req.getParameter("count");
        if (page == null || "".equals(page)) {
            page = "1";
        }
        if (count == null || "".equals(count)) {
            count = "10";
        }
        List<Meeting> list = meetingService.searchMeeting(meetingname, roomname, reservername, reservefromdate, reservetodate, meetingfromdate, meetingtodate, Integer.parseInt(page), Integer.parseInt(count));
        int totalCount = meetingService.getCount(meetingname, roomname, reservername, reservefromdate, reservetodate, meetingfromdate, meetingtodate);
        int totalPage = totalCount / Integer.parseInt(count) + 1;
        req.setAttribute("list", list);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("page", page);
        req.setAttribute("meetingname", meetingname);
        req.setAttribute("roomname", roomname);
        req.setAttribute("reservername", reservername);
        req.setAttribute("reservefromdate", reservefromdate);
        req.setAttribute("reservetodate", reservetodate);
        req.setAttribute("meetingfromdate", meetingfromdate);
        req.setAttribute("meetingtodate", meetingtodate);
        req.setAttribute("count", count);
        req.getRequestDispatcher("/searchmeetings.jsp").forward(req, resp);
    }
}
