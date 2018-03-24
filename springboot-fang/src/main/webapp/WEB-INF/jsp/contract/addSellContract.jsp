<%--
  Created by IntelliJ IDEA.
  User: xzkp
  Date: 2018/3/22
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui/css/layui.css"/>
    <script src="/js/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" id="addSellContractForm">

    <div class="layui-form-item">
        <label class="layui-form-label">房源出卖</label>
        <div class="layui-input-block">
            <select name="house_id" id="house_id"  lay-filter="123">
            </select>
        </div>
    </div>



    <div class="layui-form-item" style="width:1250px">

        <label class="layui-form-label">起租时间</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 0px; float: left;">
            <input type="text"  class="layui-input" id="rent_time" name="rent_time">
        </div>
        <label class="layui-form-label">到租时间</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" id="finish_time" name="finish_time">
        </div>

        <label class="layui-form-label">出租方</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="lease_name" value="" id="lease_name" required  lay-verify="required" placeholder="请选择房源租赁" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">承租方</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="lessee_name" id="lessee_name" required  lay-verify="required" placeholder="请输入承租方名称" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="width:1250px">
        <label class="layui-form-label">付款方式</label>
        <div class="layui-input-inline" style="width: 180px; display: inline-block; margin-left: 0px; float: left;">
            <select name="payment_method" id="payment_method" lay-filter="house">
            </select>
        </div>
        <label class="layui-form-label">分期状态</label>
        <div class="layui-input-inline" style="width: 180px; display: inline-block; margin-left: 0px; float: left;">
            <select name="staging_state" id="staging_state"  required  lay-verify="required" lay-filter="house" selected>
            </select>
        </div>

        <label class="layui-form-label">租金金额</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" id="rent_money" placeholder="￥" name="rent_money">
        </div>
        <div class="layui-form-mid layui-word-aux">元</div>
        <label class="layui-form-label">押金</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" placeholder="￥" id="deposit_money" name="deposit_money">
        </div>
        <div class="layui-form-mid layui-word-aux">元</div>
    </div>

    <div class="layui-form-item" style="width:1250px">
        <label class="layui-form-label">收租金日期(号）</label>
        <div class="layui-input-inline" style="width: 180px; display: inline-block; margin-left: 0px; float: left;">
            <input type="text"  class="layui-input" placeholder="1~31号" id="mention_rent" name="mention_rent">
        </div>
        <div class="layui-form-mid layui-word-aux">号</div>
        <label class="layui-form-label">违约金比例</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" placeholder="$" id="liquidated_damages_ercentage" name="liquidated_damages_ercentage">
        </div>
        <div class="layui-form-mid layui-word-aux">%</div>
        <label class="layui-form-label">第一次支付金额</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" placeholder="￥" id="one_money" name="one_money">
        </div>
        <div class="layui-form-mid layui-word-aux">元</div>
    </div>

    <center>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        <a class="layui-btn layui-btn-mini" onclick="calculateMonet()" lay-event="edit">计算金额</a>
        <a class="layui-btn layui-btn-mini" onclick="addContract()" lay-event="edit">添加</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="layui-btn layui-btn-mini" onclick="toRentHouse()" lay-event="edit">租房合同</a>
    </center>
</form>
</body>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;


        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#finish_time',//指定元素
            });
        })

        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#rent_time',//指定元素
            })
        })

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });


        form.on('select(123)', function(data){
            var categoryName = data.elem[data.elem.selectedIndex].value;
            //查询出租金，押金
            $.ajax({
                url:"../house/getRent.do",
                data:{"id":categoryName},
                type:"post",
                dataType:"json",
                success:function (data) {
                    for(var i=0;i<data.length;i++){
                        $("#rent_money").val(data[i].rent_money);
                        $("#lease_name").val(data[i].name);
                        $("#deposit_money").val(data[i].deposit_money);
                    }
                }
            })

        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

    });
    /**
     * 查询房源信息
     */
    $.ajax({
        url:"../house/getHouseAndEmpSell.do",
        type:"post",
        dataType:"json",
        async:false,
        success:function(data){
            $("#house_id").html("");
            var  house= '<option value="-1">请选择需要卖的房源</option>';
            for(var i=0;i<data.length;i++){
                house += '<option  value="'+data[i].id+'">'+data[i].title+'</option>'
            }
            $("#house_id").append(house);
        }
    })

    /**
     * 查询付款方式
     */
    $.ajax({
        url:"../house/getPaymentType.do",
        type:"post",
        dataType:"json",
        async:false,
        success:function(data){
            $("#payment_method").html("");
            var  house= '<option value="-1">请选择付款方式</option>';
            $.each(data,function(){
                house += '<option value="'+this.id+'">'+this.payment_name+'</option>'
            })
            $("#payment_method").append(house);
        }
    })

    /**
     * 查询分期状态
     */
    $.ajax({
        url:"../house/getStagingType.do",
        type:"post",
        dataType:"json",
        async:false,
        success:function(data) {
            $("#staging_state").html("");
            var house = '';
            $.each(data, function () {
                house += '<option value="' + this.id + '">' + this.name + '</option>'
            })
            $("#staging_state").append(house);
        }
    })

    function calculateMonet() {
        $.ajax({
            url:"../house/calculateMonet.do",
            data:$("#addContractForm").serialize(),
            dataType:"json",
            type:"post",
            success:function (data) {
                if(data.msg==false){
                    alert("请选择有效日期");
                    return false;
                }
                $("#one_money").val(data.one_money);
            },
            error:function () {
                alert("GG");
            }

        });
    }

    function addContract() {
        $.ajax({
            url:"../house/addContract.do",
            data:$("#addContractForm").serialize(),
            dataType:"json",
            type:"post",
            success:function (data) {
                if(data.success){
                    alert("成功");
                }
            },
            error:function () {
                alert("系统出错！！！");
            }

        });
    }

    function toRentHouse(){
        location.href="../toAddContract.do"
    }

</script>
</html>
