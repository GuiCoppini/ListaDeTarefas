import React from 'react';
import TaskListForm from './TaskListForm';
import TaskListPack from './TaskListPack';
import TaskDetail from './TaskDetail';
import TaskForm from './TaskForm';
import TaskListDetail from './TaskListDetail';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

export default class ReactRouter extends React.Component {
  render() {
    return (
      <Router>
          <Switch>
            <Route name="task_list_form" exact path="/lista_form" component={TaskListForm} />
            <Route name="task_list_pack" exact path="/get_listas" component={TaskListPack} />
            <Route name="task_list_detail" exact path="/lista/:id" component={TaskListDetail} />
            <Route name="task_form" exact path="/lista/:idLista/new" component={TaskForm} />
            <Route name="task_detail" exact path="/lista/:idLista/:idTarefa" component={TaskDetail} />
          </Switch>
      </Router>
      )
  };
}
