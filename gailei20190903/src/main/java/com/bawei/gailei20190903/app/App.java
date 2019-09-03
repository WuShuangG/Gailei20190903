package com.bawei.gailei20190903.app;

import android.app.Application;
import android.content.Context;

/**
 * author: 盖磊
 * data: 2019/9/3 09:9:07
 * function:
 */
public class App extends Application {

    public static Context ofContext;

    @Override
    public void onCreate() {
        super.onCreate();
        ofContext = this;
    }
}
