import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import AddSubscriber from './AddSubscriber';
import './common/common.css';

//ReactDOM.render(<App />, document.getElementById('root'));
ReactDOM.render(<AddSubscriber />, document.getElementById('root'));

// render first argument is what to render we can also use JSX directly to rener
//ReactDOM.render(<p>Hello World</p>, document.getElementById('root'));

// ReactDOM.render(
//     <h3>Programming is a skill that is best acquired by practice rather than by reading books!</h3>,
//     document.getElementsByClassName('root')[0]
//  );

// ReactDOM.render(
//     <h3>If you don’t succeed initially, call it version 1.0</h3>,
//     document.getElementsByName('root')[0]
//  );

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
