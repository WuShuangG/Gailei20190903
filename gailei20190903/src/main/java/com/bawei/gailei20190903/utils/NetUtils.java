package com.bawei.gailei20190903.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.gailei20190903.app.App;

/**
 * author: 盖磊
 * data: 2019/9/3 09:9:10
 * function:
 */
public class NetUtils {

    //b)	使用单例模式封装NetUtils网络工具类
    private static NetUtils netUtils = null;
    public NetUtils(){}
    public static NetUtils getInstance(){
        if (netUtils == null){
            synchronized (NetUtils.class){
                if (netUtils == null){
                    netUtils = new NetUtils();
                }
            }
        }
        return netUtils;
    }

    public interface CallBackT{
        void onSuccess(Object obj);
        void onError(String msg);
    }


    //c)	封装网络判断的方法，可以获取有网、无网、wifi、4G
    public static boolean  isNetWork(Context context){
        if (context != null){
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null){
                return info.isAvailable();
            }
        }
        return false;
    }

    //d)	封装获取网络数据的方法，并使用该方法完成接口数据的请求
    public void getJson(String path, final CallBackT callBackT){
        RequestQueue queue = Volley.newRequestQueue(App.ofContext);
        StringRequest request = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (callBackT != null){
                    callBackT.onSuccess(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (callBackT != null){
                    callBackT.onError(error.getMessage());
                }
            }
        });
        queue.add(request);
    }

    //e)	封装获取网络图片的方法，并使用该方法完成图片的请求
    public void getImage(String path, final CallBackT callBackT){
        RequestQueue queue = Volley.newRequestQueue(App.ofContext);
        StringRequest request = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (callBackT != null){
                    callBackT.onSuccess(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (callBackT != null){
                    callBackT.onError(error.getMessage());
                }
            }
        });
        queue.add(request);
    }
}
