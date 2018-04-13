import React from 'react';
import { Redirect, withRouter } from 'react-router';
import * as APIservice from './APIservice'

export default class TaskListForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      titulo: ''
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({titulo: event.target.value});
  }

  handleSubmit(event) {
    event.preventDefault();
    APIservice.postLista(this.state, this.doOnSuccess, this.doOnError);
    <Redirect to="/listas" />
  }

  doOnError(error) {
    alert('deu erro');
    console.log(error);
  }

  doOnSuccess(response) {
    alert('sussa');
    window.location.href = 'http://localhost:3000/listas';
    // pior jeito possivel
  }

  render() {
    return (
      <form className="form-inline" onSubmit={this.handleSubmit}>
        <div className="form-group">
          <label>Título: </label>
          <input type="text" onChange={this.handleChange} className="form-control" id="titulo"></input>
        </div>
        <button type="submit" className="btn btn-success">Cria lista</button>
      </form>
    );
  }
}
