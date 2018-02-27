package middlem.person.basemodule;

import android.app.Application;

import middlem.person.utilsmodule.LogUtils;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/30 13:37
 ***********************************************/

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.setLogEnable(true);
    }
}
