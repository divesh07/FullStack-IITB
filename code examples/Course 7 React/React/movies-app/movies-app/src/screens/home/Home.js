import React, { Component } from 'react';
import './Home.css'
import Header from '../../common/header/Header';
import { withStyles } from '@material-ui/core/styles';
import moviesData from '../../common/movieData';
import genres from '../../common/genres';
import artists from '../../common/artists';
import { Select, MenuItem, GridList, GridListTile, GridListTileBar, Card, CardContent, Checkbox, FormControl, Typography, ListItemText, Input, InputLabel, TextField } from '@material-ui/core';

const styles = theme => ({
    root: {
        flexGrow: 1,
        backgroundColor: theme.palette.background.paper
    },
    upcomingMoviesHeading: {
        textAlign: 'center',
        background: '#ff9999',
        padding: '8px',
        fontSize: '1rem'
    },
    gridListUpcomingMovies: {
        flexWrap: 'nowrap',
        transform: 'translateZ(0)',
        width: '100%'
    },
    gridListMain: {
        transform: 'translateZ(0)',
        cursor: 'pointer'
    },
    formControl: {
        margin: theme.spacing.unit,
        minWidth: 240,
        maxWidth: 240
    },
    title: {
        color: theme.palette.primary.light,
    }
});

class Home extends Component {
    constructor() {
        super();
        this.state = {
            movieName: "",
            genres: [],
            artists: []
        }
    }

    mvoieNameChangeHandler = event => {
        this.setState({ movieName: event.target.value });
        //console.log(this.state.movieName);
    }

    genreSelectHandler = event => {
        this.setState({ genres: event.target.value });
    }
    
    artistSelectHandler = event => {
        this.setState({ artists: event.target.value });
    }

    render() {
        const { classes } = this.props;
        return (
            <div>
                <Header />
                <div className={classes.upcomingMoviesHeading}>
                    <span>Upcoming Movies</span>
                </div>
                <GridList cols={5} className={classes.gridListUpcomingMovies}>
                    {moviesData.map(movie => (
                        <GridListTile key={movie.id}>
                            <img src={movie.poster_url} className="movie-poster" alt={movie.title}></img>
                            <GridListTileBar title={movie.title}>
                            </GridListTileBar>
                        </GridListTile>
                    ))}
                </GridList>

                <div className="flex-container">
                    <div className="left">
                        <GridList cellHeight={350} cols={4} className={classes.gridListMain}>
                            {
                                moviesData.map(
                                    movie => (
                                        <GridListTile className="released-movie-grid-item" key={"gird" + movie.id}>
                                            <img src={movie.poster_url} className="movie-poster" alt={movie.title} ></img>
                                            <GridListTileBar>
                                                title={movie.title}
                                                subtitle = {<span>Release Date: {new Date(movie.release_date).toDateString()}</span>}
                                            </GridListTileBar>
                                        </GridListTile>
                                    )
                                )
                            }
                        </GridList>
                    </div>
                    <div className="right">
                        <Card>
                            <CardContent>
                                <FormControl className={classes.formControl} >
                                    <Typography className={classes.title} color="textSecondary">
                                        FIND MOVIES BY:
                                    </Typography>
                                </FormControl>

                                <FormControl className={classes.formControl} >
                                    <InputLabel htmlFor="movieName"> Movie Name</InputLabel>
                                    <Input id="movieName" onChange={this.mvoieNameChangeHandler}></Input>
                                </FormControl>

                                <FormControl className={classes.formControl} >
                                    <InputLabel htmlFor="select-multiple-checkbox-genre">Genre</InputLabel>
                                    <Select
                                        multiple
                                        input= {<Input id="select-multiple-checkbox-genre" />}
                                        renderValue={selected => selected.join(',')}
                                        value={this.state.genres}
                                        onChange={this.genreSelectHandler}>
                                        <MenuItem value="0">None</MenuItem>
                                        {genres.map(genre => (
                                            <MenuItem key={genre.id} value={genre.name}>
                                                <Checkbox checked={this.state.genres.indexOf(genre.name) > -1} />
                                                    <ListItemText primary={genre.name} />
                                            </MenuItem>
                                        ))}
                                    </Select>
                                </FormControl>

                                <FormControl className={classes.formControl} >
                                    <InputLabel htmlFor="select-multiple-checkbox">Artists</InputLabel>
                                    <Select
                                        multiple
                                        input= {<Input id="select-multiple-checkbox" />}
                                        renderValue={selected => selected.join(',')}
                                        value={this.state.artists}
                                        onChange={this.artistSelectHandler}>
                                        <MenuItem value="0">None</MenuItem>
                                        {artists.map(artist => (
                                            <MenuItem key={artist.id} value={artist.first_name + " " + artist.last_name}>
                                                <Checkbox checked={this.state.artists.indexOf(artist.name + " " + artist.last_name) > -1} />
                                                    <ListItemText primary={artist.first_name + " " + artist.last_name} />
                                            </MenuItem>
                                        ))}
                                    </Select>
                                </FormControl>

                                <FormControl className={classes.formControl} >
                                    <TextField id="releaseDateStart" label="Release Date Start" type="date" defaultValue="" 
                                    InputLabelProps={{shrink: true}} />
                                </FormControl>

                                <FormControl className={classes.formControl} >
                                    <TextField id="releaseDateEnd" label="Release Date End" type="date" defaultValue="" 
                                    InputLabelProps={{shrink: true}} />
                                </FormControl>



                            </CardContent>
                        </Card>
                    </div>

                </div>
            </div>
        );
    }
}

export default withStyles(styles)(Home);