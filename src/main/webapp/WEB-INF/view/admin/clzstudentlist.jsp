<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>班期学生</title>
    <script src="../../../static/layui/layui.js" charset="utf-8"></script>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <link rel="stylesheet" href="../../../static/css/admin/add.css">
    <style>


        .contain {
            /* width: 896px;*/
            height: 489px;
            position: relative;
        }


        #main {
            margin-top: 0px;
            /* width: 896px;*/
        }

        .marginl {
            margin-left: 15px;
        }

        .border {
            border-radius: 10px;
        }

        .opera {
            /*margin-left: 56px;*/
        }

        .layui-table-fixed .layui-table-body {
            height: auto !important;
        }

        .layui-table-fixed.layui-hide {
            display: block !important;
        }

        .pd-top {
            padding-top: 50px;
        }

        .layui-table-cell .layui-form-checkbox[lay-skin=primary] {
            top: 4px;
            padding: 0;
        }

        .mywidth9 {
            width: 150px;
        }


    </style>
</head>
<body>
<div class="layui-fluid pd-top">
    <div class="layui-card">
        <div class="layui-card-body ">
            <div class="contain">
                <div id="main">
                    <div class="opera">
                        <div class="demoTable">
                            <div class="layui-form opera">
                                <div style="text-align: center">
                                    <div class="layui-inline">
                                        <input class="layui-input border" name="stuName"
                                               id="stuName"
                                               placeholder="请输入学生姓名" autocomplete="off">
                                    </div>
                                    <div class="layui-inline">
                                        <input class="layui-input border" name="tname" id="tname"
                                               placeholder="请输入教师姓名" autocomplete="off">
                                    </div>
                                    <div class="layui-inline marginl ">
                                        <button class="layui-btn layui-btn-radius layui-btn-normal"
                                                data-type="search">
                                            &nbsp;搜&nbsp;索&nbsp;<i class="layui-icon">&#xe615;</i>
                                        </button>
                                        <button class="layui-btn layui-btn-radius layui-btn-danger "
                                                data-type="batchallot">批量分配 <i class="layui-icon">&#xe605;</i>
                                        </button>
                                        <div class="layui-inline ">
                                            <div class="layui-inline mywidth9">
                                                <select id="allotId" lay-filter="allotId"
                                                        name="classId">
                                                    <option value="-1">--- 可分配班期 ---</option>
                                                    <c:forEach items="${allotClz}" var="clz">
                                                        <option value="${clz.classId}">${clz.className}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="layui-inline mywidth9">
                                                <select id="state" lay-filter="allotState"
                                                        name="stuState">
                                                    <option value="-1">---选中学生状态 ---</option>
                                                    <option value="1">培训中</option>
                                                    <option value="2">试用期</option>
                                                    <option value="3">已转正</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div style="text-align: center;margin-top: 10px">
                                    <div class="layui-inline width ">
                                        <div class="marginr ">
                                            <select id="stuState" lay-filter="type" name="stuState">
                                                <option value="-1">--- 学生状态 ---</option>
                                                <option value="0">未分配班级</option>
                                                <option value="1">培训中</option>
                                                <option value="2">试用期</option>
                                                <option value="3">已转正</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="layui-inline width ">
                                        <div class="marginr ">
                                            <select id="classId" lay-filter="type" name="classId">
                                                <option value="-1">--- 班期名称 ---</option>
                                                <c:forEach items="${classes}" var="clz">
                                                    <option value="${clz.classId}">${clz.className}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="layui-inline width ">
                                        <div class="marginr ">
                                            <select id="clzState" lay-filter="type" name="clzState">
                                                <option value="-1">--- 班期状态 ---</option>
                                                <option value="0">未开课</option>
                                                <option value="1">已开课</option>
                                                <option value="2">已结课</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="layui-inline width ">
                                        <div class="marginr ">
                                            <select id="teacherId" lay-filter="type"
                                                    name="teacherId">
                                                <option value="-1">--- 教师姓名 ---</option>
                                                <c:forEach items="${teachers}" var="teacher">
                                                    <option value="${teacher.teacherId}">${teacher.tname}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="table-contain">
                        <table class="layui-hide " id="tealist" lay-filter="teacher"></table>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="reset"><i
            class="layui-icon layui-icon-refresh-1"></i>重置</a>
</script>

