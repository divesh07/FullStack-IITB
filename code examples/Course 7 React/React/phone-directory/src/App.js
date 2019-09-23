import React, { Component } from 'react';
import Header from './Header.js';
import './App.css';

class App extends Component {
  clickHandler(message){
    alert(message);
  }

  render() {
    let subrcribers = [
      {
        id: 1,
        name: "Ronak",
        phone: "8888"
      },
      {
        id: 2,
        name: "Rohit",
        phone: "9999"
      }
    ]

    return (
      <div>
        <Header heading="Phone Directory" />
        <div className="component-body-container">
          <button className="custom-btn add-btn">Add</button>

          <div className="grid-container heading-container">
            <span className="grid-item name-heading">Name</span>
            <span className="grid-item phone-heading">Phone</span>
          </div>

          {
            subrcribers.map(sub => {
              return <div key={sub.id} className="grid-container">
                <span className="grid-item">{sub.name}</span>
                <span className="grid-item">{sub.phone}</span>
                <span className= "grid-item action-btn-container">
                  <button className= "custom-btn delete-btn" onClick={this.clickHandler.bind(this,"Delete Clicked")}>Delete</button>
                </span>
                </div>
            })
          }

        </div>
      </div>
    );

    // return (
    //     React.createElement('div', {className: "main-container"},
    //      "h1", "UpGrad", "p", "Building Careers of Tomorrow!")
    // );
  
    // return(
    //   React.createElement("div", {className: "container"},
    //     React.createElement("p", {style:{color: "#aaa"}}, "Welcome User!"),
    //     React.createElement("hr"), 
    //     React.createElement("div"),
    //     React.createElement("div", {type: "text"}, "Please type your name here"),
    //     React.createElement("input"),
    //   )
    // );
  
  } 


}

export default App;

