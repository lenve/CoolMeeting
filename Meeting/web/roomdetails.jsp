<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="page-body">
    <jsp:include page="leftMenu.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            会议预定 > 修改会议室信息
        </div>
        <form action="/meeting/addmr" method="post">
            <fieldset>
                <legend>会议室信息</legend>
                <table class="formtable">
                    <tr>
                        <td>门牌号:</td>
                        <td>
                            <input name="roomid" value="${mr.roomid}" type="hidden">
                            <input id="roomnumber" name="roomnum" type="text" value="${mr.roomnum}" maxlength="10"/>
                        </td>
                    </tr>
                    <tr>
                        <td>会议室名称:</td>
                        <td>
                            <input id="capacity" type="text" name="roomname" value="${mr.roomname}" maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>最多容纳人数：</td>
                        <td>
                            <input id="roomcapacity" type="text" name="capacity" value="${mr.capacity}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>当前状态：</td>
                        <td>
                            <c:choose>
                                <c:when test="${mr.status==0}">
                                    <input type="radio" id="status" name="status" checked="checked" value="0"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status" value="1"/><label for="status"
                                                                                          value="0">停用</label>
                                </c:when>
                                <c:otherwise>
                                    <input type="radio" id="status" name="status" value="0"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status" checked="checked" value="1"/><label for="status"
                                                                                                    value="0">停用</label>
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>
                    <tr>
                        <td>备注：</td>
                        <td>
                            <textarea id="description" maxlength="200" rows="5" name="description" cols="60">${mr.description}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="command">
                            <input type="submit" value="确认修改" class="clickbutton"/>
                            <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>
