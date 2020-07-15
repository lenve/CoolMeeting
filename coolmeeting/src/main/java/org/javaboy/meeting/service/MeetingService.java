package org.javaboy.meeting.service;

import org.javaboy.meeting.mapper.MeetingMapper;
import org.javaboy.meeting.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨 ss ssm
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Service
public class MeetingService {
    @Autowired
    MeetingMapper meetingMapper;
    public Integer addMeeting(Meeting meeting, Integer[] mps) {
        meeting.setReservationtime(new Date());
        Integer result = meetingMapper.addMeeting(meeting);
        meetingMapper.addParticipants(meeting.getMeetingid(), mps);
        return result;
    }
}
