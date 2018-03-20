<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-03-20
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布公告信息</title>
    <script type="application/javascript" src="/js/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/js/layui/css/layui.css"/>
    <script src="<%=request.getContextPath()%>/js/layui/layui.js"></script>
</head>
<body>
<%--发布公告列表--%>
    <table class="layui-table" id="showNotice" lay-filter="test"></table>
    <script>
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#showNotice'
                , url: '../house/queryNotice'
                ,page:true
               // ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,cols: [[ //表头
                    {field: 'id', title: 'XX',width:80, sort: true, fixed: 'left', checkbox:true}
                    ,{field: 'empnum', title: '手机号', width:180, fixed: 'left'}
                    ,{field: 'headline', title: '标题', width:140, fixed: 'left'}
                    ,{field: 'empname', title: '员工姓名', width:180, fixed: 'left'}
                    ,{field: 'releasetime', title: '公告发布时间', width: 180, fixed: 'left'}
                    ,{field: 'content', title: '内容', width: 180, fixed: 'left'}
                    ,{field: 'auditFlag', title: '审核状态', fixed: 'left', width: 180,
                        templet: function (d) {
                            if (d.auditFlag == 1) {
                                return "待审核";
                            }else if(d.auditFlag == 2){
                                return "审核通过";
                            }else{
                                return "审核未通过";
                            }
                        }
                    }
                ]]
                , height: 430
            });
        });

    </script>
</body>
</html>
