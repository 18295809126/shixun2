<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 2018/3/15
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情页面</title>
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>

    <%--轮播--%>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/js/unslider/css/css.css">
    <script src="<%=request.getContextPath() %>/js/unslider/js/index.js"></script>
</head>
<hr>
<a class="layui-btn layui-btn-mini" onclick="backToShowHouse()" lay-event="edit">返回</a>
 <center>
        <div>
         <h1>${house.title}</h1>
         <br>
            <h2> <font color="#ff8c00">${house.price}万</font> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<font color="#ff8c00">${house.room}室${house.hall}厅</font>&nbsp;&nbsp;&nbsp;&nbsp; |&nbsp;&nbsp;&nbsp;&nbsp;<font color="#ff8c00">${house.house_area}平方米</font></h2>
        </div>
 </center>
   <div style="margin-left: 280px" class="layui-carousel" id="test10">
    <div carousel-item="" id="imgs">
    </div>
   </div>
         <hr color="#cccccc" size="100%"/>
           <h2 >  <font color="#008b8b">房屋信息</font>
           </h2>
         <br>
<br>
          <table border="0">
              <tr>
                  <td>小区名称:</td>
                  <td>${house.community}</td>
                  <td style="padding-left: 50px">地区位置:</td>
                  <td>海淀-上地</td>
                  <td style="padding-left: 50px">房屋户型:</td>
                  <td>${house.room}室${house.hall}厅${house.toilet}卫</td>
                  <td style="padding-left: 50px">装修程度:</td>
                  <td>${house.decorate}</td>
              </tr>
              <tr>
              <td >建筑类型:</td>
              <td>${house.name}</td>
              </td>
              <td style="padding-left: 50px">建筑面积:</td>
              <td>${house.house_area}平方米</td> </td>
              <td style="padding-left: 50px">房屋朝向:</td>
              <td>${house.room_direction}</td>
              <td style="padding-left: 50px">所在楼层:</td>
              <td>${house.house_floor}</td>
              </tr>
              <tr>
              <td style=""><font >建造年代:</font>:</td>
              <td>${house.building_time}</td>
              <td style="padding-left: 50px">房屋单价:</td>
              <td>${house.unit_price}元/㎡</td> </td>
              <td style="padding-left: 50px">参考首付:</td>
              <td>257万</td>
              <td style="padding-left: 50px">参考月供:</td>
              <td>${house.monthly_payments}元</td>
          </tr>
          </table>
    <br><br>
金科房产提示：非安选房源，在售状态请与经纪人确认 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;房屋编码:&nbsp;&nbsp;&nbsp;&nbsp;${house.room_num}&nbsp;&nbsp;&nbsp;&nbsp;发布时间:${house.release_time}
<br>
<hr color="#cccccc" size="100%"/>
<h2><font color="#008b8b">核心卖点</font></h2><br><br><br>
${house.selling_point}<br><br><br>
<hr color="#cccccc" size="100%"/>
<h2><font color="#008b8b">户主心态</font></h2><br><br><br>
${house.owner_mentality}<br><br><br>
<hr color="#cccccc" size="100%"/>
<h2><font color="#008b8b">小区配套</font></h2><br><br><br>
${house.community_complete}
</body>
<script>
    $(function () {
        $.ajax({
            url:"../house/getHousePhoto.do",
            type:"post",
            data:{"id":"${house.id}"},
            dataType:"json",
            success:function (data) {
              var arr=data.url;
              //var url="";
              for(var i=0;i<arr.length;i++){
                  $("#imgs").append("<div><img src='"+arr[i]+"'></div>");
                  //$("#img").append("<li><img src='"+arr[i]+"' width='50' height='50'></li>");
                 // alert(arr[i]);
                }
           },
            error:function () {
             alert("GG");
            }
        })

    })
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;


        //设定各种参数
        var ins3 = carousel.render({
            elem: '#test3'
        });
        //图片轮播
        carousel.render({
            elem: '#test10'
            ,width: '530'
            ,height: '300'
            ,interval: 3000
        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                    ,key = othis.data('key')
                    ,options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function(){
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });
    });
    // location.href="../house/toShowHouse.do";   查看预约信息
    //返回房源展示页面
    function backToShowHouse() {
        location.href="../house/toShowHouse.do";
    }
</script>
</html>
