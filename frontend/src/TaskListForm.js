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
    APIservice.postLista(this.state);
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          List Name:
          <input type="text" value={this.state.titulo} onChange={this.handleChange} />
        </label>
        <input type="submit" value="Cria saporra" />
      </form>
    );
  }
}
