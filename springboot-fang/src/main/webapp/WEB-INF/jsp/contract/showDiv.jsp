<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2018/3/26
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>
</head>
<body>
   <div id="show"></div>
<script>
    $(function () {
        layui.use('layer', function () {
            var layer = layui.layer;
            layer.open({
                type: 1
                ,title: false //不显示标题栏
                ,closeBtn: false
                ,area: '230px;'
                ,shade: 0.8
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['租房合同', '卖房合同'],
                 yes: function(){
                    location.href="../toAddContract.do"
                 }
                 ,btn2:function(){
                    location.href="../toAddSellContract.do"
                }

            });


        });
    })
</script>
</body>
</html>
