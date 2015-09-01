package com.example.user.minimemobilewebrequests;

import android.util.Base64;

import java.util.ArrayList;

/**
 * Created by user on 9/1/2015.
 */
public class PostWebRequest {

    private String url;
    private ArrayList<String> parameters;
    private int action;



    /*constructor*/
    public PostWebRequest(String url, ArrayList<String> parameters, int action){
        this.url=url;
        this.parameters=parameters;
        this.action=action;

    }


    /*send post to server*/
    public void SendPost(){
        String concat_param=BuildParam(); //take url and concat with parameters

        String header=null;
        if (this.action==1) { //with header
          header=  BuildHeader(concat_param); //build header if available
        }



        SendRequest(header); //sendRequest with or without header
    }

    /*build url with server, directory and parameters part*/
    private String BuildParam(){

        StringBuilder complete_param=new StringBuilder(); //build string with all parameters for the header function

        for (String param : this.parameters) { //faster than normal for loop

            complete_param.append(param);
            complete_param.append(":");
        }

        if (complete_param.length()>0)  { //has at least one parameter
            complete_param.setLength(complete_param.length() - 1);
            return complete_param.toString();
        }


        return null; //no parameters

    }

    /*build header*/
    private String BuildHeader(String concat_param){
        String header = getB64Auth(concat_param);
        return header;
    }



    /*help function to make the header*/
    private String getB64Auth (String concat_param) {
        if (concat_param==null){ //check if we have no parameters
            return null;
        }
        else {
            String source = concat_param;
            String ret = "Basic " + Base64.encodeToString(source.getBytes(), Base64.URL_SAFE | Base64.NO_WRAP);
            return ret;
        }
    }

    /*send post request with async task <-avoid delays*/
    private void SendRequest(String header){

        PostWithAsync post= new PostWithAsync(this.url,this.parameters,header);
        post.execute();

    }


}
