import React from 'react';
import {Navbar, Nav, NavItem, MenuItem } from 'react-bootstrap';

export default class NavBarComponent extends React.Component {
  render() {
    return (
      <Navbar>
        <Navbar.Header>
          <Navbar.Brand>
            React-Bootstrap
          </Navbar.Brand>
        </Navbar.Header>
        <Nav stacked={false}>
          <NavItem eventKey={1} href="#">
            Link1
          </NavItem>
          <NavItem eventKey={2} href="#">
            Link2
          </NavItem>
        </Nav>
      </Navbar>
      )
  };
}
