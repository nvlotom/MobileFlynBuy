package com.example.user.minimemobiledal.DomainPackage;

/**
 * Created by user on 9/4/2015.
 */
public class LoginResponse {
    LOGINRESULT LoginResult;

    /*constructor*/
    public LoginResponse(){
        LoginResult=new LOGINRESULT();
    }

    /*Getters*/
    public LOGINRESULT GetLoginResult(){
        LOGINRESULT LoginResult=new LOGINRESULT();
        LoginResult=this.LoginResult;
        return LoginResult;
    }


    /*Setters*/
    public void SetLoginResult(LOGINRESULT LoginResult){
        this.LoginResult=LoginResult;
    }


}
