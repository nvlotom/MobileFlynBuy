package com.example.user.minimemobiledal.LoginPackage;

import android.util.Log;

import com.example.user.minimemobiledal.DomainPackage.LoginResponse;
import com.example.user.minimemobilewebrequests.PostWebRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 9/1/2015.
 */
public class LoginDAL {
    private String serverpart_url; //server name
    private String directorypart_url; //directory/folder
    private ArrayList<String> parameters; //parameters
    private int action; //non-header, login, sign up, etc

    /*constructor*/
    public LoginDAL(ArrayList<String> parameters, String serverpart_url){

        this.serverpart_url=serverpart_url;
        this.directorypart_url="/Plugins/Misc.WebServices/Remote/NopService.svc/Login";
        this.parameters=parameters;
        this.action=1;// 1 is for header
    }


    /*send credentials to post them
    * return response from server
    * */
    public String SendCredentials(){
        StringBuilder url_no_param=new StringBuilder(); //faster than string concatenation
        url_no_param.append(this.serverpart_url);
        url_no_param.append(this.directorypart_url);

        PostWebRequest post=new PostWebRequest(url_no_param.toString(),this.parameters,this.action);
        String res=post.SendPost();

        Log.v("RESPONSE UPPER LEVEL","jhg");
        Log.v("RESPONSE UPPER LEVELLLL",res);




        /*deserialize*/
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        JSONObject results=null;

        //Customer customer = new Customer();
        //LOGINRESULT loginResult=new LOGINRESULT();
        LoginResponse response=new LoginResponse();

        try
        {
            results = new JSONObject(res);
            response = gson.fromJson(results.toString(), LoginResponse.class);
            Log.v("customer object", response.GetLoginResult().GetName());/////////////////
        }
        catch(Exception e)
        {
            Log.v("error customer object", e.toString());/////////////////
        }
/////////////////////////////////////////////////////////////////////////i need to think its best location




        return res;

    }





}
