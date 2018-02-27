package middlem.person.basemodule.dagger;
import middlem.person.utilsmodule.LogUtils;
import static middlem.person.basemodule.dagger.Tag.DAGGER_TAG;
/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/28 23:21
 ***********************************************/

public class Dog {
    private Person owner;


    public Dog(Person  owner){
        this.owner=owner;
    }


    public void toSay(){
        LogUtils.d(DAGGER_TAG,"我是一条狗，我的主人是:"+owner.getName()+"类型"+owner.getType());
        System.out.println("我是一条狗，我的主人是:"+owner.getName());
    }
}
