<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!-- jquery -->
<script type="text/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.js" charset="utf-8"></script>
<!-- easyUi核心js文件 -->
<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
<!-- easyUi语言包 -->
<script type="text/javascript" src="/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- easyUi默认的css样式 -->
<link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <TITLE>登录页面</TITLE>

    <STYLE>
        body {
            background: #ebebeb;
            font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
            "\9ED1\4F53", Arial, sans-serif;
            color: #222;
            font-size: 12px;
        }

        * {
            padding: 0px;
            margin: 0px;
        }

        .top_div {
            background: #008ead;
            width: 100%;
            height: 400px;
        }

        .ipt {
            border: 1px solid #d3d3d3;
            padding: 10px 10px;
            width: 290px;
            border-radius: 4px;
            padding-left: 35px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
            -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
            ease-in-out .15s;
            -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
            .15s;
            transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
        }

        .ipt:focus {
            border-color: #66afe9;
            outline: 0;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
            rgba(102, 175, 233, .6);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
            rgba(102, 175, 233, .6)
        }

        .u_logo {
            background: url("js/images/username.png") no-repeat;
            padding: 10px 10px;
            position: absolute;
            top: 43px;
            left: 40px;
        }

        .p_logo {
            background: url("js/images/password.png") no-repeat;
            padding: 10px 10px;
            position: absolute;
            top: 12px;
            left: 40px;
        }

        a {
            text-decoration: none;
        }

        .tou {
            background: url("js/images/tou.png") no-repeat;
            width: 97px;
            height: 92px;
            position: absolute;
            top: -87px;
            left: 140px;
        }

        .left_hand {
            background: url("js/images/left_hand.png") no-repeat;
            width: 32px;
            height: 37px;
            position: absolute;
            top: -38px;
            left: 150px;
        }

        .right_hand {
            background: url("js/images/right_hand.png") no-repeat;
            width: 32px;
            height: 37px;
            position: absolute;
            top: -38px;
            right: -64px;
        }

        .initial_left_hand {
            background: url("js/images/hand.png") no-repeat;
            width: 30px;
            height: 20px;
            position: absolute;
            top: -12px;
            left: 100px;
        }

        .initial_right_hand {
            background: url("js/images/hand.png") no-repeat;
            width: 30px;
            height: 20px;
            position: absolute;
            top: -12px;
            right: -112px;
        }

        .left_handing {
            background: url("js/images/left-handing.png") no-repeat;

            width: 30px;
            height: 20px;
            position: absolute;
            top: -24px;
            left: 139px;
        }

        .right_handinging {
            background: url("js/images/right_handing.png") no-repeat;
            width: 30px;
            height: 20px;
            position: absolute;
            top: -21px;
            left: 210px;
        }
    </STYLE>



    <SCRIPT type="text/javascript">
        $(function() {
            //得到焦点
            $("#password").focus(function() {
                $("#left_hand").animate({
                    left : "150",
                    top : " -38"
                }, {
                    step : function() {
                        if (parseInt($("#left_hand").css("left")) > 140) {
                            $("#left_hand").attr("class", "left_hand");
                        }
                    }
                }, 2000);
                $("#right_hand").animate({
                    right : "-64",
                    top : "-38px"
                }, {
                    step : function() {
                        if (parseInt($("#right_hand").css("right")) > -70) {
                            $("#right_hand").attr("class", "right_hand");
                        }
                    }
                }, 2000);
            });
            //失去焦点
            $("#password").blur(function() {
                $("#left_hand").attr("class", "initial_left_hand");
                $("#left_hand").attr("style", "left:100px;top:-12px;");
                $("#right_hand").attr("class", "initial_right_hand");
                $("#right_hand").attr("style", "right:-112px;top:-12px");
            });
        });
    </SCRIPT>



    <META name="GENERATOR" content="MSHTML 11.00.9600.17496">
</HEAD>

<BODY>

