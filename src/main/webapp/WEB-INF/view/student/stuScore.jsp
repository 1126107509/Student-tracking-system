<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/21
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生展示页面</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
    <script src="../../static/layui/layui.js"></script>
</head>
<body>
    <div>
        <table class="layui-table" lay-even lay-skin="nob">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead align="center">
                <tr>
                    <th colspan>科目</th>
                    <th colspan>成绩</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.stuScore}" var="map">
                    <tr>
                        <td>${map.courseName}</td>
                        <td>${map.score}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</body>
<script>
    layui.use('table', function(){
        var table = layui.table;
    });
</script>
</html>
