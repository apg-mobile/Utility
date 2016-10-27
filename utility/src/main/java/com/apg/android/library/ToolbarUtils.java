package com.apg.android.library;

import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by alphaadmin on 26/9/2559.
 */

public class ToolbarUtils {

    public static void setToolbar(AppCompatActivity activity, Toolbar toolbar) {
        setToolbar(activity, toolbar, 0);
    }

    public static void setToolbar(AppCompatActivity activity,
                                           Toolbar toolbar,
                                           @DrawableRes int id) {
        activity.setSupportActionBar(toolbar);
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            activity.getSupportActionBar().setHomeButtonEnabled(true);
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
            if (id != 0) {
                activity.getSupportActionBar().setHomeAsUpIndicator(id);
            }
        }
    }
}
