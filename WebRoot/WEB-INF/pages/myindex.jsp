﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
        var root="${pageContext.request.contextPath}";//根路径
        var server=root+"/user/server";
        var userRefresh=root+"/user/refresh";
        $(function(){
            var serverids="${userinfo.server}";
            ititServer(serverids);
        });
        function ititServer(serverids){
            $.ajax({
                type : "POST",
                url : server,
                dataType:"json",
                data:{
                    ids:serverids
                },
                success : function(data) {
                    var content=" <li class=\"title_header\"><span class=\"serverarea\">地区</span><span class=\"serverip\">服务器地址</span><span>加密方式</span></li>";                    if(data.success){
                    }
                    $.each(data.data,function(key,val){
                        content=content+"<li><span class=\"serverarea\">"+val.addr+"</span><span class=\"serverip\">"+val.ip+"</span><span class=\"sstype sstype_aes\">"+val.encryption+"</span><span class=\"qrcodesetup\"><a title=\"服务器地区："+val.addr+"\" class=\"inline\" href=\"#server_hk2\"><i style=\"color:#999;\" class=\"fa fa-qrcode mr5\"></i>二维码配置</a></span></li>";
                    });
                     $("#servers").html(content);
                },
                error:function(){
                }
            });
        }
       function refreshByType(type){
            var port=root+"/user/refreshProt";
            var pass=root+"/user/refreshPass";
           var url="";
           if("port"==type){
               url=port;
           } else if("pass"==type){
               url=pass;
           }
           var uid="${userinfo.uid}";
           $.ajax({
               type : "POST",
               url : url,
               dataType:"json",
               data:{
                   uid:uid
               },
               success : function(data) {
                   if(data.success){
                        $("#u_passwd").text(data.data.passwd);
                        $("#u_port").text(data.data.port);
                   }
               },
               error:function(){
                   alert("刷新失败");
               }
           });
        }
        function refresh(){
             var uid="${userinfo.uid}";
            $.ajax({
                type : "POST",
                url : userRefresh,
                dataType:"json",
                data:{
                    uid:uid
                },
                success : function(data) {
                    if(data.success){
                        $("#u_info_2").text(data.data.s_t+"MB");
                         $("#u_info_1").html("<p><i class=\"fa fa-gift mr10\" style=\"color:#d5d5d5;\"></i> 总流量:"+data.data.transfer_enable+"G</p>"+
                                 "<p><i class=\"fa fa-square mr10\" style=\"color:#ed43d5;\"></i> 上传流量:"+data.data.u+" MB</p>"+
                                 "<p><i class=\"fa fa-square mr10\" style=\"color:#62c462;\"></i> 下载流量:"+data.data.d+" MB</p>"+
                                 "<p><i class=\"fa fa-square mr10\" style=\"color:#d5d5d5;\"></i> 剩余流量:"+data.data.s_t+" MB</p>"+
                                 "<p><i class=\"fa fa-clock-o mr10\" style=\"color:#d5d5d5;\"></i> 最近连接:"+data.data.temp+"</p>");
                     }
                },
                error:function(){
                    alert("刷新失败");
                }
            });
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="center-con" class="cl">
    <div id="client_area" class="cl">

        <div class="userinfo_left"><div class="userinfo"><h1><i style="color:#ccc;" class="fa fa-user mr10"></i>官网帐号信息</h1><ul><li style="border-top:none"><span class="fr">${userinfo.user_name}</span>用户名：</li><li><span class="fr">${userinfo.email}</span>Email：</li><li><span class="fr">${userinfo.reg_date}</span>注册日期：</li><li><span style="color:#FF7600;" class="fr" id="u_info_2">${userinfo.s_t} MB</span>剩余流量：</li><li style="border-bottom:none"></li></ul></div>
            <div class="cl" style="padding:0 10px;">
                <p> <a class="userinfo_link bg_orange mr5" onclick="refresh();" href="javascript:void(0)">刷新流量</a>- <a class="userinfo_link bg_green mr5" href="${pageContext.request.contextPath}/modify">修改信息</a> <a class="userinfo_link bg_red" href="${pageContext.request.contextPath}/user/exit">退出</a></p>
                <%--<p>遇到问题请联系客服QQ:1584349998</p>--%>
            </div>

            <%--<div class="cl"><a class="affmemberlink" href="/affmember.php" target="_blank"><i class="fa fa-dollar mr10"></i>推广联盟赚钱</a></div>--%>
            <%--<div id="ifneedvpnss"><a href="http://www.pgfast.net" target="_blank">也许你还需要VPN</a></div>--%>
        </div>


        <div class="serverlist">
            <div class="mb30 cl">
                <h1><i class="fa fa-send mr10" style="color:#8cc14c;"></i>ShadowSocks帐号信息</h1>
                <div class="cl">
                    <div style="" class="progress">
                        <div style="width:0%;float:left;background-image:linear-gradient(to bottom, #ed43d5, #b04cac);background-color:#a25eba;" class="bar"></div><div style="width:0%;float:left;" class="bar"></div>
                    </div>

                    <div class="cl bdinfo">
                        <div class="cl fl" id="u_info_1">
                            <p><i class="fa fa-gift mr10" style="color:#d5d5d5;"></i> 总流量: ${userinfo.transfer_enable} G</p>
                            <p><i class="fa fa-square mr10" style="color:#ed43d5;"></i> 上传流量: ${userinfo.u} MB</p>
                            <p><i class="fa fa-square mr10" style="color:#62c462;"></i> 下载流量: ${userinfo.d} MB</p>
                            <p><i class="fa fa-square mr10" style="color:#d5d5d5;"></i> 剩余流量: ${userinfo.s_t} MB</p>
                            <p><i class="fa fa-clock-o mr10" style="color:#d5d5d5;"></i> 最近连接: ${userinfo.temp} </p>
                        </div>
                        <div class="cl fr">
                            <div class="ss_port_pass"><div style="background:#9ad7ef;" class="bar">Port端口</div><div class="co" id="u_port">${userinfo.port}</div><a title="重置ShadowSocks服务端口" id="resetsshover" href="javascript:void(0)" onclick="refreshByType('port')"><div class="reset">重置<i class="fa fa-gear" style="color:#fff;"></i></div></a></div>
                            <div class="ss_port_pass"><div style="background:#f9ce8f;" class="bar">Pass密码</div><div class="co" id="u_passwd" >${userinfo.passwd}</div><a title="重置ShadowSocks服务密码" id="resetsshover" href="javascript:void(0)" onclick="refreshByType('pass')"><div class="reset">重置<i class="fa fa-gear" style="color:#fff;"></i></div></a></div>
                            <!-- <div class="ss_port_pass"><div style="background:#b8acc8;" class="bar">加密方式</div><div class="co">RC4-MD5</div><div class="reset"><i class="fa fa-question-circle" style="color:#fff;"></i></div></div> -->
                        </div>
                    </div>

                </div>
            </div>
            <div class="serverlist_sl cl">
                <h1><i class="fa fa-sitemap mr10" style="color:#409ED9;"></i>ShadowSocks服务器列表</h1>
                <p class="tips tips_info">下面的“服务器地址”和“加密方式”以及“json配置文件”将有可能会变更。</p>
                <%--<p style="padding:15px;background:#f8f8f8;border-radius:3px;"><i class="fa fa-download mr5"></i><a href="get_gui_config_json.php?user=he7253997">点这里下载 json 自动配置文件</a>，<i class="fa fa-file-text mr5"></i><a title="json自动配置文件使用方法" class="inline" href="#howto_json">查看使用方法</a>，<i class="fa fa-clock-o mr5"></i>最近更新：2014-12-08</p>--%>
                <ul id="servers">
               </ul>
            </div>




        </div>


        <div style='display:none'>
            <div id='server_sg' style='padding:10px; background:#fff;text-align:center;'><img src="http://qr.liantu.com/api.php?w=160&m=5&text=ss://cmM0LW1kNTozM3FseHo2NUAxMTAuMzQuMTkxLjEwODo2NDc0Ng==" /><p>此二维码包含你的帐号信息，不要发布到公共网络。</p><p>ss://cmM0LW1kNTozM3FseHo2NUAxMTAuMzQuMTkxLjEwODo2NDc0Ng==</p></div>
            <div id='server_jp' style='padding:10px; background:#fff;text-align:center;'><img src="http://qr.liantu.com/api.php?w=160&m=5&text=ss://cmM0LW1kNTozM3FseHo2NUAxMDYuMTg2LjE2LjEyMTo2NDc0Ng==" /><p>此二维码包含你的帐号信息，不要发布到公共网络。</p><p>ss://cmM0LW1kNTozM3FseHo2NUAxMDYuMTg2LjE2LjEyMTo2NDc0Ng==</p></div>
            <div id='server_hk1' style='padding:10px; background:#fff;text-align:center;'><img src="http://qr.liantu.com/api.php?w=160&m=5&text=ss://YWVzLTI1Ni1jZmI6MzNxbHh6NjVAMTE4LjE5My4xNzAuMTQwOjY0NzQ2" /><p>此二维码包含你的帐号信息，不要发布到公共网络。</p><p>ss://YWVzLTI1Ni1jZmI6MzNxbHh6NjVAMTE4LjE5My4xNzAuMTQwOjY0NzQ2</p></div>
            <div id='server_hk2' style='padding:10px; background:#fff;text-align:center;'><img src="http://qr.liantu.com/api.php?w=160&m=5&text=ss://YWVzLTI1Ni1jZmI6MzNxbHh6NjVAMTIyLjEwLjExMy4xNTo2NDc0Ng==" /><p>此二维码包含你的帐号信息，不要发布到公共网络。</p><p>ss://YWVzLTI1Ni1jZmI6MzNxbHh6NjVAMTIyLjEwLjExMy4xNTo2NDc0Ng==</p></div>
            <div id='server_usa' style='padding:10px; background:#fff;text-align:center;'><img src="http://qr.liantu.com/api.php?w=160&m=5&text=ss://cmM0LW1kNTozM3FseHo2NUAxMDQuMTMxLjE0Mi44OTo2NDc0Ng==" /><p>此二维码包含你的帐号信息，不要发布到公共网络。</p><p>ss://cmM0LW1kNTozM3FseHo2NUAxMDQuMTMxLjE0Mi44OTo2NDc0Ng==</p></div>
            <div id='server_sg2' style='padding:10px; background:#fff;text-align:center;'><img src="http://qr.liantu.com/api.php?w=160&m=5&text=ss://YWVzLTI1Ni1jZmI6MzNxbHh6NjVAMTAzLjExLjE0My43NDo2NDc0Ng==" /><p>此二维码包含你的帐号信息，不要发布到公共网络。</p><p>ss://YWVzLTI1Ni1jZmI6MzNxbHh6NjVAMTAzLjExLjE0My43NDo2NDc0Ng==</p></div>

            <div id='howto_json' style='padding:10px; background:#fff;text-align:left;'>
                <p><i class="fa fa-exclamation-circle mr10" style="color:#FF004C;"></i>此自动配置文件并不适用所有的shadowsocks客户端只适应于我们指定的客户端。</p>
                <p style="color:#FF004C;"><i class="fa fa-exclamation-circle mr10"></i>此自动配置文件包含你的私有帐号信息切勿分享给其他人。</p>
                <p>1、先下载我们指定的Windows客户端，<a href="http://dl.pgfast.net/Shadowsocks-win-2.0.11.zip" target="_blank">for win7/xp</a> ，<a href="http://dl.pgfast.net/Shadowsocks-win-dotnet4.0-2.0.11.zip" target="_blank">for win8</a></p>
                <p>2、将下载好的Windows客户端解压放到你想放的文件夹内例如桌面。</p>
                <p>3、下载本自动配置文件gui-config.json（不要改文件名）并将其放到跟你上面下载的客户端同一个位置。</p>
                <p>4、打开你上面下载好的客户端Shadowsocks.exe即可使用，此时所有服务器已经配置好，只需根据需要选择服务器即可</p>
            </div>
        </div>

    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
<div style="display:none;"><script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1253704745'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/stat.php%3Fid%3D1253704745' type='text/javascript'%3E%3C/script%3E"));</script></div></body>
</html>
