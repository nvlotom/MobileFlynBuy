package com.example.user.flynbuy.RegisterCustomersPackage;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.flynbuy.R;
import com.example.user.minimemobiledal.LoginDAL;
import com.example.user.minimemobiledal.RegisterCustomersDAL;

import org.json.JSONObject;

import java.util.ArrayList;


public class RegisterCustomersUI extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_customers_interface);

        Bundle bundle = getIntent().getExtras(); //to get data from parent activity
        final String server_part_url  = bundle.getString("server_part_url");


        Button register_button= (Button) findViewById(R.id.register_button_id);
        register_button.setOnClickListener(new View.OnClickListener() {

            //login button is clicked
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                ArrayList<String> details= GrabDetails(); //grab details from fields
                ArrayList<String> name_of_details=new ArrayList<String>();
                name_of_details.add("Id");
                name_of_details.add("Name");
                name_of_details.add("PicturesBase64");
                name_of_details.add("Surname");


                String jsonobjectstring=CreateJSONObject(name_of_details,details);
                Log.v("JSONSTRING", jsonobjectstring);

                ArrayList<String> params_to_send=new ArrayList<String>();
                params_to_send.add(jsonobjectstring);

                RegisterCustomersDAL startregister=new RegisterCustomersDAL(params_to_send,server_part_url);
                String response=startregister.SendDetails();
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

    private ArrayList<String> GrabDetails(){
        EditText id_text= (EditText) findViewById(R.id.id_text_id);
        String id = id_text.getText().toString();

        EditText name_text= (EditText) findViewById(R.id.name_text_id);
        String name = name_text.getText().toString();

        EditText surname_text= (EditText) findViewById(R.id.surname_text_id);
        String surname = surname_text.getText().toString();





        ArrayList<String> details= new ArrayList<String>();
        details.add(id);
        details.add(name);
        details.add("null");
        details.add(surname);
        return details;

    }


    /*create JSONObject function*/
    private String CreateJSONObject(ArrayList<String> name_of_details, ArrayList<String> details) {
        JSONObject json = new JSONObject();

        try {
            for (int i = 0; i < name_of_details.size(); i++) {
                json.put(name_of_details.get(i), details.get(i));
            }
        }
        catch(Exception ex){
            Log.v("Exception create json", ex.toString());
            return null;
        }

        return json.toString();

    }

}
