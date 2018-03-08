import React, { Component } from 'react';
import * as APIservice from './APIservice';

export default class TaskDetail extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.match.params.idTarefa,
      titulo: '',
      descricao: '',
      prioridade: '',
      status: ''
    };
  }

  componentDidMount() {
    APIservice.getTarefa(this.state.id).then(tarefa => {
      this.setState({titulo: tarefa.titulo});
      this.setState({descricao: tarefa.descricao});
      this.setState({prioridade: tarefa.prioridade});
      this.setState({status: tarefa.status});
    })
  }

  render() {
    const tarefa = this.state;

      return <div>
          ID: {tarefa.id} <br/>
          Titulo: {tarefa.titulo} <br/>
          Prioridade: {tarefa.prioridade} <br/>
          Descrição: {tarefa.descricao} <br/>
          Status: {tarefa.status} <br/>
      </div>
  }
}
