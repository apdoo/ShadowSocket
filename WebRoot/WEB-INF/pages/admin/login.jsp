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
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/button.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/metro/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/metro/demo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style>
        .clearfix:before {
            display: table;
            content: "";
        }
        .clearfix:after {
            display: table;
            clear: both;
            content: "";
        }
        body {
            min-width: 1020px;
            font: 13px/1.4 Helvetica, arial, freesans, clean, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol";
            color: #333;
            background-color: #fff;
        }
        h1 {
            display: block;
            font-size: 2em;
            -webkit-margin-before: 0.67em;
            -webkit-margin-after: 0.67em;
            -webkit-margin-start: 0px;
            -webkit-margin-end: 0px;
            font-weight: bold;
        }
        .auth-form-body {
            padding: 20px;
            font-size: 14px;
            background-color: #fff;
            border: 1px solid #d8dee2;
            border-top: 0;
            border-radius: 0 0 3px 3px;
        }
    </style>
    <script type="text/javascript">
        $(function() {
            //登录
            $("#login").click(function(){
                var username= $("#login_username").val();
                var password=$("#login_password").val();
                $("#login_form").submit();
            });
        });
    </script>

</head>

<body>
<div class="site clearfix">
    ${msg}
    <div id="site-container" class="context-loader-container" data-pjax-container="">

        <div class="auth-form" >
            <form id="login_form" method="post" action="${pageContext.request.contextPath}/admin/doLogin">
                <div class="auth-form-header">
                    <h1>登录</h1>
                </div>
                <div class="auth-form-body">
                    <label for="login_username">
                        用户名
                    </label>
                    <input autocapitalize="off" autocorrect="off" autofocus="autofocus" class="input-block" id="login_username" name="user_name" tabindex="1" type="text">

                    <label for="login_password">
                        密 码
                    </label>
                    <input class="input-block" id="login_password" name="pass" tabindex="2" type="password">
                    <input type="button" id="login" class="button green" value="登 录"
                           tabindex="5">
                </div>
            </form>
        </div>

    </div>
    <div class="modal-backdrop"></div>
</div>
</body>
</html>