package com.hss01248.netdemo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.hss01248.net.util.MyActyManager;
import com.hss01248.net.wrapper.HttpUtil;
import com.hss01248.netdemo.akulaku.AkulakuParser;
import com.orhanobut.logger.Logger;
import com.readystatesoftware.chuck.ChuckInterceptor;

/**
 * Created by Administrator on 2016/9/4.
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        //FreelineCore.init(this);//要第一行
        super.onCreate();
        HttpUtil.init(this,"http://www.qxinli.com:8080/")
                .addInterceptor(new ChuckInterceptor(this))//注:会影响上传下载的实时进度显示,调试上传下载时,关闭此拦截器
                .addJsonParseStragegy(19,new AkulakuParser())
                .openLog("httputil");
       // MyRetrofitUtil.init(getApplicaionContext());
        registCallback();
        Logger.init("netapi");


    }


    private void registCallback() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                MyActyManager.getInstance().setCurrentActivity(activity);

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }


}
