<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/styles/common.css"/>
</head>
<body>
<#include 'top.ftl'>
<div class="page-body">
    <#include 'leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            个人中心 > <a href="notifications">最新通知</a>
        </div>
        <table class="listtable">
            <caption>
                未来7天我要参加的会议:
            </caption>
            <tr class="listheader">
                <th style="width:300px">会议名称</th>
                <th>会议室</th>
                <th>起始时间</th>
                <th>结束时间</th>
                <th style="width:100px">操作</th>
            </tr>
            <tr>
                <td>三季度销售总结会</td>
                <td>第一会议室</td>
                <td>2013-11-20 9：00</td>
                <td>2013-11-20 11：00</td>
                <td>
                    <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                </td>
            </tr>
            <tr>
                <td>与Google合作推广Android技术培训会议</td>
                <td>第三会议室</td>
                <td>2013-11-18 9：00</td>
                <td>2013-11-18 11：00</td>
                <td>
                    <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                </td>
            </tr>
            <tr>
                <td>员工例行面谈</td>
                <td>小会议室</td>
                <td>2013-11-16 16：00</td>
                <td>2013-11-16 17：00</td>
                <td>
                    <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                </td>
            </tr>
        </table>
        <table class="listtable">
            <caption>
                已取消的会议:
            </caption>
            <tr class="listheader">
                <th style="width:300px">会议名称</th>
                <th>会议室</th>
                <th>起始时间</th>
                <th>结束时间</th>
                <th>取消原因</th>
                <th style="width:100px">操作</th>
            </tr>
            <tr>
                <td>三季度销售总结会</td>
                <td>第一会议室</td>
                <td>2013-11-20 9：00</td>
                <td>2013-11-20 11：00</td>
                <td>人员出差</td>
                <td>
                    <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                </td>
            </tr>
            <tr>
                <td>与Google合作推广Android技术培训会议</td>
                <td>第三会议室</td>
                <td>2013-11-18 9：00</td>
                <td>2013-11-18 11：00</td>
                <td>人员出差</td>
                <td>
                    <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                </td>
            </tr>
            <tr>
                <td>员工例行面谈</td>
                <td>小会议室</td>
                <td>2013-11-16 16：00</td>
                <td>2013-11-16 17：00</td>
                <td>人员出差</td>
                <td>
                    <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                </td>
            </tr>
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