package com.example.tp2;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemAdapter extends BaseAdapter {
    Activity activity;
    int itemResourceId;
    List<Item> items;
    private ImageButton image;
    private TextView name;
    private TextView category;
    private TextView price;
    private ImageButton add;
    private ImageButton mince;
    private TextView qty;
    private ImageButton cart;
    private TextView totalp;
    private LinearLayout card;
    private ImageView card_img;
    private TextView card_name;
    private TextView card_category;
    private static double p = 0.0 ;
    private ArrayList<Boolean> card_b;
    private ArrayList<Boolean>  b;
    public ItemAdapter(Activity activity, int itemResourceId, List<Item> items) {
        this.activity = activity;
        this.itemResourceId = itemResourceId;
        this.items = items;
            this.b = new ArrayList<>(Collections.nCopies(items.size(), true));
            this.card_b = new ArrayList<>(Collections.nCopies(items.size(), true));

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            layout = inflater.inflate(itemResourceId, parent, false);
        } else {
            layout = convertView;
        }

        for (int i = 0; i<items.size();i++) {
            b.add(true);
            card_b.add(true);
        }


        image = layout.findViewById(R.id.img);
        name = layout.findViewById(R.id.name);
        category = layout.findViewById(R.id.category);
        price = layout.findViewById(R.id.price);

        image.setImageResource(items.get(position).getImage());
        name.setText(items.get(position).getName());
        category.setText(items.get(position).getCategory());

        add = layout.findViewById(R.id.add);
        mince = layout.findViewById(R.id.mince);
        cart = layout.findViewById(R.id.cart);
        totalp = layout.findViewById(R.id.totalp);
        qty = layout.findViewById(R.id.quantity);

        String totalText = totalp.getText().toString();
        String[] totalParts = totalText.split("\\s+");


        totalParts[2] = String.valueOf(items.get(position).getPrice());
        totalp.setText(String.join(" ", totalParts));

        cart.setOnClickListener(view -> {
            b.set(position, !b.get(position));
            String[] price_parts = price.getText().toString().split("\\s+");

            if (!b.get(position)) {
                cart = layout.findViewById(R.id.cart);
                cart.setImageResource(R.drawable.cart3);
                price = layout.findViewById(R.id.price);
               p = p - Double.parseDouble(price_parts[0]);
             MainActivity.price_t.setText(String.valueOf(p) + "DZD");
            } else {
                cart = layout.findViewById(R.id.cart);
                cart.setImageResource(R.drawable.cart2);
                price = layout.findViewById(R.id.price);
           p = p + Double.parseDouble(price_parts[0]);
            MainActivity.price_t.setText(String.valueOf(p) + "DZD");
            }
        });

        add.setOnClickListener(view -> {
            qty = layout.findViewById(R.id.quantity);
            int qty1 = Integer.parseInt(qty.getText().toString());
            qty.setText(String.valueOf(qty1 + 1));

            totalp = layout.findViewById(R.id.totalp);
            price = layout.findViewById(R.id.price);

            totalParts[2] = String.valueOf(items.get(position).getPrice());
            totalParts[0] = qty.getText().toString();
            totalp.setText(String.join(" ", totalParts));

            Double qtyValue = Double.parseDouble(totalParts[0]);
            Double itemPrice = Double.parseDouble(totalParts[2]);

            Double totalPrice = qtyValue * itemPrice;

            price.setText(String.valueOf(totalPrice) + " DZD");

            if(b.get(position)){
                String[] price_parts = price.getText().toString().split("\\s+");
                p = p + Double.parseDouble(price_parts[0]);
                MainActivity.price_t.setText(String.valueOf(p) + "DZD");
            }
        });

        mince.setOnClickListener(view -> {
            qty = layout.findViewById(R.id.quantity);
            int qty1 = Integer.parseInt(qty.getText().toString());
            if (qty1 > 0) {
                qty.setText(String.valueOf(qty1 - 1));
            } else {
                qty.setText(String.valueOf(qty1));
            }

            totalp = layout.findViewById(R.id.totalp);
            price = layout.findViewById(R.id.price);

            totalParts[2] = String.valueOf(items.get(position).getPrice());
            totalParts[0] = qty.getText().toString();
            totalp.setText(String.join(" ", totalParts));

            Double qtyValue = Double.parseDouble(totalParts[0]);
            Double itemPrice = Double.parseDouble(totalParts[2]);

            Double totalPrice = qtyValue * itemPrice;

            price.setText(String.valueOf(totalPrice) + " DZD");

            if(card_b.get(position)){
                String[] price_parts = price.getText().toString().split("\\s+");
                p = p - Double.parseDouble(price_parts[0]);
                MainActivity.price_t.setText(String.valueOf(p) + "DZD");
            }
        });

        image.setOnClickListener(v -> {
            card_b.set(position, !card_b.get(position));
            card = layout.findViewById(R.id.card);
            card_img = layout.findViewById(R.id.card_img);
            card_name = layout.findViewById(R.id.card_name);
            card_category = layout.findViewById(R.id.card_category);

            if(!card_b.get(position)) {
                card.setVisibility(View.VISIBLE);
                card_img.setImageResource(items.get(position).getImage());
                card_name.setText(items.get(position).getName());
                card_category.setText(items.get(position).getCategory());
            }else {
                card.setVisibility(View.GONE);
            }
        });

        return layout;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
