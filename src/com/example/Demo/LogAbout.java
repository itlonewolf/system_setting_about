package com.example.Demo;

import android.util.Log;

/**
 * Created by yee on 3/3/14.
 * 打印Log日志
 */

public class LogAbout {
    /*
    * 发布应用之前将状态改为   发布应用  而不是  debug状态
    * */
    public static final boolean isDebug = true ;

    public static void logcatD(String tag, String info){
        if(isDebug)
            Log.d(tag, tag+"-->" + info) ;
    }
    public static void logcatV(String tag, String info){
        if(isDebug)
            Log.v(tag, tag + "-->" + info) ;
    }
    public static void logcatE(String tag, String info){
        if(isDebug)
            Log.e(tag, tag + "-->" + info) ;
    }
    public static void logcatI(String tag, String info){
        if(isDebug)
            Log.i(tag, tag + "-->" + info) ;
    }
    public static void logcatW(String tag, String info){
        if(isDebug)
            Log.w(tag, tag + "-->" + info) ;
    }
    public static void logcatWTF(String tag, String info){
        if(isDebug)
            Log.wtf(tag, tag + "-->" + info ) ;
    }
}