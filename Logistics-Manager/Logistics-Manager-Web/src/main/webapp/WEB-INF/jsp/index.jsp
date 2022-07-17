
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
    </ul>
</div>

<div class="mainindex">


    <div class="welinfo">
        <span><img src="images/sun.png" alt="天气" /></span>
        <b><span style="font-size: 13px" ><shiro:authenticated>
            你好：<font style="color: #1c77ac;font-size: 13px"><shiro:principal property="realName"/>
        </shiro:authenticated></font>，欢迎登录系统
        </span >
        </b>
    </div>

    <div class="welinfo">
        <span ><img src="images/time.png" alt="当前时间：" /></span><label id="lb1"></label>
        <script>setInterval(
            function (){
                var date = new Date();
                year = date.getFullYear()+'年';
                month = date.getMonth()+1+'月';
                day = date.getDate()+'日';
                hours = date.getHours();
                minutes = date.getMinutes();
                seconds = date.getSeconds();
                document.getElementById("lb1").innerHTML=year+month+day+"&nbsp;"+"&nbsp;"+hours
                    +":"+minutes+":"+seconds},
            1000)
        </script>
    </div>

    <div class="xline"></div>

    <ul class="iconlist">

        <li><img src="images/ico01.png" /><p><a href="#">管理设置</a></p></li>
        <li><img src="images/ico02.png" /><p><a href="#">新增订单</a></p></li>
        <li><img src="images/ico03.png" /><p><a href="#">订单统计</a></p></li>
        <li><img src="images/ico04.png" /><p><a href="#">报表上传</a></p></li>
        <li><img src="images/ico05.png" /><p><a href="#">目录管理</a></p></li>
        <li><img src="images/ico06.png" /><p><a href="#">快速查找</a></p></li>

    </ul>

    <div class="ibox"><a class="ibtn"><img src="images/iadd.png" />添加新的快捷功能</a></div>

    <div class="xline"></div>
    <div class="box"></div>

    <div class="welinfo">
        <span><img src="images/dp.png" alt="提醒" /></span>
        <b>系统快速入门</b>
    </div>

    <ul class="infolist">
        <li><span>您可以快速新增订单或客户：</span><a class="ibtn"style="margin-left: 69px">新增订单或管理客户</a></li>
        <li><span>您可以快速查看或更新订单：</span><a class="ibtn"style="margin-left: 69px">查询或更新订单</a></li>
        <li><span>您可以进行密码修改、账户设置等操作：</span><a class="ibtn"style="margin-left: 13px">账户管理</a></li>
    </ul>

    <div class="xline"></div>

    <ul class="umlist">
        <li><a href="#">如何新增客户</a></li>
        <li><a href="#">如何快速录单</a></li>
        <li><a href="#">如何查看订单</a></li>
        <li><a href="#">后台用户设置(权限)</a></li>
        <li><a href="#">用户指南</a></li>
    </ul>


</div>



<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

