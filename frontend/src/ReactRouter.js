import React from 'react';
import ListaDeTarefasForm from './ListaDeTarefasForm';
import ListaDeTarefas from './ListaDeTarefas';
// Import routing components
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

export default class ReactRouter extends React.Component {
  render() {
    return (
      <Router>
          <Switch>
            <Route path="/lista_form" component={ListaDeTarefasForm} />
            <Route path="/get_listas" component={ListaDeTarefas} />
          </Switch>
      </Router>
      )
  };
}
