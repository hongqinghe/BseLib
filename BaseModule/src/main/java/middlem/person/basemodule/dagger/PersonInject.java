package middlem.person.basemodule.dagger;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/28 23:19
 ***********************************************/

public class PersonInject {
    private String name;

   private  String type;

    public PersonInject() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
