package com.example.user.minimemobilewebrequests;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class GetWithAsync extends AsyncTask<Void, Void, JSONObject> {

    private String url;
    private ArrayList<String> params;
    private String header;
    private OnTaskCompleted results_transferer;


    /*constructor*/
    public GetWithAsync(String url, ArrayList<String> params, String header, OnTaskCompleted results_transferer){
        this.url=url;
        this.params=params;
        this.header=header;
        this.results_transferer=results_transferer;

    }


    @Override
    protected JSONObject doInBackground(Void... params) {
        String text = "";
        BufferedReader reader=null;
        try {

            URL url = new URL(this.url);   //<------------ i want this
            //URL url = new URL("http://www.cheesejedi.com/rest_services/get_big_cheese.php");
            // Send POST data request
            HttpURLConnection conn =(HttpURLConnection) url.openConnection(); //////



            conn.setRequestMethod("GET"); /////////
            //conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");///////////

            if (this.header != null) { //check for non-empty header
                conn.setRequestProperty("Authorization", this.header);
                Log.v("HEADER->", this.header);
            }




            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            //to grab server's response code
            HttpURLConnection httpConnection = (HttpURLConnection) conn;

            int code = httpConnection.getResponseCode();

            StringBuilder sb = new StringBuilder();
            String line = null;



            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }




            text = sb.toString();

        }
        catch(Exception ex)
        {

            Log.e("MYAPP", "exception", ex);

        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }

        JSONObject jsnresponse=null;
        try {
            jsnresponse= new JSONObject(text);
        }
        catch (Exception ex){
            Log.v("ERROR HERE", ex.toString());
        }

        return jsnresponse;


    }

    @Override
    protected void onPostExecute(JSONObject jsnresponse) {
        // server's response

        Log.v("jsonresponse",jsnresponse.toString());

        this.results_transferer.onTaskCompleted(jsnresponse.toString()); //return results to caller class

        //CODE TO PARSE JSONArray
        /*
        List<String> allid = new ArrayList<String>();


        for (int i=0; i<jsnresponse.length(); i++) {

            try {
                JSONObject actor = jsnresponse.getJSONObject(i);
                String name = actor.getString("id");
                Log.v("id"+i,name);
                allid.add(name);
            }
            catch(Exception ex){

            }


        }
    */



    }

}
