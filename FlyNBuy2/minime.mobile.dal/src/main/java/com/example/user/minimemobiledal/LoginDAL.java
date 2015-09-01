package com.example.user.minimemobiledal;

import com.example.user.minimemobilewebrequests.PostWebRequest;

import java.util.ArrayList;

/**
 * Created by user on 9/1/2015.
 */
public class LoginDAL {
    private String serverpart_url; //server name
    private String directorypart_url; //directory/folder
    private ArrayList<String> parameters; //parameters
    private int action; //login, sign up, etc

    /*constructor*/
    public LoginDAL(ArrayList<String> parameters){

        this.serverpart_url="http://localhost:15536";
        this.directorypart_url="/Plugins/Misc.WebServices/Remote/NopService.svc/Login";
        this.parameters=parameters;
        this.action=1;// 1 is for login
    }


    /*send credentials to post them*/
    public void SendCredentials(){
        StringBuilder url_no_param=new StringBuilder(); //faster than string concatenation
        url_no_param.append(this.serverpart_url);
        url_no_param.append(this.directorypart_url);

        PostWebRequest post=new PostWebRequest(url_no_param.toString(),this.parameters,this.action);
        post.SendPost();


    }





}
