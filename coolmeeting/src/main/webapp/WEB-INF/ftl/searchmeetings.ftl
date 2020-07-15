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
                    会议预定 > 搜索会议
                </div>
                <form>
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" id="meetingname" maxlength="20"/>
                                </td>
                                <td>会议室名称：</td>
                                <td>
                                    <input type="text" id="roomname" maxlength="20"/>
                                </td>
                                <td>预定者姓名：</td>
                                <td>
                                    <input type="text" id="reservername" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预定日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="date" id="reservefromdate" placeholder="例如：2013-10-20"/>
                                    到&nbsp;<input type="date" id="reservetodate" placeholder="例如：2013-10-22"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="date" id="meetingfromdate" placeholder="例如：2013-10-20"/>
                                    到&nbsp;<input type="date" id="meetingtodate" placeholder="例如：2013-10-22"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="查询"/>
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
                            共<span class="info-number">54</span>条结果，
                            分成<span class="info-number">6</span>页显示，
                            当前第<span class="info-number">1</span>页
                        </div>
                        <div class="header-nav">
                            <input type="button" class="clickbutton" value="首页"/>
                            <input type="button" class="clickbutton" value="上页"/>
                            <input type="button" class="clickbutton" value="下页"/>
                            <input type="button" class="clickbutton" value="末页"/>
                            跳到第<input type="text" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" value="跳转"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                        </td>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                        </td>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                        </td>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                        </td>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                        </td>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                        </td>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                        </td>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
                        <td>
                            <a class="clickbutton" href="meetingdetails.ftl">查看详情</a>
                        </td>
                    </tr>
                    <tr>
                        <td>业务洽谈会</td>
                        <td>第一会议室</td>
                        <td>2013-10-12 8:00</td>
                        <td>2013-10-12 12:00</td>
                        <td>2013-10-10 16:00</td>
                        <td>Jerry</td>
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