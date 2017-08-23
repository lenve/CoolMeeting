<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
    <style type="text/css">

    </style>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="page-body">
    <jsp:include page="leftMenu.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            人员管理 > 注册审批
        </div>
        <table class="listtable">
            <caption>所有待审批注册信息：</caption>
            <tr class="listheader">
                <th>姓名</th>
                <th>账号名</th>
                <th>联系电话</th>
                <th>电子邮件</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="emp">
                <tr>
                    <td>${emp.employeename}</td>
                    <td>${emp.username}</td>
                    <td>${emp.phone}</td>
                    <td>${emp.email}</td>
                    <td>
                        <a class="clickbutton" href="/meeting/updateEmpStatus?status=1&empid=${emp.employeeid}">通过</a>
                        <a class="clickbutton" href="/meeting/updateEmpStatus?status=2&empid=${emp.employeeid}">不通过</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>