package org.sang.bean;

import java.sql.Timestamp;

/**
 * Created by sang on 2017/8/21.
 */
public class Meeting {
    private int meetingid;
    private String meetingname;
    private int roomid;
    private int reservationistid;
    private int numberofparticipants;
    private Timestamp starttime;
    private Timestamp endtime;
    private Timestamp reservationtime;
    private Timestamp canceledtime;
    private String description;
    private int status;
    private String roomname;
    private String empname;
    private String canceledreason;

    public String getCanceledreason() {
        return canceledreason;
    }

    public void setCanceledreason(String canceledreason) {
        this.canceledreason = canceledreason;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Meeting(String meetingname, int roomid, int reservationistid, int numberofparticipants, Timestamp starttime, Timestamp endtime, Timestamp reservationtime, String description) {
        this.meetingname = meetingname;
        this.roomid = roomid;
        this.reservationistid = reservationistid;
        this.numberofparticipants = numberofparticipants;
        this.starttime = starttime;
        this.endtime = endtime;
        this.reservationtime = reservationtime;
        this.description = description;
    }

    public Meeting() {
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingid=" + meetingid +
                ", meetingname='" + meetingname + '\'' +
                ", roomid=" + roomid +
                ", reservationistid=" + reservationistid +
                ", numberofparticipants=" + numberofparticipants +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", reservationtime=" + reservationtime +
                ", canceledtime=" + canceledtime +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", roomname='" + roomname + '\'' +
                ", empname='" + empname + '\'' +
                '}';
    }

    public Meeting(int meetingid, String meetingname, int roomid, int reservationistid, int numberofparticipants, Timestamp starttime, Timestamp endtime, Timestamp reservationtime, Timestamp canceledtime, String description, int status) {
        this.meetingid = meetingid;
        this.meetingname = meetingname;
        this.roomid = roomid;
        this.reservationistid = reservationistid;
        this.numberofparticipants = numberofparticipants;
        this.starttime = starttime;
        this.endtime = endtime;
        this.reservationtime = reservationtime;
        this.canceledtime = canceledtime;
        this.description = description;
        this.status = status;
    }

    public int getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(int meetingid) {
        this.meetingid = meetingid;
    }

    public String getMeetingname() {
        return meetingname;
    }

    public void setMeetingname(String meetingname) {
        this.meetingname = meetingname;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getReservationistid() {
        return reservationistid;
    }

    public void setReservationistid(int reservationistid) {
        this.reservationistid = reservationistid;
    }

    public int getNumberofparticipants() {
        return numberofparticipants;
    }

    public void setNumberofparticipants(int numberofparticipants) {
        this.numberofparticipants = numberofparticipants;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public Timestamp getReservationtime() {
        return reservationtime;
    }

    public void setReservationtime(Timestamp reservationtime) {
        this.reservationtime = reservationtime;
    }

    public Timestamp getCanceledtime() {
        return canceledtime;
    }

    public void setCanceledtime(Timestamp canceledtime) {
        this.canceledtime = canceledtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
