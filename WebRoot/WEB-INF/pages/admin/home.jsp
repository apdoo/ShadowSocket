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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/metro/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/metro/demo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/myeasyui.js"></script>

    <style>
        .footer {
            width: 100%;
            text-align: center;
            line-height: 35px;
        }
        .top-bg {
            background-color: #d8e4fe;
            height: 80px;
        }
    </style>
    <script type="text/javascript">
        var root="${pageContext.request.contextPath}";
    </script>
</head>

<body class="easyui-layout">
<div region="north" border="true" split="true" style="overflow: hidden; height: 80px;">
    <div class="top-bg"></div>
</div>
<div region="south" border="true" split="true" style="overflow: hidden; height: 40px;">
    <div class="footer">测试：<a >apdo</a></div>
</div>
<div region="west" split="true" title="导航菜单" style="width: 200px;">
    <jsp:include page="leftmenu.jsp"/>
</div>
<div id="mainPanle" region="center" style="overflow: hidden;">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">
            <h1>欢迎~</h1>
        </div>
    </div>
</div>
</body>
</html>