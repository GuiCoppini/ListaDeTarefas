import React from 'react';
import { Link } from 'react-router-dom'
import * as APIservice from './APIservice'

export default class ListaDeListaDeTarefas extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      lista_de_tarefas: []
    };
  }

	componentDidMount() {
    APIservice.getListas().then(listas => {
      this.setState({lista_de_tarefas: listas});
    })
	}

  render() {
  	const data = this.state.lista_de_tarefas;

  	return data.map(lista =>
  			<div>
	  			Lista: {lista.titulo} <br/>
          Tamanho: {lista.tarefas.length} <br/>
          <Link to={'/lista/' + lista.id}>Ver Lista</Link> <br/><br/>

  			</div>
  	);
  }
}
