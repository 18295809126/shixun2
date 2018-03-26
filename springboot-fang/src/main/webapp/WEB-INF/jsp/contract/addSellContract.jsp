<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2018/3/21
  Time: 14:49
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
<body bgcolor="#f0f8ff">


<form class="layui-form" id="addContractForms">
    <input type="hidden"   id="liquidated_damages" name="liquidated_damages">
    <input type="hidden"   id="unit_price" name="unit_price">
    <input type="hidden"   id="outOfDay" name="outOfDay">
    <input type="hidden"   id="tradingType" name="tradingType">
    <input type="hidden"   id="contractType" name="contractType">
    <input type="hidden"   id="house_id" name="house_id">

    <div class="layui-form-item" style="width:1250px">

        <label class="layui-form-label">出租方甲</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" readonly= "true "  name="lease_name" id="lease_name" required  lay-verify="required" placeholder="请选择房源租赁" autocomplete="off" class="layui-input">
        </div>

        <label class="layui-form-label">承租方乙</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="lessee_name" id="lessee_name" required  lay-verify="required" placeholder="请输入承租方名称" autocomplete="off" class="layui-input">
        </div>

        <label class="layui-form-label">起租时间</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" id="rent_time" name="rent_time">
        </div>

        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 30px; float: left;">
            <a class="layui-btn layui-btn-primary" onclick="getHosueInfo()" lay-event="edit">查看房源信息</a>
        </div>

    </div>

    <div class="layui-form-item" style="width:1250px">

        <label class="layui-form-label">到租时间</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" id="finish_time" name="finish_time">
        </div>

        <label class="layui-form-label">租金金额</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  readonly= "true "  class="layui-input" id="rent_money" placeholder="" name="rent_money">
        </div>


        <label class="layui-form-label">押金金额</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" readonly= "true "  placeholder="" id="deposit_money" name="deposit_money">
        </div>

    </div>

    <div class="layui-form-item" style="width:1250px">

        <label class="layui-form-label">付款方式</label>
        <div class="layui-input-inline" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <select name="payment_method" id="payment_method" lay-filter="house">
            </select>
        </div>

        <label class="layui-form-label">收租金日</label>
        <div class="layui-input-inline" style="width: 180px; display: inline-block; margin-left: 0px; float: left;">
            <input type="text"  class="layui-input" placeholder="1~31号" id="mention_rent" name="mention_rent">
        </div>

        <label class="layui-form-label">预售时间</label>
        <div class="layui-input-inline" style="width: 180px; display: inline-block; margin-left: 0px; float: left;">
            <input type="text"  class="layui-input" placeholder="" id="predetermined_period" name="predetermined_period">
        </div>

    </div>

    <div class="layui-form-item" style="width:1250px">

        <label class="layui-form-label">支付时间</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" placeholder="" id="payment_period" name="payment_period">
        </div>

        <label class="layui-form-label">迁出时间</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" placeholder="" id="emigration_time" name="emigration_time">
        </div>

        <label class="layui-form-label">违约金%</label>
        <div class="layui-input-block" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  class="layui-input" placeholder="" id="liquidated_damages_ercentage" name="liquidated_damages_ercentage">
        </div>
    </div>

    <div class="layui-form-item" style="width:1250px">

        <div  class="layui-input-block" id="one_div" style="width: 200px; display: none; margin-left: 0px; float: left;">
            <label class="layui-form-label">第一次付款</label>
            <input type="text"  style="width: 80px" class="layui-input" placeholder="￥" id="one_money" name="one_money">
        </div>

        <div class="layui-input-block" id="two_div" style="width: 200px; display: none; margin-left: 0px; float: left;">
            <label class="layui-form-label">第二次付款</label>
            <input type="text" style="width: 80px" class="layui-input" placeholder="￥" id="two_money" name="two_money">
        </div>


        <div class="layui-input-block" id="three_div" style="width: 200px; display: none; margin-left: 0px; float: left;">
            <label class="layui-form-label">第三次付款</label>
            <input type="text" style="width: 80px"  class="layui-input" placeholder="￥" id="three_money" name="three_money">
        </div>

        <div class="layui-input-block" id="four_div" style="width: 200px; display: none; margin-left: 0px; float: left;">
            <label class="layui-form-label">第四次付款</label>
            <input type="text"  style="width:80px" class="layui-input" placeholder="￥" id="four_money" name="four_money">
        </div>
    </div>

    <div class="layui-form-item" style="width:1250px">

        <label class="layui-form-label">分期状态</label>
        <div class="layui-input-inline" style="width: 180px; display: inline-block; margin-left: 10px; float: left;">
            <select  name="staging_state" id="staging_state"  required  lay-verify="required" lay-filter="staging_state" selected>
            </select>
        </div>

        <%--<a class="layui-btn layui-btn-primary" onclick="toSellHouse()" lay-event="edit">卖房合同</a>--%>
    </div>
    <br>
    <center>

        <button type="reset" class="layui-btn layui-btn-primary">重置</button>

        <a class="layui-btn layui-btn-primary" onclick="calculateMonet()" lay-event="edit">计算金额</a>

        <a class="layui-btn layui-btn-primary" onclick="addContract()" lay-event="edit">添加</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


    </center>

</form>


<div style="display: none" id="showHouseDiv">
    <table id="showHouseInfos" ></table>
</div>

