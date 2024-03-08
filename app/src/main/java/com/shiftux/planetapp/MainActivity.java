package com.shiftux.planetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<planet> planetList;
    public static CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. Set Adapter View
        list= findViewById(R.id.planet_list);

        //2.Set Data Source
        planetList=new ArrayList<>();

        planet planet1=new planet("Mercury", "0 Moons", R.drawable.mercury);
        planet planet2=new planet("Venus", "0 Moons", R.drawable.venus);
        planet planet3=new planet("Earth", "1 Moons", R.drawable.earth);
        planet planet4=new planet("Mars", "2 Moons", R.drawable.mars);
        planet planet5=new planet("Jupiter", "79 Moons", R.drawable.jupiter);
        planet planet6=new planet("Saturn", "83 Moons", R.drawable.saturn);
        planet planet7=new planet("Uranus", "27 Moons", R.drawable.uranus);
        planet planet8=new planet("Neptune", "14 Moons", R.drawable.neptune);

        planetList.add(planet1);
        planetList.add(planet2);
        planetList.add(planet3);
        planetList.add(planet4);
        planetList.add(planet5);
        planetList.add(planet6);
        planetList.add(planet7);
        planetList.add(planet8);

        //3. Adapter
        adapter=new CustomAdapter(planetList,getApplicationContext());
        list.setAdapter(adapter);

        //4.Handle On click Listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,
                        "Planet Name: " + adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}