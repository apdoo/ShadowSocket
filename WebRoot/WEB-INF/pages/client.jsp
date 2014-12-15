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
	<div id="guide" class="cl">
		<h1><i class="fa fa-lg fa-send mr10" style="color:#ffab6c;"></i>客户端下载及使用教程</h1>
		<p class="tips tips_info">所有系统使用ShadowSocks的主要设置部分就是填写<strong>服务器地址、服务端口、服务密码、加密方式</strong>四个信息，这些信息你可以登录官网后看到。咨询QQ 1584349998</p>
		<div class="guide_con cl">
		<h2><i class="fa fa-windows mr10" style="color:#17C9E8;"></i>Windows系统</h2>
		<ul>
			<li>Windows 7及7以下系统客户端下载：<i class="fa fa-download mr5" style="#8B8C8B"></i><a href="http://dl.pgfast.net/Shadowsocks-win-2.0.11.zip" target="_blank">Shadowsocks-win-2.0.11.zip</a></li>
			<li>Windows 8客户端下载：<i class="fa fa-download mr5" style="#8B8C8B"></i><a href="http://dl.pgfast.net/Shadowsocks-win-dotnet4.0-2.0.11.zip" target="_blank">Shadowsocks-win-dotnet4.0-2.0.11.zip</a></li>
			<li><a href="http://www.pgssh.com/Windows-shadowsocks.html" target="_blank"><i class="fa fa-file-text mr5" style="color:#aaa;"></i>使用教程</a></li>
		</ul>

		<h2><i class="fa fa-apple mr10" style="color:#4B4B4B;"></i>MAC OS</h2>
		<ul>
			<li>MAC OS客户端下载：<i class="fa fa-download mr5" style="#8B8C8B"></i><a href="http://dl.pgfast.net/ShadowsocksX-2.4.1.dmg" target="_blank">ShadowsocksX-2.4.1.dmg</a></li>
			<li><a href="http://www.pgssh.com/mac-shadowsocks.html" target="_blank"><i class="fa fa-file-text mr5" style="color:#aaa;"></i>使用教程</a></li>
		</ul>

		<h2><i class="fa fa-apple mr10" style="color:#B8B8B8;"></i>iPhone,iPad</h2>
		<ul>
			<li>（未越狱）iPhone,iPad客户端下载：<i class="fa fa-link mr5" style="#8B8C8B"></i><a href="https://itunes.apple.com/us/app/shadowsocks/id665729974?mt=8" target="_blank">APP Store下载</a></li>
			<li>（已越狱）iPhone,iPad客户端下载：请直接在Cydia里搜索 Shadowsocks ，然后安装即可</li>
			<li><a href="http://www.pgssh.com/ios-shadowsocks.html" target="_blank"><i class="fa fa-file-text mr5" style="color:#aaa;"></i>使用教程</a></li>
		</ul>

		<h2><i class="fa fa-android mr10" style="color:#95bf3f;"></i>安卓Android系统</h2>
		<ul>
			<li>安卓客户端下载：<i class="fa fa-download mr5" style="#8B8C8B"></i><a href="http://dl.pgfast.net/shadowsocks-nightly-2.4.6.apk" target="_blank">shadowsocks-nightly-2.4.6.apk</a></li>
			<li><a href="http://www.pgssh.com/android-shadows.html" target="_blank"><i class="fa fa-file-text mr5" style="color:#aaa;"></i>使用教程</a></li>
		</ul>
		</div>

	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<div style="display:none;"><script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1253704745'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/stat.php%3Fid%3D1253704745' type='text/javascript'%3E%3C/script%3E"));</script><span id="cnzz_stat_icon_1253704745"><a href="http://www.cnzz.com/stat/website.php?web_id=1253704745" target="_blank" title="站长统计">站长统计</a></span><script src="./buy_files/stat.php" type="text/javascript"></script><script src="./buy_files/core.php" charset="utf-8" type="text/javascript"></script></div>
</body></html>