import React from 'react';
import * as APIservice from './APIservice'

// TODO: renderizar a lista soh pelo ID
export default class ListaDeListaDeTarefas extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.match.params.id,
      titulo: '',
      tarefas: []
    };
  }

  componentDidMount() {
    APIservice.getLista(this.state.id).then(lista => {
      this.setState({titulo: lista.titulo});
      this.setState({tarefas: lista.tarefas});
    })
  }

  render() {
    const lista = this.state;

      return <div>
          ID: {lista.id} <br/>
          Titulo: {lista.titulo} <br/>
          Tamanho: {lista.tarefas.length} <br/>
          Tarefas: <br/>
        <ul>
          {
            lista.tarefas.map(tarefa =>
              <li> { tarefa.titulo } </li> )
          }
        </ul>
      </div>
  }
}
