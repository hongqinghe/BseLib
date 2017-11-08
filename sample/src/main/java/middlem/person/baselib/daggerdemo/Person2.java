package middlem.person.baselib.daggerdemo;

import javax.inject.Inject;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/7 09:31
 ***********************************************/

public class Person2 {
    @Inject
    public Person2() {

    }

    public String toSend() {
        return "dagger注解";
    }
}
