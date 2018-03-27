<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>
    <script src="/js/echarts/echarts.js"></script>
</head>
<body>

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            <img src='${company.company_logo}' class="layui-nav-img">
            ${company.company_name}
        </div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src='${emp.photo}' class="layui-nav-img">
                    ${emp.name}
                </a>
                <dl class="layui-nav-child">
                    <dd> <a href="javascript:buttonss()">查看日志</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="javascript:cancellation()">注销</a></li>
        </ul>
    </div>
    <div id="wahaha" style=" display: none;"><table id="loguser" lay-filter="test"></table></div>
    <div class="layui-side layui-bg-black">
        <div class="navBar layui-side-scroll"></div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="layui-tab" lay-filter="myTab" lay-allowclose="true">
                <ul class="layui-tab-title">
                    <li class="layui-this" lay-id="11">欢迎</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <div class="layui-container">
                            <div class="layui-row">
                                <div class="layui-col-md6" style="background: white;height: 50%">
                                    <div class="layui-collapse">
                                        <div class="layui-colla-item">
                                            <h2 class="layui-colla-title">未来五天气预报</h2>
                                            <div class="layui-colla-content layui-show" id="weatherDiv" style="width: 400px;height: 230px">内容区域</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md6" style="background: white;height: 50%" >
                                    <div class="layui-collapse">
                                        <div class="layui-colla-item">

                                            <h2 class="layui-colla-title">订单报表</h2>
                                            <form id="addressForm">
                                                <div style="margin-left: 20px;margin-top: 5px;width: 100%;height: 20%">
                                                    <label class="layui-label">省:</label>
                                                    <div class="layui-input-inline">
                                                        <select name="areaprovince" id="province"  class="layui-select" onchange="querycity()">
                                                        </select>
                                                    </div>
                                                    <label class="layui-label">市:</label>
                                                    <div class="layui-input-inline">
                                                        <select name="areacity" id="city" class="layui-select" onchange="querycountry()">
                                                        </select>
                                                    </div>
                                                    <label class="layui-label">县:</label>
                                                    <div class="layui-input-inline">
                                                        <select name="areacountry" id="county" class="layui-select">
                                                        </select>
                                                    </div>
                                                    <input class="layui-btn" type="button" value="搜索" onclick="gjss()"/>
                                                </div>
                                            </form>
                                            <!--报表的div-->
                                            <div id="bread" style="width: 100%;height: 80%"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-row">
                                <div class="layui-col-md6" style="background: white;height: 50%">
                                    <div class="layui-collapse">
                                        <div class="layui-colla-item">
                                            <h2 class="layui-colla-title">最新交易记录</h2>
                                            <div class="layui-colla-content layui-show">
                                                <table id="trad" lay-filter="test" align="center"></table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md6" style="background: white;height: 50%">
                                    <div class="layui-collapse">
                                        <div class="layui-colla-item">
                                            <h2 class="layui-colla-title">公告</h2>
                                            <div class="layui-colla-content layui-show">
                                                <table id="notices" class="layui-table" lay-filter="test"></table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="showNotice" style="display: none">
    <textarea id="content" class="layui-textarea" style="display: none;">

    </textarea>
</div>

<div style="display:none" id="321">

    <form class="layui-form" id="fasong">
        <label class="layui-form-label">收件人</label>
        <div class="layui-input-block">
            <input type="text" id="mail" name="mail" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">主题</label>
        <div class="layui-input-block">
            <input type="text" name="headline" required  lay-verify="required" placeholder="请输入主题" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">内容</label>
        <div>
            <textarea id="fwbbjq" name="content" class="layui-textarea"></textarea>
        </div>
    </form>

</div>

