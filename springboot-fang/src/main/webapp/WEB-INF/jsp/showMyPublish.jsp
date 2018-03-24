<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2018/3/19
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/layui/css/layui.css"/>
    <script src="<%=request.getContextPath()%>/js/layui/layui.js"></script>
</head>
<body>
  <table id="houses" class="layui-table" lay-filter="test"></table>
</body>
<script>
    layui.use(['table','form','laydate'], function() {
        var table = layui.table,
            laydate = layui.laydate;
        var form = layui.form;
        table.render({
            elem: '#houses'
            , url: '../house/getHouseResourceListByEmp.do'
            , page: true
            ,height:600
            , cols: [[ //表头
                {field: 'XX', title: '', checkbox:true, width: 30, sort: true, fixed: 'left'}
                , {field: 'id', title: 'ID', align:'center',sort: true, fixed: 'left'}
                , {field: 'title', title: '主题', align:'center',sort: true, fixed: 'left'}
                , {field: 'price', title: '价格', align:'center',sort: true}
                , {field: 'community', title: '所在小区', align:'center',sort: true}
                , {field: 'building_time', title: '建筑年代', align:'center',sort: true}
                , {field: 'house_floor', title: '房屋楼层', align:'center',sort: true}
                , {field: 'release_time', title: '发布时间', align:'center',sort: true}
                , {field: 'house_area', title: '面积', align:'center',sort: true}
                , {field: 'decorate', title: '装修程度', align:'center',sort: true}
                , {
                    field: 'xx', title: '新增', align:'center',sort: true, templet: function (d) {
                        return '<a href="javascript:toAddHouse()" class="layui-btn layui-btn-sm">跳转</a>';
                    }
                }
                , {
                    field: 'xx', title: '详情', align:'center',sort: true, templet: function (d) {
                        return '<a href="javascript:showHouseAllLists(' + '\'' + d.id + '\'' + ')" class="layui-btn layui-btn-sm">查看</a>';
                    }
                }
                , {
                    field: 'xxx', title: '删除', align:'center',sort: true, templet: function (d) {
                        return '<a href="javascript:delHouses(' + '\'' + d.id + '\'' + ')" class="layui-btn layui-btn-sm">删除</a>';
                    }
                }
                , {
                    field: 'xxxx', title: '修改', align:'center',sort: true, templet: function (d) {
                        return '<a href="javascript:updHouses(' + '\'' + d.id + '\'' + ')" class="layui-btn layui-btn-sm">修改</a>';
                    }
                }
            ]]
        });
    });


    //删除房源
    function delHouses(id){
        //alert(id);
        $.ajax({
            url:"../house/delHouseById.do",
            type:"post",
            data:{"id":id},
            dataType:"json",
            async:false,
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
    function showHouseAllLists(id){
        location.href="../house/showHouseInfo.do?id="+id;
    }

    function updHouses(id) {
        location.href="../house/queryHouseByIds.do?id="+id;

    }

    //跳转新增页面
    function toAddHouse(){
        location.href="../house/addMyHouse.do";
    }

</script>
</html>
