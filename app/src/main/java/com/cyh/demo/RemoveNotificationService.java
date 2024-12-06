package com.cyh.demo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import android.os.Bundle;
import android.os.UserHandle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 * File: RemoveNotificationService.java
 * 通知清除监听，可以监听是用户手动清除，还是系统清除
 * Author: chenyihui
 * Date: 2018/12/20
 */

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class RemoveNotificationService extends NotificationListenerService {
    private static final String TAG = "RemoveNotificationSer";


    @Override
    public void onNotificationRemoved(StatusBarNotification sbn, RankingMap rankingMap, int reason) {
        super.onNotificationRemoved(sbn, rankingMap, reason);
        Log.e(TAG, "onNotificationRemoved: " + sbn.toString() + "  reason = " + reason + "  " + REASON_CANCEL + "    " + REASON_LISTENER_CANCEL);
    }


    @Override
    public void onNotificationChannelModified(String pkg, UserHandle user, NotificationChannel channel, int modificationType) {
        super.onNotificationChannelModified(pkg, user, channel, modificationType);
    }

    @Override
    public void onNotificationChannelGroupModified(String pkg, UserHandle user, NotificationChannelGroup group, int modificationType) {
        super.onNotificationChannelGroupModified(pkg, user, group, modificationType);
    }

    public void getNotification() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            StatusBarNotification[] activeNotifications = getActiveNotifications();
            for (int i = 0; i < activeNotifications.length; i++) {
                StatusBarNotification activeNotification = activeNotifications[i];
                Notification notification = activeNotification.getNotification();
                Bundle extras = notification.extras;
                if (extras != null) {
                    // 获取通知标题
                    String title = extras.getString(Notification.EXTRA_TITLE, "");
                    // 获取通知内容
                    String content = extras.getString(Notification.EXTRA_TEXT, "");
                    Log.e(TAG, "getActiveNotifications==>title:" + title + ",content:" + content);
                }
            }
        }
    }
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        getNotification();
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
    }
}