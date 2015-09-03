package com.example.user.flynbuy.LoginPackage;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.flynbuy.R;
import com.example.user.minimemobiledal.LoginDAL;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class LoginUI extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_interface);

        Bundle bundle = getIntent().getExtras(); //to get data from parent activity
        final String server_part_url  = bundle.getString("server_part_url");


        Button login_button= (Button) findViewById(R.id.login_button_id);
        login_button.setOnClickListener(new View.OnClickListener() {

            //login button is clicked
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                ArrayList<String> params_to_send= GrabCredentials(); //grab credentials from fields
                LoginDAL startlogin=new LoginDAL(params_to_send,server_part_url);
                String response=startlogin.SendCredentials();
                TextView view_response= (TextView) findViewById(R.id.response_view_id);
                view_response.setText(response); //show response on UI


            }
        });

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


    /*Grab credentials from interface
    * return Arraylist with username[0] and password [1]
    * */

    private ArrayList<String> GrabCredentials(){
        EditText username_email_text= (EditText) findViewById(R.id.username_text_id);
        String username_email = username_email_text.getText().toString();

        EditText password_text= (EditText) findViewById(R.id.password_text_id);
        String password = password_text.getText().toString();

        ArrayList<String> cred= new ArrayList<String>();
        cred.add(username_email);
        cred.add(password);
        return cred;

    }
}
