package com.cyh.demo.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.cyh.demo.TextUtil;

/**
 * Description:
 *
 * @Author: chenyihui
 * Date: 2021/2/19
 */
public class NotifycationManager {

    private NotificationManager mNotiManager;
    /**
     * 默认振动频率
     */
    private static final long DEFAULT_VIBRATEPATTERN[] = new long[]{300, 350, 300, 350};

    private Context mContext;
    private NotifycationSetting mNotifycationSetting;

    public NotifycationManager(Context context, NotifycationSetting setting) {
        mContext = context;
        mNotifycationSetting = setting;
        mNotiManager = (NotificationManager) mContext
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public NotifycationSetting getNotifycationSetting() {
        return mNotifycationSetting;
    }

    public void setNotifycationSetting(NotifycationSetting notifycationSetting) {
        mNotifycationSetting = notifycationSetting;
    }

    private void deleteNotificationChannel(String channelId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.deleteNotificationChannel(channelId);
        }

    }

    public Notification getNotificationBuilder(NotifycationParams params) {
        initChannelGroup(params);
        initNotificationChannel(params);
        String channelId = "defaultId";
        if (mNotifycationSetting != null && TextUtil.isValidate(mNotifycationSetting.getDefaultChannelId())) {
            channelId = mNotifycationSetting.getDefaultChannelId();
        }
        if (params != null && TextUtil.isValidate(params.getChannelId())) {
            channelId = params.getChannelId();
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext, channelId);


        //设置通知栏标题
        if (params != null && TextUtil.isValidate(params.getTitle())) {
            builder.setContentTitle(params.getTitle());
        }

        //设置通知栏内容
        if (params != null && TextUtil.isValidate(params.getContentText())) {
            builder.setContentText(params.getContentText());
        }

        //设置通知栏状态栏图标
        if (params != null && params.getSmallIcon() > 0) {
            builder.setSmallIcon(params.getSmallIcon());
        }

        //设置通知图标
        if (params != null) {
            if (params.getLargeIconBitmap() != null) {
                builder.setLargeIcon(params.getLargeIconBitmap());
            } else {
                if (params.getLargeIcon() > 0) {
                    builder.setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), params.getLargeIcon()));
                }
            }
        }

        //设置通知显示时间
        if (params != null && params.getTimeMillis() > 0) {
            builder.setWhen(params.getTimeMillis());
        }

        //设置点击通知后自动清除通知
        if (params != null) {
            builder.setAutoCancel(params.isAutoCancel());
        }

        //设置点击通知后自动清除通知
        if (params != null) {
            builder.setVisibility(params.getVisibility());
        }

        //设置打开呼吸灯，声音，震动，触发系统默认行为
        if (params != null) {
            builder.setDefaults(params.getNotificationDefault());
        }

        //设置打开呼吸灯，声音，震动，触发系统默认行为
        boolean isOpenVibrate = false;
        long[] vibrate = null;
        if (mNotifycationSetting != null) {
            isOpenVibrate = mNotifycationSetting.isOpenVibrate();
        }
        if (params != null && params.getVibrate() != null && params.getVibrate().length > 0) {
            vibrate = params.getVibrate();
        }
        if (isOpenVibrate && (vibrate == null || vibrate.length <= 0)) {
            vibrate = DEFAULT_VIBRATEPATTERN;
        }
        if (isOpenVibrate) {
            builder.setVibrate(vibrate);
        }

        //设置呼吸灯显示颜色、显示时间、关闭时间
        if (params != null && params.getLedARGB() > 0 && params.getLedOnMS() > 0) {
            builder.setLights(params.getLedARGB(), params.getLedOnMS(), params.getLedOffMS());
        }

        //设置首次收到的时候，在状态栏中，图标的右侧显示的文字（设置之后可以显示悬停通知）
        if (params != null && params.isStick() && TextUtil.isValidate(params.getTickerText())) {
            builder.setTicker(params.getTickerText());
        }

        //设置通知优先级
        if (params != null) {
            builder.setPriority(params.getPriority());
        }

        if (params != null && params.getPendingIntent() != null) {
            builder.setContentIntent(params.getPendingIntent());
        }

        if (params != null && params.isHighPriority() && params.getPendingIntent() != null) {
            builder.setFullScreenIntent(params.getPendingIntent(), params.isHighPriority());
        }

        //设置铃声
        if (params != null && params.getSound() != null) {
            builder.setSound(params.getSound());
        }

        return builder.build();
    }

    private void initChannelGroup(NotifycationParams params) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String groupId = "group_001";
            String groupName = "系统通知";
            if (mNotifycationSetting != null && TextUtil.isValidate(mNotifycationSetting.getDefaultGroupId())) {
                groupId = mNotifycationSetting.getDefaultGroupId();
            }
            if (params != null && TextUtil.isValidate(params.getGroupId())) {
                groupId = params.getGroupId();
            }
            if (mNotifycationSetting != null && TextUtil.isValidate(mNotifycationSetting.getDefaultGroupName())) {
                groupName = mNotifycationSetting.getDefaultGroupName();
            }
            if (params != null && TextUtil.isValidate(params.getGroupName())) {
                groupName = params.getGroupName();
            }
            if (TextUtil.isValidate(groupId) && TextUtil.isValidate(groupName)) {
                NotificationChannelGroup group = new NotificationChannelGroup(groupId, groupName);
                mNotiManager.createNotificationChannelGroup(group);
            }

        }
    }

    /**
     * 创建通知渠道
     */
    private void initNotificationChannel(NotifycationParams params) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //通知渠道组id
            String groupId = "group_001";
            //设置渠道id
            String channelId = "defaultId";
            //设置渠道名称
            String channelName = "系统通知";
            //设置渠道优先级
            int importance = NotificationManager.IMPORTANCE_HIGH;
            //设置呼吸灯
            int ledARGB = 0;
            //是否开启振动
            boolean isOpenVibrate = false;
            //设置绕过免打扰模式 true 绕过 false 不绕过
            boolean isOpenDisturb = false;
            //设置是否显示通知右边角标
            boolean isShowBadge = true;
            //通知显示信息
            int visibility = NotificationCompat.VISIBILITY_PRIVATE;
            //通知振动配置
            long[] vibrate = null;

            if (mNotifycationSetting != null && TextUtil.isValidate(mNotifycationSetting.getDefaultChannelId())) {
                channelId = mNotifycationSetting.getDefaultChannelId();
            }
            if (params != null && TextUtil.isValidate(params.getChannelId())) {
                channelId = params.getChannelId();
            }

            if (mNotifycationSetting != null && TextUtil.isValidate(mNotifycationSetting.getDefaultChannelName())) {
                channelName = mNotifycationSetting.getDefaultChannelName();
            }
            if (params != null && TextUtil.isValidate(params.getChannelName())) {
                channelName = params.getChannelName();
            }

            if (mNotifycationSetting != null) {
                importance = mNotifycationSetting.getDefaultImportance();
            }
            if (params != null) {
                importance = params.getImportance();
            }

            //设置通知渠道信息
            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);

            //设置呼吸灯颜色
            if (params != null) {
                ledARGB = params.getLedARGB();
            }
            if (ledARGB > 0) {
                channel.enableLights(true);
                channel.setLightColor(ledARGB);
            }

            //设置是否打开振动
            if (mNotifycationSetting != null) {
                isOpenVibrate = mNotifycationSetting.isOpenVibrate();
            }
            if (isOpenVibrate) {
                channel.enableVibration(true);
                if (params != null) {
                    vibrate = params.getVibrate();
                }
                if (vibrate == null && vibrate.length <= 0) {
                    vibrate = DEFAULT_VIBRATEPATTERN;
                }
                channel.setVibrationPattern(vibrate);
            } else {
                channel.enableVibration(false);
                channel.setVibrationPattern(new long[]{0});
            }

            //设置绕过免打扰模式 true 绕过 false 不绕过
            if (mNotifycationSetting != null) {
                isOpenDisturb = mNotifycationSetting.isOpenDisturb();
            }
            if (params != null) {
                isOpenDisturb = params.isBypassDnd();
            }
            channel.setBypassDnd(isOpenDisturb);

            //设置是否显示通知右边角标
            if (params != null) {
                isShowBadge = params.isShowBadge();
            }
            channel.setShowBadge(isShowBadge);

            /**
             * android5.0加入了一种新的模式Notification的显示等级，共有三种
             * setVisibility() 方法共有三个选值：
             * 1.VISIBILITY_PRIVATE : 显示基本信息，如通知的图标，但隐藏通知的全部内容；
             * 2.VISIBILITY_PUBLIC : 显示通知的全部内容；
             * 3.VISIBILITY_SECRET : 不显示任何内容，包括图标。
             */
            if (params != null) {
                visibility = params.getVisibility();
            }
            channel.setLockscreenVisibility(visibility);

            //通知渠道组id
            if (mNotifycationSetting != null && TextUtil.isValidate(mNotifycationSetting.getDefaultGroupId())) {
                groupId = mNotifycationSetting.getDefaultGroupId();
            }
            if (params != null && TextUtil.isValidate(params.getGroupId())) {
                groupId = params.getGroupId();
            }
            if (TextUtil.isValidate(groupId)) {
                channel.setGroup(groupId);
            }

            mNotiManager.createNotificationChannel(channel);
        }
    }
}