</body>
 <script>

    var $;
    layui.use(['element'], function(){
        $ = layui.jquery
        var element = layui.element
        var myTab  = function(){
            this.tabConfig = {
                closed : true,
                openTabNum : 10,
                tabFilter : "myTab"
            }
        };
        $.ajax({
            url:"queryTree",
            type:"post",
            dataType:"json",
            success:function(data){
                //显示左侧菜单
                if($(".navBar").html() == ''){
                    var _this = this;
                    $(".navBar").html(navBar(data)).height($(window).height()-240);
                    element.init();  //初始化页面元素
                    $(window).resize(function(){
                        $(".navBar").height($(window).height()-240);
                    })
                }
                // 添加新窗口
                $(".layui-nav .layui-nav-item a").on("click",function(){

                    //判断当前节点是否是子节点
                    if($(this).children("span").length == 0){
                        //判断选项卡是否被打开过
                        if(!hasTab($(this).find("cite").text())){
                            element.tabAdd('myTab', {
                                title: '<cite>'+$(this).find("cite").text()+'</cite>'//用于演示
                                ,content:createFrame($(this).attr("data-url"))
                                ,id: $(this).attr("data-id")
                            })
                            element.tabChange('myTab', $(this).attr("data-id"));
                        }else{
                            element.tabChange('myTab', $(this).attr("data-id"));
                        }
                    }
                })

            }

        })



    });
    function createFrame(url){
        return '<iframe scrolling="auto" frameborder="0"  src="'+ url + '" style="width:100%;height:100%;"></iframe>';

    }

    function hasTab(title){
        var tabIndex = false;
        $(".layui-tab-title li").each(function(){
            if($(this).find("cite").text() == title){
                tabIndex = true;
            }
        })
        return tabIndex;
    }


    function navBar(data){
        var ulHtml = '<ul class="layui-nav layui-nav-tree" lay-filter="myTree">';
        for(var i=0;i<data.length;i++){
            if(data[i].spread){
                ulHtml += '<li class="layui-nav-item layui-nav-itemed">';
            }else{
                ulHtml += '<li class="layui-nav-item">';
            }
            if(data[i].children != undefined && data[i].children.length > 0){
                ulHtml += '<a href="javascript:;" data-id="'+data[i].id+'">';
                if(data[i].icon != undefined && data[i].icon != ''){
                    if(data[i].icon.indexOf("icon-") != -1){
                        ulHtml += '<i class="iconfont '+data[i].icon+'" data-icon="'+data[i].icon+'"></i>';
                    }else{
                        ulHtml += '<i class="layui-icon" data-icon="'+data[i].icon+'">'+data[i].icon+'</i>';
                    }
                }
                ulHtml += '<cite>'+data[i].title+'</cite>';;
                ulHtml += '<span class="layui-nav-more"></span>';
                ulHtml += '</a>'
                ulHtml += '<dl class="layui-nav-child">';
                for(var j=0;j<data[i].children.length;j++){
                    ulHtml += '<dd><a href="javascript:;" data-id="'+data[i].children[j].id+'" data-url="'+data[i].children[j].href+'">';
                    if(data[i].children[j].icon != undefined && data[i].children[j].icon != ''){
                        if(data[i].children[j].icon.indexOf("icon-") != -1){
                            ulHtml += '<i class="iconfont '+data[i].children[j].icon+'" data-icon="'+data[i].children[j].icon+'"></i>';
                        }else{
                            ulHtml += '<i class="layui-icon" data-icon="'+data[i].children[j].icon+'">'+data[i].children[j].icon+'</i>';
                        }
                    }
                    ulHtml += '<cite>'+data[i].children[j].title+'</cite></a></dd>';
                }
                ulHtml += "</dl>"
            }else{
                ulHtml += '<a href="javascript:;" data-id="'+data[i].id+'" data-url="'+data[i].href+'">';
                if(data[i].icon != undefined && data[i].icon != ''){
                    if(data[i].icon.indexOf("icon-") != -1){
                        ulHtml += '<i class="iconfont '+data[i].icon+'" data-icon="'+data[i].icon+'"></i>';
                    }else{
                        ulHtml += '<i class="layui-icon" data-icon="'+data[i].icon+'">'+data[i].icon+'</i>';
                    }
                }
                ulHtml += '<cite>'+data[i].title+'</cite></a>';
            }
            ulHtml += '</li>'
        }
        ulHtml += '</ul>';
        return ulHtml;
    }

    //查询日志弹框
    function buttonss(){
        $("#wahaha").val("getkaka.do");
        //示范一个公告层
        layer.open({
            type: 1,
            title: false, //不显示标题栏,
            closeBtn: false,
            area: '1000px;',
            shade: 0.8,
            id: 'LAY_layuipro', //设定一个id，防止重复弹出,
            btn: ['进攻Σ(っ °Д °;)っ', '滚犊子(ノ｀Д)ノ'],
            btnAlign: 'c',
            moveType: 1, //拖拽模式，0或者1,
            /*content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'*/
            content: $("#wahaha"),
            success: function (layero) {
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').attr({
                    /*href: 'http://www.layui.com/'*/
                    href: "getkaka.do"
                    , target: '_blank'
                });
            }
        })
    }

    //查询日志页面
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#loguser'
            //,height: 480
            ,url: 'login/getPerson' //数据接口
            ,cols: [[ //表头
                {field: 'id', title: '日志ID',width:180,align:'center', sort: true,type:'checkbox'}
                ,{field: 'username', title: '登陆姓名',width:200,align:'center'}
                ,{field: 'newDate', title: '日志日期',width:200,align:'center',sort: true}
                ,{field: 'flag', title: '登陆状态',width:200,align:'center',sort: true}
                ,{field: 'address', title: 'IP地址',width:200,align:'center',sort: true}
            ]]
            , height: 330
        });
    });

    /*公告*/
    layui.use(['table','form','laydate'], function() {
        var table = layui.table,
            laydate = layui.laydate;
        var form = layui.form;
        table.render({
            elem: '#notices'
            , url: '../house/getNoticeInfo.do'
            , page: true
            ,height:300
            , cols: [[ //表头
                  {field: 'id', title: 'ID', width: 50, sort: true, fixed: 'left'}
                , {field: 'headline', title: '标题', width: 100, fixed: 'left'}
                , {field: 'empname', title: '发布人姓名', width: 80}
                , {field: 'empnum', title: '发布人手机号', width: 120}
                , {
                    field: 'xx', title: '详情', width: 80, templet: function (d) {
                        return '<a href="javascript:showNotice('+'\''+d.id+'\''+')" class="layui-btn layui-btn-sm">查看</a>';
                    }
                },
                {
                    field: 'xx', title: '联系发布人', width: 90, templet: function (d) {
                        return '<a href="javascript:toSendEmail('+'\''+d.id+'\''+')" class="layui-btn layui-btn-sm">邮件</a>';
                    }
                }
            ]]
        });
    });

  function showNotice(id) {
      $.ajax({
          url:"../house/getNoticeById.do",
          data:{"id":id},
          dataType:"json",
          type:"post",
          success:function (data) {
                 contents=data.content;
                    alert(contents);
                  layui.use(['layedit','form'], function(){
                  layedit = layui.layedit;
                  var form=layui.form;

                  $("#content").val(contents);
                  layedit.build('content'); //建立编辑器
                  form.render();
              })
          },error:function () {
              alert("GG");
          }

      })
      //弹框
      layui.use('layer', function(){
          var layer = layui.layer;
          layer.open({
              title:'查看详情',
              type: 1,
              content:$("#showNotice"),//这里content是一个普通的String
              area:['800px', '420px'],
              offset:'auto',
              btn:['确认'],
              yes: function(index, layero){
                  layedit.sync(indexs);
              }
          });
      });

  }

 function toSendEmail(id) {
     $.ajax({
         url:"../house/getEmpEmail.do",
         data:{"id":id},
         type:"post",
         dataType:"json",
         success:function(data){
             emails=data.email;

             layui.use(['layedit','form'], function(){
                 layedit = layui.layedit;
                 var form=layui.form;
                 $("#mail").val(emails);

                 layedit.build('fwbbjq'); //建立编辑器
                 form.render();
             });
         },
     })
     //弹框
     layui.use('layer', function(){
         var layer = layui.layer;
       var  mains = layer.open({
             title:'联系发送人',
             type: 1,
             content:$("#321"),//这里content是一个普通的String
             area:['900', '500'],
             offset:'auto',
             btn:['发送'],
             yes: function(index, layero){
                 upEmail();
                 layer.close(mains);
                 layedit.sync(indexs);
             }
         });
     });
 }

    function upEmail(){
        $.ajax({
            url:"../house/sendEmail.do",
            type:"post",
            data:$("#fasong").serialize(),
            dataType:"text",
            success:function(){
                alert("成功")
            },
            error:function(){
                alert("成功")
            }
        })
    }

    //登陆用户头像名字展示
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#logtitle'
            ,url:'../Emp/showEmp.do'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                ,{field:'name', width:80, title: '用户名'}
                ,{field: 'photo', title: '图片', width: 130,templet:'<div><img src="{{d.photo}}"></div>'}
            ]]
        });
    });

    /*订单查询*/
    function demoReload() {
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#trad'
                ,height: 310
                ,url: 'tradinguser' //数据接口
                ,page: true //开启分页
                ,cellMinWidth: 80
                ,cols: [[ //表头
                    {field: 'ordernumber', title: '订单编号',align:'center'}
                    ,{field: 'eidname', title: '顾问名称',align:'center',sort: true}
                    ,{field: 'roomname', title: '交易房屋',align:'center',sort: true}
                    ,{field: 'generation_time', title: '交易时间',align:'center',sort: true}
                    ,{field: 'tradingType', title: '交易类型', align:'center',sort: true,
                        templet: function (d) {
                            if (d.tradingType == 1) {
                                return "租房";
                            }else if(d.tradingType == 2){
                                return "卖房";
                            }
                        }
                    }
                ]]
            });
        });
    }
    //2秒自动刷新交易订单表
    timename = setInterval("demoReload();", 10000);

    //注销
    function cancellation() {
        $.ajax({
            url:'../login/cancellations.do',
            dataType:'json',
            type:'post',
            success:function (data) {
                location.href="login.jsp";
            }
        })
    }

    /**
     * 天气查询
     */
    $.ajax({
        url:"getWeather",
        dataType:"json",
        success:function(data){
            var weekArray = data.weekList;
            var temperatureListArray = data.temperatureList;
            var LowListArray = data.LowList;
            var  option = {
                title: {
                    text: '未来五天的天气'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data:['高温','低温']
                },
                xAxis: [
                    {
                        type: 'category',
                        data: weekArray
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '温度/℃',
                        min: -10,
                        max: 40,
                        interval: 50,
                        axisLabel: {
                            formatter: '{value} '
                        }
                    }
                ],
                series: [

                    {
                        name:'高温',
                        type:'line',
                        itemStyle: {
                            normal: {

                            }
                        },
                        data:temperatureListArray
                    },
                    {
                        name:'低温',
                        type:'line',
                        itemStyle : {
                            normal : {
                            }
                        },
                        data:LowListArray
                    }
                ]
            };
            // 基于准备好的dom，初始化echarts实例
            var weatherForecastChart = echarts.init(document.getElementById('weatherDiv'));
            // 使用刚指定的配置项和数据显示图表。
            weatherForecastChart.setOption(option);
        },
        error:function() {
            alert("网络连接错误或系统错误，请稍后再试");
        }
    });


    /**
     * 饼图报表
     */
    $(function(){
        var breadChart = echarts.init(document.getElementById('bread'));
        $.ajax({
            url:'<%=request.getContextPath()%>/getHouse.do',
            type:"post",
            dataType:"json",
            async:false,
            success:function (data1){
                var data2=data1;
                var data3 = new Array();
                for(var i = 0;i<data1.length;i++){
                    if(data1[i].name==1){
                        data2[i].name="卖";
                        data3.push("卖");
                    }else if(data1[i].name==2){
                        data3.push("租");
                        data2[i].name="租";
                    }
                }
                option3 = {
                    title : {
                        text: '本月房屋交易详情',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'vertical',
                        left: 20,
                        top: 20,
                        bottom: 20,
                        data: data3,
                    },
                    series : [
                        {
                            name: '金科地产',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:data1,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                breadChart.setOption(option3);
            }
        });

    })



    /**
     * 三级联动   开始
     * */
    /*查询省级地区*/
    $.ajax({
        url:"../queryProvince.do",
        type:"post",
        dataType:"json",
        async:false,
        success:function(data){
            $("#province").html("");
            var  province= '<option value="-1">--请选择省--</option>';
            $.each(data,function(){
                province += '<option value="'+this.id+'">'+this.name+'</option>'
            })
            $("#province").append(province);
            $("#city").html("<option value='-1'>--请选择市--</option>");
            $("#county").html("<option value='-1'>--请选择县--</option>")
        }
    });

    function querycity() {
        $.ajax({
            url: "../queryCity.do",
            type: "post",
            data: {"id":$("#province").val()},
            dataType: "json",
            async: false,
            success: function (cityData) {
                var province = '<option value="-1">--请选择市--</option>';
                $.each(cityData, function () {
                    province += '<option value="' + this.id + '">' + this.name + '</option>'
                })
                $("#city").html(province);
            }
        })
    }
    function querycountry() {
        //加载县
        $.ajax({
            url: "../queryCountry.do",
            type: "post",
            data: {"id":$("#city").val()},
            dataType: "json",
            async: false,
            success: function (countyData) {

                var county = $("#huiCounty").val();
                var province = '<option value="-1">--请选择县/区--</option>';
                $.each(countyData, function () {
                    province += '<option value="' + this.id + '">' + this.name + '</option>'
                })
                $("#county").html(province);
            }
        })
    }

    //条件地区查询
    function gjss(){
        /*alert($("#addressForm").serialize());*/
        var breadChart = echarts.init(document.getElementById('bread'));
        $.ajax({
            url: "../getHouseTwo.do",
            type: "post",
            data:$("#addressForm").serialize(),
            dataType: "json",
            async: false,
            success: function (data1) {
                var data1=data2;
                var data3 = new Array();
                for(var i = 0;i<data1.length;i++){
                    if(data1[i].name==1){
                        data2[i].name="卖";
                        data3.push("卖");
                    }else if(data1[i].name==2){
                        data3.push("租");
                        data2[i].name="租";
                    }
                }
                option3 = {
                    title : {
                        text: '本月房屋交易详情',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        type: 'scroll',
                        orient: 'vertical',
                        left: 20,
                        top: 20,
                        bottom: 20,
                        data: data3,
                    },
                    series : [
                        {
                            name: '金科地产',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:data2,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                breadChart.setOption(option3);
            }
        })
    }


 </script>
</html>
