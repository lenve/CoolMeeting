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
            会议预定 > 搜索员工
        </div>
        <form action="/meeting/serachemp" method="post">
            <fieldset>
                <legend>搜索会议</legend>
                <table class="formtable">
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input type="text" id="employeename" name="employeename" value="${employeename}"
                                   maxlength="20"/>
                        </td>
                        <td>账号名：</td>
                        <td>
                            <input type="text" id="accountname" name="username" value="${username}" maxlength="20"/>
                        </td>
                        <td>状态：</td>
                        <td>
                            <c:choose>
                                <c:when test="${status==0}">
                                    <input type="radio" id="status" name="status" value="1"
                                    /><label>已批准</label>
                                    <input checked="checked" type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="-1"/><label>已关闭</label>
                                </c:when>
                                <c:when test="${status==1}">
                                    <input type="radio" checked="checked" id="status" name="status" value="1"
                                    /><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="-1"/><label>已关闭</label>
                                </c:when>
                                <c:when test="${status==-1}">
                                    <input type="radio" id="status" name="status" value="1"
                                    /><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" checked="checked" id="status" name="status" value="-1"/><label>已关闭</label>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="command">
                            <input type="submit" class="clickbutton" value="查询"/>
                            <input type="reset" class="clickbutton" value="重置"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        <div>
            <h3 style="text-align:center;color:black">查询结果</h3>
            <div class="pager-header">
                <div class="header-info">
                    共<span class="info-number">${totalCount}</span>条结果，
                    分成<span class="info-number">${totalPage}</span>页显示，
                    当前第<span class="info-number">${page}</span>页
                </div>
                <div class="header-nav">
                    <a type="button" class="clickbutton"
                       href="/meeting/serachemp?page=1&status=${status}&employeename=${employeename}&username=${username}">首页</a>
                    <c:choose>
                        <c:when test="${page>1}">
                            <a type="button" class="clickbutton"
                               href="/meeting/serachemp?page=${page-1}&status=${status}&employeename=${employeename}&username=${username}">上页</a>
                        </c:when>
                        <c:otherwise>
                            上页
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page<totalPage}">
                            <a type="button" class="clickbutton"
                               href="/meeting/serachemp?page=${page+1}&status=${status}&employeename=${employeename}&username=${username}">下页</a>
                        </c:when>
                        <c:otherwise>
                            下页
                        </c:otherwise>
                    </c:choose>
                    <a type="button" class="clickbutton"
                       href="/meeting/serachemp?page=${totalPage}&status=${status}&employeename=${employeename}&username=${username}">末页</a>
                    <form action="/meeting/serachemp" method="post" style="display: inline">
                        <input type="hidden" name="employeename" value="${employeename}">
                        <input type="hidden" name="username" value="${username}">
                        <input type="hidden" name="status" value="${status}">
                        跳到第<input type="text" id="pagenum" name="page" class="nav-number"/>页
                        <input type="submit" class="clickbutton" value="跳转"/>
                    </form>
                </div>
            </div>
        </div>
        <table class="listtable">
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
                        <form method="post" action="/meeting/serachemp">
                            <input type="hidden" name="employeename" value="${employeename}">
                            <input type="hidden" name="username" value="${username}">
                            <input type="hidden" name="status" value="${status}">
                            <input type="hidden" name="updateStatus" value="-1">
                            <input type="hidden" name="empid" value="${emp.employeeid}">
                            <input class="clickbutton" value="关闭账号" type="submit"></input>
                        </form>
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
