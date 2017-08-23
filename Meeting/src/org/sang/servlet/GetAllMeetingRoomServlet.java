package org.sang.servlet;

import org.sang.bean.MeetingRoom;
import org.sang.service.MeetingRoomService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sang on 2017/8/18.
 */
public class GetAllMeetingRoomServlet extends HttpServlet {
    private MeetingRoomService meetingRoomService = new MeetingRoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MeetingRoom> allMeetingRoom = meetingRoomService.getAllMeetingRoom();
        req.setAttribute("list", allMeetingRoom);
        req.getRequestDispatcher("/meetingrooms.jsp").forward(req, resp);
    }
}
