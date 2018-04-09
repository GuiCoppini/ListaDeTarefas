import React from 'react';
import * as APIservice from './APIservice'
import { Link } from 'react-router-dom'

export default class IndexComponent extends React.Component {
  render() {
    return (
      <div align="center">
        <Link to='/listas/'>
          <button className="btn btn-large btn-info" type="button">Lista de Tarefas</button>
        </Link>
      </div>
    );
  }
}
