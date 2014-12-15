<%@ page language="java" contentType="text/html; charset=GBK" isErrorPage="true" pageEncoding="UTF-8"%>
 <%response.setStatus(HttpServletResponse.SC_OK);%>
 <%
 /**
  * 本页面是在客户查找的页面无法找到的情况下调用的
  */
  response.setStatus(HttpServletResponse.SC_OK);
  %>
  <body>
 错误的请求，点击 <a href="javascript:history.go(-1)">返回</a>到主页！
 <br/>
 </body>