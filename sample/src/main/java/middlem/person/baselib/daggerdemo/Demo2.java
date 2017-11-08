package middlem.person.baselib.daggerdemo;

import javax.inject.Inject;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/7 09:35
 ***********************************************/

public class Demo2 {
    private Person2 person2;
    @Inject
    public Demo2(Person2 person2){
        this.person2=person2;
    }
    public String toDo(){
        return person2.toSend();
    }
}
