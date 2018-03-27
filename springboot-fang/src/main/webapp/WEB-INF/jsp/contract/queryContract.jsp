<%--
  Created by IntelliJ IDEA.
  User: 高帅
  Date: 2018/3/22
  Time: 9:50
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
<form class="layui-form" id="contractForm">

    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">编号</label>
        <div class="layui-input-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="code"id="codename"  size="10" lay-verify="title" autocomplete="off" placeholder="请输入编号" lay-verify="required" class="layui-input">
        </div>
        <label class="layui-form-label">承租方</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="lessee_name" id="lesseename"   lay-verify="" placeholder="请输入承租方" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div style=" height:100%;margin:0;height:100%">
        <div>
            <a class="layui-btn layui-btn-danger layui-btn-mini" id="searchSellcontract">搜索</a>
            <button type="reset" class="layui-btn layui-btn-mini">重置</button>
            <table class="layui-table" id="contract" lay-filter="test"></table>
        </div>
    </div>
</form>
<%--<table id="contract" lay-filter="test"></table>--%>
<script>

    //form表单封装成json
    $.fn.serializeJson = function(){
        var serializeObj={};
        var array=this.serializeArray();
        var str=this.serialize();
        $(array).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value;
            }
        });
        return serializeObj;
    };



    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        tableList  = table.render({
            elem: '#contract'
            ,url: '../house/getContractList.do' //数据接口
            ,page: true //开启分页
            //,cellMinWidth: 100
            ,cols: [[ //表头
                {field: 'code', title: '选择',width:80, sort: true, fixed: 'left',type:'checkbox'}
                ,{field: 'lease_name', title: '出租方', fixed: 'left', width: 80}
                ,{field: 'lessee_name', title: '承租方', fixed: 'left', width: 80}
                ,{field: 'title', title: '房屋租赁', fixed: 'left', width: 80}
                ,{field: 'rent_time', title: '起租时间', fixed: 'left', width: 120}
                ,{field: 'finish_time', title: '到租时间', fixed: 'left', width: 120}
                ,{field: 'payment_name', title: '付款方式关联id', fixed: 'left', width: 80}
                ,{field: 'name', title: '分期状态关联id', fixed: 'left', width: 80}
                ,{field: 'generation_time', title: '合同生成日期', fixed: 'left', width: 120}
                ,{field: 'mention_rent', title: '收租金时间', fixed: 'left', width: 100}
                ,{field: 'liquidated_damages', title: '违约金', fixed: 'left', width: 80}
                ,{field: 'one_money', title: '第一次支付金额', fixed: 'left', width: 130}
                ,{field: 'xxx', title: '删除',templet:function (d) {
                    return '<a href="javascript:delHouse('+'\''+d.code+'\''+')" class="layui-btn layui-btn-sm">删除</a>';
                }}
            ]]
            , height: 600
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
        //搜索
        $('#searchSellcontract').on('click', function(){
            //alert("1");
            tableList.reload({
                where:$('#contractForm').serializeJson()
            });
            return false;
        });
    });

    //删除合同
    function delHouse(code){
        //alert(id);
        $.ajax({
            url:"../house/delContract.do",
            type:"post",
            data:{"code":code},
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
