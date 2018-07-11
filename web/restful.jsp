<%--
  Created by IntelliJ IDEA.
  User: WX
  Date: 2018/6/27
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>RESTful 测试</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js">
    </script>
    <script type="text/javascript">
        function search(){
// 获取输入的查询编号
            var id = $("#number").val();
            $.ajax({
                url : "${pageContext.request.contextPath }/user/"+id,
                type : "GET",
//定义回调响应的数据格式为 JSON 字符串,该属性可以省略
            dataType : "json",
//成功响应的结果
                success : function(data){
                if(data.name != null){
                    alert("您查询的用户是："+data.name);
                }else{
                    alert("没有找到 id 为:"+id+"的用户！");
                }
            }
        });
        }
    </script>
</head>
<body>
<form>
    编号：<input type="text" name="number" id="number">
    <input type="button" value=" 搜索 " onclick="search()" />
</form>
</body>
</html>
