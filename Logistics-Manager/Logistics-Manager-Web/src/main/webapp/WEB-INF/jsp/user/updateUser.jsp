
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript"src="/js/jquery.js"></script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">表单</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>添加用户</span></div>
    <form action="/user/saveOrUpdate" method="post">
    <ul class="forminfo">
        <input type="hidden" name="user.userId" class="dfinput" id="userId">
        <li><label>账号</label><input name="user.userName" type="text" class="dfinput" id="username"
                                    value=""/><i id="userNameI"></i></li>
        <li><label>密码</label><input name="user.password" type="text" class="dfinput" value=""/><i></i></li>
        <li><label>姓名</label><input name="user.realName" type="text" class="dfinput" value=""/><i></i></li>
        <li><label>邮箱</label><input name="user.email" type="text" class="dfinput" value=""/><i></i></li>
        <li><label>电话</label><input name="user.phone" type="text" class="dfinput" value=""/><i></i></li>
        <li><label>角色</label>
            <div style="height: 38px;line-height: 38px;font-size: 13px" >
            <c:forEach items="${roleList}" var="roles">
                <input type="checkbox" name="roleIds" value="${roles.roleId}"> ${roles.roleName}
                &nbsp;&nbsp;
            </c:forEach>
            <i></i>
            </div>
        </li>


        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
<script >
    $(function (){
        $("#username").blur(function (){
           //获取输入框内容
            var obj = $(this).val();
            //客户端校验
            if(obj != null && obj.length>=3 && obj.length <= 10){
                //满足账号的规则，再判断是否存在相同的数据
                $.get("/user/checkUserName", {userName: obj}, function(msg){
                        if(msg == "1"){
                            $("#userNameI").html("<span style='color:blue'>账号可用</span>")
                        }else {
                            $("#userNameI").html("<span style='color:red'>账号已存在</span>")
                        }
                });
            }else {
                alert("账号的长度必须是3-10位")
            }

        });
    });
</script>
</div>


<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