<DIV class="top_div"></DIV>

<DIV
        style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">

    <DIV style="width: 165px; height: 96px; position: absolute;">

        <DIV class="tou"></DIV>

        <DIV class="initial_left_hand" id="left_hand"></DIV>

        <DIV class="initial_right_hand" id="right_hand"></DIV>
    </DIV>
    <form id="form1" action="login!login.action" method="post">
        <P style="padding: 30px 0px 10px; position: relative;">
             <INPUT class="ipt" name="phonenumer" type="text" id="phonenumer"
                                                placeholder="请输入手机号" value="">

            <span style="background: rgb(0, 142, 173);cursor:pointer; padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" id="getYzm" onclick="sendnumber(this)">获取验证码</span>
            <%--<a id="btn" href="#" class="easyui-linkbutton" >获取验证码</a>--%>
            <%--<input type="button" value="获取验证码" id="butt" onclick="settime(this)">--%>
        </P>

        <P style="position: relative;">
            <SPAN class="p_logo"></SPAN> <INPUT class="ipt" name="userpass" id="verification"
                                                type="text" placeholder="请输入验证码" value="">
            <span style="background: rgb(0, 142, 173);cursor:pointer; padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" id="checknumber">登录</span>
        </P>
    </form>

    <DIV
            style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">

        <P style="margin: 0px 35px 20px 45px;">
				<SPAN style="float: left;">
                    <A style="color: rgb(204, 204, 204);" href="#">忘记密码?</A>
				</SPAN>
            <SPAN style="float: right;">
                    <A style="color: rgb(204, 204, 204); margin-right: 10px;" href="#">注册</A>
                    <span style="background: rgb(0, 142, 173);cursor:pointer; padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" onclick="tologinpage()">账号登陆</span>

                </SPAN>
        </P>
    </DIV>
</DIV>

