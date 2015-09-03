package com.example.user.flynbuy.GetOrderPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.user.flynbuy.LoginPackage.LoginUI;
import com.example.user.flynbuy.R;
import com.example.user.minimemobiledal.GetHomePageProductsDAL;
import com.example.user.minimemobiledal.GetOrderDAL;


public class GetOrderUI extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_order_interface);

        Bundle bundle = getIntent().getExtras(); //to get data from parent activity
        String server_part_url  = bundle.getString("server_part_url");

        GetOrderDAL products = new GetOrderDAL(server_part_url);
        String response=products.SendRequest();
        TextView view_response= (TextView) findViewById(R.id.response_view_id);
        view_response.setText(response); //show response on UI

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

