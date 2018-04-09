import React from 'react';
import {Navbar, Nav, NavItem, MenuItem } from 'react-bootstrap';

export default class NavBarComponent extends React.Component {
  render() {
    return (
      <Navbar>
        <Navbar.Header>
          <Navbar.Brand>
            ListaDeTarefas
          </Navbar.Brand>
        </Navbar.Header>
        <Nav>
          <NavItem eventKey={1} href="/listas/new">
            Nova Lista de Tarefas
          </NavItem>
          <NavItem eventKey={2} href="#">
            Link2
          </NavItem>
        </Nav>
      </Navbar>
      )
  };
}
