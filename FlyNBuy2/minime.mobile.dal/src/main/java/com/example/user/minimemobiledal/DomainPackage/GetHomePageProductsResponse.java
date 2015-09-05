package com.example.user.minimemobiledal.DomainPackage;

import java.util.List;

/**
 * Created by user on 9/4/2015.
 */
public class GetHomePageProductsResponse {
    List<GETHOMEPAGEPRODUCTSRESULT> GetHomePageProductsResult;

    /*constructor*/
    public GetHomePageProductsResponse(){
        this.GetHomePageProductsResult=null;
    }

    /*Getters & Setters*/
    public List<GETHOMEPAGEPRODUCTSRESULT> getGetHomePageProductsResult() {
        return GetHomePageProductsResult;
    }

    public void setGetHomePageProductsResult(List<GETHOMEPAGEPRODUCTSRESULT> getHomePageProductsResult) {
        GetHomePageProductsResult = getHomePageProductsResult;
    }
}
