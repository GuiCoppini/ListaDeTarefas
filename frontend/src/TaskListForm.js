import React from 'react';
import * as APIservice from './APIservice'

export default class TaskListForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {titulo: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({titulo: event.target.value});
  }

  handleSubmit(event) {
    event.preventDefault();
    APIservice.postLista(this.state, this.doOnError);
  }

  doOnError(error) {
    console.log(error)
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
