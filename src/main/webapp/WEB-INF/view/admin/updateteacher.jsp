<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="utf-8">
    <title>更改教师信息</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../static/css/admin/add.css">
    <style>
        .marginr {
            margin-right: 9%;
            margin-left: -3%;
        }

        body {
            height: 560px;
        }

        #demo1 {
            width: 113px;
            height: 140px;
        }

        .marginl {
            margin-left: 141px;
        }

        #main {
            margin-left: 250px;
        }

        .layui-upload-list {
            /*display: none;*/
        }

        .item-label:before {
            display: inline-block;
            margin-right: 4px;
            content: "*";
            font-family: SimSun;
            color: red;
        }


        #main .warn {
            border-color: red !important;
        }

    </style>
</head>
<body>
<div id="contain">
    <div id="headline">
        <p>教师信息修改</p>
    </div>
    <div id="main">
        <form class="layui-form">
            <input type="hidden" name="teacherId" value="${teacher.teacherId}">

            <div class="layui-form-item mywidth2">
                <label class="layui-form-label font item-label">姓名</label>
                <div class="layui-input-block ">
                    <input type="text" name="tname" placeholder="请输入教师姓名" autocomplete="off"
                           value="${teacher.tname}" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" value="男"
                           title="男" ${teacher.sex == "男"?"checked":""}>
                    <input type="radio" name="sex" value="女"
                           title="女" ${teacher.sex == "女"?"checked":""}>
                </div>
            </div>
            <div class="layui-form-item mywidth31">
                <label class="layui-form-label font item-label">电话</label>
                <div class="layui-input-block">
                    <input type="text" name="phone" placeholder="请输入联系方式" autocomplete="off"
                           value="${teacher.phone}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item mywidth31">
                <label class="layui-form-label font item-label">身份证</label>
                <div class="layui-input-block">
                    <input type="text" name="idCard" placeholder="请输入身份证号" autocomplete="off"
                           value="${teacher.idCard}" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item mywidth3">
                <label class="layui-form-label">出生年月</label>
                <div class="layui-input-block">
                    <input type="text" name="birthday" id="birthday" lay-verify="date"
                           value="${teacher.birthday}" placeholder="yyyy-MM-dd" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <input type="hidden" name="photo" id="photo" value="${teacher.photo}">
            <div class="layui-form-item marginl">
                <button type="button" class="layui-btn layui-btn-warm" id="test7"><i
                        class="layui-icon"></i>选择头像
                </button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="demo1"
                         src='../../../static/${teacher.photo == null?"img/default.png":teacher.photo}'>
                    <p id="demoText"></p>
                </div>

            </div>
            <div class="layui-form-item margin1">
                <div class="layui-input-block">
                    <button type="button"
                            class="layui-btn layui-btn-radius layui-btn-normal marginr" lay-submit
                            id="submit">&nbsp;&nbsp;修&nbsp;&nbsp;&nbsp;&nbsp;改&nbsp;&nbsp;
                    </button>
                    <button type="button" class="layui-btn layui-btn-radius layui-btn-danger"
                            lay-reset
                            id="back">&nbsp;&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;&nbsp;
                    </button>
                </div>
            </div>
        </form>

    </div>
</div>
<script src="../../../static/layui/layui.all.js"></script>
<script src="../../../static/js/jquery.min.js"></script>
<script src="../../../static/js/admin/verify.js"></script>
<script>


    var ele = window.parent.document.getElementById('parent');
    var parentHeight = $(ele).css('height');
    var currentHeight = $('body').css('height');
    if (currentHeight > parentHeight) {
        $(ele).prop('scrolling', 'yes');
    }

    layui.use(['upload', 'jquery', 'laydate'], function () {
        var $ = layui.jquery;
        var upload = layui.upload;
        var laydate = layui.laydate;
        laydate.render({
            elem: '#birthday',
            trigger: 'click'
        })


        $('#submit').click(function () {
            var tname = $('input[name=tname]').val();
            var idCard = $('input[name=idCard]').val();
            var phone = $('input[name=phone]').val();

            if (tname != '' && idCard != '' && phone != '') {
                $.ajax({
                    url: "/udttea",
                    type: 'post',
                    dataType: 'json',
                    data: {
                        'teacherId': $('input[name=teacherId]').val(),
                        'tname': $('input[name=tname]').val(),
                        'sex': $('input[type=radio]:checked').val(),
                        'birthday': $('input[name=birthday]').val(),
                        'idCard': $('input[name=idCard]').val(),
                        'phone': $('input[name=phone]').val(),
                        'photo': $('#photo').val(),
                    },
                    success: function (data) {
                        if (data.flag) {
                            layer.msg("教师信息修改成功，一秒后刷新页面..");
                            setTimeout("location.href='/teacher'", 1000);
                        } else {
                            layer.msg("教师信息修改失败，稍后再试..");
                        }

                    }
                })
            }
        })


        $('#back').click(function () {

            var imgpath = $('#photo').val();
            if (imgpath != '') {
                $.ajax({
                    url: "/delimg",
                    type: 'post',
                    dataType: 'json',
                    data: {
                        'photo': $('#photo').val(),
                    },
                    success: function (data) {
                        console.log(data)
                    }
                })
            }
            history.go(-1);

        })


        upload.render({
            elem: '#test7'
            , url: '/saveimg' //改成您自己的上传接口
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('.layui-upload-list').show()
                    $('#demo1').attr('src', result);
                });
            }
            , done: function (res) {
                $('#photo').val(res.img)
            }
        });


    });

    /* $(function () {
         layui.use('form', function () {
             var form = layui.form;
             form.render();
         })
     })*/


</script>
</body>
</html>