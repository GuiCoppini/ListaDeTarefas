import React from 'react';
import { Link } from 'react-router-dom'
import * as APIservice from './APIservice'
import 'bootstrap/dist/css/bootstrap.css';

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

      return (
        <div>
          <table className="table table-striped">
            <thead>
              <tr>
                <th>Titulo</th>
                <th>Tarefas</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {mapListas(data)}
            </tbody>
          </table>
        </div>
      )
  }
}
  function mapListas(listas) {
    return listas.map(lista =>
              <tr>
                <td>{lista.titulo}</td>
                <td>{lista.tarefas.length}</td>

                <td>
                  <Link to={'/listas/' + lista.id}>
                    <button class="btn btn-success">Ver Lista</button>
                  </Link>
                </td>

              </tr>
             );
  }
