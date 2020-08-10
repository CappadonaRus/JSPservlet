
$('#array').change(function () {

    var option = $(this).find('option:selected');
    var text = option.text();//to get <option>Text</option> content
    $.ajax({
        url: 'http://localhost:8080/servletWeb/data', // URL - сервлет
        type: 'POST', // тип запроса
        data: {                 // передаваемые сервлету данные
            userName: text
        },
        success: function (response) {

            var upgradedFirstTable = '<tr>';
            $.each(response, function (key, value) {
                upgradedFirstTable += '<td>' + value + '</td>';
                upgradedFirstTable += '</tr>'
                $('#firstTable').html(upgradedFirstTable)

            });
        }
    });
});

$('#array2').change(function () {

    var option = $(this).find('option:selected');
    var text = option.text();
    $.ajax({
        url: 'http://localhost:8080/servletWeb/data2',
        type: 'POST', // тип запроса
        data: {
            userName: text
        },
        success: function (response) {
            var upgradedThirdTable = '<tr>';
            $.each(response, function (key, value) {
                upgradedThirdTable += '<td>' + value + '</td>';
                upgradedThirdTable += '</tr>'
                $('#secondTable').html(upgradedThirdTable)
            });
        }
    });
});

$('#array3').change(function () {

    var option = $(this).find('option:selected');
    var text = option.text();
    $.ajax({
        url: 'http://localhost:8080/servletWeb/data3',
        type: 'POST', // тип запроса
        data: {
            userName: text
        },
        success: function (response) {
            document.querySelectorAll('[id="image"]')[0].src = 'data:image/png;base64, '+response["0"];
            $('image').each(function(){$(this).css('width','400px')});
        }
    });
});
var textArea = "";
$('#submitAllForms').click(function (e) {
    e.preventDefault();
    var option = $('#array').find('option:selected');
    var firstTableValue = option.text();
    var option2 = $('#array2').find('option:selected');
    var secondTableValue = option2.text();
    var option3 = $('#array3').find('option:selected');
    var thirdTableValue = option3.text();

    var buttonsParam = $('input[name="radio"]:checked').val();

    if(buttonsParam != null) {
        $.ajax({
            url: 'http://localhost:8080/servletWeb/fin',
            type: 'POST', // тип запроса
            data: {
                firstTableV: firstTableValue,
                secondTableV: secondTableValue, // переменная со значением из поля с классом email
                thirdTableV: thirdTableValue,
                radioButtonsV: buttonsParam
            },
            success: function (response) {
                textArea += response;
                $("#textArea").val(textArea)
            }
        });
    }
    else {
        alert("Выбери радиобаттон")
    }
});




