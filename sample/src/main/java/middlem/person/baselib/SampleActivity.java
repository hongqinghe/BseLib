package middlem.person.baselib;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import middlem.person.baselib.daggerdemo.DaggerActivityComponent;
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
    private TextView textContent;

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
        textContent = findViewById(R.id.textView);

        Person person = new Person();
        Demo demo = new Demo(person);
        Log.e(TAG, demo.toDo());
        Log.e(TAG, demo2.toDo());

//        ReadStringUtils.getString(this);
//        ReadStringUtils.textReader(this);
    }

    /**
     * 字符格式化
     * @param view
     */
    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    public void stringFormat(View view) {
        @SuppressLint("StringFormatMatches")
//        String format = String.format(getResources().getString(R.string.string_format), 100);
        String format = String.format(getResources().getString(R.string.price_cost), 100.01,"年");
        System.out.println("=================="+format);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sDateFormat = new SimpleDateFormat("EEEE");
        Calendar calendar = Calendar.getInstance();
        textContent.setText(String.format(getString(R.string.today_is), calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH), sDateFormat.format(new Date())));

    }
}
