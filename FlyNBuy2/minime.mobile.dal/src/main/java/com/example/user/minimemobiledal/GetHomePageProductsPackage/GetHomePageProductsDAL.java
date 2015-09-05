package com.example.user.minimemobiledal.GetHomePageProductsPackage;

import android.util.Log;

import com.example.user.minimemobiledal.DomainPackage.GETHOMEPAGEPRODUCTSRESULT;
import com.example.user.minimemobiledal.DomainPackage.GetHomePageProductsResponse;
import com.example.user.minimemobiledal.DomainPackage.LoginResponse;
import com.example.user.minimemobilewebrequests.GetWebRequest;
import com.example.user.minimemobilewebrequests.PostWebRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by user on 9/2/2015.
 */
public class GetHomePageProductsDAL {
    private String serverpart_url; //server name
    private String directorypart_url; //directory/folder
    private ArrayList<String> parameters; //parameters
    private int action; //non-header, login, sign up, etc

    public GetHomePageProductsDAL(String serverpart_url){

        this.serverpart_url=serverpart_url;
        this.directorypart_url="/Plugins/Misc.WebServices/Remote/NopService.svc/GetHomePageProducts";
        this.parameters=null;
        this.action=0;// 0 is for non header

    }


    public String SendRequest(){
        StringBuilder url_no_param=new StringBuilder(); //faster than string concatenation
        url_no_param.append(this.serverpart_url);
        url_no_param.append(this.directorypart_url);

        GetWebRequest get=new GetWebRequest(url_no_param.toString(),this.parameters,this.action);
        String res=get.SendGet();

        Log.v("RESPONSE UPPER LEVEL", "jhg");
        Log.v("RESPONSE UPPER LEVELLLL",res);




        /*deserialize*/
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        JSONObject results=null;

        //Customer customer = new Customer();
        //LOGINRESULT loginResult=new LOGINRESULT();
        GetHomePageProductsResponse response=new GetHomePageProductsResponse();

        try
        {
            results = new JSONObject(res);
            response = gson.fromJson(results.toString(), GetHomePageProductsResponse.class);


            Iterator<GETHOMEPAGEPRODUCTSRESULT> responseiterator = response.getGetHomePageProductsResult().iterator();//iterate through list
            while (responseiterator.hasNext()) {

                GETHOMEPAGEPRODUCTSRESULT current=responseiterator.next();
                Log.v("customer object", current.getFullDescription()+"\n-->"+current.getAvailableEndDateTimeUtc()+"\n--]>"+current.getSpecialPrice()+"");/////////////////

            }


        }
        catch(Exception e)
        {
            Log.v("error customer object", e.toString());/////////////////
        }
/////////////////////////////////////////////////////////////////////////i need to think its best location







        return res;


    }


}
