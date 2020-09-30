<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>金桥工程学员跟踪系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../../static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../static/css/admin/admin.css" media="all">
    <script src="../../../static/layui/layui.js"></script>
    <link rel="stylesheet" href="../../../static/css/admin/myindex.css">

    <style>

        .item-label:before {
            display: inline-block;
            margin-right: 4px;
            content: "*";
            font-family: SimSun;
            color: red;
        }

        #mainright .warn {
            border-color: red !important;
        }

        .cur-layadmin-iframe {
            position: absolute;
            width: 100%;
            height: 580px;
            left: 0;
            top: 0;
            right: 0;
            bottom: 0;
        }

        #mainright {
            width: 300px;
            height: 300px;
            position: fixed;
            z-index: 99999999999;
            right: -34%;
        }

        #rightbody {
            padding-left: 88px;
            padding-top: 15px;
        }

        .buttonleft {
            margin-left: -37px;
            margin-top: 10px;
        }

        .error {
            width: 17px;
            height: 17px;
            margin-left: 65px;
            text-align: center;
        }

        .reerror, .olderror, .confirm {
            margin: 5px auto;
            visibility: hidden;
        }

        .reerror .errfont, .olderror .errfont, .confirm .errfont {
            color: red;
            width: 280px;
        }

        .height1 {
            height: 8px;
        }
    </style>
</head>
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">


                <li class="layui-nav-item" id="time">
                    <a>
                    </a>

                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="../../../static/images/head3.jpg" class="layui-nav-img">
                        ${user.userName}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="JavaScript:;" id="alter">修改密码</a></dd>
                        <dd><a href="JavaScript:;" id="exit">退出系统</a></dd>
                    </dl>
                </li>

            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div id="img">
                    <div>
                        <img src="../../../static/images/head3.jpg" alt="">
                    </div>
                    <div class="welcome"><span>欢迎使用金桥学员跟踪系统</span></div>
                </div>
                <div class="layui-logo" lay-href="" id="logo">
                    <i class="layui-icon layui-icon-home home"></i>
                </div>

                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu"
                    lay-filter="layadmin-system-side-menu">
                </ul>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev"
                 layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next"
                 layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a>
                            </dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a>
                            </dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a>
                            </dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true"
                 lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this">
                        <i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>


        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <div class="layui-fluid">
                    <div class="layui-card">
                        <div class="layui-card-body">
                            <iframe src="/teacher" frameborder="0"
                                    class="cur-layadmin-iframe"></iframe>
                        </div>
                    </div>
                </div>


            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
        <div id="mainright">
            <div id="rightbody">
                <div class="layui-form layui-form-pane" id="info">
                    <input type="hidden" name="userId" id="userId" value="${user.userId}">
                    <div class="layui-form-item">
                        <label class="layui-form-label item-label">原密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="oldPwd" id="oldPwd" required
                                   lay-verify="required" placeholder="输入原始密码"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item olderror">
                        <div class="layui-input-inline errfont">
                            <img src="../../../static/images/error.png" class="error" alt="">
                            原始密码不正确，请重新输入
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label item-label">新密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="newPwd" id="newPwd" required
                                   lay-verify="required" placeholder="输入新密码"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item height1">
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label item-label">确认密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="rePwd" id="rePwd" required
                                   lay-verify="required" placeholder="再次输入新密码"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item reerror">
                        <div class="layui-input-inline errfont">
                            <img src="../../../static/images/error.png" class="error" alt="">
                            输入的两次密码不一致
                        </div>
                    </div>
                    <div class="layui-form-item buttonleft">
                        <div class="layui-input-block">
                            <button type="button"
                                    class="layui-btn layui-btn-radius layui-btn-normal"
                                    id="alterPwd" lay-submit lay-filter="formDemo">
                                &nbsp;修&nbsp;改&nbsp;
                            </button>
                            <button type="button"
                                    id="cancle" class="layui-btn layui-btn-radius layui-btn-danger">
                                &nbsp;取&nbsp;消&nbsp;
                            </button>
                        </div>
                    </div>
                    <div class="layui-form-item confirm">
                        <div class="layui-input-inline errfont">
                            <img src="../../../static/images/error.png" class="error" alt="">
                            请您全部输入后点击提交
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../../static/js/jquery.min.js"></script>
<script src="../../../static/js/myindex2.js"></script>

<script>
    function getTime() {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        if (month < 10) {
            month = '0' + month;
        }
        var day = date.getDate();
        if (day < 10) {
            day = '0' + day;
        }
        var hours = date.getHours();
        if (hours < 10) {
            hours = '0' + hours;
        }
        var minutes = date.getMinutes();
        if (minutes < 10) {
            minutes = '0' + minutes;
        }
        var seconds = date.getSeconds();
        if (seconds < 10) {
            seconds = '0' + seconds;
        }
        var str = year + '/' + month + '/' + day + ' ' + hours + ':' + minutes + ':' + seconds;
        $('#time a').html(str)
    }

    getTime()
    setInterval(getTime, 1000);

    $('#LAY_app_flexible').click(function () {
        $('.home').toggleClass('home-actice');

        if ($('.layadmin-side-shrink').length == 1) {
            $('#img').show()
            $('#logo').hide()

        } else {
            $('#img').hide()
            $('#logo').show()
        }
    })

    layui.use(['layer', 'jquery'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        $('#exit').click(function () {
            $.ajax({
                url: '/exit',
                success: function (data) {
                    layer.msg(data);
                    setTimeout('location.href="/"', 1500);
                }
            })
        });
        var curindex = '';
        $('#alter').click(function () {
            curindex = layer.open({
                type: 1,
                title: '修改密码',
                content: $('#rightbody'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                area: ['480px', '400px'],
                offset: ['150px', '450px']
            });
        });


        /*以下是修改密码*/

        var isAlter = true;
        $('#oldPwd').blur(function () {
            var pwd = $(this).val();
            if (pwd != '${user.pwd}') {
                $(this).select().addClass('warn');
                $('.olderror').css('visibility', 'visible');
                isAlter = false;
            } else {
                $('.olderror').css('visibility', 'hidden');
                $(this).removeClass('warn');
                isAlter = true;
            }
        })
        $('#rePwd').blur(function () {
            var repwd = $(this).val();
            var newPwd = $('#newPwd').val();
            if (newPwd != repwd) {
                $(this).select().addClass('warn');
                $('#newPwd').select().addClass('warn');
                $('.reerror').css('visibility', 'visible')
                isAlter = false;
            } else {
                $(this).removeClass('warn');
                $('#newPwd').removeClass('warn');
                $('.reerror').css('visibility', 'hidden');
                isAlter = true;
            }
        })

        $('#alterPwd').click(function () {
            var oldPwd = $('#oldPwd').val();
            var newPwd = $('#newPwd').val();
            var rePwd = $('#rePwd').val();
            var userId = $('#userId').val();
            var msg = '';
            if (oldPwd != '' && newPwd != '' && rePwd != '') {
                $('.confirm').css('visibility', 'hidden');
                $.ajax({
                    url: '/alter',
                    method: 'post',
                    data: {
                        'pwd': newPwd,
                        'userId': userId
                    },
                    success: function (data) {
                        layer.close(curindex);
                        layer.msg(data)
                    }
                })

            } else {
                $('.confirm').css('visibility', 'visible');
            }


        })


        $('#cancle').click(function () {
            layer.close(layer.index);
        })

    })

</script>
<script>
    layui.config({
        base: '../../../static/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');
</script>
</body>
</html>


