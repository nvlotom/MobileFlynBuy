package com.example.user.minimemobilewebrequests;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class PostWithAsync extends AsyncTask<Void, Void, JSONObject> {

    private String url;
    private ArrayList<String> params;
    private String header;
    private OnTaskCompleted results_transferer;


    /*constructor*/
    public PostWithAsync(String url, ArrayList<String> params, String header, OnTaskCompleted results_transferer){
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
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            //conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");///////////

            if (this.header != null) { //check for non-empty header
                conn.setRequestProperty("Authorization", this.header);
                Log.v("HEADER->", this.header);
            }


            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            StringBuilder complete_param = new StringBuilder();


            if (this.params != null){  //has at least one parameter


                for (String param : this.params) { //faster than normal for loop
                    complete_param.append(param);
                    complete_param.append("/");
                }

                complete_param.setLength(complete_param.length() - 1);



                wr.write(complete_param.toString());//   <------- i want this

            }
            else{
                wr.write("");//no parameters
            }

            //wr.write("puzzle=1");   //<--------this must leave

            wr.flush();





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