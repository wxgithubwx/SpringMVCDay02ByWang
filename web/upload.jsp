<%--
  Created by IntelliJ IDEA.
  User: weido
  Date: 2018/6/25
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        // 判断是否填写上传人并已选择上传文件
        function check() {
            var name = document.getElementById("name").value;
            var file = document.getElementById("file").value;
            if (name == "") {
                alert("填写上传人");
                return false;
            }
            if (file.length == 0 || file == "") {
                alert("请选择上传文件");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/fileUpload"
      method="post" enctype="multipart/form-data"
      onsubmit="return check()">
    上传人：
    <input id="name" type="text" name="name"/><br/>
    请选择文件：
    <input id="file" type="file" name="uploadFile" multiple="multiple"/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
