<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="/user/testListAndMap">
    <table align="center">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userInfos[0].username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="userInfos[0].password"></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="userInfos[0].user.name"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="userInfos[0].user.age"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="userInfos[0].user.gender" value="男">男</td>
            <td><input type="radio" name="userInfos[0].user.gender" value="女" checked>女</td>
        </tr>
        <tr>
            <td>信息</td>
            <td><input type="text" name="userInfos[0].user.info"></td>
        </tr>
        <tr>
            <td>日期</td>
            <td><input type="date" name="userInfos[0].user.birthday"></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="reset" value="重置">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>