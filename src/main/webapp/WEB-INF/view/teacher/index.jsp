<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师首页</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
    <ul class="layui-nav">
        <li class="layui-nav-item">
            <a href="/studentList" target="main_iframe">学员信息</a>
        </li>
        <li class="layui-nav-item">
            <a href="/teacherInfo" target="main_iframe">个人中心</a>
        </li>
        <li class="layui-nav-item" lay-unselect="">
            <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
            <dl class="layui-nav-child">
                <dd><a href="javascript:;">修改信息</a></dd>
                <dd><a href="javascript:;">安全管理</a></dd>
                <dd><a href="javascript:;">退出</a></dd>
            </dl>
        </li>
    </ul>
    <iframe src="/studentList" name="main_iframe" frameborder="0" height="90%" width="100%"></iframe>
    <script>
        layui.use('element', function(){
            var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

            //监听导航点击
            element.on('nav(demo)', function(elem){
                //console.log(elem)
                layer.msg(elem.text());
            });
        });
    </script>
</body>
</html>
