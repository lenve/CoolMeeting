package org.sang.servlet;

import org.sang.bean.MeetingRoom;
import org.sang.service.MeetingRoomService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sang on 2017/8/21.
 */
public class RoomdetailsServlet extends HttpServlet {
    private MeetingRoomService meetingRoomService = new MeetingRoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomid = req.getParameter("roomid");
        MeetingRoom meetingRoom = meetingRoomService.getMeetingRoomById(Integer.parseInt(roomid));
        req.setAttribute("mr", meetingRoom);
        req.getRequestDispatcher("/roomdetails.jsp").forward(req, resp);
    }
}
