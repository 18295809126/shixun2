<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-03-15
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增房源</title>
    <script type="application/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui/css/layui.css"/>
    <script src="/js/layui/layui.js"></script>
</head>
<body>
<%--新增房源信息--%>

<%--修改房源信息--%>
<form class="layui-form" id="updHouseForm">
    <input type="hidden" name="id" id="id" value="${houseResource.id}">
    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">房屋主题</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" value="${houseResource.title}" name="title" id="title" required  lay-verify="required" placeholder="请输入主题信息" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">房屋价格</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="price" value="${houseResource.price}" id="price" required  lay-verify="required" placeholder="请输入价格(万)" autocomplete="off" class="layui-input">
        </div>

        <label class="layui-form-label">建筑面积</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" value="${houseResource.house_area}" name="house_area" id="house_area" required  lay-verify="required" placeholder="建筑面积(㎡)" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">核心卖点</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  value="${houseResource.selling_point}" class="layui-input" id="selling_point" name="selling_point">
        </div>
        <label class="layui-form-label">业主心态</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  value="${houseResource.owner_mentality}" class="layui-input" id="owner_mentality" name="owner_mentality">
        </div>

        <label class="layui-form-label">小区配套</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" value="${houseResource.community_complete}" class="layui-input" id="community_complete" name="community_complete">
        </div>
    </div>

    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">建筑年代</label>
        <div class="layui-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  value="${houseResource.building_time}" class="layui-input" id="building_time" name="building_time">
        </div>
        <label class="layui-form-label">房屋朝向</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" value="${houseResource.room_direction}" class="layui-input" id="room_direction" name="room_direction">
        </div>
        <label class="layui-form-label">所在楼层</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text"  value="${houseResource.house_floor}" class="layui-input" id="house_floor" name="house_floor">
        </div>
    </div>

    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">服务介绍</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" value="${houseResource.service_introduce}" class="layui-input" id="service_introduce" name="service_introduce">
        </div>
        <label class="layui-form-label">发布时间</label>
        <div class="layui-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;"> <!-- 注意：这一层元素并不是必须的 -->
            <input type="text" value="${houseResource.release_time}" class="layui-input" id="release_time" name="release_time">
        </div>

        <label class="layui-form-label">房源编号</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" value="${houseResource.room_num}" class="layui-input" id="room_num" name="room_num">
        </div>
    </div>

    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">房屋单价</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" value="${houseResource.unit_price}" class="layui-input" id="unit_price" name="unit_price" required  lay-verify="required" placeholder="房屋单价(元/㎡)" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">参考月供</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" value="${houseResource.monthly_payments}" class="layui-input" id="monthly_payments" name="monthly_payments" placeholder="参考月供(元)">
        </div>
        <label class="layui-form-label">房屋户型</label>
        <div class="layui-input-block" style="width: 65px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" value="${houseResource.room}" name="room" id="room" required  lay-verify="required" placeholder="室" autocomplete="off" class="layui-input" style="width:50px">
        </div>
        <div class="layui-input-block" style="width: 65px; display: inline-block; margin-left: 5px; float: left;">
            <input type="text" value="${houseResource.hall}" name="hall" id="hall" required  lay-verify="required" placeholder="厅" autocomplete="off" class="layui-input" style="width:50px">
        </div>
        <div class="layui-input-block" style="width: 65px; display: inline-block; margin-left: 5px; float: left;">
            <input type="text" value="${houseResource.toilet}" name="toilet" id="toilet" required  lay-verify="required" placeholder="卫" autocomplete="off" class="layui-input" style="width:50px">
        </div>
    </div>

    <input type="hidden" id="huiProvice" value="${houseResource.province}">
    <input type="hidden" id="huiCity" value="${houseResource.city}">
    <input type="hidden" id="huiCounty" value="${houseResource.county}">
    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">所在省</label>
        <div class="layui-input-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <select name="province" id="province" lay-filter="province">
            </select>
        </div>
        <label class="layui-form-label">所在市</label>
        <div class="layui-input-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <select name="city" id="city" lay-filter="city">
                <option value="-1">请选择市</option>
            </select>
        </div>
        <label class="layui-form-label">所在县</label>
        <div class="layui-input-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <select name="county" id="county">
                <option value="-1">请选择县/区</option>
            </select>
        </div>
    </div>
    <input type="hidden" id="huiCommunity" value="${houseResource.community}">
    <input type="hidden" id="huiRoomType" value="${houseResource.room_type}">
    <input type="hidden" id="huiDecorate" value="${houseResource.decorate}">
    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">所在小区</label>
        <div class="layui-input-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <select name="community" id="community" lay-filter="province">
            </select>
        </div>
        <label class="layui-form-label">房屋类型</label>
        <div class="layui-input-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <select name="room_type" id="room_type" lay-filter="province" selected>
            </select>
        </div>
        <label class="layui-form-label">装修程度</label>
        <div class="layui-input-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <select name="decorate" id="decorate" lay-filter="province">
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">上传房源相关图片</label>
        <div class="layui-upload" style="float: inherit">
            <div class="layui-upload-list" id="demo2">
                <button type="button" class="layui-btn" id="test2">多图片上传</button>
            </div>
        </div>
    </div>
    <center>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        <a class="layui-btn layui-btn-mini" onclick="addHouse()" lay-event="edit">修改</a>
    </center>
