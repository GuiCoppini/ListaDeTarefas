import React from 'react';
import TaskListForm from './TaskListForm';
import TaskListPack from './TaskListPack';
import TaskDetail from './TaskDetail';
import TaskForm from './TaskForm';
import IndexComponent from './IndexComponent';
import TaskListDetail from './TaskListDetail';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

export default class ReactRouter extends React.Component {
  render() {
    return (
      <Router>
          <Switch>
            <Route exact path="/" component={IndexComponent} />
            <Route exact path="/listas/new" component={TaskListForm} />
            <Route exact path="/listas" component={TaskListPack} />
            <Route exact path="/listas/:id" component={TaskListDetail} />
            <Route exact path="/listas/:idLista/new" component={TaskForm} />
            <Route exact path="/listas/:idLista/:idTarefa" component={TaskDetail} />
          </Switch>
      </Router>
      )
  };
}
