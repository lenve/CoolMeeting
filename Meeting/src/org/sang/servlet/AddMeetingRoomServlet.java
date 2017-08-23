package org.sang.servlet;

import org.sang.bean.MeetingRoom;
import org.sang.service.MeetingRoomService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sang on 2017/8/18.
 */
public class AddMeetingRoomServlet extends HttpServlet {
    private MeetingRoomService meetingRoomService = new MeetingRoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomid = req.getParameter("roomid");
        String roomnum = req.getParameter("roomnum");
        String roomname = req.getParameter("roomname");
        String capacity = req.getParameter("capacity");
        String status = req.getParameter("status");
        String description = req.getParameter("description");
        MeetingRoom meetingRoom = new MeetingRoom(Integer.parseInt(roomnum), roomname, Integer.parseInt(capacity), Integer.parseInt(status), description);
        if (roomid == null || "".equals(roomid)) {
            //添加会议室
            int result = meetingRoomService.insert(meetingRoom);
            if (result == 1) {
                //去查看会议室页面
                resp.sendRedirect(req.getContextPath() + "/getallmr");
            } else {
                req.setAttribute("error", "添加失败");
                req.getRequestDispatcher("/addmeetingroom.jsp").forward(req, resp);
            }
        } else {
            //修改会议室
            meetingRoom.setRoomid(Integer.parseInt(roomid));
            int update = meetingRoomService.update(meetingRoom);
            if (update == 1) {
                resp.sendRedirect(req.getContextPath() + "/getallmr");
            }else{
                //更新失败
            }
        }
    }
}
