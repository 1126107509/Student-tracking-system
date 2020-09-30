<%@page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="../../../static/layui/css/layui.css" media="all">
    <script src="../../../static/layui/layui.js"></script>
    <link rel="stylesheet" href="../../../static/css/admin/add.css">
    <link rel="stylesheet" href="../../../static/css/admin/class.css">
    <style>
        .select-width {
            width: 190px;
        }

        #mainleft {
            margin-left: 18%;
        }

        #rightbody {
            width: 385px;
            margin-top: 6.8%;

        }

        .buttonleft {
            margin-top: 8%;
            margin-left: -9%;
        }

        #bg {
            width: 100%;
            height: 100%;
            /* background-color: white;*/
            position: absolute;
            z-index: -1;
        }

        .layui-form-select dl {
            max-height: 145px;
        }
    </style>
</head>
<body>
<div id="bg"></div>
<div class="layui-fluid pd-top">
    <div class="layui-card">
        <div class="layui-card-body ">
            <div class="contain">
                <div id="main">
                    <div id="mainleft">
                        <div class="opera">
                            <div class="demoTable">
                                <div class="layui-inline marginl" id="toolbar">
                                    <button class="layui-btn layui-btn-radius layui-btn-normal"
                                            id="addclass">
                                        点击添加 <i class="layui-icon">&#xe624;</i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div id="table-contain">
                            <table class="layui-hide" id="test" lay-filter="test"></table>
                        </div>
                    </div>
                    <div id="mainright">
                        <div id="rightbody">
                            <form class="layui-form layui-form-pane" id="info">
                                <div class="layui-form-item">
                                    <label class="layui-form-label item-label">班期名称</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="className" id="className" required
                                               lay-verify="required" placeholder="班期(xx期xx班)"
                                               autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label item-label">授课教师</label>
                                    <div class="layui-input-block select-width" style="text-align: center">
                                        <select name="teacherId" lay-verify="required" required
                                                id="teacher">
                                            <option value="-1"> ---请选择教师---</option>
                                            <c:forEach items="${teachers}" var="teacher">
                                                <option value="${teacher.teacherId}">${teacher.tname}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label item-label">班期状态</label>
                                    <div class="layui-input-block select-width">
                                        <select name="state" lay-verify="required" required
                                                id="state">
                                            <option value="-1"> ---请选择状态---</option>
                                            <option value="0" selected>未开课</option>
                                            <option value="1">已开课</option>
                                            <option value="2">已结课</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-form-item buttonleft">
                                    <div class="layui-input-block">
                                        <button type="button"
                                                class="layui-btn layui-btn-radius layui-btn-normal"
                                                id="submit" lay-submit lay-filter="formDemo">
                                            &nbsp;提&nbsp;交&nbsp;
                                        </button>
                                        <button type="reset"
                                                class="layui-btn layui-btn-radius layui-btn-danger">
                                            &nbsp;重&nbsp;置&nbsp;
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i
            class="layui-icon layui-icon-delete"></i>删除</a>
</script>

<script>
    layui.use(['table', 'layer', 'form'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        var $ = layui.jquery;


        $('#addclass').click(function () {

            layer.open({
                type: 1,
                title: '添加班期信息',
                content: $('#rightbody'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                area: ['480px', '400px']
            });
            //监听提交
            $('#submit').click(function (data) {
                var teacherId = $('#teacher').val();
                var state = $('#state').val();
                var className = $('#className').val();
                if (teacherId == -1) {
                    layer.msg("请选择教师...");
                    return false;
                } else if (teacherId == -1) {
                    layer.msg("请选择班期状态...");
                    return false;
                } else if (className != '') {
                    $.ajax({
                        type: 'post',
                        url: '/addclass',
                        dataType: 'json',
                        data: $('#info').serialize(),
                        success: function (data) {
                            if (data.flag) {
                                layer.msg('添加成功...');
                                setTimeout('', 500);
                                layer.close(layer.index);
                                setTimeout('location.href="/class"', 1000)

                            } else {
                                layer.msg('添加失败，稍后再试...');
                            }

                        }

                    })
                }
            });

        })

        //方法级渲染表格
        table.render({
            elem: '#test'
            , url: '/listclass'
            , cols: [[
                {title: '序号', align: 'center', type: 'numbers', width: 50}
                , {field: 'classId', width: 0, hide: 'true'}
                , {field: 'className', title: '班期名称', align: 'center',}
                , {
                    field: 'tname',
                    title: '授课教师',
                    align: 'center',
                    templet: function (data) {
                        return data.teacher.tname;
                    }
                }
                , {field: 'stateName', title: '班期状态', align: 'center'}
                , {title: '操作', toolbar: '#barDemo', align: 'center', width: 110}
            ]]
            , id: 'testReload'
            , page: true
            , height: 390
            , limit: 5
            , limits: [3, 5, 10, 15]
            , done: function (res, curr, count) {
                $('.layui-table').css("width", "100%");
                $("th[data-field='bar']").css("border-right", 'none');

            }
        })

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            var id = data.classId;
            //console.log(id)
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    $.ajax({
                        url: "/delClass",
                        type: 'post',
                        dataType: 'json',
                        data: {
                            'classId': id,
                        },
                        success: function (data) {
                            if (data.flag) {
                                layer.msg("该班期删除成功..");
                                setTimeout(' location.reload()', 1000)
                            } else {
                                layer.msg("该班期删除失败，稍后再试..");
                            }

                        }
                    })

                    layer.close(index);

                });
            }

        });


    })

</script>
</body>

</html>