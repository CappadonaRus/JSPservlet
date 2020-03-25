<%--
  Created by IntelliJ IDEA.
  User: Cappadona
  Date: 25.03.2020
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" media="all">
</head>
<body>
<div class="textarea">
    <form>
        <p><b>Текстовое поле</b></p>
        <p><label>
            <textarea rows="10" cols="45" name="text"></textarea>
        </label></p>
        <p><input type="submit" value="Отправить"></p>
    </form>
</div>

</body>
</html>
