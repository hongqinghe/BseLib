package middlem.person.baselib.daggerdemo;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/7 09:26
 ***********************************************/

public class Demo {
    private Person person;

    public Demo(Person person) {
        this.person = person;
    }

    public String toDo() {
        return person.toSend();
    }
}
