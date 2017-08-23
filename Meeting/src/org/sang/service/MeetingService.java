package org.sang.service;

import org.sang.bean.Employee;
import org.sang.bean.Meeting;
import org.sang.dao.EmployeeDao;
import org.sang.dao.MeetingDao;
import org.sang.dao.MeetingParticipantsDao;

import java.util.List;

/**
 * Created by sang on 2017/8/21.
 */
public class MeetingService {
    private MeetingDao meetingDao = new MeetingDao();
    private EmployeeDao employeeDao = new EmployeeDao();
    private List<Employee> emps;

    public List<Employee> getEmps() {
        return emps;
    }

    private MeetingParticipantsDao meetingParticipantsDao = new MeetingParticipantsDao();

    public void insert(Meeting meeting, String[] empids) {
        int insert = meetingDao.insert(meeting);
        meetingParticipantsDao.insert(insert, empids);
    }

    public List<Meeting> searchMeeting(String meetingname, String roomname, String reservername, String reservefromdate, String reservetodate, String meetingfromdate, String meetingtodate, int page, int count) {
        return meetingDao.searchMeeting(meetingname, roomname, reservername, reservefromdate, reservetodate, meetingfromdate, meetingtodate, page, count);
    }

    public int getCount(String meetingname, String roomname, String reservername, String reservefromdate, String reservetodate, String meetingfromdate, String meetingtodate) {
        return meetingDao.getCount(meetingname, roomname, reservername, reservefromdate, reservetodate, meetingfromdate, meetingtodate);
    }

    public Meeting getMeetingDetailsByMeetingId(int mid) {
        Meeting meeting = meetingDao.getMeetingById(mid);
        this.emps = employeeDao.getEmpByMeetingId(meeting.getMeetingid());
        return meeting;
    }
    public List<Meeting> getCanceledMeeting(int empid) {
        return meetingDao.getCanceledMeeting(empid);
    }
    public List<Meeting> getMeeting7Days(int empid) {
        return meetingDao.getMeeting7Days(empid);
    }
    public List<Meeting> getMyBookingMeeting(int empid) {
        return meetingDao.getMyBookingMeeting(empid);
    }
    public int cancelMeeting(int mid, String reason) {
        return meetingDao.cancelMeeting(mid, reason);
    }
    public List<Meeting> getMyMeeting(int empid) {
        return meetingDao.getMyMeeting(empid);
    }
}
