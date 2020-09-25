package isi.dam.myapplication05;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import java.util.logging.Handler;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(3500);
            Intent i = new Intent();
            i.putExtra("data1","INTENT SERVICE");
            i.putExtra("data2","TimeStamp: "+System.currentTimeMillis());
            i.setAction(MyFirstReceiver.EVENTO_01);
            sendBroadcast(i);
            this.sendBroadcast(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
