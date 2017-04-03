package com.example.e155733a.miniprojetmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class VueDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        Film film = (Film) getIntent().getSerializableExtra("film");
        ImageView imI = (ImageView) findViewById(R.id.imageFilmDetail);
        Picasso.with(getBaseContext()).load("https://image.tmdb.org/t/p/w500"+film.getImage()).into(imI);
        TextView imT = (TextView) findViewById(R.id.titreFilmDetail);
        imT.setText("Titre: "+film.getTitre());
        TextView imDa = (TextView) findViewById(R.id.dateFilmDetail);
        imDa.setText("Année de sortie: "+film.getAnnee());
        TextView imDe = (TextView) findViewById(R.id.descFilmDetail);
        imDe.setText("Résumé du film: \n"+film.getResumer());
    }
}
