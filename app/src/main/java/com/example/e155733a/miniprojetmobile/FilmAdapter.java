package com.example.e155733a.miniprojetmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by E155733A on 30/03/17.
 */
public class FilmAdapter extends BaseAdapter {
    private List<Film> mListF;
    private Context context;
    private LayoutInflater inflater;

    public FilmAdapter(Context acontext, List<Film> items) {
        context = acontext;
        mListF = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mListF.size();
    }

    @Override
    public Object getItem(int pos) {
        return mListF.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        // instanciation d’un View correspondant à notre fichier de layout
        if(row == null)
            row=inflater.inflate(R.layout.mon_layout_film, null);
        // personnalisation de la vue
        Film f = (Film) getItem(position);
        ImageView photo = (ImageView) row.findViewById(R.id.imageFilm);
        Picasso.with(context).load("https://image.tmdb.org/t/p/w500"+f.getImage()).into(photo);
        TextView titre = (TextView)row.findViewById(R.id.titre);
        titre.setText(f.getTitre());
        TextView annee = (TextView)row.findViewById(R.id.annee);
        annee.setText(f.getAnnee());
        return(row);
    }
}