</form>
</body>
<script>
    function addHouse() {
        $.ajax({
            url:"../house/addHouseDatasource",
            type:"post",
            data:$("#updHouseForm").serialize(),
            dataType:"json",
            success:function(data){
                if(data.success == true){
                    alert("修改成功");
                    location.href="../house/toShowHouse.do";
                }
            }
        })
    }
    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
        //建筑年代
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#building_time',//指定元素
            });
        });
        //发布时间
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#release_time',//指定元素
            });
        });
    })

    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;
        upload.render({
            elem: '#test2'
            , url: '../house/headImgUpload'
            , multiple: true
            , number: 3
            , size: 1024
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo2').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img" height="100" width="100">')
                });
            }
            , done: function (res) {
                //上传完毕
            }
            , allDone: function (obj) {
                console.log(obj)
            }
        });
    })
    /**
     * 三级联动   开始
     * */
    /*查询省级地区*/
    $.ajax({
        url:"../house/selectProvince",
        type:"post",
        data:{"pid":0},
        dataType:"json",
        async:false,
        success:function(data){
            var provice = $("#huiProvice").val();
            alert(provice)
            $("#province").html("");
            var  province= '<option value="-1">请选择省</option>';
            $.each(data,function(){
                province += '<option value="'+this.id+'" == provice selected>'+this.name+'</option>'
            })
            $("#province").append(province);
        }
    });
    /*查询市级地区*/
    layui.use(['table','form','laydate'], function() {
        var table = layui.table,
            laydate = layui.laydate;
        var form = layui.form;
        form.on('select(province)', function (data) {
            //加载市
            $.ajax({
                url: "../house/selectProvince",
                type: "post",
                data: {"pid": data.value},
                dataType: "json",
                async: false,
                success: function (cityData) {
                    var city = $("#huiCity").val();
                    alert(city)
                    var province = '<option value="-1">请选择市</option>';
                    $.each(cityData, function () {
                        province += '<option value="' + this.id + '" == city selected>' + this.name + '</option>'
                    })
                    $("#city").html(province);
                    form.render('select');
                }
            })
        });
        /*查询县级地区*/
        form.on('select(city)', function (data) {
            //加载县
            $.ajax({
                url: "../house/selectProvince",
                type: "post",
                data: {"pid": data.value},
                dataType: "json",
                async: false,
                success: function (countyData) {
                    var county = $("#huiCounty").val();
                    alert(county)
                    var province = '<option value="-1">请选择县/区</option>';
                    $.each(countyData, function () {
                        province += '<option value="' + this.id + '" == county selected>' + this.name + '</option>'
                    })
                    $("#county").html(province);
                    form.render('select');
                }
            })
        });
    })
    /**
     * 三级联动   结束
     * */

    /**
     * 房屋类型
     * */
    $.ajax({
        url:"../house/selectRoomType",
        type:"post",
        dataType:"json",
        async:false,
        success:function(data){
            var roomType = $("#huiRoomType").val();
            $("#room_type").html("");
            var  province= '<option value="-1">请选择房屋类型</option>';
            $.each(data,function(){
                province += '<option value="'+this.id+'" == roomType selected>'+this.name+'</option>'
            })
            $("#room_type").append(province);
        }
    });
    /**
     * 查询装修程度
     * */
    $.ajax({
        url:"../house/selectDecorate",
        type:"post",
        dataType:"json",
        async:false,
        success:function(data){
            var decorate = $("#huiDecorate").val();
            $("#decorate").html("");
            var  province= '<option value="-1">请选择装修程度</option>';
            $.each(data,function(){
                province += '<option value="'+this.id+'" == decorate selected>'+this.name+'</option>'
            })
            $("#decorate").append(province);
        }
    });
    /**
     * 查询所在小区
     * */
    $.ajax({
        url:"../house/selectCommunity",
        type:"post",
        dataType:"json",
        async:false,
        success:function(data){
            var community = $("#huiCommunity").val();
            $("#community").html("");
            var  province= '<option value="-1">请选择所在小区</option>';
            $.each(data,function(){
                province += '<option value="'+this.id+'" == community selected>'+this.name+'</option>'
            })
            $("#community").append(province);
        }
    });
</script>
</html>
