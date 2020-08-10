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
        <form name="firstSelectTable">
            <select id="array" name="firstTableHeaders">
                <c:forEach items="${firstTableHeaders}" var="firstTableHeaders">
                    <option>${firstTableHeaders}</option>
                </c:forEach>
            </select>
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
                    <table id="firstTable"></table>
                </td>
            </tr>
        </table>
    </form>
</div>

<div class="rInner">
    <form name="form2">
        <select id="array2" name="secondTableHeaders">
            <c:forEach items="${secondTableHeaders}" var="secondTableHeaders">
                <option>${secondTableHeaders}</option>
            </c:forEach>
        </select>
        <table>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td>selfkey</td>
                        </tr>
                        <tr>
                            <td>confirmKey</td>
                        </tr>
                        <tr>
                            <td>login</td>
                        </tr>
                        <tr>
                            <td>password</td>
                        </tr>
                        <tr>
                            <td>fullName</td>
                        </tr>
                        <tr>
                            <td>branch</td>
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
                    </table>
                </td>

                <td>
                    <table id="secondTable"></table>
                </td>

            </tr>
        </table>
    </form>
</div>
<div class="tablefree">
    <form name="form2">
        <select id="array3" name="thirdTableHeaders">
            <c:forEach items="${thirdTableHeaders}" var="thirdTableHeaders">
                <option>${thirdTableHeaders}</option>
            </c:forEach>
        </select>
    </form>

</div>
<div class = "img">
    <img style="height: 400px; width: 400px; " id="image" />
</div>

<div class="buttons">
    <form name="buttonsarea">
        <p>
        <div class="form_radio">
            <input id="radio-1" type="radio" name="radio" value="1" required>
            <label for="radio-1">Radio button 1</label>
        </div>
    </p>

        <p>
        <div class="form_radio">
            <input id="radio-2" type="radio" name="radio" value="2">
            <label for="radio-2">Radio button 2</label>
        </div>
        </p>
        <p>
        <div class="form_radio">
            <input id="radio-3" type="radio" name="radio" value="3">
            <label for="radio-3">Radio button 3</label>
        </div>
        </p>
        <p>
        <div class="form_radio">
            <input id="radio-4" type="radio" name="radio" value="4" >
            <label for="radio-4">Radio button 4</label>
        </div>
        </p>
        <p>
        <div class="form_radio">
            <input id="radio-5" type="radio" name="radio" value="5" >
            <label for="radio-5">Radio button 5</label>
        </div>
        </p>

    </form>

</div>

<div class="textarea">
    <p>
        <p><b>Текстовое поле</b></p>
        <p><label>
            <textarea id = "textArea" rows="10" cols="45" name="text"></textarea>
        </label></p>
        </form>
</div>
<div class= "submitButton">
    <form id = "submitAllForms" method="post">
        <button> Submit button </button>
    </form>
</div>



<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous">
</script>
<script src="js/main.js"></script>
</body>
</html>