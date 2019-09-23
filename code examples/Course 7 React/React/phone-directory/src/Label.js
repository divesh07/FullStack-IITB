import React from 'react';
import ReactDOM from 'react-dom';

/* TODO: 
  Debug the code on browser.
  Rectify all errors and warnings one by one.
  Do this until the code shows no error or warning in the Console Tab in Developer Tools.
*/
ReactDOM.render(
<div>
  <label htmlFor="username">Username: </label> <br/>
  <input id="username" type="text"/><br></br>
  <label htmlFor="password">Password: </label><br/>
  <input id="password" type="password" /><br></br>
  </div>,
  document.getElementById('root')
);