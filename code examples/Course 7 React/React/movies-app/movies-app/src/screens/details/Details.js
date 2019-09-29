import React, { Component } from 'react';
import Header from '../../common/header/Header';
import moviesData from '../../common/movieData';
import { Typography } from '@material-ui/core';
import './Details.css';

class Details extends Component {

    constructor() {
        super();
        this.state = {
            movie: {}
        }
    }

    componentWillMount() {
        let currentState = this.state;
        currentState.movie = moviesData.filter((mov) => {
            return mov.id === this.props.movieId
        })[0];

        this.setState({ currentState });
        console.log(this.state);
    }

    render() {
        let movie = this.state.movie;
        return (
            <div className="details">
                <Header />
                <div className="flex-containerDetails">
                    <div className="leftDetails">
                        <img src={movie.poster_url} alt={movie.title} />
                    </div>
                    <div className="middleDetails">
                        <div>
                            <Typography variant="headline" component="h2">
                                {movie.title}
                            </Typography>
                        </div>

                        <div>
                            <Typography>
                                <span className="bold">Genre: </span>
                                {movie.genres.join(',')}
                            </Typography>
                        </div>

                        <div>
                            <Typography>
                                <span className="bold">Duration: </span>
                                {movie.duration}
                            </Typography>
                        </div>

                        <div>
                            <Typography>
                                <span className="bold">Release Date: </span>
                                {new Date(movie.release_date).toDateString()}
                            </Typography>
                        </div>

                        <div>
                            <Typography>
                                <span className="bold">Release Date: </span>
                                {movie.critics_rating}
                            </Typography>
                        </div>

                        <div className="marginTop16">
                            <Typography>
                                <span className="bold">Plot: </span>
                                <a href={movie.wiki_url}>(Wiki Link)</a>
                                {movie.storyline}
                            </Typography>
                        </div>



                    </div>
                    <div className="rightDetails">
                    </div>
                </div>
            </div>
        );
    }
}

export default Details;