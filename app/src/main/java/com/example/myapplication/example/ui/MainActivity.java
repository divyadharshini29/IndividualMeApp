package com.example.myapplication.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Random;

import com.example.myapplication.example.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity {
    GridView simpleGrid;
    AndroidImageAssets assets = new AndroidImageAssets();
    ArrayList<Integer> image = (ArrayList<Integer>) assets.getAll();
    ImageView head;
    ImageView body;
    ImageView foot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        simpleGrid = (GridView) findViewById( R.id.simpleGridView );
        final MasterListAdapter customAdapter = new MasterListAdapter( getApplicationContext(), image );
        simpleGrid.setAdapter( customAdapter );
        head = findViewById( R.id.head );
        body = findViewById( R.id.body );
        foot = findViewById( R.id.foot );

        simpleGrid.setBackgroundColor( Color.GRAY );

        simpleGrid.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {

                AndroidImageAssets assets1 = new AndroidImageAssets();

                arg1.setSelected( true );

                if (position <= 11) {
                    head.setImageResource( assets.all.get( position ) );


                } else if (position <= 23) {
                    body.setImageResource( assets.all.get( position ) );
                } else {
                    foot.setImageResource( assets.all.get( position ) );

                }
            }
        } );
        simpleGrid.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected( true );
                view.setBackgroundColor( Color.BLACK );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

    }

    public void random(View view) {
        Random r = new Random();
        int i1 = r.nextInt( 12 - 0 ) + 0;
        head.setImageResource( assets.all.get( i1 ) );
        int i2 = r.nextInt( 24 - 12 ) + 12;
        body.setImageResource( assets.all.get( i2 ) );
        int i3 = r.nextInt( 36 - 24 ) + 24;
        foot.setImageResource( assets.all.get( i3 ) );
    }
}
