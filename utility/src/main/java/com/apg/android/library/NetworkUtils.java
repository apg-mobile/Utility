package com.apg.android.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by X-tivity on 9/30/2016 AD.
 */

public class NetworkUtils {

    public static boolean hasInternetConnection(Context context) {
        NetworkInfo activeNetwork = getConnectivityManager(context).getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static boolean isConnectWifi(Context context) {
        NetworkInfo activeNetwork = getConnectivityManager(context).getActiveNetworkInfo();
        return  activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    }

    public static boolean isConnectMobile(Context context) {
        NetworkInfo activeNetwork = getConnectivityManager(context).getActiveNetworkInfo();
        return  activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
    }


    private static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
