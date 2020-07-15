package org.javaboy.meeting.controller;

import org.javaboy.meeting.model.Department;
import org.javaboy.meeting.model.Employee;
import org.javaboy.meeting.model.Meeting;
import org.javaboy.meeting.service.DepartmentService;
import org.javaboy.meeting.service.EmployeeService;
import org.javaboy.meeting.service.MeetingRoomService;
import org.javaboy.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨 ssm coolmeeting
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@Controller
public class MeetingController {
    @Autowired
    MeetingRoomService meetingRoomService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @Autowired
    MeetingService meetingService;
    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model) {
        model.addAttribute("mrs", meetingRoomService.getAllMr());
        return "bookmeeting";
    }

    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> getAllDeps() {
        return departmentService.getAllDeps();
    }

    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getEmpsByDepId(Integer depId) {
        return employeeService.getEmpsByDepId(depId);
    }

    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting, Integer[] mps, HttpSession session) {
        Employee currentuser = (Employee) session.getAttribute("currentuser");
        meeting.setReservationistid(currentuser.getEmployeeid());
        Integer result = meetingService.addMeeting(meeting,mps);
        if (result == 1) {
            return "redirect:/searchmeetings";
        }else{
            return "forward:/bookmeeting";
        }
    }
    @RequestMapping("/searchmeetings")
    public String searchmeetings() {
        return "searchmeetings";
    }
}
