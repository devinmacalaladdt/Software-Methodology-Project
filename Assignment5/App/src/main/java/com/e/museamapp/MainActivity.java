/**
 * Devin Macalalad and David Gasperini
 */
package com.e.museamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Main Activity. Contains buttons for each museum page and functionality to
 * transition to 2nd activity
 */
public class MainActivity extends AppCompatActivity {

    //Called on activity creation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons to museum ticket calculator
        //listeners for each
        Button chineseBtn = (Button)findViewById(R.id.chinese);
        Button jewishBtn = (Button)findViewById(R.id.jewish);
        Button newmuseumBtn = (Button)findViewById(R.id.newmuseum);
        Button noguchiBtn = (Button)findViewById(R.id.noguchi);

        chineseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                String museum = getString(R.string.chinese_museum_indicator);
                intent.putExtra(getString(R.string.museum_key),museum);
                view.getContext().startActivity(intent);}
        });

        jewishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                String museum = getString(R.string.jewish_museum_indicator);
                intent.putExtra(getString(R.string.museum_key),museum);
                view.getContext().startActivity(intent);}
        });

        newmuseumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                String museum = getString(R.string.new_museum_indicator);
                intent.putExtra(getString(R.string.museum_key),museum);
                view.getContext().startActivity(intent);}
        });

        noguchiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                String museum = getString(R.string.noguchi_museum_indicator);
                intent.putExtra(getString(R.string.museum_key),museum);
                view.getContext().startActivity(intent);}
        });

    }
}

