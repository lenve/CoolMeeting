package org.sang.bean;

/**
 * Created by sang on 2017/8/18.
 */
public class MeetingRoom {
    private int roomid;
    private int roomnum;
    private String roomname;
    private int capacity;
    private int status;
    private String description;

    public MeetingRoom() {
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "roomid=" + roomid +
                ", roomnum=" + roomnum +
                ", roomname='" + roomname + '\'' +
                ", capacity=" + capacity +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }

    public MeetingRoom(int roomnum, String roomname, int capacity, int status, String description) {
        this.roomnum = roomnum;
        this.roomname = roomname;
        this.capacity = capacity;
        this.status = status;
        this.description = description;
    }

    public MeetingRoom(int roomid, int roomnum, String roomname, int capacity, int status, String description) {
        this.roomid = roomid;
        this.roomnum = roomnum;
        this.roomname = roomname;
        this.capacity = capacity;
        this.status = status;
        this.description = description;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
