<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2018/3/20
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布公告</title>
    <script type="application/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui/css/layui.css"/>
    <script src="/js/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" id="addNoticeForm">

    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">公告主题</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 0px; float: left;">
            <input type="text" name="headline" id="headline" required  lay-verify="required" placeholder="请输入主题信息" autocomplete="off" class="layui-input">
        </div>

    </div>
    <textarea id="content" name="content" style="display: none;"></textarea>
    <center>
    <div class="layui-form-item" style="width:1000px">
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <a class="layui-btn layui-btn-mini" onclick="addNotice()" lay-event="edit">提交</a>
    </div>
    </center>

</form>
</body>
<script>

    layui.use('layedit', function(){
     layedit = layui.layedit;
        layedit.set({
            uploadImage: {
                url: '../house/headNoticeImgUpload' //接口url
                ,type: 'post' //默认post
            }
        });
      indexsfour =layedit.build('content', {
        height: 280, //设置编辑器高度
    }); //建立编辑器
});

    function addNotice(){
        layedit.sync(indexsfour);
        $.ajax({
            url:"../house/addNotice.do",
            type:"post",
            data:$("#addNoticeForm").serialize(),
            dataType:"json",
            success:function (data) {
                if(data.success){
                    location.href=location;
                }else{
                    alert("GG");
                }
            }
        })
    }
</script>
</html>
