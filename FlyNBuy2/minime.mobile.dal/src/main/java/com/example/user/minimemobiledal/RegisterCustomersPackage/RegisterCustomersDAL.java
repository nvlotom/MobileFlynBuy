package com.example.user.minimemobiledal.RegisterCustomersPackage;

import android.util.Log;

import com.example.user.minimemobilewebrequests.PostWebRequest;

import java.util.ArrayList;


public class RegisterCustomersDAL {
    private String serverpart_url; //server name
    private String directorypart_url; //directory/folder
    private ArrayList<String> parameters; //parameters
    private int action; //non-header, login, sign up, etc

    /*constructor*/
    public RegisterCustomersDAL(ArrayList<String> parameters, String serverpart_url){

        this.serverpart_url=serverpart_url;
        this.directorypart_url="/Plugins/Misc.WebServices/Remote/NopService.svc/RegisterCustomers";
        this.parameters=parameters;
        this.action=0;// 1 is for non-header
    }


    /*send credentials to post them
    * return response from server
    * */
    public String SendDetails(){
        StringBuilder url_no_param=new StringBuilder(); //faster than string concatenation
        url_no_param.append(this.serverpart_url);
        url_no_param.append(this.directorypart_url);

        PostWebRequest post=new PostWebRequest(url_no_param.toString(),this.parameters,this.action);
        String res=post.SendPost();

        Log.v("RESPONSE UPPER LEVEL", "jhg");
        Log.v("RESPONSE UPPER LEVELLLL",res);
        return res;

    }





}
