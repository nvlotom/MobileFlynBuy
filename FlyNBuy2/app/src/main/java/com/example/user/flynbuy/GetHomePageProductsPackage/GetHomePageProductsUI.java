package com.example.user.flynbuy.GetHomePageProductsPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.flynbuy.LoginPackage.LoginUI;
import com.example.user.flynbuy.R;
import com.example.user.minimemobiledal.GetHomePageProductsDAL;


public class GetHomePageProductsUI extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_homepage_products_interface);

        Bundle bundle = getIntent().getExtras(); //to get data from parent activity
        String server_part_url  = bundle.getString("server_part_url");

        GetHomePageProductsDAL products = new GetHomePageProductsDAL(server_part_url);
        products.SendRequest();
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
