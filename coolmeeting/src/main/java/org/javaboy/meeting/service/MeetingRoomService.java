package org.javaboy.meeting.service;

import org.javaboy.meeting.mapper.MeetingRoomMapper;
import org.javaboy.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨 888 coolmeeting
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Service
public class MeetingRoomService {
    @Autowired
    MeetingRoomMapper meetingRoomMapper;
    public List<MeetingRoom> getAllMr() {
        return meetingRoomMapper.getAllMr();
    }

    public MeetingRoom getMrById(Integer roomid) {
        return meetingRoomMapper.getMrById(roomid);
    }

    public Integer updateRoom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.updateRoom(meetingRoom);
    }

    public Integer addMr(MeetingRoom meetingRoom) {
        return meetingRoomMapper.addMr(meetingRoom);
    }
}