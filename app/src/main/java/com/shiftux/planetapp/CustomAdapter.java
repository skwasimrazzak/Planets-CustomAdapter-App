package com.shiftux.planetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<planet> {

    // *For Custom layout we use custom adapters
    // *Using array adapters because we would be storing the Model objects in an arrayList
    // *Array Lists are dynamic in nature. They grow and shrink depending on the content unlike the pre defined
    //  storage space of an array.

    private ArrayList<planet> planetArrayList;
    Context context;

    public CustomAdapter( ArrayList<planet> planetArrayList, Context context) {
        super(context, R.layout.item_list_layout, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context =  context;
    }

    private static class ViewHolder{
        TextView planetName;
        TextView planeMoon;
        ImageView planetImage;
    }

    // *getView is used to <<Create>> and <<Return>> a view for a specific item

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1. Getting the planet object from the current position
        planet Planet= getItem(position);

        //2. Inflate layout: Here we check if the view already exists or create a new view
        ViewHolder viewHolder;
        final View result; //Just a variable to store the answer to be returned.
                           // The return type is view

        if(convertView== null){
                viewHolder=new ViewHolder();
            LayoutInflater inflater= LayoutInflater.from(getContext());
            convertView=inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

        //3. Finding individual Views:
            viewHolder.planetName= (TextView) convertView.findViewById(R.id.planet_name);
            viewHolder.planetImage= (ImageView) convertView.findViewById(R.id.planet_img);
            viewHolder.planeMoon= (TextView) convertView.findViewById(R.id.moon_count);


            result = convertView;

            convertView.setTag(viewHolder); //setTag is used to add additional data to the existing view object.
                                            // viewHolder is add to convertView to retrieve the cache data
        }else{
            //Pre existing view is getting recycled.
            viewHolder= (ViewHolder) convertView.getTag();
            result=convertView;
        }

        //Getting data from the model class (planet)
        viewHolder.planetName.setText(Planet.getPlanetName());
        viewHolder.planeMoon.setText(Planet.getMoonCount());
        viewHolder.planetImage.setImageResource(Planet.getPlanetImage());

        return result;
    }
}
