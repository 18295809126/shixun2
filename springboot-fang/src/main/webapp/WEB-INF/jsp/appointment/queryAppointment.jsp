<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>
</head>
<body>
<table id="appointment" lay-filter="test"></table>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#appointment'
            //,height: 480
            ,url: '../appointment/getAppointmentList.do' //数据接口
            ,page: true //开启分页
            //,cellMinWidth: 100
            ,cols: [[ //表头
                 {field: 'id', title: '选择',width:80, sort: true, fixed: 'left',type:'checkbox'}
                ,{field: 'title', title: '房源', fixed: 'left', width: 80}
                ,{field: 'community', title: '所在小区', fixed: 'left', width: 100,
                    templet: function (d) {
                        if (d.community == 1) {
                            return "育新花园";
                        }else if(d.community == 2){
                            return "空军大院";
                        }else{
                            return "金科地产";
                        }
                    }
                }
                ,{field: 'userName', title: '用户名',width:120,}
                ,{field: 'userSex', title: '性别',}
                ,{field: 'userPhonenum', title: '联系方式',width:150,sort: true}
                ,{field: 'name', title: '员工名称', width: 100,}
                ,{field: 'reservations_time', title: '看房时间',width:200}
                ,{field: 'xxx', title: '删除',templet:function (d) {
                    return '<a href="javascript:delHouse('+'\''+d.id+'\''+')" class="layui-btn layui-btn-sm">删除</a>';
                }}
            ]]
            , height: 430
            ,done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                laypage.render({
                    elem:'laypage'
                    ,count:count
                    ,curr:curnum
                    ,limit:limitcount
                    ,scrollbar: false// 父页面 滚动条 禁止
                    ,layout: ['prev', 'page', 'next', 'skip','count','limit']
                    ,jump:function (obj,first) {
                        if(!first){
                            curnum = obj.curr;
                            limitcount = obj.limit;
                            productsearch(curnum,limitcount);
                        }
                    }
                })
            }
        });
    });

    //删除房源
    function delHouse(id){
        //alert(id);
        $.ajax({
            url:"../appointment/delAppointment.do",
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




</script>
</body>
</html>
