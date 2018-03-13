package com.epicodus.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.widget.Toast;
import android.widget.AdapterView;
import android.view.View;

public class RestaurantsActivity extends AppCompatActivity {
    private TextView mLocationTextView;
    private ListView mListView;

    private String[] restaurants = new String[] {
            "The Meat Dimension", "Moe's", "The Angry Dwarf", "The Broken Drum", "The Mended Drum",
            "Dibbler's", "Ctrl Alt Deli", "Zonie's", "Duckberger", "Small Pharaoh", "Meno's",
            "The Block", "Goodfellows Pizza", "Mama Gkika's", "15", "Sixteen Tons", "17"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        mListView = (ListView) findViewById(R.id.listView);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
               String restaurant = ((TextView)view).getText().toString();
               Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
           }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the restaurants near " + location);
    }


}