<div style="text-align:center;"></div>
</BODY>
<script>
    /*$("#checknumber").click(function () {
        var verification = $("#verification").val();
        var phonenumer = $("#phonenumer").val();
        alert(yanzhengma);
        alert(phonenumer);
        if(phonenumer != null && phonenumer != "" && verification !="" && verification !=null){
        $.ajax({
            url:"login/userLoginMethod.do",
            type: "post",
            data: {"verification":verification,"phonenumer": phonenumer},
            dataType: "json",
            success: function (info) {
                $.messager.alert("提示",info.msg,"info");
                if(info.success){
                    location.href="index.jsp";
                }
            },
            error: function () {
                alert("登陆错误!")
            }
        })
        }else{
            $.messager.alert("提示","账号或验证码不能为空","info");
        }
    })

    var count=60;
    function sendnumber(val) {

        var phonenumer = $("#phonenumer").val();

        if (phonenumer==null||phonenumer==""){
            $.messager.alert("提示","请输入正确的手机号","info");
            return false;
        }else {
            $.ajax({
                url: "login/getInterfaceSMS.do",
                type: "post",
                data: {"phonenumer": phonenumer},
                dataType: "json",
                success: function (jso) {
                    $.messager.alert("提示",jso.msg,"info");

                },
                error: function (jso) {
                    $.messager.alert("提示",jso.msg)
                }
            })
        }
        yanzheng60s(val)
    }
    function yanzheng60s(val) {

        if (count == 0) {
            val.removeAttribute("disabled");
            val.value = "获取验证码";
            count = 60;
            return false;
        } else {

            val.setAttribute("disabled", true);
            $("#getYzm").val("重新发送(" + count + ")");

            count--;
        }
        setTimeout(function () {
            yanzheng60s(val);
        }, 1000);
    }*/
    //刷新验证码
    flag = true;
    /*function updateImg(){
        $("#updateImgCode").attr('src',"../ImgServlet?"+Date.parse(new Date()));
    }*/
    $("#checknumber").click(function () {
        var checkCode = $("#verification").val();
        if (checkCode == "" && checkCode == null) {
            layer.alert("验证码不能为空")
            return;
        }
        if (checkCode.length != 6) {
            layer.alert("验证码必须六位")
            return;
        }
        $.ajax({
            url: "<%=request.getContextPath()%>/login/userLoginMethod",
            type: "post",
            data: {"phonenumer": $("#phonenumer").val(), "verification": $("#verification").val()},
            dataType: "json",
            async: true,
            success: function (data) {
                if (data.success || data.success == "true") {
                    location.href = "index.jsp";
                } else {
                    layer.alert("验证码错误");index.jsp
                }
            }
        });
    })
    var count = 5;
    var time;
    function sendnumber(){
        flag = false;
        $('#getYzm').val(--count+"s");
        if(count <= 0){
            $('#getYzm').val("获取验证码");
            count = 5;
            flag = true;
            window.clearInterval(time);
        }
    }

    $("#getYzm").click(function () {
        var phonenumer = $("#phonenumer").val();
        if (phonenumer == "" && phonenumer == null) {
            layer.alert("用户名不能为空");
            return;
        }
        if ($('#getYzm').val() == "获取验证码"){
            if(flag) {
                time = window.setInterval('countdown()', 1000)
            }
            $.ajax({
                url: "../login/getInterfaceSMS",
                type: "post",
                dataType: "json",
                data: {"phonenumer": $("#phonenumer").val()},
                async: true,
                success: function (data) {
                    if (data.success == 1) {
                        layer.alert("发送成功！请注意查收！");
                    }
                    if (data.success == 2) {
                        layer.alert("该手机号未注册！");
                    }
                    if (data.success == 3) {
                        layer.alert("请稍后！ 亲");
                    }
                    if (data.success == 3) {
                        layer.alert("系统繁忙");
                    }
                }
            });
        }
    })
    function tologinpage(){
        location.href="login.jsp";
    }


    //登录
    /*function landing(){
        if(flag==false){
            $('#container').css('display','block');
            flag=true;
            var loginnumber=$("#loginnumber").val();
            if(loginnumber==""){
                layer.alert('提示','用户名不能为空')
                flag=false
                return;
            }
            /!*var password=$("#password").val();
            if(password==""){
                layer.alert('提示','密码不能为空')
                flag=false
                return;
            }*!/
            var checkCode=$("#checkCode").val();
            if(checkCode==""){
                layer.alert('提示','验证码不能为空')
                flag=false
                return;
            }
            if (checkCode.length!=6) {
                layer.alert('提示','验证码必须六位')
                flag=false
                return;
            }
            $.ajax({
                url:"../login/toLogin.do",
                type:'post',
                async:false,
                data:{
                    loginNumber:loginnumber,
                    password:password,
                    checkNumber:checkCode
                },
                datatype:'json',
                success:function(data){
                    if(data.flag==5){
                        location.href="../index/toIndex.do";
                    }else if(data.flag==1){
                        $('#container').css('display','none');
                        $.messager.alert('提示','验证码错误!');
                        updateImg();
                        flag=false;
                    }
                    else if(data.flag==2){
                        $('#container').css('display','none');
                        $.messager.alert('提示','用户名或密码错误');
                        updateImg();
                        flag=false;
                    }
                    else if(data.flag==3){
                        $('#container').css('display','none');
                        $.messager.alert('提示','账户被锁定');
                        updateImg()
                        flag=false;
                    }
                    else if(data.flag==4){
                        $.messager.alert('警告','警告消息');
                        $.messager.confirm('确认','账号不在常用地址登陆',function(r){
                            if (r){
                                location.href="../index/toIndex.do";
                            }
                        });

                    }
                }
            })
        }else{
            $.messager.alert('提示','请勿重复登录')
        }
    }*/
    //回车登录
    $(document).keypress(function(e) {
        var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
        if (eCode == 13){
            landing();
        }
    });

</script>
</html>
