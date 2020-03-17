package com.example.climate_prediction;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.View;

import static java.security.AccessController.getContext;

public class MyGlobals {

    private Context mContext;

    public MyGlobals(Context context){
        this.mContext = context;
    }

    static Uri resourceToUri(Context context, int resID) {
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                context.getResources().getResourcePackageName(resID) + '/' +
                context.getResources().getResourceTypeName(resID) + '/' +
                context.getResources().getResourceEntryName(resID) );
    }
}
