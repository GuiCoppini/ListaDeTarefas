import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import ReactRouter from './ReactRouter';
import NavBarComponent from './NavBarComponent';
import registerServiceWorker from './registerServiceWorker';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/css/bootstrap-theme.css';
import { unregister as unregisterServiceWorker } from './registerServiceWorker'

unregisterServiceWorker();

ReactDOM.render(<NavBarComponent />, document.getElementById('header')
);

ReactDOM.render(<ReactRouter />, document.getElementById('root')
);
