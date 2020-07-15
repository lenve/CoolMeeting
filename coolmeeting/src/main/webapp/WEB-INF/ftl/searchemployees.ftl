<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/styles/common.css"/>
    <style type="text/css">

    </style>
</head>
<body>
<#include 'top.ftl'>
<div class="page-body">
    <#include 'leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            会议预定 > 搜索员工
        </div>
        <form action="/admin/searchemployees" method="get">
            <fieldset>
                <legend>搜索会议</legend>
                <table class="formtable">
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input name="employeename" type="text" id="employeename"
                                   value="<#if employee??>${employee.employeename!''}</#if>" maxlength="20"/>
                        </td>
                        <td>账号名：</td>
                        <td>
                            <input name="username" type="text" id="accountname"
                                   value="<#if employee??>${employee.username!''}</#if>" maxlength="20"/>
                        </td>
                        <td>状态：</td>
                        <td>
                            <#if employee??>
                                <#if employee.status==0>
                                    <input type="radio" id="status" name="status" value="1"/><label>已批准</label>
                                    <input checked="checked" type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                <#elseif employee.status==1>
                                    <input checked="checked" type="radio" id="status" name="status" value="1"/><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                <#elseif employee.status==2>
                                    <input type="radio" id="status" name="status" value="1"/><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input checked="checked" type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                </#if>
                            <#else>
                                <input type="radio" id="status" name="status" value="1"
                                       checked="checked"/><label>已批准</label>
                                <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                            </#if>
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
                    共<span class="info-number">${total}</span>条结果，
                    分成<span class="info-number">${pagenum}</span>页显示，
                    当前第<span class="info-number">${page}</span>页
                </div>
                <div class="header-nav">
                    <input type="button" class="clickbutton" value="首页"/>
                    <input type="button" class="clickbutton" value="上页"/>
                    <input type="button" class="clickbutton" value="下页"/>
                    <input type="button" class="clickbutton" value="末页"/>
                    <form action="/admin/searchemployees" style="display: inline" method="get">
                        跳到第<input name="page" type="text" id="pagenum" class="nav-number"/>页
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
            <#if emps??>
                <#list emps as emp>
                    <tr>
                        <td>${emp.employeename}</td>
                        <td>${emp.username}</td>
                        <td>${emp.phone}</td>
                        <td>${emp.email}</td>
                        <td>
                            <a class="clickbutton" href="/admin/updateemp?id=${emp.employeeid}">关闭账号</a>
                        </td>
                    </tr>
                </#list>
            </#if>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="/images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>