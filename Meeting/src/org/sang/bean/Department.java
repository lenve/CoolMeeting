package org.sang.bean;

/**
 * Created by sang on 2017/8/17.
 */
public class Department {
    private int departmentid;
    private String departmentname;

    public Department() {
    }

    public Department(int departmentid, String departmentname) {
        this.departmentid = departmentid;
        this.departmentname = departmentname;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }//departmentName

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}
