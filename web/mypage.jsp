<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web.webServlet</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" media="all">
</head>
<body>
<div class="table1">
    <form name="form1" action="${pageContext.request.contextPath}/main" method="post">
        <form name = "firstSelectTable" method="post">
        <select id="array" name="headers">
            <c:forEach items="${headers}" var="headers">
                <option>${headers}</option>
            </c:forEach>
        </select>
            <input type="submit" value="Submit">
        </form>
        <table>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td>fio</td>
                        </tr>
                        <tr>
                            <td>lastName</td>
                        </tr>
                        <tr>
                            <td>firstName</td>
                        </tr>
                        <tr>
                            <td>middleName</td>
                        </tr>
                        <tr>
                            <td>birthDate</td>
                        </tr>
                        <tr>
                            <td>card</td>
                        </tr>
                        <tr>
                            <td>sessionType</td>
                        </tr>
                        <tr>
                            <td>document</td>
                        </tr>
                        <tr>
                            <td>type</td>
                        </tr>
                        <tr>
                            <td>series</td>
                        </tr>
                        <tr>
                            <td>number</td>
                        </tr>
                        <tr>
                            <td>seriesNumber</td>
                        </tr>
                    </table>
                </td>

                <td>
                    <table id="firstTable">
<%--                        <script>--%>
<%--                        function loadeddata (data) {--%>
<%--                        $.each(data, function (key, value) {--%>

<%--                            for(var i = 0; i < data.length, i++){--%>

<%--                            }--%>
<%--                        // действия, которые будут выполняться для каждого свойства объекта--%>
<%--                        // key - текущее имя свойства массива--%>
<%--                        // value - значение текущего свойства объекта--%>

<%--                        // выведем имя свойства и его значение в консоль--%>
<%--                        console.log('Свойство: ' + key + '; Значение: ' + value);--%>

<%--                        });--%>
<%--                        }--%>
<%--                        </script>--%>


<%--                        <c:forEach items="${dataArray}" var="dataArray">--%>
<%--                            <tr>--%>
<%--                                <td>${dataArray}</td>--%>
<%--                            </tr>--%>
<%--                        </c:forEach>--%>
                    </table>

                </td>
            </tr>
        </table>
        <strong>Ответ сервлета </strong>:
        <span id="ajaxUserServletResponse"></span>

    </form>
</div>
<div class="rInner">
    <form name="form2">
        <select id="array2" name="headers">
            <c:forEach items="${headers}" var="headers">
                <option>${headers}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Submit">
        <table>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td>fio</td>
                        </tr>
                        <tr>
                            <td>lastName</td>
                        </tr>
                        <tr>
                            <td>firstName</td>
                        </tr>
                        <tr>
                            <td>middleName</td>
                        </tr>
                        <tr>
                            <td>birthDate</td>
                        </tr>
                        <tr>
                            <td>card</td>
                        </tr>
                        <tr>
                            <td>sessionType</td>
                        </tr>
                        <tr>
                            <td>document</td>
                        </tr>
                        <tr>
                            <td>type</td>
                        </tr>
                        <tr>
                            <td>series</td>
                        </tr>
                        <tr>
                            <td>number</td>
                        </tr>
                        <tr>
                            <td>seriesNumber</td>
                        </tr>
                    </table>
                </td>

                <td>
                    <table>
                        <c:forEach items="${dataArray}" var="dataArray">
                            <tr>
                                <td>${dataArray}</td>
                            </tr>
                        </c:forEach>
                    </table>

                </td>
            </tr>
        </table>
    </form>
</div>
<div class="tablefree">
    <form name="form2">
        <select id="array3" name="headers">
            <c:forEach items="${headers}" var="headers">
                <option>${headers}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Submit">
        <table>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td>fio</td>
                        </tr>
                        <tr>
                            <td>lastName</td>
                        </tr>
                        <tr>
                            <td>firstName</td>
                        </tr>
                        <tr>
                            <td>middleName</td>
                        </tr>
                        <tr>
                            <td>birthDate</td>
                        </tr>
                        <tr>
                            <td>card</td>
                        </tr>
                        <tr>
                            <td>sessionType</td>
                        </tr>
                        <tr>
                            <td>document</td>
                        </tr>
                        <tr>
                            <td>type</td>
                        </tr>
                        <tr>
                            <td>series</td>
                        </tr>
                        <tr>
                            <td>number</td>
                        </tr>
                        <tr>
                            <td>seriesNumber</td>
                        </tr>
                    </table>
                </td>

                <td>
                    <table>
                        <c:forEach items="${dataArray}" var="dataArray">
                            <tr>
                                <td>${dataArray}</td>
                            </tr>
                        </c:forEach>
                    </table>

                </td>
            </tr>
        </table>
    </form>
</div>

<div class="buttons">
    <form name="buttonsarea">
        <p><b>Radio Buttons</b></p>
        <p><input name="first" type="radio" value="first" checked> first</p>
        <p><input name="second" type="radio" value="second"> second</p>
        <p><input name="third" type="radio" value="third"> third</p>
        <p><input name="four" type="radio" value="four"> four</p>
        <p><input name="five" type="radio" value="five"> five</p>
        <p><input type="submit" value="Выбрать"></p>

    </form>
</div>

<div class="textarea">
    <form>
        <p><b>Текстовое поле</b></p>
        <p><label>
            <textarea rows="10" cols="45" name="text"></textarea>
        </label></p>
        <p><input type="submit" value="Отправить"></p>
    </form>
</div>

<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous">
</script>
<script src ="js/main.js"></script>

</body>
</html>