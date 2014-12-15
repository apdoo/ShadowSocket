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
            $('#w').window('close');
            $('#i').window('close');
            $('#tt').datagrid({
                url:'${pageContext.request.contextPath}/admin/getServers',
                singleSelect:true,
                loadMsg:'数据加载中,请稍后......',
                frozenColumns:[[
                    {field:'id',checkbox:true}
                ]],
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
        function deletef(){
            var id="";
            $("input:checked").each(function(){
                id=$(this).val();
            });
            if(id==""){
                alert("选择一个记录进行更改");
                return false;
            }
            $.messager.confirm('提示框', '你确定要删除吗?',function(){
                $.ajax({
                    type : "POST",
                    url : "${pageContext.request.contextPath}/admin/deleteServer",
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
        function add(){
            $('#i').window('open');
        }
        function addsub(){
            $.ajax({
                type : "POST",
                url : "${pageContext.request.contextPath}/admin/insertServer",
                dataType:"json",
                data :$("#serverform").serialize(),
                success : function(data) {
                    $('#i').window('close');
                    $('#tt').datagrid('reload');
                },
                error:function(){
                    alert("新增失败");
                }
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
                url : "${pageContext.request.contextPath}/admin/updateServer",
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
                alert("选择一个记录进行更改");
                return false;
            }

            $.ajax({
                type : "POST",
                url : "${pageContext.request.contextPath}/admin/getServerInfo",
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

    </script>
</head>

<body>
<table id="tt">
    <thead>
    <tr>
        <th field="ip" width="100">ip</th>
        <th field="addr" width="100">地址</th>
        <th field="encryption" width="100">加密方式</th>
    </tr>
    </thead>
</table>

<div id="i" class="easyui-window" data-options="title:'新增服务器',iconCls:'icon-save'" style="width:500px;height:300px;padding:5px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center',border:false" style="padding:10px;background:#fff;border:1px solid #ccc;">
            <form id="serverform" >
                <table align="center">
                    <tr>
                        <td>ip：</td>
                        <td><input type="text" value=""  name="ip"  ></td>
                    </tr>
                    <tr>
                        <td>地址：</td>
                        <td><input type="text" value=""   name="addr"  ></td>
                    </tr>
                    <tr>
                        <td>加密方式：</td>
                        <td><select    name="encryption"  >
                            <option value="aes-256-cfb"> aes-256-cfb</option>
                            <option value="bf-cfb">bf-cfb</option>
                            <option value="table">table</option>
                            <option value="aes-128-cfb">aes-128-cfb</option>
                            <option value="aes-192-cfb">aes-192-cfb</option>
                            <option value="camellia-128-cfb">camellia-128-cfb</option>
                            <option value="camellia-192-cfb">camellia-192-cfb</option>
                            <option value="camellia-256-cfb">camellia-256-cfb</option>
                            <option value="cast5-cfb">cast5-cfb</option>
                            <option value="des-cfb">des-cfb</option>
                            <option value="idea-cfb">idea-cfb</option>
                            <option value="rc2-cfb">rc2-cfb</option>
                            <option value="rc4">rc4</option>
                            <option value="seed-cfb">seed-cfb</option>
                            </select></td>
                    </tr>
                </table>
            </form>

        </div>
        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0;">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="addsub()">确定</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="cancel()">取消</a>
        </div>
    </div>
</div>
<!--弹层-->
<div id="w" class="easyui-window" data-options="title:'服务器修改',iconCls:'icon-save'" style="width:500px;height:300px;padding:5px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center',border:false" style="padding:10px;background:#fff;border:1px solid #ccc;">
            <form id="userform" >
                <table align="center">
                    <tr>
                        <td>id：</td>
                        <td> <input type="text" value="" id="id" name="id" readonly="readonly" ></td>
                    </tr>

                    <tr>
                        <td>ip：</td>
                        <td><input type="text" value="" id="ip" name="ip"  ></td>
                    </tr>
                    <tr>
                        <td>地址：</td>
                        <td><input type="text" value="" id="addr" name="addr"  ></td>
                    </tr>
                    <tr>
                        <td>加密方式：</td>
                        <td><input type="text" value="" id="encryption" name="encryption"  ></td>
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