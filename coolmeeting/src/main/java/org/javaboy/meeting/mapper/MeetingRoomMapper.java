package org.javaboy.meeting.mapper;

import org.javaboy.meeting.model.MeetingRoom;

import java.util.List;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public interface MeetingRoomMapper {
    List<MeetingRoom> getAllMr();

    MeetingRoom getMrById(Integer roomid);

    Integer updateRoom(MeetingRoom meetingRoom);

    Integer addMr(MeetingRoom meetingRoom);
}
