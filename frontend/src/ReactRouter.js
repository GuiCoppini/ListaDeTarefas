import React from 'react';
import ListaDeTarefasForm from './ListaDeTarefasForm';
import ListaDeListaDeTarefas from './ListaDeListaDeTarefas';
import ListaDeTarefas from './ListaDeTarefas';
// Import routing components
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

export default class ReactRouter extends React.Component {
  render() {
    return (
      <Router>
          <Switch>
            <Route name="form_lista_de_tarefas" path="/lista_form" component={ListaDeTarefasForm} />
            <Route name="todas_listas_de_tarefas" path="/get_listas" component={ListaDeListaDeTarefas} />
            <Route name="lista_de_tarefas" path="/lista/:id" component={ListaDeTarefas} />
          </Switch>
      </Router>
      )
  };
}
