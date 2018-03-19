<%--
  Created by IntelliJ IDEA.
  User: b
  Date: 2018/3/15
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body >
<%--新增form--%>
<div id="addstaff" style="padding-left: 300px; " style="background:url('http://1708bone.oss-cn-beijing.aliyuncs.com/file1521386800800.jpg?Expires=1836746798&OSSAccessKeyId=LTAIDWJJcHLYf4PW&Signature=iS9vEcpJqIFYcHlr0lcWxaeh%2FDA%3D') no-repeat;">
    <form class="layui-form" id="addstaffForm" data-align="center">

        <input type="hidden" name="id" id="id" value="${emp.id}">

        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名:</label>
            <div class="layui-input-inline">
                <input type="text" name="name" id="name" value="${emp.name}" required lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">员工微信:</label>
            <div class="layui-upload-list" id="demo4" ></div>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test3">微信上传</button>

                <input type="hidden" name="weixin" id="image2" value="${emp.weixin}">

            </div>
            <div class="layui-input-inline">
                <div  id="demo3"></div>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">手机号:</label>
            <div class="layui-input-inline">
                <input type="text" name="phonenumer" value="${emp.phonenumer}"  id="phonenumer" required lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">            <label class="layui-form-label">登陆账号:</label>
            <div class="layui-input-inline">
                <input type="text" name="loginnumber" id="loginnumber" value="${emp.loginnumber}"   required lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-inline">
                <input type="text" name="password" id="password" value="${emp.password}"  required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">封面</label>
            <div class="layui-upload-list" id="demo2"></div>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test2">多图片上传</button>

                <input type="hidden" name="photo" id="image" value="${emp.photo}">
            </div>
        </div>

    </form>
    <div id="addstaf" style="padding-left: 130px; ">
        <%--新增按钮--%>
        <button class="layui-btn" id="add"><i class="layui-icon">保存</i></button>
    </div>
</div>

<script>
    $(function () {
        var a = "${emp.id}";
        //alert(a);
        if(a != null && a != ""){
            //alert(a);
            $('#demo4').append('<img src="${emp.weixin}" class="layui-upload-img" height="100" width="100">');
        }

    });



    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;

        upload.render({
            elem: '#test2'
            , url: '../Emp/headImgUpload.do'
            , multiple: true
            , number: 3
            , size: 1024
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo2').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img" height="100" width="100">')
                });
            }
            , done: function (res) {
                alert(res.path);
                $("#image2").val(res.path);
                //上传完毕
            }
            , allDone: function (obj) {
                console.log(obj)
            }
        });
    })
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;

        upload.render({
            elem: '#test3'
            , url: '../Emp/headImgUpload.do'
            , multiple: true
            , number: 3
            , size: 1024
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo4').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img" height="100" width="100">')
                });
            }
            , done: function (res) {
                alert(res.path);
                $("#image").val(res.path);
                //上传完毕
            }
            , allDone: function (obj) {
                console.log(obj)
            }
        });
    })
</script>
<script>

    //新增
    $("#add").click(function(){

                    $.ajax({
                        url:"../Emp/submitEmp.do",
                        type:"post",
                        data:$("#addstaffForm").serialize(),
                        success:function (map) {
                            if(map.success){
                                alert("操作成功！");
                                location.href="../Emp/toEmp.do";
                            }else{
                                layer.alert("出错了！");
                                location.href="../Emp/toEmp.do";
                            }
                        }
                    })

    })


</script>

</body>
</html>