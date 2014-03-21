package com.example.Demo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by yee on 3/21/14.
 * 网络状态
 * <p>包括判断是否有网络连接，网络连接类型
 * </p>
 */
public class NetworkStatus {

    private static final String TAG = "NetworkStatus" ;
    private static ConnectivityManager connMgr;

    static{
        connMgr = (ConnectivityManager)App.globalContext().
                getSystemService(Context.CONNECTIVITY_SERVICE);
        LogAbout.logcatD(TAG,"initial connectivityManager");
    }

    private NetworkStatus(){
    }


    /**
     * 判断WIFI是否已经连接
     * @return
     */
    public static boolean checkWIFIStatus(){
        LogAbout.logcatD(TAG,"check whether wifi status is useable");
        NetworkInfo wifiInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return (wifiInfo != null && wifiInfo.isConnected()) ;
    }

    /**
     * 判断手机网络是否已经连接
     * @return
     */
    public static boolean checkMobileStatus(){
        LogAbout.logcatD(TAG,"check whether mobile network is useable");
        NetworkInfo mobileInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return (mobileInfo != null && mobileInfo.isConnected()) ;
    }


    /**
     * check whether network is usable，include wifi and mobile
     * @return
     */
    public static boolean isOnline() {
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }


    /**
     * 返回连接网络的类型
     * <ol>
     *     <li>网络连接未激活</li>
     *     <li>WIFI</li>
     *     <li>Mobile</li>
     *     <li>未知网络</li>
     * </ol>
     * @return
     */
    public static NetworkType networkType(){
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        //无网络连接
        if (networkInfo == null) {
            return NetworkType.NO_ACTIVE;
        }
        //WIFI
        if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return NetworkType.WIFI ;
        }
        //Mobile
        if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return NetworkType.MOBILE;
        }
        //未知网络
        return NetworkType.NO_NAME ;

    }

    /**
     * 移动mobile 联通unicom. 电信elecom，WIFI
     */
    public enum NetworkType{

        /**网络连接未激活*/
        NO_ACTIVE,

        /**未知网络*/
        NO_NAME,

        /**移动2G*/
        MOBILE_2G,

        /**联通2G*/
        UNICOM_2G,
        /**电信2G*/
        ELECOM_2G,

        /**联通3G*/
        UNICOM_3G,
        /**电信3G*/
        ELECOM_3G,

        /**手机网络 */
        MOBILE ,

        /**WIFIS*/
        WIFI,
    }
}