import React from 'react';
import * as APIservice from './APIservice';
import { Link } from 'react-router-dom'
import TaskDetail from './TaskDetail';

export default class TaskListDetail extends React.Component {
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

      return <div align="center">
          <h2> Titulo: {lista.titulo} </h2>
          <h3> Tamanho: {lista.tarefas.length} </h3>
          {lista.tarefas.length > 0 ? 'Tarefas:' : 'A lista nao possui tarefas.'}
        <ul>
          {
            lista.tarefas.map(tarefa =>
                  <li key={tarefa.id}>Titulo: {tarefa.titulo} <br/>
                    <Link to={`/listas/${lista.id}/${tarefa.id}`}>Ver Tarefa</Link> <br/><br/>
                  </li>
            )
          }
        </ul>
        <br/><br/>
        <Link to={`/listas/${lista.id}/new`}>Nova Tarefa</Link> <br/><br/>
      </div>
  }

}
