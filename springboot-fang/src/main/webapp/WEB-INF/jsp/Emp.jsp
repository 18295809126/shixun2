<%--
  Created by IntelliJ IDEA.
  User: b
  Date: 2018/3/15
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="/js/layui-v2.2.5/layui/css/layui.css">
    <script type="application/javascript" src="/js/layui-v2.2.5/layui/layui.js"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%--新增按钮--%>
<button class="layui-btn" id="add"><i class="layui-icon">添加</i></button>
<%--<a href="javascript:toadd()">新增</a>--%>
<%--展示列表--%>
<table class="layui-hide" id="test" lay-filter="demo"></table>
<%--新增form--%>
<div id="addstaff" style="display: none">
    <form class="layui-form" id="addstaffForm" >

        <input type="hidden" name="id" id="id">

        <div class="layui-form-item">
            <label class="layui-form-label">员工姓名:</label>
            <div class="layui-input-inline">
                <input type="text" name="name" id="name" required lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">员工微信:</label>
            <div class="layui-input-inline">
                <div  id="demo3"></div>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">手机号:</label>
            <div class="layui-input-inline">
                <input type="text" name="phonenumer" id="phonenumer" required lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">登陆账号:</label>
            <div class="layui-input-inline">
                <input type="text" name="loginnumber" id="loginnumber" required lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-inline">
                <input type="text" name="password" id="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">封面</label>
            <input type="hidden" name="photo" id="image">
        </div>

        <div class="layui-upload">
            <button type="button" class="layui-btn" id="test2">多图片上传</button>
            <div class="layui-upload-list" id="demo2"></div>
        </div>
    </form>
</div>
<script>
    function toadd() {

        $.ajax({

            url :  "../Emp/toAddEmp.do",

        })
    }
    layui.use('upload', function() {
        var $ = layui.jquery
            , upload = layui.upload;

        upload.render({
            elem: '#test2'
            , url: '../Emp/headImgUpload.do'
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
                alert(res.path);
                $("#image").val(res.path);
                //上传完毕
            }
            , allDone: function (obj) {
                console.log(obj)
            }
        });
    })
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'../Emp/showEmp.do'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'22', width:80, title: '',checkbox:true}
                ,{field:'id', width:80, title: 'ID', sort: true}
                ,{field:'name', width:80, title: '用户名'}
                //,{field:'weixin', width:80, title: '微信', sort: true}
                ,{field: 'weixin', title: '微信', width: 130,templet:'<div><img src="{{d.weixin}}"></div>'}
               // ,{field:'photo', width:80, title: '城市'}
                ,{field: 'photo', title: '图片', width: 130,templet:'<div><img src="{{d.photo}}"></div>'}
                ,{field:'phonenumer', title: '手机号', width:120} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'loginnumber', title: '登陆名', sort: true}
                ,{field:'password', title: '密码', sort: true}
                ,{field:'33', title: '操作',align:'center', toolbar: '#barDemo'}
            ]]
        });
    });
    //新增
    $("#add").click(function(){

        location.href = "../Emp/toAddEmp.do";
    })

    //删除
    function delstaff() {
        layui.use('table', function(){
            var table = layui.table;
            var checkStatus = table.checkStatus('test');

            if(checkStatus.data.length==0){
                layer.alert('请选择需要删除的数据!', {icon: 2});
            }else{
                var id=checkStatus.data[0].id;
                layer.confirm('你确定要删除此条数据吗?', {icon: 3, title:'提示'}, function(index){
                    $.ajax({
                        url:"../Emp/delEmp.do",
                        type:"post",
                        data:{'id':id},
                        success:function (map) {
                            if(map.success){
                                layer.close(index);
                                layer.alert('删除成功', {icon: 1});
                                location.href=location;
                            }
                        }
                    })

                });
            }
        })
    }
</script>
<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                //删除
                layui.use('table', function(){
                    var table = layui.table;
                        var id=data.id;
                        layer.confirm('你确定要删除此条数据吗?', {icon: 3, title:'提示'}, function(index){
                            $.ajax({
                                url:"../Emp/delEmp.do",
                                type:"post",
                                data:{'id':id},
                                success:function (map) {
                                    if(map.success){
                                        layer.close(index);
                                        layer.alert('删除成功', {icon: 1});
                                        location.href=location;
                                    }
                                }
                            })

                        });

                });
            } else if(obj.event === 'edit'){
                var  id = null
                layui.use('table', function(){
                    var table = layui.table;
                     id=data.id;

                })
                alert(id);
                location.href = "../Emp/huixianById.do?id="+id;

                /*layui.use('layer', function(){
                    var layer = layui.layer;
                    $('#demo3').append('<img src="' + data.weixin + '" alt="' + "图片不存在" + '" class="layui-upload-img" height="100" width="100">')
                    $("#name").val(data.name);
                    $("#phonenumer").val(data.phonenumer);
                    $("#loginnumber").val(data.loginnumber);
                    $("#password").val(data.password);
                    $("#id").val(data.id);
                    layer.open({
                        title:'修改员工信息',
                        type: 1,
                        content:$("#addstaff"),//这里content是一个普通的String
                        area:['600px', '400px'],
                        offset:'auto',
                        btn:['确认'],
                        yes: function(index, layero){
                            $.ajax({
                                url:"../Emp/updEmp.do",
                                type:"post",
                                data:$("#addstaffForm").serialize(),
                                success:function (map) {
                                    if(map.success){
                                        layer.alert("修改成功！")
                                        layer.close(index);
                                        location.href=location;

                                    }else {
                                        layer.alert("修改出错了！")
                                        layer.close(index);
                                        location.href=location;
                                    }
                                }
                            })
                        }
                    });
                });*/

            }
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

</body>
</html>