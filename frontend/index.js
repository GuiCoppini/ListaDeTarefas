$(document).ready(function () {
    $('#a').click(function() {
        alert('CLICKED');

//        $.get( "http://localhost:8080/tarefas/", function( data ) {
//          console.log(data);
//        });

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
});
