<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <% 
     pageContext.setAttribute("APP_PATH", request.getContextPath());
   %>
    <!-- Bootstrap css-->
    <link href="${APP_PATH}/src/main/webapp/WEB-INF/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/src/main/webapp/WEB-INF/bootstrap/bootstrap-3.3.7-dist/jquery/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/src/main/webapp/WEB-INF/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>这是首页</h1>
    <table class="table table-hover">
      <tr>
     <td class="active">one</td>
     <td class="success">two</td>
     <td class="warning">three</td>
     <td class="danger">four</td>
     <td class="info">five</td>
</tr>
    </table>
</body>
</html>