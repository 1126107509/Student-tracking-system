<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>修改学生信息</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../../static/css/admin/add.css">
    <style>
        .marginr {
            margin-right: 9%;
            margin-left: -3%;
        }

        body {
            /* height: 560px;*/
        }

        #demo1 {
            padding-left: 35px;
            display: block;
            width: 113px;
            height: 140px;
            /* background-color: #93D1FF;*/
            padding-bottom: 18px;
            cursor: pointer;
        }
        #test7{
            width: 113px;
            height: 140px;
        }

        .marginl {
            margin-left: 141px;
        }

        #main {
            margin-left: 190px;
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

        .layui-form-item .layui-input-inline {
            width: 208px;
        }

        .layui-form-label {
            font-size: 15px;
        }

        .text-width {
            width: 461px;
        }

        .pd-top {
            padding-top: 50px;
        }
    </style>
</head>
<body>
<div class="layui-fluid pd-top">
    <div class="layui-card">
        <div class="layui-card-body ">
            <div id="contain">
                <div id="main">
                    <form method="post" action="" class="layui-form layui-form-pane" id="form">
                        <input type="hidden" name="stuId" value="${student.stuId}">

                        <table>
                            <tr>
                                <td>
                                    <div class="layui-form-item mywidth2">
                                        <label class="layui-form-label font item-label">姓名</label>
                                        <div class="layui-input-block ">
                                            <input type="text" name="stuName" placeholder="请输入学生姓名"
                                                   autocomplete="off"
                                                   value="${student.stuName}" class="layui-input ">
                                        </div>
                                    </div>
                                    <div class="layui-form-item mywidth2" pane>
                                        <label class="layui-form-label ">性别</label>
                                        <div class="layui-input-block">
                                            <input type="radio" name="sex" value="男"
                                                   title="男" ${student.sex == "男"?"checked":""}>
                                            <input type="radio" name="sex" value="女"
                                                   title="女" ${student.sex == "女"?"checked":""}>
                                        </div>
                                    </div>
                                    <div class="layui-form-item mywidth2" pane>
                                        <label class="layui-form-label ">婚姻状态</label>
                                        <div class="layui-input-block">
                                            <input type="radio" name="marry" value="已婚"
                                                   title="已婚" ${student.marry == "已婚"?"checked":""}>
                                            <input type="radio" name="marry" value="未婚"
                                                   title="未婚" ${student.marry == "未婚"?"checked":""}>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <div class="layui-form-item ">
                                        <div class="layui-upload-list" id="demo1">
                                            <img class="layui-upload-img" id="test7"
                                                 src='../../../static/${student.photo == null?"img/default.png":student.photo}'>
                                            <p id="demoText"></p>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </table>



                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label item-label">电话</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="telephone" placeholder="请输入联系方式"
                                           autocomplete="off"
                                           value="${student.telephone}" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline ">
                                    <label class="layui-form-label">目前状态</label>
                                    <div class="layui-input-block">
                                        <select name="state" >
                                            <option value="-1" >--请选择状态--</option>
                                            <option value="0" ${student.state==0?"selected" : ""}>未分配班级</option>
                                            <option value="1" ${student.state==1?"selected" : ""}>培训中</option>
                                            <option value="2" ${student.state==2?"selected" : ""}>试用期</option>
                                            <option value="3" ${student.state==3?"selected" : ""}>已转正</option>
                                        </select>
                                    </div>

                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label item-label">身份证</label>
                                <div class="layui-input-inline inline">
                                    <input type="text" name="idCard" placeholder="请输入身份证号"
                                           autocomplete="off"
                                           value="${student.idCard}" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline ">
                                <label class="layui-form-label ">邮箱</label>
                                <div class="layui-input-inline inline">
                                    <input type="email" name="email" placeholder="请输入邮箱"
                                           autocomplete="off"
                                           value="${student.email}" class="layui-input">
                                </div>
                            </div>
                        </div>


                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label ">出生年月</label>
                                <div class="layui-input-inline inline">
                                    <input type="text" name="birthday" id="birthday"
                                           lay-verify="date"
                                           value="${student.birthday}" placeholder="yyyy-MM-dd"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline ">
                                <label class="layui-form-label">民族</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="nation" placeholder="请输入民族"
                                           autocomplete="off"
                                           value="${student.nation}" class="layui-input">
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label item-label">毕业院校</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="university" placeholder="请输入毕业院校"
                                           value="${student.university}" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline ">
                                <label class="layui-form-label item-label">专业</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="major" placeholder="请输入所学专业"
                                           autocomplete="off"
                                           value="${student.major}" class="layui-input">
                                </div>
                            </div>
                        </div>


                        <div class="layui-form-item mywidth2">
                            <label class="layui-form-label item-label">出生地</label>
                            <div class="layui-input-block">
                                <input type="text" name="birthPlace" placeholder="请输入出生地"
                                       autocomplete="off"
                                       value="${student.birthPlace}" class="layui-input ">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text text-width">
                            <label class="layui-form-label">备注</label>
                            <div class="layui-input-block">
                    <textarea placeholder="请输入备注信息" class="layui-textarea" name="note"
                              value="${student.note}" id="note"></textarea>
                            </div>
                        </div>
                        <input type="hidden" name="photo" id="photo" value="${student.photo}">

                        <div class="layui-form-item margin1">
                            <div class="layui-input-block">
                                <button type="button"
                                        class="layui-btn layui-btn-radius layui-btn-normal marginr"
                                        lay-submit
                                        id="submit">&nbsp;&nbsp;修&nbsp;&nbsp;&nbsp;&nbsp;改&nbsp;&nbsp;
                                </button>
                                <button type="button"
                                        class="layui-btn layui-btn-radius layui-btn-danger"
                                        id="back">&nbsp;&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;&nbsp;
                                </button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../../static/layui/layui.all.js"></script>
<script src="../../../static/js/jquery.min.js"></script>
<script src="../../../static/js/verify.js"></script>
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
        var layer = layui.layer;
        laydate.render({
            elem: '#birthday',
            trigger: 'click'
        })


        $('#submit').click(function () {

            var stuName = $('input[name=stuName]').val();
            var birthPlace = $('input[name=birthPlace]').val();
            var university = $('input[name=university]').val();
            var major = $('input[name=major]').val();
            var idCard = $('input[name=idCard]').val();
            var phone = $('input[name=phone]').val();

            if (stuName != '' && idCard != '' && phone != '' && birthPlace != '' && university != '' && major != '') {
                $.ajax({
                    url: "/udtstudent",
                    type: 'post',
                    dataType: 'json',
                    data: $('#form').serialize(),
                    success: function (data) {
                        if (data.flag) {
                            layer.msg("学生信息修改成功，一秒后刷新页面..");
                            setTimeout("location.href='/student'", 1000);
                        } else {
                            layer.msg("学生信息修改失败，稍后再试..");
                        }

                    }
                })
            } else {
                layer.msg('请把带<span class="item-label"></span>必填项填全')
            }

        })


        $('#back').click(function () {

            var imgpath = $('#photo').val();
            var photopath = '${student.photo}';

            if (imgpath != photopath) {
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
                    $('#test7').attr('src', result);
                });
            }
            , done: function (res) {
                $('#photo').val(res.img)
            }
        });


    });


</script>
</body>
</html>