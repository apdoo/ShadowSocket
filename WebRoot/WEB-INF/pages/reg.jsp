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
<jsp:include page="header.jsp"></jsp:include>
<div id="center-con" class="cl">
<div id="register">
<h1 class="title reg">注册新用户</h1>
<form action="${pageContext.request.contextPath}/user/reg" method="POST">
<lable>用户名:</lable>
<input style="ime-mode: disabled;display:block;" placeholder="用户名：5-30位小写字母数字" autocomplete="off" tabindex="1" class="ipt" type="text" name="user_name" maxlength="30" required oninvalid="setCustomValidity('允许5-30位小写字母、数字');" oninput="setCustomValidity('');" pattern="[a-z0-9]{5,30}" autofocus x-webkit-speech value="">
<p style="margin-top:5px"></p>

<lable>密码:</lable>
<input style="display:block;" tabindex="2" class="ipt" type="pass" placeholder="密码：6-30位字母数字" name="pass" required="required" maxlength="30" value="">
<p style="margin-top:5px"></p>

<lable>Email:</lable>
<input style="display:block;" tabindex="3" class="ipt" type="email" name="email" placeholder="填写常用Email地址" required="required" maxlength="50" x-webkit-speech value="">
<p style="margin-top:5px"></p>
<lable>邀请码:</lable>
<input style="display:block;" tabindex="3" class="ipt" type="temp" name="temp" placeholder="填写邀请码" value="">
<p style="margin-top:5px"></p>

<input type="hidden" name="subjoin" value="1"><input class="btn-reg" type="submit" value="注册帐号">


<p>已经有帐号? <a href="${pageContext.request.contextPath}/ss/login.jsp">点此登录!</a></p>

</form>

</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<div style="display:none;"><script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1253704745'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/stat.php%3Fid%3D1253704745' type='text/javascript'%3E%3C/script%3E"));</script></div></body>
</html>
