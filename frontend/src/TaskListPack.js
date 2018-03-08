import React from 'react';
import { Link } from 'react-router-dom'
import * as APIservice from './APIservice'

export default class TaskListPack extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      task_list_pack: []
    };
  }

	componentDidMount() {
    APIservice.getListas().then(listas => {
      this.setState({task_list_pack: listas});
    })
	}

  render() {
  	const data = this.state.task_list_pack;

  	return data.map(lista =>
  			<div>
          <dl>
            <dt>Lista:</dt>
            <dd>{lista.titulo}</dd>
            <dt>Tamanho:</dt>
            <dd>{lista.tarefas.length}</dd>
          </dl>
          <Link to={'/lista/' + lista.id}>Ver Lista</Link> <br/><br/>

  			</div>
  	);
  }
}
