package com.example.user.minimemobilewebrequests;

/**
 * Created by user on 9/2/2015.
 */

/*Helpful function to return server's response from an async task to the caller class
* String response is the response from the server
* */
public interface OnTaskCompleted{
    void onTaskCompleted(String response);
}

