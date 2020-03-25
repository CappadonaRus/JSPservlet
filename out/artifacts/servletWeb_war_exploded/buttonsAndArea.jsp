<%--
  Created by IntelliJ IDEA.
  User: Cappadona
  Date: 25.03.2020
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" media="all">
</head>
<body>
<div class="buttons">
    <form name="buttonsarea">
        <p><b>Radio Buttons</b></p>
        <p><input name="first" type="radio" value="first" checked> first</p>
        <p><input name="second" type="radio" value="second"> second</p>
        <p><input name="third" type="radio" value="third"> third</p>
        <p><input name="four" type="radio" value="four"> four</p>
        <p><input name="five" type="radio" value="five"> five</p>
        <p><input type="submit" value="Выбрать"></p>

        <p><b>Текстовое поле</b></p>
        <p><label>
            <textarea rows="10" cols="45" name="text"></textarea>
        </label></p>
        <p><input type="submit" value="Отправить"></p>

    </form>
</div>
</body>
</html>
