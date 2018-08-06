package com.kaihuang.commondemo;

import android.app.Application;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhihao.wen on 2016/11/25.
 */

public class App extends Application {


    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

//        AVIMMessageManager.registerDefaultMessageHandler(new CustomMessageHandler());
    }






}
