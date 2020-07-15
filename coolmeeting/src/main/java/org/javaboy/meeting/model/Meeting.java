package org.javaboy.meeting.model;

import java.io.PipedReader;
import java.util.Date;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
public class Meeting {
    private Integer meetingid;
    private String meetingname;
    private Integer roomid;
    private Integer reservationistid;
    private Integer numberofparticipants;
    private Date starttime;
    private Date endtime;
    private Date reservationtime;
    private Date canceledtime;
    private String description;
    private Integer status;

    public Integer getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(Integer meetingid) {
        this.meetingid = meetingid;
    }

    public String getMeetingname() {
        return meetingname;
    }

    public void setMeetingname(String meetingname) {
        this.meetingname = meetingname;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getReservationistid() {
        return reservationistid;
    }

    public void setReservationistid(Integer reservationistid) {
        this.reservationistid = reservationistid;
    }

    public Integer getNumberofparticipants() {
        return numberofparticipants;
    }

    public void setNumberofparticipants(Integer numberofparticipants) {
        this.numberofparticipants = numberofparticipants;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getReservationtime() {
        return reservationtime;
    }

    public void setReservationtime(Date reservationtime) {
        this.reservationtime = reservationtime;
    }

    public Date getCanceledtime() {
        return canceledtime;
    }

    public void setCanceledtime(Date canceledtime) {
        this.canceledtime = canceledtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
