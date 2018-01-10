var counter = 0;
console.log('abriu');

class ListaDeTarefas extends React.Component {
    render() {
        return (
        <ul>
            <li></li>
        </ul>);
    }
}
ReactDOM.render(
    <ListaDeTarefas />,
    document.getElementById('root')
);

$("#a").click(function() {
    var listas;
    console.log("clicou");
    $.get("http://localhost:8080/listadetarefas/", function(data) {
        listas = data;

        for (var i=0; i<listas.length; i++) {
            console.log(listas[i]);
        }
    });
});


