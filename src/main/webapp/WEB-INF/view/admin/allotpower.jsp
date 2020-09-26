<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>权限管理</title>
    <link rel="stylesheet" href="../../../static/css/admin/add.css">
    <script src="../../../static/js/jquery3.3.1.js" charset="utf-8"></script>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <style>


        .contain {
            /* width: 896px;*/
            /* height: 500px;*/
            position: relative;
        }


        #main {
            margin-top: 15px;
        }

        .marginl {
            margin-left: 15px;
        }

        .width {
            width: 140px;
        }

        .border {
            border-radius: 10px;
        }

        /* .layui-table-fixed .layui-table-body {
             height: auto !important;
         }

         .layui-table-fixed.layui-hide {
             display: block !important;
         }*/

        .opera {
            margin-left: 100px;
        }


        /*  .layui-form input[type=checkbox], .layui-form input[type=radio], .layui-form select {
              display: block;
          }*/
    </style>
</head>
<body>
<div class="layui-form">
    <div class="contain">
        <div id="headline">
            <p>权限分配</p>
        </div>
        <div id="main">
            <div class="opera">
                <div class="demoTable">
                    <div class="opera">
                        <div class=" layui-inline width ">
                            <div class="marginl ">
                                <select id="type">
                                    <option value="-1">--请选择--</option>
                                    <!--class="layui-select"-->
                                     <c:forEach items="${roles}" var="role">
                                         <c:if test="${role.flag!=0}">
                                             <option value="${role.flag}">${role.roleName}</option>
                                         </c:if>
                                     </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <input class="layui-input border" name="condition" id="search"
                                   placeholder="请输入用户名" autocomplete="off">
                        </div>
                        <div class="layui-inline marginl" id="toolbar">
                            <button class="layui-btn layui-btn-radius layui-btn-normal"
                                    data-type="search">
                                &nbsp;搜&nbsp;索&nbsp;<i class="layui-icon">&#xe615;</i></button>
                            <button class="layui-btn layui-btn-radius layui-btn-danger"
                                    data-type="batchudt">
                                批量授权 <i class="layui-icon">&#xe672;</i>
                            </button>
                            <button class="layui-btn layui-btn-radius layui-btn-danger "
                                    data-type="batchudt">批量移除 <i class="layui-icon">&#xe672;</i>
                            </button>
                        </div>

                    </div>

                </div>
            </div>
            <div id="table-contain">
                <table class="layui-hide" id="test" lay-filter="test"></table>
            </div>
        </div>
    </div>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="allot"><i
            class="layui-icon layui-icon-auz"></i>授权</a>
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="unallot"><i
            class="layui-icon layui-icon-auz"></i>不授权</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i
            class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script type="text/html" id="demo">
    <input type="checkbox">
</script>
<script src="../../../static/layui/layuiall.js" charset="utf-8"></script>
<script>

    $(function () {
        ;!function () {
            var table = layui.table;
            var layer = layui.layer;
            var $ = layui.jquery;
            var form = layui.form;

            //方法级渲染
            table.render({
                elem: '#test'
                , url: '/userpower'
                , cols: [[
                    {checkbox: true}
                    , {field: 'userId', hide: 'true', width: 0}
                    , {title: '序号', align: 'center', type: 'numbers', width: 80}
                    , {field: 'userName', title: '用户名',}
                    , {field: 'pwd', title: '密码',}
                    , {field: 'realName', title: '用户姓名'}
                    , {field: 'userType', title: '用户类型', align: 'center', width: 120}
                    , {field: 'powerName', title: '授权状态', align: 'center', width: 120}
                    , {field: 'peopleID', hide: 'true'}
                    , {title: '操作', toolbar: '#barDemo', width: 300, align: 'center'}

                ]]
                , id: 'testReload'
                , page: true
                , height: 425
                , limit: 5
                , limits: [3, 5, 10, 15]
                , done: function (res, curr, count) {
                    $('.layui-table').css("width", "100%");
                    $("th[data-field='bar']").css("border-right", 'none');
                    form.render('select');
                    form.render('checkbox');


                }
            })

            layui.table.render()
            //监听行工具事件
            table.on('tool(test)', function (obj) {
                var data = obj.data;
                var id = data.userId;
                // console.log(id)
                if (obj.event === 'del') {
                    layer.confirm('真的删除行么', function (index) {
                        $.ajax({
                            url: "/deluser",
                            type: 'post',
                            dataType: 'json',
                            data: {
                                'id': id,
                            },
                            success: function (data) {
                                if (data.flag) {
                                    layer.msg("用户信息删除成功..");
                                    setTimeout(' location.reload()', 500)
                                } else {
                                    layer.msg("用户信息删除失败，稍后再试..");
                                }

                            }
                        })

                        layer.close(index);

                    });
                } else if (obj.event === 'allot') {

                    if (data.powerName == '已授权') {
                        layer.msg("该用户已授权，无法再次授权.....");
                        return false;
                    } else {
                        $.ajax({
                            url: "/updatepower",
                            type: 'post',
                            dataType: 'json',
                            data: {
                                'id': id,
                                'power': 1
                            },
                            success: function (data) {
                                if (data.flag) {
                                    layer.msg("用户授权成功..");
                                    setTimeout(' location.reload()', 500)
                                } else {
                                    layer.msg("用户授权失败，稍后再试..");
                                }

                            }
                        })
                    }

                } else if (obj.event === 'unallot') {
                    if (data.powerName == '未授权') {
                        layer.msg("该用户未授权，无法取消权限.....");
                        return false;
                    } else {
                        $.ajax({
                            url: "/updatepower",
                            type: 'post',
                            dataType: 'json',
                            data: {
                                'id': id,
                                'power': 0
                            },
                            success: function (data) {
                                if (data.flag) {
                                    layer.msg("用户权限取消成功..");
                                    setTimeout(' location.reload()', 500)
                                } else {
                                    layer.msg("用户权限取消失败，稍后再试..");
                                }

                            }
                        })
                    }
                }

            });


            var $ = layui.$, active = {
                //搜索
                search: function () {
                    var condition = $('#search').val();
                    var type = $('#type').val();
                    console.log(condition)

                    table.reload('testReload', {

                        page: {
                            curr: 1 //重新从第 1 页开始

                        }
                        , where: {
                            'condition': condition,
                            'flag': type
                        }
                    }, 'data');


                },
                //批量删除
                batchudt: function () {
                    layer.confirm('确定删除吗', {icon: 2, title: '删除新闻'}, function () {
                        //返回data数组
                        var data = table.checkStatus('testReload').data;
                        var arr = [];
                        $(data).each(function (i) {
                            arr.push(data[i].id);
                        })
                        var ids = arr.join(',');

                        $.ajax({
                            url: "/delusers",
                            type: 'post',
                            dataType: 'json',
                            data: {"id": ids},
                            success: function (data) {
                                if (data.flag) {
                                    layer.msg("用户信息删除成功,1秒后刷新页面..");
                                } else {
                                    layer.msg("用户信息删除失败,请稍后再试..");
                                }
                                setTimeout("location.reload()", 1000);
                            }
                        })
                    })
                },
            };

            $('#type').change(function () {
                var condition = $('#search').val();
                var type = $('#type').val();
                table.reload('testReload', {

                    page: {
                        curr: 1 //重新从第 1 页开始

                    }
                    , where: {
                        'condition': condition,
                        'flag': type
                    }
                }, 'data');

            })


            $('.demoTable .layui-btn').on('click', function () {
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });

            form.render('select', 'select');
            form.render('checkbox', 'test');

        }()
    })

</script>
<script>


</script>

</body>
</html>