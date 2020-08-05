// var targetValue; // переменная, куда при изменении выбора списка уйдет его value


$('#array').change(function () {
    //Use $option (with the "$") to see that the variable is a jQuery object
    var option = $(this).find('option:selected');
    var text = option.text();//to get <option>Text</option> content
    console.log(text)
    $.ajax({
        url: 'http://localhost:8080/servletWeb/data', // URL - сервлет
        type: 'POST', // тип запроса
        data: {                 // передаваемые сервлету данные
            userName: text
        },
        success: function (response) {

            console.log(response)
            $('#ajaxUserServletResponse').text(response);

            $.getJSON( 'http://localhost:8080/servletWeb/main' ,function(response) {
                var tbl_body = "";
                var odd_even = false;
                $.each(response, function() {
                    var tbl_row = "";
                    $.each(this, function(k , v) {
                        tbl_row += "<td>"+v+"</td>";
                    });
                    tbl_body += "<tr class=\""+( odd_even ? "odd" : "even")+"\">"+tbl_row+"</tr>";
                    odd_even = !odd_even;
                });
                $("#firstTable").html(tbl_body);
            });
        }
    });


    $('#array2').change(function () {
        //Use $option (with the "$") to see that the variable is a jQuery object
        var $option = $(this).find('option:selected');
        var text = $option.text();//to get <option>Text</option> content
        $.ajax({
            url: 'http://localhost:8080/servletWeb/data',     // URL - сервлет
            type: 'POST', // тип запроса
            data: {                 // передаваемые сервлету данные
                userName: text
            },
            success: function (response) {
                console.log(response)
                $('#ajaxUserServletResponse').text(response);
            }
        });
    });
});



$('#array3').change(function () {
    //Use $option (with the "$") to see that the variable is a jQuery object
    var $option = $(this).find('option:selected');
    var text = $option.text();//to get <option>Text</option> content
    $.ajax({
        url: 'http://localhost:8080/servletWeb/data',     // URL - сервлет
        type: 'POST', // тип запроса
        data: {                 // передаваемые сервлету данные
            userName: text
        },
        success: function (response) {
            console.log(response)
            $('#ajaxUserServletResponse').text(response);
        }
    });
});


// var firstTableValue  = $('#array :selected').text();
// console.log(firstTableValue);


//
// // вызов функции по завершению загрузки страницы
// $(document).ready(function() {
//     // вызов функции после потери полем 'userName' фокуса
//     $('#firstSelectTable').onchange(function() {
//         var targetValue; // переменная, куда при изменении выбора списка уйдет его value
//         var sel = document.getElementById("firstSelectTable");
//         targetValue = sel.value;
//         $.ajax({
//             url : 'jQueryServlet',     // URL - сервлет
//             data : {                 // передаваемые сервлету данные
//                 userName : $(targetValue)
//             },
//             success : function(response) {
//                 console.log(response)
//                 $('#ajaxUserServletResponse').text(response);
//             }
//         });
//     });
// });