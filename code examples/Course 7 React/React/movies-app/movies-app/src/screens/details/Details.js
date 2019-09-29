import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Header from '../../common/header/Header';
import moviesData from '../../common/movieData';
import { Typography, GridList, GridListTile, GridListTileBar } from '@material-ui/core';
import './Details.css';
import Home from '../../screens/home/Home';
import YouTube from 'react-youtube';

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

    backtoHomeHandler = () =>{
        ReactDOM.render(<Home />, document.getElementById('root'));
    }

    artistClickHandler = (url) => {
        window.location = url;
    }

    render() {
        let movie = this.state.movie;
        const opts = {
            height: '300',
            width: '700',
            playerVars: {
                autoplay: 1
            }
        }

        return (
            <div className="details">
                <Header />
                <div className="back">
                    <Typography onClick={this.backtoHomeHandler}>
                        &#60; Back to Home
                    </Typography>
                </div>
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

                        <div className="trailerContainer">
                            <Typography>
                                <span className="bold">Trailer: </span>
                                <YouTube
                                    videoId={movie.trailer_url.split("?v=")[1]}
                                    opts= {opts}
                                    onReady = {this._onReady}
                                />
                                
                            </Typography>
                        </div>
                    </div>

                    <div className="rightDetails">

                        <div className="bold marginBottom16 marginTop16">
                            <Typography>
                                <span className="bold">Artists:</span>
                            </Typography>
                        </div>
                        <div className="paddingRight">
                            <GridList cellHeight={160} cols={2}>
                                {movie.artists !=null && movie.artists.map(artist => (
                                    <GridListTile className="gridTile" 
                                    onClick={ () => this.artistClickHandler(artist.wiki_url)} 
                                    key= {artist.id}>
                                        <img src={artist.profile_url} alt={artist.first_name + " " + artist.last_name} />
                                        <GridListTileBar title={artist.first_name + " " + artist.last_name} />
                                    </GridListTile>
                                )) }

                            </GridList>

                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default Details;