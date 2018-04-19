package middlem.person.basemodule.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Objects;

/***********************************************
 * <P> desc:
 * <P> Author: hehongqing
 * <P> Date: 2018/3/26 10:06
 ***********************************************/

public class SupplyBaseReceiver extends BroadcastReceiver{
    private static final String BROADCAST_ACTION = "com.seasy.android.SupplyBaseReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), BROADCAST_ACTION)){
            Toast.makeText(context, "message", Toast.LENGTH_SHORT).show();
        }
    }
}
