package com.example.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);


        // Data
        final ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Bosphorus Bridge");
        landmarkNames.add("Brooklyn Bridge");
        landmarkNames.add("Golden Gate Bridge");
        landmarkNames.add("London Bridge");

        final ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("Turkey");
        countryNames.add("United States");
        countryNames.add("United States");
        countryNames.add("England");

        Bitmap bosphorusbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bosphorusbridge);
        Bitmap brooklynbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.brooklynbridge);
        Bitmap goldengatebridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.goldengatebridge);
        Bitmap londonbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(bosphorusbridge);
        landmarkImages.add(brooklynbridge);
        landmarkImages.add(goldengatebridge);
        landmarkImages.add(londonbridge);


        // ListView
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkNames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",landmarkNames.get(i));
                intent.putExtra("country",countryNames.get(i));

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(i));

                startActivity(intent);
            }
        });
    }
}
