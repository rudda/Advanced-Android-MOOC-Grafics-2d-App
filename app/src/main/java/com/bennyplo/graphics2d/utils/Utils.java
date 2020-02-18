package com.bennyplo.graphics2d.utils;

import android.content.Context;

/**
 * class create by Rudda and aims to provides some screen utils resources
 * in order to reuse into all project tasks.
 * :)
 * I'm lucky guy
 */
public class Utils {

    public static int getScreenWidth(Context context){
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenHeight(Context context){
        return context.getResources().getDisplayMetrics().widthPixels;
    }


}
