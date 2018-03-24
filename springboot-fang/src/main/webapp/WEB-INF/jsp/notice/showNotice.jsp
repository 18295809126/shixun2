<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2018/3/20
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告查询</title>
    <script type="application/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui/css/layui.css"/>
    <script src="/js/layui/layui.js"></script>
</head>
<body>
<table class="layui-table" id="notice" lay-filter="test"></table>
</body>
<script>
    layui.use(['table','form','laydate'], function() {
        var table = layui.table,
            laydate = layui.laydate;
        var form = layui.form;
        table.render({
            elem: '#notice'
            , url: '../house/getNotice.do'
            , page: true
            ,height:650
            , cols: [[ //表头
                  {field: 'id', title: 'xx',checkbox:true, width: 50, sort: true, fixed: 'left'}
                , {field: 'headline', title: '主题',align:'center', width: 220, fixed: 'left'}
                , {field: 'empname', title: '员工姓名',align:'center',align:'center', width: 160}
                , {field: 'empnum', title: '员工联系方式',align:'center', width:160}
                , {field: 'content', title: '内容', width: 355,align:'center', sort: true}
                , {field: 'releasetime', title: '发布时间',align:'center', width: 200}
                , {
                    field: 'xx', title: '操作',align:'center', width: 280, templet: function (d) {
                        return '<a href="javascript:updateFlag2(' + '\'' + d.id + '\'' + ')" class="layui-btn layui-btn-sm">通过</a><a href="javascript:updateFlagto3(' + '\'' + d.id + '\'' + ')" class="layui-btn layui-btn-sm">不通过</a>';
                    }
                }
            ]]
        });
    });

    /**
     * 修改状态为通过
     * @param id
     */
    function updateFlag2(id) {
        $.ajax({
            url:"../house/updateFlagto2.do",
            data:{"id":id},
            dataType:"json",
            type:"post",
            success:function (data) {
                if(data.success){
                    location.href=location;
                }else{
                    alert("GG");
                }
            }
        })
    }
    /**
     * 修改状态为不通过
     * @param id
     */
    function updateFlagto3(id) {
        $.ajax({
            url:"../house/updateFlagto3.do",
            data:{"id":id},
            dataType:"json",
            type:"post",
            success:function (data) {
                if(data.success){
                    location.href=location;
                }else{
                    alert("GG");
                }
            }
        })
    }
    /**
     * 修改状态为通过
     * @param id
     */
    function updateFlagto2(id) {
        alert(id);
        $.ajax({
            url:"../house/updateFlagTo2.do",
            data:{"id":id},
            dataType:"json",
            type:"post",
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
