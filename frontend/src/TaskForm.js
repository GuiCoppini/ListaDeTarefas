import React from 'react';
import * as APIservice from './APIservice'

export default class TaskForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      titulo: '',
      prioridade: '',
      descricao: '',
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    console.log("state = " + JSON.stringify(this.state))
    APIservice.postTarefa(this.props.match.params.idLista, this.state);
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          Titulo:
          <input type="text" name="titulo" value={this.state.titulo} onChange={this.handleChange} />
          <br />
        </label>
        <label>
          Prioridade:
          <input type="number" name="prioridade" value={this.state.prioridade} onChange={this.handleChange} />
          <br />
        </label>
        <label>
          Descricao:
          <input type="text" name="descricao" value={this.state.descricao} onChange={this.handleChange} />
          <br />
        </label>
        <input type="submit" value="Cria saporra" />
      </form>
    );
  }
}
