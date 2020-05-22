package id.amin_syifa.dgreen;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.*;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private MySingleton(Context context){
        mCtx = context;
        mRequestQueue = getmRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context){
        if (mInstance == null){
            mInstance = new MySingleton(context);
        }return mInstance;
    }

    private RequestQueue getmRequestQueue(){
        if (mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        getmRequestQueue().add(req);
    }
}