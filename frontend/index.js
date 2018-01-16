$(document).ready(function () {
    $('#a').click(function() {
        alert('CLICOU');
        $.get( "127.0.0.1:8080/tarefas", function( data ) {
          console.log(data);
        });
    });
});
