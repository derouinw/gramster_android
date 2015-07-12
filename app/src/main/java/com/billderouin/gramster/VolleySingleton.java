package com.billderouin.gramster;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by bill on 7/12/15.
 */
public class VolleySingleton {

    private static RequestQueue mRequestQueue;

    public static synchronized RequestQueue getRequestQueue(Context context) {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }

        return mRequestQueue;
    }
}
