package com.cyh.demo;

import android.os.Build;
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

@RequiresApi(api = Build.VERSION_CODES.O)
public class RemoveNotificationService extends NotificationListenerService {
    private static final String TAG = "RemoveNotificationSer";

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn, RankingMap rankingMap, int reason) {
        super.onNotificationRemoved(sbn, rankingMap, reason);
        Log.e(TAG, "onNotificationRemoved: "+sbn.toString()+"  reason = " +reason +"  "+REASON_CANCEL+"    "+REASON_LISTENER_CANCEL);
    }

}
