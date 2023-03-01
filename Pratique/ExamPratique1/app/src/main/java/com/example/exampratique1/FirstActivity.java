package com.example.exampratique1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.exampratique1.databinding.ActivityFirstBinding;
import com.google.android.material.navigation.NavigationView;

public class FirstActivity extends AppCompatActivity {
     private ActivityFirstBinding myBinding;
     private ActionBarDrawerToggle actionBarToggler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        this.setUpDrawer();

    }

    private void setUpDrawer() {
        myBinding= ActivityFirstBinding.inflate(getLayoutInflater());
        View myView = myBinding.getRoot();
        setContentView(myView);
        NavigationView nv = myBinding.navMenu;
        DrawerLayout myDrawer = myBinding.drawerLayout;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarToggler = new ActionBarDrawerToggle(this,myDrawer,R.string.drawer_Open,R.string.drawer_Close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.DrawerTitle);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(R.string.app_name);
            }
        };
        myDrawer.addDrawerListener(actionBarToggler);
        actionBarToggler.syncState();
        
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarToggler.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarToggler.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        actionBarToggler.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);

    }
}