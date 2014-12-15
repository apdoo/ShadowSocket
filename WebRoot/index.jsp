<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>ShadowSocks帐号服务 - PGfast网络加速器ShadowSocks帐号代理服务</title>
    <meta name="keywords" content="美国ShadowSocks帐号,日本ShadowSocks帐号,香港ShadowSocks帐号,ss帐号,ShadowSocks代理服务器,pgfastss.com" />
    <meta name="description" content="PGfast提供的ShadowSocks帐号服务" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" /><link rel="icon" href="/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" type="image/x-icon" href="/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/images/pgstyle.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/images/fonts/css.css?family=Open+Sans:400">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/images/font-awesome.min.css" media="screen" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function() {
        });
    </script>
</head>
<body>
<jsp:include page="WEB-INF/pages/header.jsp"></jsp:include>
<div id="top_banner" class="cl">
    <div class="top_banner_in cl">
        <div class="top_banner_left">
            <p>使用简单、快速的加密代理</p>
            <p>多国服务器加速你的网络</p>
            <p>适用于各种设备</p>
            <a class="btn" href="javascript:void(0);">了解更多...</a>
        </div>
        <div class="top_banner_right"></div>
    </div>
</div>

<div id="index_con" class="cl">
    <div id="index_con_easysetup" class="cl">
        <img src="${pageContext.request.contextPath}/images/easysetup.png" />
        <h5>设置简单快速</h5>
        <p>只需要简单的设置即可在Windows、MAC、Android等各种桌面及移动设备上使用PGfast提供的ShadowSocks服务。</p>
    </div>
    <div id="index_con_esafe" class="cl">
        <img src="${pageContext.request.contextPath}/images/esafe.png" />
        <h5>安全的加密连接</h5>
        <p>当连接ShadowSocks服务器后您设备上的网络连接将会使用加密协议传输你的网络连接数据。顺畅访问全球网络。</p>
    </div>
    <div id="index_con_manyserver" class="cl">
        <img src="${pageContext.request.contextPath}/images/manyserver.png" />
        <h5>多国服务器简单切换</h5>
        <p>PGfast网络加速器提供的ShadowSocks服务提供美国、日本、新加坡、香港等全球各地服务器一号通用无需额外付费。</p>
    </div>
</div>
<jsp:include page="WEB-INF/pages/footer.jsp"></jsp:include>

</html>