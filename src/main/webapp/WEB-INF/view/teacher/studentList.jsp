<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
    <table class="layui-table" lay-data="{width:1300, url:'getStuByTeacher?teacherId=1', page: true, limit: 10, limits:[10,20,30,40,50]}">
        <thead>
        <tr>
            <th lay-data="{checkbox:true, fixed:'left'}" rowspan="2"></th>
            <th lay-data="{field:'stuName', width:80}" rowspan="2">姓名</th>
            <th lay-data="{field:'sex', width:80}" rowspan="2">性别</th>
            <th lay-data="{field:'university', width:150}" rowspan="2">学校</th>
            <th lay-data="{field:'birthPlace', width:80}" rowspan="2">籍贯</th>
            <th colspan="6">培训期间测试成绩</th>
        </tr>
        <tr>
            <c:forEach var="course" items="${sessionScope.courseList}">
                <th lay-data="{field:'scoreList', width:120}">
                        ${course.courseName}
                </th>
            </c:forEach>
        </tr>
        </thead>
    </table>
    <script>
        layui.use('table', function(){
            var table = layui.table;
        });
    </script>
</body>
</html>
