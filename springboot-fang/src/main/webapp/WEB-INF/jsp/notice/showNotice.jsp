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
            ,height:450
            , cols: [[ //表头
                  {field: 'XX', title: '', checkbox:true, width: 30, sort: true, fixed: 'left'}
                , {field: 'id', title: 'ID', width: 100, sort: true, fixed: 'left'}
                , {field: 'headline', title: '主题',align:'center', width: 220, fixed: 'left'}
                , {field: 'empname', title: '员工姓名',align:'center',align:'center', width: 160}
                , {field: 'empnum', title: '员工联系方式',align:'center', width:160}
                , {field: 'content', title: '内容', width: 117,align:'center', sort: true}
                , {field: 'releasetime', title: '发布时间',align:'center', width: 120}
                , {
                    field: '', title: '发布状态', width: 120, templet: function (d) {
                              if (d.auditFlag == 1) {
                            return '<a  class="layui-btn layui-btn-sm">待审核</a>';
                        }else if(d.auditFlag == 2){
                            return '<a  class="layui-btn layui-btn-sm">审核通过</a>';
                        }else{
                            return '<a  class="layui-btn layui-btn-sm">审核不通过</a>';
                        }
                    }
                }
                , {
                    field: 'xx', title: '操作', width: 120, templet: function (d) {
                        if (d.auditFlag == 1) {
                            return '<a href="javascript:updateFlag2('+'\''+d.id+'\''+')" class="layui-btn layui-btn-sm">修改状态</a>';
                        }else if(d.auditFlag == 2){
                            return '<a href="javascript:updateFlagto3('+'\''+d.id+'\''+')" class="layui-btn layui-btn-sm">修改状态</a>';
                        }else{
                            return '<a href="javascript:updateFlagto2('+'\''+d.id+'\''+')" class="layui-btn layui-btn-sm">修改状态</a>';
                        }
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
