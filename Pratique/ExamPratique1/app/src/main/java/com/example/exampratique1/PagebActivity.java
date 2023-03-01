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
import com.example.exampratique1.databinding.ActivityPagebBinding;
import com.google.android.material.navigation.NavigationView;

public class PagebActivity extends AppCompatActivity {
    private ActivityPagebBinding myBinding;
    private ActionBarDrawerToggle actionBarToggler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageb);
        this.setUpDrawer();
    }
    private void setUpDrawer() {
        myBinding = ActivityPagebBinding.inflate(getLayoutInflater());
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
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i ;

                switch (item.getItemId()){
                    case R.id.nav_pageA:
                        i = new Intent(getApplicationContext(),FirstActivity.class);
                        startActivity(i);
                        break;
                    case  R.id.nav_pageB:
                        i = new Intent(getApplicationContext(),PagebActivity.class);
                        startActivity(i);
                        break;

                }
                myDrawer.closeDrawers();
                return false;
            }
        });
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