<%--
  Created by IntelliJ IDEA.
  User: xzkp
  Date: 2018/3/26
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>
</head>
<body>
<div style="padding-left: 300px; " style="background:url('http://1708bone.oss-cn-beijing.aliyuncs.com/file1521386800800.jpg?Expires=1836746798&OSSAccessKeyId=LTAIDWJJcHLYf4PW&Signature=iS9vEcpJqIFYcHlr0lcWxaeh%2FDA%3D') no-repeat;">
    <form class="layui-form" id="addcompanyForm" data-align="center">

        <input type="hidden" name="id" id="id">

        <div class="layui-form-item">
            <label class="layui-form-label">公司名称:</label>
            <div class="layui-input-inline">
                <input type="text" name="company_name" id="name" required lay-verify="required" placeholder="请输入公司名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">公司logo:</label>
            <div class="layui-upload-list" id="demo1" ></div>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test1">上传logo</button>

                <input type="hidden" name="company_logo" id="logoimg">

            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">公司简介:</label>
            <textarea id="introduction" name="company_introduction" style="display: none;"></textarea>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">公司主页:</label>
            <div class="layui-input-inline">
                <input type="text" name="company_homepage" id="homepage" required lay-verify="required" placeholder="请输入公司主页" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">支付宝</label>
            <div class="layui-upload-list" id="demo2"></div>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test2">支付宝二维码上传</button>

                <input type="hidden" name="alipay_img" id="alipayimg">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">微信</label>
            <div class="layui-upload-list" id="demo3"></div>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test3">微信二维码上传</button>

                <input type="hidden" name="wx_img" id="wximg">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">转账:</label>
            <div class="layui-input-inline">
                <input type="text" name="accounts" id="account" required lay-verify="required" placeholder="请输入转账银行卡号" autocomplete="off" class="layui-input">
            </div>
        </div>

    </form>

    <div id="addcompany"  style="padding-left: 130px; ">
        <%--新增按钮--%>
        <button class="layui-btn" id="add"><i class="layui-icon">保存</i></button>
    </div>
</div>

<script>
    /*logo上传*/
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;

        upload.render({
            elem: '#test1'
            , url: '../Company/companyImgUpload.do'
            , multiple: true
            , number: 3
            , size: 1024
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img" height="100" width="100">')
                });
            }
            , done: function (res) {
                alert(res.path);
                $("#logoimg").val(res.path);
                //上传完毕
            }
            , allDone: function (obj) {
                console.log(obj)
            }
        });
    })

    /*公司简介富文本图片上传*/
    layui.use('layedit', function(){
        layedit = layui.layedit;
        layedit.set({
            uploadImage: {
                url: '../Company/companyImgUpload.do' //接口url
                ,type: 'post' //默认post
            }
        });
        indexsfour =layedit.build('introduction', {
            height: 280, //设置编辑器高度
        }); //建立编辑器
    });

    /*支付宝二维码上传*/
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;

        upload.render({
            elem: '#test2'
            , url: '../Company/companyImgUpload.do'
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
                $("#alipayimg").val(res.path);
                //上传完毕
            }
            , allDone: function (obj) {
                console.log(obj)
            }
        });
    })

    /*微信二维码上传*/
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;

        upload.render({
            elem: '#test3'
            , url: '../Company/companyImgUpload.do'
            , multiple: true
            , number: 3
            , size: 1024
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo3').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img" height="100" width="100">')
                });
            }
            , done: function (res) {
                alert(res.path);
                $("#wximg").val(res.path);
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
            url:"../Company/addCompany.do",
            type:"post",
            data:$("#addcompanyForm").serialize(),
            success:function (map) {
                if(map.success){
                    alert("操作成功！");
                }else{
                    layer.alert("出错了！");
                }
            }
        })

    })


</script>
</body>
</html>
