package com.example.e155733a.miniprojetmobile;

import java.io.Serializable;

/**
 * Created by E155733A on 29/03/17.
 */
public class Film implements Serializable {
    private String image;
    private String titre;
    private String annee;
    private String resumer;

    public Film(String image, String titre, String annee, String resumer) {
        this.image = image;
        this.titre = titre;
        this.annee = annee;
        this.resumer = resumer;
    }

    public String getImage() {
        return image;
    }

    public String getTitre() {
        return titre;
    }

    public String getAnnee() {
        return annee;
    }


    public String getResumer() {
        return resumer;
    }

    @Override
    public String toString() {
        return "image='" + image + '\'' +
                ", titre='" + titre + '\'' +
                ", annee='" + annee + '\'' +
                ", resumer='" + resumer + '\'';
    }
}
//api des genres : https://developers.themoviedb.org/3/genres/get-movie-list
//api des films : https://developers.themoviedb.org/3/search/search-movies
