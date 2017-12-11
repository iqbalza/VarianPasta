package com.example.dedijun.varianpasta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.app.ListActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //deklarasi
    private ListView mListView;
    //array untuk menghitung counter setiap item
    private List<Integer> counterList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //catch listView
        mListView = findViewById(R.id.listView);
        //deklarasi referensi database
        final DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("menu");


        //ListView Firebase
        FirebaseListAdapter<menu> firebaseListAdapter = new FirebaseListAdapter<menu>(
                this, menu.class, R.layout.list_order, mDatabaseReference
        )
        {
            @Override
            protected void populateView(View v, menu model, final int position) {
                //Mengeset nama
                TextView nama = v.findViewById(R.id.nama);
                nama.setText(model.getNama());
                //Mengeset gambar
                ImageView image = (ImageView) v.findViewById(R.id.image);
                Picasso.with(MainActivity.this).load(model.getImage()).into(image);

                //onClick button minus
                Button minus = v.findViewById(R.id.minus);
                minus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Mencatch view
                        View view = (View) v.getParent();
                        TextView counter = view.findViewById(R.id.counter);
                        //Mencari posisi
                        int i = counterList.get(position);
                        //Mengecek counter apakah 0
                        if (i == 0) {

                        } else {
                            //set array
                            counterList.set(position, i - 1);
                            //update text
                            counter.setText(String.valueOf(counterList.get(position)));
                        }

                    }
                });

                Button plus = v.findViewById(R.id.plus);
                plus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       int i = counterList.get(position);
                        View view = (View) v.getParent();
                        counterList.set(position,i+1);
                        TextView counter = view.findViewById(R.id.counter);
                        counter.setText(String.valueOf(counterList.get(position)));

                    }
                });

               counterList.add(0);
//
//
//
//                    Log.v("for", String.valueOf(counterList));
                }





        };
        mListView.setAdapter(firebaseListAdapter);






    }

    
}
