package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * This returns the list of cities
     * @return
     */
    public List getCities() {
        List list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * this adds a city object to the list
     *for the first phase it will be empty
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * this returns true if the given city is in the arrayList
     * @param city
     * @return
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes the given city if it is in the list
     * @param city
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns the amount of cities
     * @return
     */
    public int countCities() {
        return cities.size();
    }



}
