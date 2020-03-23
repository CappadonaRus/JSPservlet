<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web.webServlet</title>
</head>
<body>
<div id="rTable">
<form name="form2">
        <div class="rSelect">
            <select id="array" name="headers">
                <c:forEach items="${headers}" var="headers">
                    <option>${headers}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Submit">
        </div>
        <div class="rInner">
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
        </div>
    </div>
</form>
</body>
</html>