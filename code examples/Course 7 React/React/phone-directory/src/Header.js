import React from 'react';
import './Header.css'; // external css


//Functional component
 const Header = function(props){
     const headerStyle = { textAlign: 'center', padding: 20, background: '#000', color: '#fff', textTransform:  'uppercase'};
     return(
         //<div className="header">
         //replace with inline styles
         //<div style= {headerStyle}> // for internal css

         // for external css
         <div class="header">
             {props.heading}
          </div>
     )
 }

// // Class component - in case we want to save state
// class Header extends Component {
//     render() {
//         return (
//             <div className="header">
//                 Phone Directory
//                 {this.props.heading}
//             </div>
//         )
//     }
// }
export default Header;