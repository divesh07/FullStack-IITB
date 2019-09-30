import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Header from '../../common/header/Header';
import language from '../../common/language';
import location from '../../common/location';
import showDate from '../../common/showDate';
import showTime from '../../common/showTime';
import './BookShow.css';
import { Typography, Card, CardContent, FormControl, InputLabel, Select, Input, MenuItem } from '@material-ui/core';
import Details from '../../screens/details/Details';

class BookShow extends Component {

    constructor(){
        super();
        this.state = {
            location: ""
        }

    }
    backToDetailsHandler = () => {
        ReactDOM.render(<Details movieId={this.props.movieId}/>, document.getElementById('root'));
    }

    locationChangeHandler = event => {
        this.setState({location: event.target.value});
    }

    render() {
        return (
            <div>
                <Header />
                <div className="bookShow">
                    <Typography className="back" onClick={this.backToDetailsHandler}>
                        &#60; Back to Movie Details
                    </Typography>
                    <Card className="cardStyle">
                        <CardContent>
                            <Typography variant="headline" component="h2">
                                Book Show
                            </Typography>
                            <br />

                            <FormControl required className="formControl">
                                <InputLabel htmlFor="location">Choose Location</InputLabel>
                                <Select 
                                    value={this.state.location}
                                    onChange={this.locationChangeHandler} >
                                    {location.map(loc => (
                                        <MenuItem key={"loc" + loc.id} value={loc.location}>
                                            {loc.location}
                                        </MenuItem>
                                    ))}
                                </Select>

                            </FormControl>
                        </CardContent>

                    </Card>
                </div>
            </div>
        );
    }
}
export default BookShow;