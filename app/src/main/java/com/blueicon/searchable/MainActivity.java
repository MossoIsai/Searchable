package com.blueicon.searchable;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.blueicon.searchable.adaptador.AdaptadorPersona;
import com.blueicon.searchable.models.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SearchView searchView;
    private AdaptadorPersona adaptadorPersona;
    private List<Persona> personaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listViewSearchable);
        searchView = (SearchView)findViewById(R.id.searchView);
        personaList =  new ArrayList<>();
        personaList.add(new Persona("JUAN","GARCIA",1.54,27));
        personaList.add(new Persona("LUIS","GARCIA",1.54,27));
        personaList.add(new Persona("PEDRO","GARCIA",1.54,27));
        personaList.add(new Persona("ERNESTO","GARCIA",1.54,27));
        personaList.add(new Persona("ISAI","GARCIA",1.54,27));
        personaList.add(new Persona("JOSE","GARCIA",1.54,27));
        personaList.add(new Persona("LUIS MONTES","GARCIA",1.54,27));
        personaList.add(new Persona("FELIPE","GARCIA",1.54,27));
        personaList.add(new Persona("PEDROTE","GARCIA",1.54,27));
        personaList.add(new Persona("LALO","GARCIA",1.54,27));
        personaList.add(new Persona("ISRAEL","GARCIA",1.54,27));
        personaList.add(new Persona("OMAR","GARCIA",1.54,27));
        personaList.add(new Persona("ERICK","GARCIA",1.54,27));
        personaList.add(new Persona("PEPEELTORO","GARCIA",1.54,27));

        adaptadorPersona = new AdaptadorPersona(MainActivity.this,personaList);
        listView.setAdapter(adaptadorPersona);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adaptadorPersona.getFilter().filter(newText);
                return true;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        return true;
    }
}
