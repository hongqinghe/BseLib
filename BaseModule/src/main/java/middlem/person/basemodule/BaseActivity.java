package middlem.person.basemodule;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/***********************************************
 *
 * <P> desc:   基类activty
 * <P> Author: gongtong
 * <P> Date: 2017-11-01 21:14
 ***********************************************/

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void nextActivity(Class clz){
        nextActivity(clz,null);
    }
    public void nextActivity(Class clz, @Nullable Bundle bundle){
        Intent intent=new Intent(this,clz);
        if (bundle!=null){
            startActivity(intent,bundle);
        }else {
            startActivity(intent);
        }
    }
}
