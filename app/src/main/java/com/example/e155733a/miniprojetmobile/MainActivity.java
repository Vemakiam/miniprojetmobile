package com.example.e155733a.miniprojetmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> listnbRecherche = new ArrayList<>();
        listnbRecherche.add(5);listnbRecherche.add(10);listnbRecherche.add(15);listnbRecherche.add(20);
        listnbRecherche.add(25);listnbRecherche.add(30);
        ArrayAdapter<Integer> aaI = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, listnbRecherche);
        Spinner spin = (Spinner) findViewById(R.id.nbResultats);
        spin.setAdapter(aaI);
        Button valider = (Button) findViewById(R.id.changerVue);
        valider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(MainActivity.this, VueListe.class);
        EditText rech = (EditText) findViewById(R.id.saisieRecherche);
        Spinner spin = (Spinner) findViewById(R.id.nbResultats);
        it.putExtra("recherche", rech.getText().toString());
        it.putExtra("nbResultats", (int) spin.getSelectedItem());
        startActivity(it);
    }
}
