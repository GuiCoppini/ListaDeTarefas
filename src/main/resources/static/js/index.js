$(document).ready(function () {

    $('#get-button').click(function() {
        alert('CLICKED GET');
        $.ajax({
            url:"http://localhost:8080/tarefas/",
            type: "GET",
            headers: {
               "Access-Control-Allow-Origin": "*",
               "Access-Control-Allow-Methods": "*",
               "Access-Control-Allow-Headers": "*"
            },
            success: function(data) { console.log(data); }
        });
    });

    var postData = {
                      "descricao": "string",
                      "prioridade": 0,
                      "titulo": "string"
                   }

    $('#post-button').click(function() {
        alert('CLICKED POST');

        $.ajax({
          type: "POST",
          url: "http://localhost:8080/tarefas/new",
          data: JSON.stringify(postData),
          success: function(data) {
            console.log(data);
          },
          headers: {
             "Access-Control-Allow-Origin": "*",
             "Access-Control-Allow-Methods": "*",
             "Access-Control-Allow-Headers": "*"
          },
          dataType: 'json',
          contentType: 'application/json'
        });
    });

});
