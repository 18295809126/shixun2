<%--
  Created by IntelliJ IDEA.
  User: 安晓智
  Date: 2018/3/22
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>交易表</title>
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>
</head>
<body>
<table id="trading" lay-filter="test" align="center"></table>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#trading'
            ,height: 430
            ,url: 'tradinguser' //数据接口
            ,page:true //开启分页
            ,cellMinWidth: 80
            ,cols: [[ //表头
                {field: 'id', title: 'ID',align:'center', sort: true,type:'checkbox'}
                ,{field: 'ordernumber', title: '房屋编号',align:'center'}
                ,{field: 'name', title: '顾问名称',align:'center',sort: true}
                ,{field: 'tradingTime', title: '交易时间',align:'center',sort: true}
                ,{field: 'tradingType', title: '购买类型',align:'center',sort: true}
            ]]
        });
    });
</script>
</body>
</html>
