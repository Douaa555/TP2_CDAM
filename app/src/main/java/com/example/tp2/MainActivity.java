package com.example.tp2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView item;
    private ImageButton add;
    private ImageButton mince;
    private TextView qty ;
    private ImageButton calandar;
    private TextView txtcalandar;
    private Toolbar toolbar1;
    public static TextView price_t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);

        price_t = findViewById(R.id.price_t);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Commande de :");
            getSupportActionBar().setSubtitle("Grossiste kaf naadja");
            toolbar1.setTitleTextColor(getResources().getColor(R.color.white));
            toolbar1.setSubtitleTextColor(getResources().getColor(R.color.white));
        }

        item = findViewById(R.id.itemss);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.drawable.img1, "Amandes", "F", 150.0));
        items.add(new Item(R.drawable.img1, "Pistache", "F", 150.0));
        items.add(new Item(R.drawable.img1, "Noix de Cajou", "F", 150.0));
        items.add(new Item(R.drawable.img1, "Noix de Cajou", "F", 150.0));

        ItemAdapter adapter = new ItemAdapter(MainActivity.this, R.layout.item_product, items);
        item.setAdapter(adapter);


    }


    }