<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="../../static/layui/layui.js"></script>
    <link rel="stylesheet" href="../../static/css/login.css">
    <style>

    </style>
</head>
<body>

<div class="contain">
    <div class="left">
        <div class="left-body">
            <div class="circle-body">
                <img src="../../static/images/bg-circle.png" alt="" class="circle">
                <div class="font0">
                    <img src="../../static/images/zi-0.png" alt="" class="font0-img">
                </div>
                <div class="font-common ">
                    <img src="../../static/images/zi-1.png" alt="" class="font-common-img">
                </div>
                <div class="font-common ">
                    <img src="../../static/images/zi-2.png" alt="" class="font-common-img">
                </div>
                <div class="font-common ">
                    <img src="../../static/images/zi-3.png" alt="" class="font-common-img">
                </div>
                <div class="font-common ">
                    <img src="../../static/images/zi-4.png" alt="" class="font-common-img">
                </div>
                <div class="font-common ">
                    <img src="../../static/images/zi-6.png" alt="" class="font-common-img">
                </div>
                <div class="font-common ">
                    <img src="../../static/images/zi-5.png" alt="" class="font-common-img">
                </div>
            </div>


            <div class="bg1 flag">
                <div class="bg1-inner"></div>
                <img src="../../static/images/title-1.png" alt="" class="bg1-img">
            </div>
            <div class="bg2 flag ">
                <div class="bg2-inner"></div>
                <img src="../../static/images/title-2.png" alt="" class="bg2-img">
            </div>
            <div class="bg3 flag">
                <div class="bg3-inner"></div>
                <img src="../../static/images/title-3.png" alt="" class="bg3-img">
            </div>
            <div class="bg4 flag">
                <div class="bg4-inner"></div>
                <img src="../../static/images/title-4.png" alt="" class="bg4-img">
            </div>
            <div class="content">
                <dl>
                    <dt>讲做结合</dt>
                    <dd>教学由浅入深，循环渐进，讲课与动手相结合，掌握最新的开发技能</dd>
                </dl>
                <dl class="active">
                    <dt>教育培训</dt>
                    <dd>免费培训三个月，给你一个步入IT行业的机会</dd>
                </dl>

                <dl>
                    <dt>实时跟踪</dt>
                    <dd>每周考试总结，实时了解学生学习状况，查缺补漏</dd>
                </dl>
                <dl>
                    <dt>职级阶梯</dt>
                    <dd>考试面试合格，实习转正，员工职级阶梯提升</dd>
                </dl>
            </div>
        </div>

    </div>
    <div id="right">
        <div id="logo5"><img src="../../static/images/img5.png" alt=""></div>
        <div id="info">
            <form id="login" action="#" method="post">
                <table id="info_table">
                    <tr class="info_1">
                        <td><img src="../../static/images/name.png"
                                 alt="">
                            <input name="username" type="text" placeholder="请输入您的用户名"
                                   value="${cookie.ad_name.value}"
                                   style="border:none;outline: none">
                        </td>

                    </tr>
                    <tr>
                        <td class="error" id="name_err_msg">
                            <img src="../../static/images/error.png" alt=""><span
                                class="name_err_msg"></span>
                        </td>
                    </tr>
                    <tr class="info_1">
                        <td>
                            <img src="../../static/images/pwd.png"
                                 alt="">
                            <input name="password" type="password" placeholder="请输入您的密码"
                                   value="${cookie.ad_pwd.value}" style="border:none;outline: none">
                        </td>
                    </tr>
                    <tr>
                        <td class="error" id="pwd_err_msg"><img src="../../static/images/error.png" alt=""><span
                                class="pwd_err_msg"></span></td>
                    </tr>
                    <tr class="pwd">
                        <td style="padding-bottom: 5px">
                            <input type="checkbox" name="check" id="check" checked> 记住密码
                        </td>
                    </tr>
                    <tr class="sub">
                        <td>
                            <input type="button" id="submit"
                                   style="background-image: url('../../static/images/login.png' )"
                                   value=" ">
                        </td>
                    </tr>
                    <tr class="bottom">
                        <td>请使用chrome、IE10+浏览器</td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="phone">

            <div id="tel"><img src="../../static/images/tel.png" alt=""></div>

            <div id="bar">
                <ul>
                    <li><img src="../../static/images/ph.png" alt=""></li>
                    <li><img src="../../static/images/server.png" alt=""></li>
                    <li><img src="../../static/images/dl.png" alt=""></li>
                    <li><img src="../../static/images/help.png" alt=""></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script src="../../static/js/jquery.min.js"></script>
<script src="../../static/js/login.js"></script>
<script>

    layui.use(['layer', 'jquery'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        //给form绑定一个回车事件
        $('#login').keydown(function (args) {
            if (args.keyCode === 13) {
                login();
            }
        });

        $('#submit').click(function () {
            login();
        });

        function login() {
            var isCheck = $('#check').prop('checked');
            var userName = $('input[name=username]').val();
            var password = $('input[name=password]').val();
            var isSend = true;
            if ($.trim(userName) == '') {
                /*alert("用户名不能为空");*/

                $(this).parent().css('border-bottom-color', 'red');
                $('.name_err_msg').html('用户名不能为空');
                $('#name_err_msg').css('visibility', 'visible');
                isSend = false;
                $(this).select();
                return false;
            } else {
                $(this).parent().css('border-bottom-color', '#cccccc');
                $('#name_err_msg').css('visibility', 'hidden')
            }


            if ($.trim(password) == '') {
                /*alert("密码不能为空");*/
                $(this).parent().css('border-bottom-color', 'red');
                $('.pwd_err_msg').html('密码不能为空');
                $('#pwd_err_msg').css('visibility', 'visible')
                $(this).select();
                return false;
            } else if (password.length < 4) {
                /*  alert("密码长度最低4位");*/
                $(this).parent().css('border-bottom-color', 'red');
                $('.pwd_err_msg').html('密码长度最低4位');
                $('#pwd_err_msg').css('visibility', 'visible');
                isSend = false;
                $(this).select();
                return false;
            } else {
                $('#pwd_err_msg').css('visibility', 'hidden');
                $(this).parent().css('border-bottom-color', '#cccccc');
            }

            if (isSend) {
                $.ajax({
                    url: '/loginCheck',
                    type: 'post',
                    data: {
                        'userName': userName,
                        'password': password,
                        'isCheck': isCheck
                    },
                    success: function (data) {
                        location.href = "loginJudge/" + data;
                    },
                    error: function () {
                        layer.msg("账号或密码错误.....")
                    }
                })
            }


        }
    })
</script>
</body>
</html>