package com.usuarioupt.firebasedatabaseexample;

/**
 * Created by USUARIOUPT on 15/05/2017.
 */

public class Movie {
    public String movieName;
    public String moviePoster;
    public String hecho;
    public String des;
    public String llave;
    //public float movieRating;
    public Movie(){
    }
    public Movie(String movieName,String moviePoster,String hecho,String des){
        this.movieName = movieName;
        this.moviePoster = moviePoster;
        this.hecho = hecho;
        this.des = des;
        //this.movieRating  = movieRating;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getMoviePoster() {
        return moviePoster;
    }
    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }
    public String gethecho() {
        return hecho;
    }
    public void sethecho(String hecho) {
        this.hecho= hecho;
    }
    public String getdes() {
        return des;
    }
    public void setdes(String des) {
        this.hecho= des;
    }
    //public float getMovieRating() {
     //   return movieRating;
   // }
   // public void setMovieRating(float movieRating) {
        //this.movieRating = movieRating;
    //}
}
