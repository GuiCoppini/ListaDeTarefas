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

      return <div>
          ID: {lista.id} <br/>
          Titulo: {lista.titulo} <br/>
          Tamanho: {lista.tarefas.length} <br/>
          Tarefas:
        <ul>
          {
            lista.tarefas.map(tarefa =>
              <li key={tarefa.id}>Titulo: {tarefa.titulo} <br/>
              <Link to={`/lista/${lista.id}/${tarefa.id}`}>Ver Tarefa</Link> <br/><br/>
              </li>
            )
          }
        </ul>
        <br/><br/>
        <Link to={`/lista/${lista.id}/new`}>Nova Tarefa</Link> <br/><br/>
      </div>
  }
}
