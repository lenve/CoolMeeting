package org.sang.dao;

import org.sang.bean.Meeting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sang on 2017/8/21.
 */
public class MeetingDao {
    public int getCount(String meetingname, String roomname, String reservername, String reservefromdate, String reservetodate, String meetingfromdate, String meetingtodate) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer("SELECT count(*) FROM meeting m,employee e,meetingroom mr WHERE m.`roomid`=mr.`roomid` AND m.`reservationistid`=e.`employeeid`");
        if (meetingname != null && !"".equals(meetingname)) {
            sb.append(" and meetingname=?");
        }
        if (roomname != null && !"".equals(roomname)) {
            sb.append(" and roomname=?");
        }
        if (reservername != null && !"".equals(reservername)) {
            sb.append(" and employeename=?");
        }
        if (reservefromdate != null && !"".equals(reservefromdate) && reservetodate != null && !"".equals(reservetodate)) {
            sb.append(" and reservationtime > ? and reservationtime<?");
        }
        if (meetingfromdate != null && !"".equals(meetingfromdate) && meetingtodate != null && !"".equals(meetingtodate)) {
            sb.append(" and starttime>? and endtime<?");
        }
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sb.toString());
            int index = 1;
            if (meetingname != null && !"".equals(meetingname)) {
                ps.setString(index++, meetingname);
            }
            if (roomname != null && !"".equals(roomname)) {
                ps.setString(index++, roomname);
            }
            if (reservername != null && !"".equals(reservername)) {
                ps.setString(index++, reservername);
            }
            if (reservefromdate != null && !"".equals(reservefromdate) && reservetodate != null && !"".equals(reservetodate)) {
                ps.setTimestamp(index++, Timestamp.valueOf(reservefromdate));
                ps.setTimestamp(index++, Timestamp.valueOf(reservetodate));
            }
            if (meetingfromdate != null && !"".equals(meetingfromdate) && meetingtodate != null && !"".equals(meetingtodate)) {
                ps.setTimestamp(index++, Timestamp.valueOf(meetingfromdate));
                ps.setTimestamp(index++, Timestamp.valueOf(meetingtodate));
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return -1;
    }

    public List<Meeting> searchMeeting(String meetingname, String roomname, String reservername, String reservefromdate, String reservetodate, String meetingfromdate, String meetingtodate, int page, int count) {
        List<Meeting> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer("SELECT m.*,e.`employeename` AS employeename,mr.`roomname` AS roomname FROM meeting m,employee e,meetingroom mr WHERE m.`roomid`=mr.`roomid` AND m.`reservationistid`=e.`employeeid`");
        if (meetingname != null && !"".equals(meetingname)) {
            sb.append(" and meetingname=?");
        }
        if (roomname != null && !"".equals(roomname)) {
            sb.append(" and roomname=?");
        }
        if (reservername != null && !"".equals(reservername)) {
            sb.append(" and employeename=?");
        }
        if (reservefromdate != null && !"".equals(reservefromdate) && reservetodate != null && !"".equals(reservetodate)) {
            sb.append(" and reservationtime > ? and reservationtime<?");
        }
        if (meetingfromdate != null && !"".equals(meetingfromdate) && meetingtodate != null && !"".equals(meetingtodate)) {
            sb.append(" and starttime>? and endtime<?");
        }
        sb.append(" limit ?,?");
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sb.toString());
            int index = 1;
            if (meetingname != null && !"".equals(meetingname)) {
                ps.setString(index++, meetingname);
            }
            if (roomname != null && !"".equals(roomname)) {
                ps.setString(index++, roomname);
            }
            if (reservername != null && !"".equals(reservername)) {
                ps.setString(index++, reservername);
            }
            if (reservefromdate != null && !"".equals(reservefromdate) && reservetodate != null && !"".equals(reservetodate)) {
                ps.setTimestamp(index++, Timestamp.valueOf(reservefromdate));
                ps.setTimestamp(index++, Timestamp.valueOf(reservetodate));
            }
            if (meetingfromdate != null && !"".equals(meetingfromdate) && meetingtodate != null && !"".equals(meetingtodate)) {
                ps.setTimestamp(index++, Timestamp.valueOf(meetingfromdate));
                ps.setTimestamp(index++, Timestamp.valueOf(meetingtodate));
            }
            ps.setInt(index++, (page - 1) * count);
            ps.setInt(index++, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                int meetingid = rs.getInt("meetingid");
                String meetingname1 = rs.getString("meetingname");
                int roomid = rs.getInt("roomid");
                int reservationistid = rs.getInt("reservationistid");
                int numberofparticipants = rs.getInt("numberofparticipants");
                Timestamp starttime = rs.getTimestamp("starttime");
                Timestamp endtime = rs.getTimestamp("endtime");
                Timestamp reservationtime = rs.getTimestamp("reservationtime");
                Timestamp canceledtime = rs.getTimestamp("canceledtime");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                String employeename = rs.getString("employeename");
                String roomname1 = rs.getString("roomname");
                Meeting meeting = new Meeting(meetingid, meetingname1, roomid, reservationistid, numberofparticipants, starttime, endtime, reservationtime, canceledtime, description, status);
                meeting.setEmpname(employeename);
                meeting.setRoomname(roomname1);
                list.add(meeting);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return list;
    }

    public List<Meeting> getMeeting7Days(int empid) {
        List<Meeting> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT m.*,mr.`roomname` AS roomname FROM meeting m,meetingroom mr WHERE meetingid IN(SELECT meetingid FROM meetingparticipants WHERE employeeid=?) AND m.`roomid`=mr.`roomid` AND starttime<? AND starttime>?");
            ps.setInt(1, empid);
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000));
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int meetingid = rs.getInt("meetingid");
                String meetingname1 = rs.getString("meetingname");
                int roomid = rs.getInt("roomid");
                int reservationistid = rs.getInt("reservationistid");
                int numberofparticipants = rs.getInt("numberofparticipants");
                Timestamp starttime = rs.getTimestamp("starttime");
                Timestamp endtime = rs.getTimestamp("endtime");
                Timestamp reservationtime = rs.getTimestamp("reservationtime");
                Timestamp canceledtime = rs.getTimestamp("canceledtime");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                String roomname1 = rs.getString("roomname");
                Meeting meeting = new Meeting(meetingid, meetingname1, roomid, reservationistid, numberofparticipants, starttime, endtime, reservationtime, canceledtime, description, status);
                meeting.setRoomname(roomname1);
                list.add(meeting);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return list;
    }

    public List<Meeting> getMyBookingMeeting(int empid) {
        List<Meeting> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT m.*,mr.`roomname` AS roomname FROM meeting m,meetingroom mr WHERE m.`reservationistid`=? AND m.status=0 AND m.`roomid`=mr.`roomid`");
            ps.setInt(1, empid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int meetingid = rs.getInt("meetingid");
                String meetingname1 = rs.getString("meetingname");
                int roomid = rs.getInt("roomid");
                int reservationistid = rs.getInt("reservationistid");
                int numberofparticipants = rs.getInt("numberofparticipants");
                Timestamp starttime = rs.getTimestamp("starttime");
                Timestamp endtime = rs.getTimestamp("endtime");
                Timestamp reservationtime = rs.getTimestamp("reservationtime");
                Timestamp canceledtime = rs.getTimestamp("canceledtime");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                String roomname1 = rs.getString("roomname");
                Meeting meeting = new Meeting(meetingid, meetingname1, roomid, reservationistid, numberofparticipants, starttime, endtime, reservationtime, canceledtime, description, status);
                meeting.setRoomname(roomname1);
                list.add(meeting);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return list;
    }

    public List<Meeting> getCanceledMeeting(int empid) {
        List<Meeting> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT m.*,mr.`roomname` AS roomname FROM meeting m,meetingroom mr WHERE meetingid IN(SELECT meetingid FROM meetingparticipants WHERE employeeid=?) AND m.`roomid`=mr.`roomid` AND m.status=1");
            ps.setInt(1, empid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int meetingid = rs.getInt("meetingid");
                String meetingname1 = rs.getString("meetingname");
                int roomid = rs.getInt("roomid");
                int reservationistid = rs.getInt("reservationistid");
                int numberofparticipants = rs.getInt("numberofparticipants");
                Timestamp starttime = rs.getTimestamp("starttime");
                Timestamp endtime = rs.getTimestamp("endtime");
                Timestamp reservationtime = rs.getTimestamp("reservationtime");
                Timestamp canceledtime = rs.getTimestamp("canceledtime");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                String roomname1 = rs.getString("roomname");
                String canceledreason = rs.getString("canceledreason");
                Meeting meeting = new Meeting(meetingid, meetingname1, roomid, reservationistid, numberofparticipants, starttime, endtime, reservationtime, canceledtime, description, status);
                meeting.setCanceledreason(canceledreason);
                meeting.setRoomname(roomname1);
                list.add(meeting);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return list;
    }

    public List<Meeting> getMyMeeting(int empid) {
        List<Meeting> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT m.*,e.`employeename`,mr.`roomname` FROM meeting m,employee e,meetingroom mr WHERE m.`meetingid` IN(SELECT mp.`meetingid` FROM meetingparticipants mp WHERE mp.`employeeid`=?) AND m.`roomid`=mr.`roomid` AND m.`reservationistid`=e.`employeeid` and m.status=0 AND m.starttime>?");
            ps.setInt(1, empid);
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            rs = ps.executeQuery();
            while (rs.next()) {
                int meetingid = rs.getInt("meetingid");
                String meetingname1 = rs.getString("meetingname");
                int roomid = rs.getInt("roomid");
                int reservationistid = rs.getInt("reservationistid");
                int numberofparticipants = rs.getInt("numberofparticipants");
                Timestamp starttime = rs.getTimestamp("starttime");
                Timestamp endtime = rs.getTimestamp("endtime");
                Timestamp reservationtime = rs.getTimestamp("reservationtime");
                Timestamp canceledtime = rs.getTimestamp("canceledtime");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                String roomname1 = rs.getString("roomname");
                String employeename = rs.getString("employeename");
                String canceledreason = rs.getString("canceledreason");
                Meeting meeting = new Meeting(meetingid, meetingname1, roomid, reservationistid, numberofparticipants, starttime, endtime, reservationtime, canceledtime, description, status);
                meeting.setCanceledreason(canceledreason);
                meeting.setRoomname(roomname1);
                meeting.setEmpname(employeename);
                list.add(meeting);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return list;
    }

    /**
     * 添加一条会议记录
     *
     * @param meeting
     * @return 返回值为插入记录的id
     */
    public int insert(Meeting meeting) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("insert into meeting (meetingname,roomid,reservationistid,numberofparticipants,starttime,endtime,reservationtime,description,status) values (?,?,?,?,?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, meeting.getMeetingname());
            ps.setInt(2, meeting.getRoomid());
            ps.setInt(3, meeting.getReservationistid());
            ps.setInt(4, meeting.getNumberofparticipants());
            ps.setTimestamp(5, meeting.getStarttime());
            ps.setTimestamp(6, meeting.getEndtime());
            ps.setTimestamp(7, meeting.getReservationtime());
            ps.setString(8, meeting.getDescription());
            ps.setInt(9, meeting.getStatus());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return -1;
    }

    public Meeting getMeetingById(int mid) {
        Meeting meeting = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("select * from meeting WHERE meetingid=?;");
            ps.setInt(1, mid);
            rs = ps.executeQuery();
            if (rs.next()) {
                int meetingid = rs.getInt("meetingid");
                String meetingname1 = rs.getString("meetingname");
                int roomid = rs.getInt("roomid");
                int reservationistid = rs.getInt("reservationistid");
                int numberofparticipants = rs.getInt("numberofparticipants");
                Timestamp starttime = rs.getTimestamp("starttime");
                Timestamp endtime = rs.getTimestamp("endtime");
                Timestamp reservationtime = rs.getTimestamp("reservationtime");
                Timestamp canceledtime = rs.getTimestamp("canceledtime");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                meeting = new Meeting(meetingid, meetingname1, roomid, reservationistid, numberofparticipants, starttime, endtime, reservationtime, canceledtime, description, status);
                return meeting;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs);
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return null;
    }

    public int cancelMeeting(int mid, String reason) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("UPDATE meeting  SET status=1,canceledtime=?,canceledreason=? WHERE meetingid=?");
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setString(2, reason);
            ps.setInt(3, mid);
            return ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return -1;
    }

    public static void main(String[] args) {
        Meeting meeting = new MeetingDao().getMeetingById(25);
        System.out.println(meeting.toString());
    }
}
