<%--
  Created by IntelliJ IDEA.
  User: xzl
  Date: 2018/3/15
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/layui/css/layui.css"/>
    <script src="<%=request.getContextPath()%>/js/layui/layui.js"></script>
</head>
<body>
<%--<form action="${pageContext.request.contextPath}/test/headImgUpload" method="post" enctype="multipart/form-data">--%>
    <%--<input type="file" name="file" >--%>

        <div class="layui-upload">
            <button type="button" class="layui-btn" id="test2">多图片上传</button>
            <div class="layui-upload-list" id="demo2"></div>
        </div>

   <%-- <input type="submit" value="提交">
</form>--%>
</body>
<script>
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;

        upload.render({
            elem: '#test2'
            , url: '../test/headImgUpload'
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
                //上传完毕
            }
            , allDone: function (obj) {
                console.log(obj)
            }
        });
    })
</script>
</html>
