package middlem.person.basemodule.mvp;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/6 09:08
 ***********************************************/
public interface AppComponent {

    Application application();

    void  inject(AppDelegate delegate);
}
