/**
 * Devin Macalalad and David Gasperini
 */
package com.e.museamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Ticket calculation activity. Contains clickable image and specificatioins for ticket prices
 */
public class MainActivity2 extends AppCompatActivity {

    /**Constant 3-tuples representing the price data from the respective websites**/
    final int[] chinese = {8,12,8};
    final int[] jewish = {10,16,12};
    final int[] new_museum = {12,18,15};
    final int[] noguchi = {5,10,5};

    /**Current NY sales tax, note all museums are in NY**/
    final double salesTaxNY = 0.08875;

    /**Called when the activity launches, performs initialization and button click methods**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**Initial setup**/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(getApplicationContext(),getString(R.string.toast),
                Toast.LENGTH_SHORT).show();

        /**Get GUI components**/
        String museum = getIntent().getStringExtra("museum");
        ImageView image = (ImageView)findViewById(R.id.img);
        TextView museum_name = (TextView)findViewById(R.id.museum_name);
        Button btnCalc = (Button)findViewById(R.id.btnCalc);
        TextView txtStudent = (TextView)findViewById(R.id.txtStudent);
        TextView txtSenior = (TextView)findViewById(R.id.txtSenior);
        TextView txtAdult = (TextView)findViewById(R.id.txtAdult);

        /**Set museum specific information based on the initial selection in Activity 1**/
        if(museum.equals(getString(R.string.chinese_museum_indicator))){
            /**Set ticket price per type**/
            txtStudent.append("" + chinese[0]);
            txtAdult.append("" + chinese[1]);
            txtSenior.append("" + chinese[2]);

            image.setImageResource(R.drawable.china);
            museum_name.setText(getString(R.string.chinese));

            /**Click to website**/
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uriUrl = Uri.parse(getString(R.string.chinaLink));
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);}
            });
        }else if(museum.equals(getString(R.string.jewish_museum_indicator))){
            /**Set ticket price per type**/
            txtStudent.append("" + jewish[0]);
            txtAdult.append("" + jewish[1]);
            txtSenior.append("" + jewish[2]);

            image.setImageResource(R.drawable.jewish);
            museum_name.setText(getString(R.string.jewish));

            /**Click to website**/
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uriUrl = Uri.parse(getString(R.string.jewishLink));
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);}
            });
        }else if(museum.equals(getString(R.string.new_museum_indicator))){
            /**Set ticket price per type**/
            txtStudent.append("" + new_museum[0]);
            txtAdult.append("" + new_museum[1]);
            txtSenior.append("" + new_museum[2]);

            image.setImageResource(R.drawable.thenew);
            museum_name.setText(getString(R.string.newmuseum));

            /**Click to website**/
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uriUrl = Uri.parse(getString(R.string.newLink));
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);}
            });
        }else{
            /**Set ticket price per type**/
            txtStudent.append("" + noguchi[0]);
            txtAdult.append("" + noguchi[1]);
            txtSenior.append("" + noguchi[2]);

            image.setImageResource(R.drawable.noguchi);
            museum_name.setText(getString(R.string.noguchi));

            /**Click to website**/
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uriUrl = Uri.parse(getString(R.string.noguchiLink));
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);}
            });
        }

        /**Click action for calculate, same for all museums**/
        btnCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /**initialization**/
                Spinner spinStudent = (Spinner) findViewById(R.id.spinStudent);
                Spinner spinSenior = (Spinner) findViewById(R.id.spinSenior);
                Spinner spinAdult = (Spinner) findViewById(R.id.spinAdult);
                double subTotal, taxes, total;

                /**Change calculation for museum type; calculate sub-total**/
                if (museum.equals(getString(R.string.chinese_museum_indicator))) {
                    subTotal = Integer.parseInt(spinStudent.getSelectedItem().toString()) * chinese[0]
                            + Integer.parseInt(spinAdult.getSelectedItem().toString()) * chinese[1] +
                            Integer.parseInt(spinSenior.getSelectedItem().toString()) * chinese[2];
                } else if (museum.equals(getString(R.string.jewish_museum_indicator))) {
                    subTotal = Integer.parseInt(spinStudent.getSelectedItem().toString()) * jewish[0]
                            + Integer.parseInt(spinAdult.getSelectedItem().toString()) * jewish[1] +
                            Integer.parseInt(spinSenior.getSelectedItem().toString()) * jewish[2];
                } else if (museum.equals(getString(R.string.new_museum_indicator))) {
                    subTotal = Integer.parseInt(spinStudent.getSelectedItem().toString()) * new_museum[0]
                            + Integer.parseInt(spinAdult.getSelectedItem().toString()) * new_museum[1] +
                            Integer.parseInt(spinSenior.getSelectedItem().toString()) * new_museum[2];
                } else {
                    subTotal = Integer.parseInt(spinStudent.getSelectedItem().toString()) * noguchi[0]
                            + Integer.parseInt(spinAdult.getSelectedItem().toString()) * noguchi[1] +
                            Integer.parseInt(spinSenior.getSelectedItem().toString()) * noguchi[2];
                }

                /**Calculate other fields like taxes and final total**/
                taxes = subTotal * salesTaxNY;
                total = subTotal + taxes;
                taxes = Math.round(taxes*100) / 100.0;
                subTotal = Math.round(subTotal*100) / 100.0;
                total = Math.round(total*100) / 100.0;

                /**Write to GUI**/
                EditText txtbxSub = (EditText)findViewById(R.id.txtbxSub);
                EditText txtbxTax = (EditText)findViewById(R.id.txtbxTax);
                EditText txtbxTotal = (EditText)findViewById(R.id.txtbxTotal);
                txtbxSub.setText("" + subTotal);
                txtbxTax.setText("" + taxes);
                txtbxTotal.setText("" + total);
            }
        });
    }

    //For back button leading to homescreen
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