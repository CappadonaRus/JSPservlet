<%--
  Created by IntelliJ IDEA.
  User: Cappadona
  Date: 25.03.2020
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="tablefree">
    <form name="form2">
        <select id="array" name="headers">
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
</html>
