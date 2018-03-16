<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2018/3/15
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>
</head>
<body>

<table id="house" lay-filter="test"></table>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#house'
            ,height: 480
            ,url: '../house/getHouseResourceList.do' //数据接口
            ,page: true //开启分页


            ,cols: [[ //表头
                {field: 'id', title: 'ID',width:80, sort: true, fixed: 'left'}
                ,{field: 'title', title: '主题', width:80, fixed: 'left'}
                ,{field: 'price', title: '价格', width:80}
                ,{field: 'community', title: '所在小区', width:100}
                ,{field: 'building_time', title: '建筑年代', width:120, sort: true}
                ,{field: 'house_floor', title: '房屋楼层', width: 100}
                ,{field: 'release_time', title: '发布时间', width: 120, sort: true}
                ,{field: 'house_area', title: '面积', width: 115, sort: true}
                ,{field: 'decorate', title: '装修程度', width: 80}
                ,{field: 'xx', title: '详情', width: 80,templet:function (d) {
                    return '<a href="javascript:showHouseAllList('+'\''+d.id+'\''+')" class="layui-btn layui-btn-sm">查看</a>';
                }}
                ,{field: 'xxx', title: '删除', width: 80,templet:function (d) {
                    return '<a href="javascript:delHouse('+'\''+d.id+'\''+')" class="layui-btn layui-btn-sm">删除</a>';
                }}
                ,{field: 'xxxx', title: '修改', width: 80,templet:function (d) {
                    return '<a href="javascript:updHouse('+'\''+d.id+'\''+')" class="layui-btn layui-btn-sm">修改</a>';
                }}
            ]]
        });
    });


    //删除房源
    function delHouse(id){
        //alert(id);
        $.ajax({
            url:"../house/delHouseById.do",
            type:"post",
            data:{"id":id},
            dataType:"json",
            success:function (data) {
              if(data.success){
                  location.href=location;
              }else{
                  alert("GG");
              }
            },
            error:function () {
                alert("系统出错，请联系管理员");
            }
        })
    }

    //详情房源数据
    function showHouseAllList(id){
     location.href="../house/showHouseInfo.do?id="+id;
    }

    function updHouse(id) {
        location.href="../house/queryHouseById.do?id="+id;
        /*$.ajax({
            url:"../house/queryHouseById",
            type:"post",
            data:{"id":id},
            dataType:"json",
            success:function (data) {
                /!*if(data.success){
                    location.href=location;
                }else{
                    alert("GG");
                }*!/
            },
            error:function () {
                alert("系统出错，请联系管理员");
            }
        })*/
    }

</script>
</body>
</html>
