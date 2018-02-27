import React from 'react';

export default class ListaDeTarefas extends React.Component {   
  constructor(props) {
    super(props);
    this.state = {
      lista_de_tarefas: []
    };
  }

	componentDidMount() {
		fetch('http://localhost:8080/listadetarefas/')
	    .then(results => {
	    	return results.json();
	    }).then(data => {
	    	let listas = data;
	    	this.setState({lista_de_tarefas: listas})
	    	console.log(data)
	    })
	}

  render() {
  	const data = this.state.lista_de_tarefas;
  	const listItems = data.map((d) => 
  		<li key={d.titulo}> {d.titulo}</li>);
  	return (
        <div>{ listItems }</div>
    );
  }
}
