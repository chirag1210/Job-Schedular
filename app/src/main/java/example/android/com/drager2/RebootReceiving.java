package example.android.com.drager2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Chirag Chaudhari on 31,August,2017
 */
public class RebootReceiving extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equalsIgnoreCase(intent.getAction())) {

            Toast.makeText(context, "onReceive ", Toast.LENGTH_LONG).show();
        }
        //all works is done in manifest file
    }

}
