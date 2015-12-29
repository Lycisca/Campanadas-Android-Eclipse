package com.bigtle.uvas2016;

import java.util.Calendar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.widget.Toast;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;

public class AlarmReceiver extends BroadcastReceiver {

	final public static String ONE_TIME = "onetime";
	private Uri soundURI = Uri.parse("android.resource://com.bigtle.uvas2016/"+ R.raw.campanadas_app);

	
	@Override
	public void onReceive(Context context, Intent intent) {
		// NOTIFICACION
		//NotificationManager nManager = (NotificationManager) context
	    //        .getSystemService(Context.NOTIFICATION_SERVICE);
		
	    //NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
	    //        .setSmallIcon(android.R.drawable.btn_star_big_on)
	    //        .setContentTitle("Campanadas for sure")
	    //        .setContentText("¡FELIZ AÑO 2016!")
	    //        .setSound(soundURI)
	    //        .setAutoCancel(false);
	 
	    //Intent targetIntent = new Intent(context, SplashScreenActivity.class);
	    //PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
	    //        targetIntent, PendingIntent.FLAG_CANCEL_CURRENT);
	    //builder.setContentIntent(contentIntent);
	 
	    //builder.setAutoCancel(false);
	    //builder.setDeleteIntent (contentIntent);
	 
	    //nManager.notify(2, builder.getNotification());
	    	    
	    // FIN NOTIFICACION
	    
        //PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
        ////Acquire the lock
        //wl.acquire();
     
        //Toast.makeText(context, "Feliz Año 2016!!", Toast.LENGTH_LONG).show();
      
        ////Release the lock
        //wl.release();
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
			.setSound(soundURI)
			.setVibrate(new long[] { 0, 1000 });
		// Get an instance of the notification manager
		NotificationManager noteManager = (NotificationManager)
				context.getSystemService(Context.NOTIFICATION_SERVICE);
		// Post to the system
		noteManager.notify(1, builder.getNotification());	

	    PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
        //Acquire the lock
        wl.acquire();
        
        Toast.makeText(context, "Feliz Año 2016!!", Toast.LENGTH_LONG).show();
        
        //Release the lock
        wl.release();
	}

    public void setOnetimeTimer(Context context){	
    	// for Alarm 31/12/2015 at 23.59.40   
    	Calendar now = Calendar.getInstance();
    	Calendar myAlarmDate = Calendar.getInstance();
    	myAlarmDate.setTimeInMillis(System.currentTimeMillis());
    	myAlarmDate.set(2015, 11, 31, 23, 59, 33); 
    	if(myAlarmDate.getTimeInMillis() >= now.getTimeInMillis()){
    		AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    		Intent intent = new Intent(context, AlarmReceiver.class);
    		
    		PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
    		am.set(AlarmManager.RTC_WAKEUP, myAlarmDate.getTimeInMillis(), pi);
    	};
    }
}
