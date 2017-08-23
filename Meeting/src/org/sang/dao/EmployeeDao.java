package org.sang.dao;

import org.sang.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sang on 2017/8/17.
 */
public class EmployeeDao {

    public int updateEmpStatusById(int id, int status) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("UPDATE employee set status=? WHERE employeeid=?");
            ps.setInt(1, status);
            ps.setInt(2, id);
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

    public List<Employee> getUnApproveaccount() {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT * FROM employee WHERE status=0 AND role =2");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt("employeeid"), rs.getString("employeename"), rs.getString("username"), rs.getString("phone"), rs.getString("email"), rs.getInt("status"), rs.getInt("departmentid"), rs.getString("password"), rs.getInt("role")));
            }
            return list;
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

    public List<Employee> getEmpByDepId(int depId) {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT * FROM employee WHERE status=1 AND departmentid=?");
            ps.setInt(1,depId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt("employeeid"), rs.getString("employeename"), rs.getString("username"), rs.getString("phone"), rs.getString("email"), rs.getInt("status"), rs.getInt("departmentid"), rs.getString("password"), rs.getInt("role")));
            }
            return list;
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

    public List<Employee> getEmpByMeetingId(int mid) {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT * FROM employee WHERE employeeid IN(SELECT employeeid FROM meetingparticipants WHERE meetingid=?)");
            ps.setInt(1,mid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt("employeeid"), rs.getString("employeename"), rs.getString("username"), rs.getString("phone"), rs.getString("email"), rs.getInt("status"), rs.getInt("departmentid"), rs.getString("password"), rs.getInt("role")));
            }
            return list;
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

    public int getCount(String employeename, String username, int status) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer("SELECT count(*) FROM employee WHERE status=? AND role =2");
        if (employeename != null && !"".equals(employeename)) {
            sb.append(" and employeename=?");
        }
        if (username != null && !"".equals(username)) {
            sb.append(" and username=?");
        }
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sb.toString());
            ps.setInt(1, status);
            int index = 2;
            if (employeename != null && !"".equals(employeename)) {
                ps.setString(index++, employeename);
            }
            if (username != null && !"".equals(username)) {
                ps.setString(index++, username);
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

    public List<Employee> searchEmp(String employeename, String username, int status, int page, int count) {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer("SELECT * FROM employee WHERE status=? AND role =2");
        if (employeename != null && !"".equals(employeename)) {
            sb.append(" and employeename=?");
        }
        if (username != null && !"".equals(username)) {
            sb.append(" and username=?");
        }
        sb.append(" limit ?,?");
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sb.toString());
            ps.setInt(1, status);
            int index = 2;
            if (employeename != null && !"".equals(employeename)) {
                ps.setString(index++, employeename);
            }
            if (username != null && !"".equals(username)) {
                ps.setString(index++, username);
            }
            ps.setInt(index++, (page - 1) * count);
            ps.setInt(index++, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt("employeeid"), rs.getString("employeename"), rs.getString("username"), rs.getString("phone"), rs.getString("email"), rs.getInt("status"), rs.getInt("departmentid"), rs.getString("password"), rs.getInt("role")));
            }
            return list;
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

    public Employee login(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT * FROM employee WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("employeeid"), rs.getString("employeename"), rs.getString("username"), rs.getString("phone"), rs.getString("email"), rs.getInt("status"), rs.getInt("departmentid"), rs.getString("password"), rs.getInt("role"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int reg(Employee employee) {
        if (isUsernameExists(employee.getUsername())) {
            return -1;
        }
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("INSERT INTO employee(employeename,username,phone,email,status,departmentid,password,role) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, employee.getEmployeename());
            ps.setString(2, employee.getUsername());
            ps.setString(3, employee.getPhone());
            ps.setString(4, employee.getEmail());
            ps.setInt(5, 0);
            ps.setInt(6, employee.getDepartmentid());
            ps.setString(7, employee.getPassword());
            ps.setInt(8, 2);
            return ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
        return 0;
    }

    public boolean isUsernameExists(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("SELECT * from employee WHERE username=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
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
        return false;
    }
}
