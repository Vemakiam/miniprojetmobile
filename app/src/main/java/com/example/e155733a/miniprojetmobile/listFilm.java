package com.example.e155733a.miniprojetmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by E155733A on 30/03/17.
 */
public class listFilm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_film);
        affReq();
    }

    private void affReq() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest =
                new StringRequest(
                        Request.Method.GET,
                        "https://api.themoviedb.org/3/search/movie?api_key=b5fee4ae2d7830bef6768caf85408dcc&language=fr&region=france&query=logan&page=1",
                        new Response.Listener<String>() {
                            public void onResponse(String response) {
                                try {
                                    JSONObject repObj = (JSONObject) new JSONTokener(response).nextValue();
                                    JSONArray ar = repObj.getJSONArray("results");
                                    ArrayList<Film> filmListe = new ArrayList<>();
                                    for (int i=0; i < ar.length();i++) {
                                        JSONObject val = ar.getJSONObject(i);
                                        Film film = new Film(val.getString("poster_path"), val.getString("title"), val.getString("release_date"), val.getString("genre_ids"), val.getString("overview"));
                                        filmListe.add(film);
                                    }
                                    affichage_liste_films(filmListe);
                                } catch (JSONException je) {
                                    Log.e("MainActivity", je.getMessage());
                                }
                            }},
                        new Response.ErrorListener() {
                            public void onErrorResponse(VolleyError error) {
                                Log.e("VOLLEY", error.getMessage());
                            }})
                {
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        return params;
                    }
                };
        queue.add(stringRequest);
    }

    public void affichage_liste_films(ArrayList<Film> films) {
        FilmAdapter fa = new FilmAdapter(this, films);
        ListView lv = (ListView) findViewById(R.id.listeFilm);
        lv.setAdapter(fa);
    }
}
