<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-header">
    <div class="header-banner">
        <img src="images/header.png" alt="CoolMeeting"/>
    </div>
    <div class="header-title">
        欢迎访问Cool-Meeting会议管理系统
    </div>
    <div class="header-quicklink">
        欢迎您<strong><c:if test="${loginUser!=null}">,${loginUser.employeename}</c:if></strong>
        <a href="changepassword.html">[修改密码]</a>
    </div>
</div>
