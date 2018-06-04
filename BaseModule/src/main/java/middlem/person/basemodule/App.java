package middlem.person.basemodule;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import middlem.person.utilsmodule.comutils.LogUtils;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/30 13:37
 ***********************************************/

public class App extends Application{
    String tag = "app";
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.setLogEnable(true);
        registerActivityLifecycleCallbacks(lifecycleCallbacks);
    }

    Application.ActivityLifecycleCallbacks lifecycleCallbacks=new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            LogUtils.d(tag,activity.getClass().getName()+"------->create");
        }

        @Override
        public void onActivityStarted(Activity activity) {
            LogUtils.d(tag,activity.getClass().getName()+"------->onActivityStarted");
        }

        @Override
        public void onActivityResumed(Activity activity) {
            LogUtils.d(tag,activity.getClass().getName()+"------->onActivityResumed");
        }

        @Override
        public void onActivityPaused(Activity activity) {
            LogUtils.d(tag,activity.getClass().getName()+"------->onActivityPaused");
        }

        @Override
        public void onActivityStopped(Activity activity) {
            LogUtils.d(tag,activity.getClass().getName()+"------->onActivityStopped");
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            LogUtils.d(tag,activity.getClass().getName()+"------->onActivitySaveInstanceState");
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
//            TDFActivityStackManager.getInstance().popActivity(activity);
            LogUtils.d(tag,activity.getClass().getName()+"------->onActivityDestroyed");
        }
    };
}
