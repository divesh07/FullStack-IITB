import React, { Component } from 'react';
import Header from './Header.js';
import './ShowSubscribers.css';
import {Link} from 'react-router-dom';

class ShowSubscribers extends Component {
  clickHandler(message){
    alert(message);
  }

  // constructor() {
  //   super();
  //   this.state = {
  //     subrcribersListToShow: []
  //   }
  //   console.log("Constructor called")
  // }

  // componentDidMount(){
  //   let newSubscriber = {
  //     id:1,
  //     name: "Shilpa",
  //     phone: "8888"

  //   }
  //   let subscribersList = this.state.subrcribersListToShow;
  //   subscribersList.push(newSubscriber);
  //   this.setState( {subrcribersListToShow: subscribersList});
  //   console.log("State", this.state)
  // }

  onDeletedClick = (subscriberId) => {
    this.props.deleteSubscriberHandler(subscriberId);
  }

  render() {
    // let subrcribers = [
    //   {
    //     id: 1,
    //     name: "Ronak",
    //     phone: "8888"
    //   },
    //   {
    //     id: 2,
    //     name: "Rohit",
    //     phone: "9999"
    //   }
    // ]
    console.log("Render called")
    return (
      <div>
        <Header heading="Phone Directory" />
        <div className="component-body-container">
          <Link to="/add"><button className="custom-btn add-btn">Add</button></Link>

          <div className="grid-container heading-container">
            <span className="grid-item name-heading">Name</span>
            <span className="grid-item phone-heading">Phone</span>
          </div>

          {
            this.props.subscribersList.map(sub => {
              return <div key={sub.id} className="grid-container">
                <span className="grid-item">{sub.name}</span>
                <span className="grid-item">{sub.phone}</span>
                <span className= "grid-item action-btn-container">
                  {/* <button className= "custom-btn delete-btn" onClick={this.clickHandler.bind(this,"Delete Clicked")}>Delete</button> */}
                  
                  <button className= "custom-btn delete-btn" onClick={this.onDeletedClick.bind(this, sub.id)}>Delete</button>
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

export default ShowSubscribers;

