<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/metro/demo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        $(function() {
            //弹层默认关闭
            $('#w').window('close');
            $('#i').window('close');
            $('#tt').datagrid({
                url:'${pageContext.request.contextPath}/admin/getUsers',
                singleSelect:true,
                loadMsg:'数据加载中,请稍后......',
                frozenColumns:[[
                    {field:'uid',checkbox:true}
                ]],//单选按钮
                fit: true,
                rownumbers:true,
                toolbar:[
                    {text:'添加',iconCls:'icon-add',handler:add},
                    {text:'编辑',iconCls:'icon-edit',handler:update} ,
                    {text:'删除',iconCls:'icon-remove',handler:deletef}
                ],
                pagination:true
            });
            var p = $('#tt').datagrid('getPager');
            $(p).pagination({
                pageSize: 10,
                pageList: [10,20,50],
                beforePageText: '第',
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
            });
        });
        function add(){
            $('#i').window('open');
        }
        function addsubmit(){
            $.ajax({
                type : "POST",
                url : "${pageContext.request.contextPath}/admin/addUser",
                dataType:"json",
                data :$("#userformnew").serialize(),
                success : function(data) {
                    $('#i').window('close');
                    $('#tt').datagrid('reload');
                },
                error:function(){
                    alert("新增失败");
                }
            });
        }

        function deletef(){
            var id="";
            $("input:checked").each(function(){
                id=$(this).val();
            });
            if(id==""){
                alert("选择一个用户进行删除");
                return false;
            }
            $.messager.confirm('提示框', '你确定要删除吗?',function(){
                $.ajax({
                    type : "POST",
                    url : "${pageContext.request.contextPath}/admin/deleteUser",
                    dataType:"json",
                    data :{
                        id:id
                    },
                    success : function(data) {
                        $('#tt').datagrid('reload');
                    },
                    error:function(){
                    }
                });
            });
        }
        //
        function cancel(){
            $('#w').window('close');
            $('#i').window('close');
        }
        //确认修改
        function submit(){
            $.ajax({
                type : "POST",
                url : "${pageContext.request.contextPath}/admin/updateUser",
                dataType:"json",
                data :$("#userform").serialize(),
                success : function(data) {
                    $('#w').window('close');
                    $('#tt').datagrid('reload');
                },
                error:function(){
                }
            });
        }
        //更新方法
        function update(){
            var id="";
            $("input:checked").each(function(){
                id=$(this).val();
            });
            if(id==""){
                alert("选择一个用户进行更改");
                return false;
            }
            $.ajax({
                type : "POST",
                url : "${pageContext.request.contextPath}/admin/getUserInfo",
                dataType:"json",
                data : {
                    id : id
                },
                success : function(data) {
                    $('#userform').form('load',data);
                    $('#w').window('open');
                },
                error:function(){
                }
            });
        }
        function optionTransfer(value,rec,index){
            return  typeTransform(rec.priv);
        }
        function typeTransform(priv){
            switch (priv)
            {
                case 0:return "普通会员";break;
                case 1:return "管理员"; break;
                default : return "未知";

            }
        }
    </script>
</head>

<body>
<table id="tt">
    <thead>
    <tr>
        <th field="user_name" width="100">用户名</th>
        <th field="email" width="100">邮箱</th>
        <th field="passwd" width="100">ss密码</th>
        <th field="u" width="100">上传(MB)</th>
        <th field="d" width="100">下载(MB)</th>
        <th field="transfer_enable" width="100">流量限止(G)</th>
        <th field="port" width="100">ss端口</th>
        <th field="server" width="100">服务器ID</th>
        <th data-options="field:'opt',width:80,align:'center',formatter:optionTransfer,sortable:true">类型</th>
    </tr>
    </thead>
</table>
<div id="i" class="easyui-window" data-options="title:'会员新增',iconCls:'icon-save'" style="width:500px;height:300px;padding:5px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center',border:false" style="padding:10px;background:#fff;border:1px solid #ccc;">
            <form id="userformnew" >
                <table align="center">
                    <tr>
                        <td>用户名：</td>
                        <td><input type="text" value=""  name="user_name"  ></td>
                    </tr>
                    <tr>
                        <td>邮箱：</td>
                        <td><input type="text" value="" id="email" name="email"  ></td>
                    </tr>
                    <tr>
                        <td>登录密码：</td>
                        <td><input type="text" value=""   name="pass"  ></td>
                    </tr>

                </table>
            </form>
        </div>
        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0;">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="addsubmit()">确定</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="cancel()">取消</a>
        </div>
    </div>
</div>
<!--弹层-->
<div id="w" class="easyui-window" data-options="title:'会员修改',iconCls:'icon-save'" style="width:500px;height:300px;padding:5px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center',border:false" style="padding:10px;background:#fff;border:1px solid #ccc;">
            <form id="userform" >
                <table align="center">
                    <input type="hidden" value="" id="uid" name="uid"  >
                    <tr>
                        <td>用户名：</td>
                        <td><input type="text" value="" id="user_name" name="user_name" disabled="disabled"></td>
                    </tr>
                    <tr>
                        <td>登录密码：</td>
                        <td><input type="text" value="" id="pass" name="pass"  ></td>
                    </tr>
                    <tr>
                        <td>ss密码：</td>
                        <td><input type="text" value="" id="passwd" name="passwd"  ></td>
                    </tr>
                    <tr>
                        <td>流量限制(G)：</td>
                        <td><input type="text" value="" id="transfer_enable" name="transfer_enable"  ></td>
                    </tr>
                    <tr>
                        <td>ss端口：</td>
                        <td><input type="text" value="" id="port" name="port"  ></td>
                    </tr>
                    <tr>
                        <td>服务器id：</td>
                        <td><input type="text" value="" id="server" name="server"  ></td>
                    </tr>
                </table>
            </form>
        </div>
        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0;">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="submit()">确定</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="cancel()">取消</a>
        </div>
    </div>
</div>
</body>
</html>