</body>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var  form = layui.form
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

        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#predetermined_period',//指定元素
            })
        })

        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#payment_period',//指定元素
            })
        })


        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#emigration_time',//指定元素
            })
        })

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        form.on('select(staging_state)', function(data){
            var categoryName = data.elem[data.elem.selectedIndex].value;
            //查询出租金，押金
            //alert(categoryName);
            if(categoryName==3){
                $("#one_div").attr('style','display: inline-block;');
                $("#two_div").attr('style','display: none;');
                $("#three_div").attr('style','display: none;');
                $("#four_div").attr('style','display: none;');
            }
            if(categoryName==2){
                $("#one_div").attr('style','display: inline-block;');
                $("#two_div").attr('style','display: inline-block;');
                $("#three_div").attr('style','display: none;');
                $("#four_div").attr('style','display: none;');
            }
            if(categoryName==1){
                $("#one_div").attr('style','display: inline-block;');
                $("#two_div").attr('style','display: inline-block;');
                $("#three_div").attr('style','display: inline-block;');
                $("#four_div").attr('style','display: inline-block;');
            }
            if(categoryName==0){
                $("#one_div").attr('style','display: none;');
                $("#two_div").attr('style','display: none;');
                $("#three_div").attr('style','display: none;');
                $("#four_div").attr('style','display: none;');
            }
        });

    });
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
            //$("#名称").attr("属性名","属性值");
            $("#staging_state").html("");
            var staging_state ='<option value="">请选择分期状态</option>';
            $.each(data, function () {
                staging_state += '<option value="' + this.id + '">' + this.name + '</option>'
            })
            $("#staging_state").append(staging_state);
        }
    })

    function calculateMonet() {
        if($("#rent_time").val()=="" || $("#finish_time").val()=="" || $("#liquidated_damages_ercentage").val()==null || $("#emigration_time").val()==""){
            alert("请您完善信息");
            return false;
        }
        //alert($("#unit_price").val());
        $.ajax({
            url: "../house/calculateMonets.do",
            type: "post",
            data: $("#addContractForms").serialize(),
            dataType: "json",
            //async: false,
            success:function (data) {
                alert("11");
                if(data.msg==false){
                    alert("请选择有效日期");
                    return false;
                }
                if(data.mags==false){
                    alert("迁出时间不能小于系统时间");
                    return false;
                }
                $("#liquidated_damages").val(data.liquidatedCamages);
                $("#outOfDay").val(data.ouOfDays);


                if($("#staging_state").val()==1){
                    $("#one_money").val(data.one_money);
                    $("#two_money").val(data.two_money);
                    $("#three_money").val(data.two_money);
                    $("#four_money").val(data.two_money);
                }
                if($("#staging_state").val()==2){
                    $("#one_money").val(data.one_money);
                    $("#two_money").val(data.two_money);
                }
                if($("#staging_state").val()==3){
                    $("#one_money").val(data.one_money);
                }
            },
            error:function () {
                alert("GG");
            }

        });

    }
    function addContract() {
        $.ajax({
            url:"../house/addContract.do",
            data:$("#addContractForms").serialize(),
            dataType:"json",
            type:"post",
            success:function (data) {
                if(data.success){
                    alert("成功");
                }
                location.href=location;
            },
            error:function () {
                alert("系统出错！！！");
            }

        });
    }

    layui.use(['table','form','laydate'], function() {
        var table = layui.table,
            laydate = layui.laydate;
        var form = layui.form;
        //展示房屋数据
        houseList= table.render({
            elem: '#showHouseInfos'
            , url: '../house/getSellHouseAndEmp.do'
            , page: true
            , height: 450
            , cols: [[ //表头
                {field: 'id', title: '', checkbox: true, width: 30, sort: true, fixed: 'left'}
                , {field: 'companyName', title: '公司名称', align: 'center', width: 220, fixed: 'left'}
                , {field: 'title', title: '房屋主题', align: 'center', align: 'center', width: 165}
                , {field: 'house_floor', title: '房屋楼层', align: 'center', width: 120}
                , {field: 'unit_price', title: '房屋单价', width: 117, align: 'center', sort: true}
                , {field: 'release_time', title: '发布时间', align: 'center', width: 120}
            ]]
        });
    });

    function getHosueInfo() {
        layui.use('layer', function () {
            var layer = layui.layer;
            var houseClose =  layer.open({
                title: '查看出租房源',
                type: 1,
                content: $("#showHouseDiv"),//这里content是一个普通的String
                area: ['800px', '320px'],
                offset: 'auto',
                btn: ['确认'],
                yes: function (index, layero) {
                    //slayedit.sync(index);
                    layui.use('table', function(){
                        var table = layui.table;
                        var checkStatus = table.checkStatus('showHouseInfos'); //test即为基础参数id对应的值
                        //console.log(checkStatus);
                        var companyName = checkStatus.data[0].companyName;
                        var rent_money = checkStatus.data[0].rent_money;
                        var deposit_money = checkStatus.data[0].deposit_money;
                        var unit_price = checkStatus.data[0].unit_price;
                        var house_id = checkStatus.data[0].id;
                        var house_type = checkStatus.data[0].house_type;
                        $("#house_id").val(house_id);
                        $("#contractType").val(house_type);
                        $("#tradingType").val(house_type);
                        //alert(rent_money);
                        $("#lease_name").val(companyName);
                        $("#rent_money").val(rent_money);
                        $("#deposit_money").val(deposit_money);
                        $("#unit_price").val(unit_price);
                        layer.close(houseClose);
                    });
                }
            });
        });
    }

</script>

</html>
