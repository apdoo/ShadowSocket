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
    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="center-con" class="cl">
<div id="login">
<h1 class="title login">用户登录</h1>

<form  method="POST" action="${pageContext.request.contextPath}/user/login">

<lable>用户名:</lable>
<input style="ime-mode:disabled;display:block;" placeholder="请输入您的用户名" autocomplete="off" required="required" pattern="[a-z0-9]{1,30}" autofocus x-webkit-speech tabindex="1" class="ipt" type="text" name="user_name" maxlength="30" value="">
<p style="margin-top:5px;"></p>
<lable>密码:</lable>
<input style="display:block;" tabindex="2" class="ipt" type="password" name="pass" maxlength="30" placeholder="请输入您的密码" required="required" x-webkit-speech value="">
<p style="margin-top:5px;"></p>
<p><input style="vertical-align: text-bottom;" type="checkbox" name="remember" >下次自动登录</p>
<input type="hidden" name="sublogin" value="1">
<input class="btn-login" type="submit" value="点击登录">
<%--<p>[<a href="/forgotpass.php">找回密码</a>]</p>--%>
<p>还没有帐号? <a href="${pageContext.request.contextPath}/reg">点这里注册一个!</a></p>

</form>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<div style="display:none;"><script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1253704745'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/stat.php%3Fid%3D1253704745' type='text/javascript'%3E%3C/script%3E"));</script></div></body>
</html>
