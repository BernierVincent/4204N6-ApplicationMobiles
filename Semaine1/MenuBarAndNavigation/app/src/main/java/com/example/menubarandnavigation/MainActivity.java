package com.example.menubarandnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_navigation,menu);
        return true ;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent i = new Intent();
        switch (id){
            case R.id.main:
                 i = new Intent(MainActivity.this,MainActivity.class);

                startActivity(i);
                return true;
            case R.id.second:
                i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
                return true;
            case R.id.third:
                i = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(i);
                return true;

        }
        return false;
    }
}