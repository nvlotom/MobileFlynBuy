package com.example.user.minimemobiledal.DomainPackage;

import java.util.List;

/**
 * Created by user on 9/4/2015.
 */
public class LOGINRESULT {
    int Id;
    String Name;
    int Surname;
    List<String> PicturesBase64;

    /*constructor*/
    public LOGINRESULT(){
        this.Id=0;
        this.Name=null;
        this.Surname=0;
        this.PicturesBase64=null;
    }

    /*Getters*/
    public int GetId (){
        int Id=this.Id;
        return Id;
    }

    public String GetName(){
        String Name=this.Name;
        return Name;
    }

    public int GetSurname(){
        int Surname=this.Surname;
        return Surname;
    }

    public List<String> GetPicturesBase64(){
        List<String> PicturesBase64=this.PicturesBase64;
        return PicturesBase64;
    }


    /*Setters*/
    public void SetId(int Id){
        this.Id=Id;
    }

    public void SetName(String Name){
        this.Name=Name;
    }

    public void SetSurname(int Surname){
        this.Surname=Surname;
    }

    public void SetPicturesBase64(List<String> PicturesBase64){
        this.PicturesBase64=PicturesBase64;
    }


}
