
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>信息管理系统界面</title>
</head>
<body>
    <table>
        <tr>
            <th>
                编号
            </th>
            <th>
                姓名
            </th>
            <th>
                账户
            </th>
            <th>
                邮箱
            </th>
        </tr>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>
                ${user.userId}
                </td>
                <td>
                ${user.userName}
                </td>
                <td>
                ${user.realName}
                </td>
                <td>
                ${user.email}
                </td>
            </tr>
        </c:forEach>

    </table>
    ${list}
</body>
</html>
