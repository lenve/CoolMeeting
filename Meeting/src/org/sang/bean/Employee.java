package org.sang.bean;

/**
 * Created by sang on 2017/8/17.
 */
public class Employee {
    private int employeeid;
    private String employeename;
    private String username;
    private String phone;
    private String email;
    private int status;
    private int departmentid;
    private String password;
    private int role;

    public Employee(String employeename, String username, String phone, String email, int departmentid, String password) {
        this.employeename = employeename;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.departmentid = departmentid;
        this.password = password;
    }

    public Employee(int employeeid, String employeename, String username, String phone, String email, int status, int departmentid, String password, int role) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.departmentid = departmentid;
        this.password = password;
        this.role = role;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
