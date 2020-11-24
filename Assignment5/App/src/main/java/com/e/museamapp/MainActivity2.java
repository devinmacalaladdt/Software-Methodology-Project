package com.e.museamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(getApplicationContext(),getString(R.string.toast),Toast.LENGTH_SHORT).show();

        String museum = getIntent().getStringExtra("museum");
        ImageView image = (ImageView)findViewById(R.id.img);
        TextView museum_name = (TextView)findViewById(R.id.museum_name);
        if(museum.equals(getString(R.string.chinese_museum_indicator))){

            image.setImageResource(R.drawable.china);
            museum_name.setText(getString(R.string.chinese));
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uriUrl = Uri.parse(getString(R.string.chinaLink));
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);}
            });

        }else if(museum.equals(getString(R.string.jewish_museum_indicator))){

            image.setImageResource(R.drawable.jewish);
            museum_name.setText(getString(R.string.jewish));
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uriUrl = Uri.parse(getString(R.string.jewishLink));
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);}
            });

        }else if(museum.equals(getString(R.string.new_museum_indicator))){

            image.setImageResource(R.drawable.thenew);
            museum_name.setText(getString(R.string.newmuseum));
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uriUrl = Uri.parse(getString(R.string.newLink));
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);}
            });

        }else{

            image.setImageResource(R.drawable.noguchi);
            museum_name.setText(getString(R.string.noguchi));
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uriUrl = Uri.parse(getString(R.string.noguchiLink));
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);}
            });

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}