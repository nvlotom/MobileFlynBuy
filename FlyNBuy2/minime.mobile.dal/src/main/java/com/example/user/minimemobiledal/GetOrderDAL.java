package com.example.user.minimemobiledal;

import android.util.Log;

import com.example.user.minimemobilewebrequests.PostWebRequest;

import java.util.ArrayList;


public class GetOrderDAL {
    private String serverpart_url; //server name
    private String directorypart_url; //directory/folder
    private ArrayList<String> parameters; //parameters
    private int action; //non-header, login, sign up, etc

    public GetOrderDAL(String serverpart_url){

        this.serverpart_url=serverpart_url;
        this.directorypart_url="/Plugins/Misc.WebServices/Remote/NopService.svc/GetOrders";
        this.parameters=null;
        this.action=0;// 0 is for non header

    }


    public String SendRequest(){
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
