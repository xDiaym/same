package org.juicecode.telehlam;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    private final String name = "messageNotifications";
    private final String description = "channel for notifications";
    public static final String CHANNEL_ID = "Message_Notification_channel";
    @Override
    public void onCreate() {
        super.onCreate();
        createChannel();
    }
    public void createChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
