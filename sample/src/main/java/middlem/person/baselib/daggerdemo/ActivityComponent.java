package middlem.person.baselib.daggerdemo;

import dagger.Component;
import middlem.person.baselib.SampleActivity;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/7 21:36
 ***********************************************/
@Component
public interface ActivityComponent {
    void  inject(SampleActivity sampleActivity);
}
