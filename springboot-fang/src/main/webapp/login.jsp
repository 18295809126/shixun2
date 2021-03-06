<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <TITLE>登录页面</TITLE>

    <SCRIPT src="js/jquery-1.9.1.min.js" type="text/javascript"></SCRIPT>
    <script src="checkedCode/gVerify.js"></script>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css">
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>


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

        .ipt1{
            border: 1px solid #d3d3d3;
            padding: 10px 10px;
            width: 250px;
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
            background: url("/js/images/left-handing.png") no-repeat;
            width: 30px;
            height: 20px;
            position: absolute;
            top: -24px;
            left: 139px;
        }

        .right_handinging {
            background: url("/js/images/right_handing.png") no-repeat;
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
        style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 290px; text-align: center;">

    <DIV style="width: 165px; height: 150px; position: absolute;">

        <DIV class="tou"></DIV>

        <DIV class="initial_left_hand" id="left_hand"></DIV>

        <DIV class="initial_right_hand" id="right_hand"></DIV>
    </DIV>
    <form id="loginform1">
        <P style="padding: 30px 0px 10px; position: relative;">
            <SPAN class="u_logo"></SPAN> <INPUT class="ipt" name="loginnumber" id="loginnumber" type="text"
                                                placeholder="请输入用户名" value="">

        </P>

        <P style="position: relative;">
            <SPAN class="p_logo"></SPAN> <INPUT class="ipt" name="password" id="password"
                                                type="password" placeholder="请输入密码" value="">
        </P>
        <div id="v_container" style="width: 290px;height: 30px;margin-left: 55px;margin-top: 8px;margin-bottom: 8px;"></div>
        <input class="ipt" id="code_input" value="" placeholder="请输入验证码"/>
    </form>

    <DIV
            style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">

        <P style="margin: 0px 35px 20px 45px;">
				<SPAN style="float: left;">
                   <A style="color: rgb(204, 204, 204);" href="javascript:Usersubmit()">忘记密码?</A>
				</SPAN>
            <SPAN style="float: right;">
                    <A style="color: rgb(204, 204, 204); margin-right: 10px;" href="#">注册</A>
					<span style="background: rgb(0, 142, 173);cursor:pointer; padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" onclick="submits()">登录</span>
                    <span style="background: rgb(0, 142, 173);cursor:pointer; padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" onclick="tophoneloginpage()">手机号登陆</span>
                </SPAN>
        </P>
    </DIV>
</DIV>


<div style="text-align:center;"></div>
</BODY>
<script>
    var verifyCode = new GVerify("v_container");
    function submits(){
        $.ajax({
            url:"../login/login.do",
            type:"post",
            data:$("#loginform1").serialize(),
            dataType:"json",
            success:function (data) {
                if(data.success){
                    var res = verifyCode.validate(document.getElementById("code_input").value);
                    if(res){
                        location.href="index.jsp";
                    }else{
                        $.messager.alert('警告',"验证码错误");
                    }
                }else{
                    $.messager.alert('警告',data.mag);
                }
            }
        })
    }
    function tophoneloginpage(){
        location.href="../phonelogin.jsp";
    }

    //忘记密码怎么办！快去修改啊啊
    function Usersubmit(){
        layui.use('layer', function() {
            var layer = layui.layer;
            layer.open({
                id: 1,
                type: 1,
                title: '修改密码',
                skin: 'layui-layer-rim',
                area: ['450px', 'auto'],

                content: ' <div class="row" style="width: 420px;  margin-left:7px; margin-top:10px;">'
                + '<div class="col-sm-12">'
                + '<div class="input-group">'
                + '<span class="input-group-addon"> 新 密 码   :</span>'
                + '<input id="firstpwd" type="password" class="form-control" placeholder="请输入密码">'
                + '</div>'
                + '</div>'
                + '<div class="col-sm-12" style="margin-top: 10px">'
                + '<div class="input-group">'
                + '<span class="input-group-addon">确认密码:</span>'
                + '<input id="secondpwd" type="password" class="form-control" placeholder="请再输入一次密码">'
                + '</div>'
                + '</div>'
                + '</div>'
                ,
                btn: ['保存', '取消'],
                btn1: function (index, layero) {
                    layer.close(index);
                },
                btn2: function (index, layero) {
                    layer.close(index);
                }
            });
        })
    }
</script>
</html>
