package middlem.person.baselib;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import javax.inject.Inject;

import middlem.person.baselib.daggerdemo.Demo;
import middlem.person.baselib.daggerdemo.Demo2;
import middlem.person.baselib.daggerdemo.Person;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/1 21:11
 * <P> Copyright  2008 二维火科技
 ***********************************************/

public class SampleActivity extends FragmentActivity {
    private static final String TAG = "test";
    @Inject
    Demo2 demo2;
    private RecyclerView recycleView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.create().inject(this);
        recycleView = findViewById(R.id.recycleView);
        Person person = new Person();
        Demo demo = new Demo(person);
        Log.e(TAG, demo.toDo());
        Log.e(TAG, demo2.toDo());
    }

}
