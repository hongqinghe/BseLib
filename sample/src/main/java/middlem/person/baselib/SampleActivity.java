package middlem.person.baselib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import middlem.person.basemodule.BaseActivity;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/1 21:11
 * <P> Copyright  2008 二维火科技
 ***********************************************/

public class SampleActivity extends BaseActivity {
    private static final String TAG = "test";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void daggerSampleActivity(View view) {
//       nextActivity(DaggerSmapleActivity.class);
    }

    public void viewTest(View view) {
        nextActivity(ViewTestActivity.class);
    }
}
