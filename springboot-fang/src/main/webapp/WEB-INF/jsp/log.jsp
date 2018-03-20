<%--
  Created by IntelliJ IDEA.
  User: 安晓智
  Date: 2018/3/20
  Time: 19:07
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
<table id="log" lay-filter="test" align="center"></table>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#log'
            //,height: 480
            ,url: 'login/getPerson' //数据接口
            ,page: true //开启分页
            ,cellMinWidth: 80
            ,cols: [[ //表头
                {field: 'id', title: '日志ID',align:'center', sort: true,type:'checkbox'}
                ,{field: 'username', title: '登陆姓名',align:'center'}
                ,{field: 'newDate', title: '日志日期',align:'center',sort: true}
                ,{field: 'flag', title: '登陆状态',align:'center',sort: true}
                ,{field: 'address', title: 'IP地址',align:'center',sort: true}
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
    </script>
    </body>
</html>
