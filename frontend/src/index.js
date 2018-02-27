import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
// import App from './App';
import ListaDeTarefas from './ListaDeTarefas';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<ListaDeTarefas />, document.getElementById('root'));
registerServiceWorker();
