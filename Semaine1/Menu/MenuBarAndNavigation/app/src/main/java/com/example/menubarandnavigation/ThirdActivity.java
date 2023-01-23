package com.example.menubarandnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_navigation,menu);
        return true ;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.main){
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            return  true;
        }
        else if (id == R.id.second){
            Intent i = new Intent(getApplicationContext(),SecondActivity.class);
            startActivity(i);
            return  true;
        }
        else {
            Intent i = new Intent(getApplicationContext(),ThirdActivity.class);
            startActivity(i);
            return  true;
        }
    }
}