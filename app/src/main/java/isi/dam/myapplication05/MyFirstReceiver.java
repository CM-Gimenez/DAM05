package isi.dam.myapplication05;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Network;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class MyFirstReceiver extends BroadcastReceiver {

    public static final String EVENTO_01  = "isi.dam.myapplication05.EVENTO_01";
    public static String NOTIFICATION_ID = "notification-id" ;
    public static String NOTIFICATION = "notification" ;
    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    public static final String TEXTO_LARGO = "Este texto es muy largo para aparecer en una sola linea en la barra de notificaciones mi vieja mula ya no es lo que era  monoriel monoriel monorielnotificaciones mi vieja mula ya no es lo que era  monoriel monoriel monorielnotificaciones mi vieja mula ya no es lo que era  monoriel monoriel monorielnotificaciones mi vieja mula ya no es lo que era  monoriel monoriel monorielnotificaciones mi vieja mula ya no es lo que era  monoriel monoriel monorielnotificaciones mi vieja mula ya no es lo que era  monoriel monoriel monorielnotificaciones mi vieja mula ya no es lo que era  monoriel monoriel monorielnotificaciones mi vieja mula ya no es lo que era  monoriel monoriel monoriel";

    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction() + "\n");
        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        String log = sb.toString();
//        intent.getExtras().getString()
        Log.d("APP05", log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();
        if(intent.getAction().equalsIgnoreCase(EVENTO_01)){
           // enviarNotificacion(context,intent);
            // enviarNotificacionImagen(context,intent);
            enviarNotificacionTexto(context,intent);

        }
    }


    private void enviarNotificacion(Context context,Intent intent){
        Intent opcion1 = new Intent(context, MainActivity2.class);
        opcion1.putExtra("datox", 9999);
        opcion1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent opcion1Pi = PendingIntent.getBroadcast(context, 0, opcion1, 0);

        //Patron builder para configurar
        // como quiero que se construyan los objetos
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.utn_icon)
                // .setContentIntent(opcion1Pi)
                .setContentTitle(intent.getExtras().getString("data1"))
                .setContentText(intent.getExtras().getString("data2"))
                .setAutoCancel(true)
                .addAction(android.R.drawable.ic_media_play,"EJECUTAR",opcion1Pi)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Notification laNotificacion =  mBuilder.build();

        // obtengo el notification manager
        NotificationManager notificationManager =
                context.getSystemService(NotificationManager.class);
        // envio la notificacion
        notificationManager.notify(99,laNotificacion);
    }


    private void enviarNotificacionImagen(Context context,Intent intent){
        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.utn_icon);
        Bitmap aBigBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.utnsantafe);

        Intent opcion1 = new Intent(context, MainActivity.class);
        opcion1.putExtra("datox", 9999);
        PendingIntent opcion1Pi = PendingIntent.getBroadcast(context, 0, opcion1, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.utn_icon)
                .setContentIntent(opcion1Pi)
                .setContentTitle(intent.getExtras().getString("data1"))
                .setContentText(intent.getExtras().getString("data2"))
                .setLargeIcon(largeIcon)
                .setStyle(
                            new NotificationCompat.BigPictureStyle()
                                .bigPicture(aBigBitmap)
                                .setBigContentTitle("Mi Notificacion con imagen"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager notificationManager =
                context.getSystemService(NotificationManager.class);
        notificationManager.notify(99, mBuilder.build());
    }

    private void enviarNotificacionTexto(Context context,Intent intent){

        Intent opcion1 = new Intent(context, MainActivity.class);
        opcion1.putExtra("datox", 9999);
        PendingIntent opcion1Pi = PendingIntent.getBroadcast(context, 0, opcion1, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.utn_icon)
                .setContentIntent(opcion1Pi)
                .setContentTitle(intent.getExtras().getString("data1"))
                .setContentText(intent.getExtras().getString("data2"))
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(TEXTO_LARGO))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager notificationManager =
                context.getSystemService(NotificationManager.class);
        notificationManager.notify(99, mBuilder.build());
    }





}
