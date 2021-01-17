package com.example.versa_app;

import android.os.Bundle;

import com.example.versa_app.DB.DatabaseHelper;
import com.example.versa_app.DB.DatabaseManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    public DatabaseManager dbManager;
    final String[] from = new String[] { DatabaseHelper._ID, DatabaseHelper.ITEM, DatabaseHelper.USER, DatabaseHelper.RATING, DatabaseHelper.DESC };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DatabaseManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        /*dbManager.insert("Mcdonald's | Coffee","Jason",3,"Bold!");
        dbManager.insert("Starbucks | Coffee","Carlee",4,"Nice");
        dbManager.insert("Mcdonald's | Iced Coffee","Jason",4,"Refreshing");
        dbManager.insert("Mcdonald's | Coffee","Carlee",4,"I like it");*/

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}
