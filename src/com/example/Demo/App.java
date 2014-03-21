package com.example.Demo;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by yee on 3/21/14.
 */
public class App extends Application {

    private static Context globalContext ;

    @Override
    public void onCreate() {
        super.onCreate();
        if (globalContext == null) {
            globalContext = getApplicationContext() ;
        }
    }

    public static Context globalContext(){
        return globalContext ;
    }

    /**
     * toast info not required context
     * @param info
     */
    public static void alert(String info){
        alert(info,Toast.LENGTH_SHORT);
    }

    /**
     * @param info
     * @param time
     */
    public static void alert(String info, int time) {
        Toast.makeText(globalContext,info,time).show();
    }

}
