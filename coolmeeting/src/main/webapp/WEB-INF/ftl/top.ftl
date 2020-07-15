<div class="page-header">
    <div class="header-banner">
        <img src="/images/header.png" alt="CoolMeeting"/>
    </div>
    <div class="header-title">
        欢迎访问Cool-Meeting会议管理系统
    </div>
    <div class="header-quicklink">
        欢迎您，
        <#if currentuser??>
            <strong>${currentuser.employeename!''}</strong>
        </#if>
        <a href="changepassword.ftl">[修改密码]</a>
    </div>
</div>