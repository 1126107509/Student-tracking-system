<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <script src="../../../static/layui/layui.js"></script>
</head>
<body>
    <form class="layui-form" action="" style="width: 50%" enctype="multipart/form-data" method="post" id="stuForm">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-block">
                <input type="text" name="stuName" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别：</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked>
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">民族：</label>
            <div class="layui-input-block">
                <input type="text" name="nation" required  lay-verify="required" placeholder="请输入民族" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">出生日期：</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="birthday" placeholder="yyyy-MM-dd">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出生地：</label>
            <div class="layui-input-block">
                <input type="text" name="birthPlace" required  lay-verify="required" placeholder="请输入出生地" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">婚姻状态：</label>
            <div class="layui-input-block">
                <input type="radio" name="marry" value="未婚" title="未婚" checked>
                <input type="radio" name="marry" value="已婚" title="已婚">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话：</label>
            <div class="layui-input-block">
                <input type="text" name="telephone" required  lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号：</label>
            <div class="layui-input-block">
                <input type="text" name="idCard" required  lay-verify="required" placeholder="请输入民族" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">毕业学校：</label>
            <div class="layui-input-block">
                <input type="text" name="university" required  lay-verify="required" placeholder="请输入民族" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">专业：</label>
            <div class="layui-input-block">
                <input type="text" name="major" required  lay-verify="required" placeholder="请输入民族" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">班级：</label>
            <div class="layui-input-block">
                <input type="text" name="class" required  lay-verify="required" placeholder="请输入民族" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">部门：</label>
            <div class="layui-input-block">
                <input type="text" name="deptId" required  lay-verify="required" value="培训学校" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">照片：</label>
            <div class="layui-input-block">
                <input type="file" name="photo" id="photo">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注：</label>
            <div class="layui-input-block">
                <textarea name="note" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" id="submit" lay-submit lay-filter="formDemo">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

    <script>
        layui.use(['form', 'laydate', 'upload','$','layer'], function(){
            var form = layui.form
                ,laydate = layui.laydate
                ,upload = layui.upload
                ,$ = layui.jquery
                ,layer = layui.layer;

            //日期
            laydate.render({
                elem: '#birthday'
            });

            $("#submit").click(function () {
                var photo = $("#photo").val();
                if (file == "") {
                    alert("请选择照片");
                    return;
                }
                //获取要上传的数据，使用FormData可以实现Ajax文件提交
                var formData = new FormData($("#stuForm"));
                $.ajax({
                    url:"addStudent",
                    type:"post",
                    data:formData,
                    cache:false,
                    //contentType必须设置false，contentType代表的是发送到服务器的内容编码类型
                    //默认值application/x-www-from-urlencoded
                    contentType:false,
                    //processData必须设置为false，才能避开jQuery对formData的默认处理
                    //processData设置为false，因为data的值是FormData的对象，不需要对数据进行处理
                    processData:false,
                    success:function (data) {
                        layer.msg("上传成功");
                    },
                    error:function () {
                        layer.msg("上传失败");
                    }
                })
            })
        });
    </script>
</body>
</html>
