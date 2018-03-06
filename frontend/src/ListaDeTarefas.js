import React from 'react';
import * as APIservice from './APIservice'

export default class ListaDeTarefas extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      lista_de_tarefas: []
    };
  }

	componentDidMount() {
    APIservice.getListas().then(data => {
        let listas = data;
        alert('data = ' + listas)
        return listas;
      })
	}

	renderTarefa(lista) {
		lista.map((tarefa) => {
			return (
  				<li key={tarefa.id}> {tarefa.titulo} {tarefa.prioridade}</li>
  			);
  		});
	}

  render() {
  	const data = this.state.lista_de_tarefas;

  	return data.map(lista =>
  			<div>
	  			Lista: {lista.titulo} Tamanho: {lista.tarefas.length}
	  			<ul>
	  				{
              lista.tarefas.map(tarefa =>
                <li> { tarefa.titulo } </li> )
	  				}
	  			</ul>
  			</div>
  	);
  }
}
