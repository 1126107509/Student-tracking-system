<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="../static/layui/layui.js"></script>
</head>
<body>
    <table class="layui-table" lay-data="{width:800, url:'getStuByTeacher?teacherId=1', page: true, limit: 10}">
        <thead>
        <tr>
            <th lay-data="{checkbox:true, fixed:'left'}" rowspan="2"></th>
            <th lay-data="{field:'stuName', width:150}" rowspan="2">姓名</th>
            <th lay-data="{field:'sex', width:150}" rowspan="2">性别</th>
            <th lay-data="{field:'university', width:150}" rowspan="2">学校</th>
            <th lay-data="{field:'birthPlace', width:150}" rowspan="2">籍贯</th>
            <th lay-data="{align:'center'}" colspan="3">地址</th>
<%--
            <th lay-data="{fixed: 'right', width: 160, align: 'center', toolbar: '#barDemo'}" rowspan="2">操作</th>
--%>
        </tr>
        <tr>
            <th lay-data="{field:'province', width:120}">省</th>
            <th lay-data="{field:'city', width:120}">市</th>
            <th lay-data="{field:'zone', width:200}">区</th>
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
