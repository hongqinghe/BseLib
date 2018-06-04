package middlem.person.baselib;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import middlem.person.basemodule.BaseActivity;
import middlem.person.basemodule.receiver.SupplyBaseReceiver;

public class ViewTestActivity extends BaseActivity {

    private SupplyBaseReceiver baseReceiver;
    private static final String BROADCAST_ACTION = "com.seasy.android.SupplyBaseReceiver";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);
    }

    @Override
    protected void onResume() {
        super.onResume();
        baseReceiver = new SupplyBaseReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        registerReceiver(baseReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(baseReceiver);
    }

    public void toSend(View view) {
//        Intent intent=new Intent();
//        intent.setAction(BROADCAST_ACTION);
//        sendBroadcast(intent);
        recreate();
    }
}
