var targetValue; // переменная, куда при изменении выбора списка уйдет его value


// вызов функции по завершению загрузки страницы
$(document).ready(function() {
    // вызов функции после потери полем 'userName' фокуса
    $('#form1').onchange(function() {
        var targetValue; // переменная, куда при изменении выбора списка уйдет его value
        var sel = document.getElementById("form1");
        targetValue = sel.value;
        $.ajax({
            url : 'jQueryServlet',     // URL - сервлет
            data : {                 // передаваемые сервлету данные
                userName : $(targetValue)
            },
            success : function(response) {
                // обработка ответа от сервера
                $('#ajaxUserServletResponse').text(response);
            }
        });
    });
});