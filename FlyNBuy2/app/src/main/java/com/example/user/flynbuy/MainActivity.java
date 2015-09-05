package com.example.user.flynbuy;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.flynbuy.GetHomePageProductsPackage.GetHomePageProductsUI;
import com.example.user.flynbuy.GetOrderPackage.GetOrderUI;
import com.example.user.flynbuy.LoginPackage.LoginUI;
import com.example.user.flynbuy.RegisterCustomersPackage.RegisterCustomersUI;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GET SERVER'S URL FROM MINIME.MOBILE.LOCATION
        String server_part_url="http://192.168.10.42:15536";


        Intent i = new Intent(MainActivity.this, GetHomePageProductsUI.class);
        i.putExtra("server_part_url", server_part_url); //send data to child activity
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
