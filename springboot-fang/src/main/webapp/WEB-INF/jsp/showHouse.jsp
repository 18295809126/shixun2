<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表页面</title>

    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.min.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/layui/css/layui.css"/>
    <script src="<%=request.getContextPath()%>/js/layui/layui.js"></script>

</head>
<body>

<form class="layui-form" id="houseForm">

    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">房屋标题</label>
        <div class="layui-input-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="title"id="uname"  size="10" lay-verify="title" autocomplete="off" placeholder="请输入标题" lay-verify="required" class="layui-input">
        </div>
        <label class="layui-form-label">建造年代</label>
        <div class="layui-input-block" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="building_time" id="building_time"   lay-verify="" placeholder="请输入年代：yyyy" autocomplete="off" class="layui-input">
        </div>

        <label class="layui-form-label">房屋户型</label>
        <div class="layui-input-block" style="width: 65px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="room" id="room" required  lay-verify="required" placeholder="室" autocomplete="off" class="layui-input" style="width:50px">
        </div>
        <div class="layui-input-block" style="width: 65px; display: inline-block; margin-left: 5px; float: left;">
            <input type="text" name="hall" id="hall" required  lay-verify="required" placeholder="厅" autocomplete="off" class="layui-input" style="width:50px">
        </div>
        <div class="layui-input-block" style="width: 65px; display: inline-block; margin-left: 5px; float: left;">
            <input type="text" name="toilet" id="toilet" required  lay-verify="required" placeholder="卫" autocomplete="off" class="layui-input" style="width:50px">
        </div>
    </div>

    <div class="layui-form-item" style="width:1000px">
        <label class="layui-form-label">房屋面积</label>
        <div class="layui-input-inline" style="width: 65px; display: inline-block; margin-left: 10px; float: left;">
            <input name="house_areaMin" placeholder="/m²" autocomplete="off" class="layui-input" type="text">
        </div>
        <div class="layui-form-mid">-</div>
        <div class="layui-input-inline" style="width: 65px; display: inline-block; margin-left: 10px; float: left;">
            <input name="house_areaMax" placeholder="/m²" autocomplete="off" class="layui-input" type="text">
        </div>

        <label class="layui-form-label">售价区间</label>
        <div class="layui-input-inline" style="width: 65px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="price_min" id="price_min" placeholder="￥" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid">-</div>
        <div class="layui-input-inline" style="width: 65px; display: inline-block; margin-left: 10px; float: left;">
            <input type="text" name="price_max" id="price_max" placeholder="￥" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">装修情况</label>
        <div class="layui-input-inline" style="width: 200px; display: inline-block; margin-left: 10px; float: left;">
            <select name="decorate" id="decorate">
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">房屋地区</label>
        <div class="layui-input-inline">
            <select name="province" id="province" lay-filter="province">
                <option value="-1">请选择省</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="city" id="city" lay-filter="city">
                <option value="-1">请选择市</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="county" id="county">
                <option value="-1">请选择县/区</option>
            </select>
        </div>
    </div>

    <div id="pTable" style=" height:100%;margin:0;height:100%">
        <div>
            &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<a class="layui-btn layui-btn-danger layui-btn-mini"  onclick="toHouseAdd()">新增</a>
            <a class="layui-btn layui-btn-danger layui-btn-mini" id="searchSellHouse">搜索</a>
            <button type="reset" class="layui-btn layui-btn-mini">重置</button>
            <table class="layui-table" id="layui_table_id" lay-filter="test"></table>
            <div id="laypage"></div>
        </div>
    </div>
</form>
</body>
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

    //---------三级联动------------------------------
    //加载省  //Demo
    $.ajax({
        url:"../house/selectProvince",
        type:"post",
        data:{"pid":0},
        dataType:"json",
        async:false,
        success:function(data){
            $("#province").html("");
            var  province= '<option value="-1">请选择省</option>';
            $.each(data,function(){
                province += '<option value="'+this.id+'">'+this.name+'</option>'
            })
            $("#province").append(province);

        }
    });

    $.ajax({
        url:"../house/selectDecorate.do",
        type:"post",
        dataType:"json",
        async:false,
        success:function(data){
            $("#decorate").html("");
            var  province= '<option value="">请选择装修程度</option>';
            $.each(data,function(){
                province += '<option value="'+this.id+'">'+this.name+'</option>'
            })
            $("#decorate").append(province);
        }
    });

    /**
     * 三级联动   开始
     * */
    /*查询省级地区*/
    $.ajax({
        url:"../house/selectProvince.do",
        type:"post",
        data:{"pid":0},
        dataType:"json",
        async:false,
        success:function(data){
            $("#province").html("");
            var  province= '<option value="-1">请选择省</option>';
            $.each(data,function(){
                province += '<option value="'+this.id+'">'+this.name+'</option>'
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
                url: "../house/selectProvince.do",
                type: "post",
                data: {"pid": data.value},
                dataType: "json",
                async: false,
                success: function (cityData) {
                    var province = '<option value="-1">请选择市</option>';
                    $.each(cityData, function () {
                        province += '<option value="' + this.id + '">' + this.name + '</option>'
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
                    var province = '<option value="-1">请选择县/区</option>';
                    $.each(countyData, function () {
                        province += '<option value="' + this.id + '">' + this.name + '</option>'
                    })
                    $("#county").html(province);
                    form.render('select');
                }
            })
        });


        /**
         * 表格
         */
        var tableList = table.render({
            elem: '#layui_table_id'
            , url: '../house/getHouseResourceList'
            ,page:true
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[ //表头
                {field: 'id', title: 'XX',width:80, sort: true, fixed: 'left', checkbox:true}
                ,{field: 'title', title: '主题', width:80, fixed: 'left'}
                ,{field: 'price', title: '价格', width:80}
                ,{field: 'community', title: '所在小区', width:100}
                ,{field: 'building_time', title: '建筑年代', width:120, sort: true}
                ,{field: 'house_floor', title: '房屋楼层', width: 100}
                ,{field: 'release_time', title: '发布时间', width: 120, sort: true}
                ,{field: 'house_area', title: '面积', width: 122, sort: true}
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

        $('#searchSellHouse').on('click', function(){
            tableList.reload({
                where:$('#houseForm').serializeJson()
            });
            return false;
        });
        //-----------------------------------------

        //监听工具条
        table.on('tool(test)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'detail') {
                viewLableInfo(data.attrId);
                layer.msg(data.attrId);
            } else if (layEvent === 'del') {
                //layer.msg('删除');
                layer.confirm("确认要删除吗，删除后不能恢复", {title: "删除确认"}, function (index) {
                    layer.close(index);
                    $.post("../house/delHouseById?id=" + data.id, function (data) {
                        location.reload();
                    });
                });

            } else if (layEvent === 'edit') {
                location.href="<%=request.getContextPath()%>/house/lookhouse?id="+data.id;

            }else if(layEvent == 'editDetails'){
                location.href="<%=request.getContextPath()%>/house/lookhxq?id="+data.id;
            }
        });
        //监听提交 //Demo
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });

    });
    productsearch( curnum, limitcount);

    //----------------------------------------------------------------

    //删除房源
    function delHouse(id){
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
    function showHouseAllList(id){
        location.href="../house/showHouseInfo.do?id="+id;
    }

    function updHouse(id) {
        location.href="../house/queryHouseById.do?id="+id;

    }

    //跳转新增页面
    function toHouseAdd(){
        location.href="../house/addHouse.do";
    }

</script>
</html>