<script>


    layui.use(['table', 'layer', 'form'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;
        var form = layui.form;

        //方法级渲染
        table.render({
            elem: '#tealist'
            , url: '/clzAndStus'
            , method: 'post'
            , contentType: 'application/x-www-form-urlencoded'
            , cols: [[
                {type: 'checkbox'}
                , {title: '序号', align: 'center', type: 'numbers', width: 80}
                , {field: 'stuId', width: 0, hide: 'true'}
                , {field: 'stuName', title: '学生姓名', align: 'center'}
                , {field: 'stuState', title: '学生状态', align: 'center'}
                , {
                    field: 'clz.classId', title: '班级id', width: 0, hide: 'true',
                    templet: function (d) {
                        return d.clz.classId;
                    }
                }
                , {
                    field: 'clz.className',
                    title: '班期名称',
                    width: 200,
                    align: 'center',
                    templet: function (d) {
                        return d.clz.className;
                    }
                }
                , {
                    field: 'clz.stateName', title: '班期状态', align: 'center', templet: function (d) {
                        return d.clz.stateName;
                    }
                }
                , {
                    field: 'teacher.teacherId', title: '教师id', width: 0, hide: 'true',
                    templet: function (d) {
                        return d.teacher.teacherId;
                    }
                }
                , {
                    field: 'teacher.tname', title: '教师姓名', align: 'center', templet: function (d) {
                        return d.teacher.tname;
                    }
                }
                , {title: '操作', toolbar: '#barDemo', width: 100, align: 'center'}
            ]]
            , id: 'testReload'
            , page: true
            , height: 395
            , limit: 5
            , limits: [3, 5, 10, 15]
            , done: function (res, curr, count) {
                $('.layui-table').css("width", "100%");
                $("th[data-field='bar']").css("border-right", 'none');
            }

        });
        //form监听下拉框事件--负责获取可分配班期id
        var classId = '';
        var allotState = '';
        form.on('select(allotId)', function (data) {
            classId = data.value;
        })
        form.on('select(allotState)', function (data) {
            allotState = data.value;
        })

        var $ = layui.$, active = {
            search: function () {
                var stuName = $('#stuName').val();
                var tname = $('#tname').val();
                //console.log(stuName)
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        'stuName': stuName,
                        'tname': tname
                    }

                }, 'data');
            },
            batchallot: function () {
                layer.confirm('确定学生分配吗？？？', {icon: 3, title: '学生分配班级'}, function () {
                    //返回data数组
                    var data = table.checkStatus('testReload').data;
                    if (data.length == 0) {
                        layer.msg('您还没有选数据呢....')
                        return false;
                    }
                    var arr = []; //存出要修改的学生id
                    var isSend = true; //标志是否可以发送数据
                    $(data).each(function (i) {
                        if (data[i].stuState != '未分配班级') {
                            layer.msg('该学生:' + data[i].stuName + '已分配，请重新选择...');
                            isSend = false;
                            return false;
                        }
                        arr.push(data[i].stuId);
                    });

                    if (classId == '') {
                        isSend = false;
                        layer.msg("您还没有选择可分配班期...");
                        return false;
                    }
                    if (allotState == '') {
                        isSend = false;
                        layer.msg("您还没有选择分配的学生状态...");
                        return false;
                    }

                    if (isSend) {
                        $.ajax({
                            url: "/udtStuOfClzId",
                            type: 'post',
                            dataType: 'json',
                            data: {"stuids": arr, 'classId': classId, 'state': allotState},
                            success: function (data) {
                                if (data.flag) {
                                    layer.msg("学生分配班级成功...");
                                } else {
                                    layer.msg("学生分配班级失败,请稍后再试..");
                                }

                                function load() {
                                    table.reload('testReload')
                                }

                                setTimeout(load, 1000);

                            }
                        })
                    }
                })

            },

        };
        //form监听下拉框事件
        var arr = [];
        form.on('select(type)', function (data) {
            // console.log(data.elem.name + '--' + data.value); //得到被选中的值
            var elename = data.elem.name;
            var value = data.value;
            var obj = {'name': elename, 'id': value}
            if (arr.length == 0) {
                arr.push(obj)
            } else {
                arr.forEach(function (item, index) {
                    if (item.name == elename) {
                        item.id = value;
                    }
                })
                var ispush = true;
                //判断是否需要往数组添加新的对象
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i].name == elename) {
                        ispush = false;
                        break;
                    }
                }
                if (ispush) {
                    arr.push(obj)
                }
            }
            var condition = {"stuState": -1, "classId": -1, "teacherId": 0, "clzState": -1};
            for (var cur of arr) {
                var name = cur.name;
                condition[name] = cur.id;
            }

            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: condition
            }, 'data');
        });


        //监听行工具事件
        table.on('tool(teacher)', function (obj) {
            var data = obj.data;
            var id = data.stuId;
            //console.log(id)
            if (obj.event === 'reset') {
                layer.confirm('真的要重置吗？？？', function (index) {
                    $.ajax({
                        url: "/resetStu",
                        type: 'post',
                        dataType: 'json',
                        data: {
                            'stuId': id,
                        },
                        success: function (data) {
                            if (data.flag) {
                                layer.msg("学生班级分配重置成功..");
                                setTimeout(' location.reload()', 500)
                            } else {
                                layer.msg("学生班级分配重置失败，稍后再试..");
                            }

                        }
                    })

                    layer.close(index);

                });
            } else if (obj.event === 'edit') {

                location.href = '/updstudent/' + id;
            }
        });


        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

</body>
</html>