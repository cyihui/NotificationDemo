package com.cyh.demo.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Description:
 *
 * @Author: chenyihui
 * Date: 2021/2/19
 */
public class NotifycationParams {
    /**
     * 通知渠道 适配于Android O 8.0以上系统有效
     */
    private String mChannelId = "defaultId";
    /**
     * 设置渠道名称
     */
    private String mChannelName = "系统通知";

    /**
     * 通知渠道组id
     */
    private String groupId = "group_001";
    /**
     * 通知渠道组名称
     */
    private String groupName = "系统通知";

    /**
     * 通知id
     */
    private int mNotificationId;
    /**
     * 通知tag
     */
    private String mNotificationTag;
    /**
     * 通知标题
     */
    private String mTitle;
    /**
     * 通知内容
     */
    private String mContentText;
    /**
     * 设置通知状态栏图标
     * 当 setSmallIcon() 与 setLargeIcon() 同时存在时, mSmallIcon 显示在通知的右下角, mLargeIcon 显示在左侧；
     * 当只设置 setSmallIcon() 时, mSmallIcon 显示在左侧。
     */
    private int mSmallIcon;
    /**
     * 通知图标
     */
    private int mLargeIcon;
    /**
     * 通知图标bitmap
     */
    private Bitmap mLargeIconBitmap;
    /**
     * 通知时间
     */
    private long mTimeMillis;
    /**
     * 点击通知后自动清除通知
     */
    private boolean isAutoCancel = true;
    /**
     * 打开呼吸灯，声音，震动，触发系统默认行为
     */
    private int mNotificationDefault;
    /**
     * 呼吸灯颜色
     */
    private int mLedARGB;
    /**
     * 呼吸灯唤醒时间
     */
    private int mLedOnMS;
    /**
     * 呼吸灯关闭时间
     */
    private int mLedOffMS;

    /**
     * android5.0加入了一种新的模式Notification的显示等级，共有三种
     * setVisibility() 方法共有三个选值：
     * 1.VISIBILITY_PRIVATE : 显示基本信息，如通知的图标，但隐藏通知的全部内容；
     * 2.VISIBILITY_PUBLIC : 显示通知的全部内容；
     * 3.VISIBILITY_SECRET : 不显示任何内容，包括图标。
     */
    private int mVisibility = NotificationCompat.VISIBILITY_PRIVATE;
    /**
     * 自定义震动效果
     * 设置震动，用一个 long 的数组来表示震动状态，这里表示的是先震动1秒、静止1秒、再震动1秒，这里以毫秒为单位
     * 如果要设置先震动1秒，然后停止0.5秒，再震动2秒则可设置数组为：long[]{1000, 500, 2000}。
     */
    private long[] vibrate = null;

    /**
     * 首次收到的时候，在状态栏中，图标的右侧显示的文字（设置之后可以显示悬停通知）
     */
    private String mTickerText;
    /**
     * 通知优先级
     */
    private int mPriority = NotificationCompat.PRIORITY_HIGH;

    /**
     * 处理通知的交互事件
     */
    private PendingIntent mPendingIntent;
//    /**
//     * 处理通知的交互事件可与 PendingIntent相同
//     */
//    private PendingIntent mFullScreenIntent;
    /**
     * 设置悬停 在5.0以上可以悬停之后可以正常收起，6.0以上会一直停留知道用户手动操作消失
     */
    private boolean isHighPriority = false;
    /**
     * 频道重要性
     */
    private int mImportance = NotificationManager.IMPORTANCE_HIGH;
    /**
     * 设置音效
     * 调用自己提供的铃声，位于 /res/values/raw 目录下
     * Uri.parse("android.resource://packageName/" + R.raw.sound)
     */
    private Uri mSound;
    /**
     * 设置绕过免打扰模式
     * true 绕过 false 不绕过
     */
    private boolean bypassDnd;
    /**
     * 设置是否显示通知右边角标
     */
    private boolean showBadge;
    /**
     * 是否悬停
     */
    private boolean mIsStick;

    private NotifycationParams(Builder builder) {
        setChannelId(builder.mChannelId);
        setChannelName(builder.mChannelName);
        setGroupId(builder.groupId);
        setGroupName(builder.groupName);
        setNotificationId(builder.mNotificationId);
        setNotificationTag(builder.mNotificationTag);
        setTitle(builder.mTitle);
        setContentText(builder.mContentText);
        setSmallIcon(builder.mSmallIcon);
        setLargeIcon(builder.mLargeIcon);
        setLargeIcon(builder.mLargeIconBitmap);
        setTimeMillis(builder.mTimeMillis);
        setAutoCancel(builder.isAutoCancel);
        setNotificationDefault(builder.mNotificationDefault);
        setLedARGB(builder.mLedARGB);
        setLedOnMS(builder.mLedOnMS);
        setLedOffMS(builder.mLedOffMS);
        setVisibility(builder.mVisibility);
        setVibrate(builder.vibrate);
        setTickerText(builder.mTickerText);
        setIsStick(builder.mIsStick);
        setPriority(builder.mPriority);
        setPendingIntent(builder.mPendingIntent);
        setHighPriority(builder.isHighPriority);
        setImportance(builder.mImportance);
        setSound(builder.mSound);
        setBypassDnd(builder.bypassDnd);
        setShowBadge(builder.showBadge);
    }

    public static Builder initBuilder() {
        return new Builder();
    }

    /**
     * 通知渠道 适配于Android O 8.0以上系统有效
     *
     * @return
     */
    public String getChannelId() {
        return mChannelId;
    }

    /**
     * 通知渠道 适配于Android O 8.0以上系统有效
     *
     * @param channelId 全局唯一
     */
    public void setChannelId(String channelId) {
        this.mChannelId = channelId;
    }

    /**
     * 渠道名称
     *
     * @return
     */
    public String getChannelName() {
        return mChannelName;
    }

    /**
     * 设置渠道名称
     * 在通知管理显示
     *
     * @param channelName 渠道名称
     */
    public void setChannelName(String channelName) {
        this.mChannelName = channelName;
    }

    /**
     * 渠道组id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置渠道组id
     *
     * @param groupId 组id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * 渠道组名称
     *
     * @return
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置渠道组名称
     * 在通知管理显示
     *
     * @param groupName 组名
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 通知id
     */
    public int getNotificationId() {
        return mNotificationId;
    }

    /**
     * 通知id
     */
    public void setNotificationId(int mNotificationId) {
        this.mNotificationId = mNotificationId;
    }

    /**
     * 通知tag
     *
     * @return
     */
    public String getNotificationTag() {
        return mNotificationTag;
    }

    /**
     * 设置通知tag
     *
     * @param mNotificationTag
     */
    public void setNotificationTag(String mNotificationTag) {
        this.mNotificationTag = mNotificationTag;
    }

    /**
     * 通知标题
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * 设置通知标题
     *
     * @param mTitle
     */
    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    /**
     * 通知内容
     *
     * @return
     */
    public String getContentText() {
        return mContentText;
    }

    /**
     * 设置通知内容
     *
     * @param mContentText
     */
    public void setContentText(String mContentText) {
        this.mContentText = mContentText;
    }

    /**
     * 获取通知小图标
     */
    public int getSmallIcon() {
        return mSmallIcon;
    }

    /**
     * 设置通知状态栏图标
     * 当 setSmallIcon() 与 setLargeIcon() 同时存在时, mSmallIcon 显示在通知的右下角, mLargeIcon 显示在左侧；
     * 当只设置 setSmallIcon() 时, mSmallIcon 显示在左侧。
     *
     * @param mSmallIcon 透明图层图标
     */
    public void setSmallIcon(int mSmallIcon) {
        this.mSmallIcon = mSmallIcon;
    }

    /**
     * 获取通知大图标
     */
    public int getLargeIcon() {
        return mLargeIcon;
    }

    /**
     * 设置通知图标，不设置时使用应用icon
     * 当 setSmallIcon() 与 setLargeIcon() 同时存在时, mSmallIcon 显示在通知的右下角, mLargeIcon 显示在左侧；
     * 当只设置 setSmallIcon() 时, mSmallIcon 显示在左侧。
     *
     * @param mLargeIcon
     */
    public void setLargeIcon(int mLargeIcon) {
        this.mLargeIcon = mLargeIcon;
    }

    /**
     * 获取图片bitmap
     */
    public Bitmap getLargeIconBitmap() {
        return mLargeIconBitmap;
    }

    /**
     * 设置通知图标
     *
     * @param mLargeIconBitmap bitmap
     */
    public void setLargeIcon(Bitmap mLargeIconBitmap) {
        this.mLargeIconBitmap = mLargeIconBitmap;
    }

    /**
     * 获取设置通知创建时间
     */
    public long getTimeMillis() {
        return mTimeMillis;
    }

    /**
     * 设置通知创建时间
     * 默认为系统发出通知的时间，通常可以不用设置
     *
     * @param timeMillis 时间戳 系统会自动格式化
     */
    public void setTimeMillis(long timeMillis) {
        this.mTimeMillis = timeMillis;
    }

    /**
     * 是否设置点击通知清除缓存
     *
     * @return true 清除 false 不清楚
     */
    public boolean isAutoCancel() {
        return isAutoCancel;
    }

    /**
     * 设置点击通知后清除
     *
     * @param autoCancel true 清除 false 不清除
     */
    public void setAutoCancel(boolean autoCancel) {
        isAutoCancel = autoCancel;
    }

    /**
     * 获取通知默认设置
     */
    public int getNotificationDefault() {
        return mNotificationDefault;
    }

    /**
     * 打开呼吸灯，声音，震动，触发系统默认行为
     * NotificationCompat.DEFAULT_VIBRATE     添加默认震动提醒  需要VIBRATE permission
     * NotificationCompat.DEFAULT_SOUND       添加默认声音提醒
     * NotificationCompat.DEFAULT_LIGHTS      添加默认三色灯提醒
     * NotificationCompat.DEFAULT_ALL         添加默认以上3种全部提醒
     */
    public void setNotificationDefault(int mNotificationDefault) {
        this.mNotificationDefault = mNotificationDefault;
    }

    /**
     * 获取配置手机的LED灯(呼吸灯)颜色
     */
    public int getLedARGB() {
        return mLedARGB;
    }

    /**
     * 设置手机的LED灯为蓝色并且灯亮2秒，熄灭1秒，达到灯闪烁的效果，不过这些效果在模拟器上是看不到的，
     * 需要将程序安装在真机上才能看到对应效果，如果不想设置这些通知提示效果，
     * 可以直接设置：setDefaults(Notification.DEFAULT_ALL);
     * 意味将通知的提示效果设置为系统的默认提示效果
     *
     * @param argb 颜色 一般三种颜色：红，绿，蓝，经测试，小米支持黄色 Color.YELLOW Color.RED Color.GREEN
     *             onMs  显示时间
     *             offMs  消失时间
     */
    public void setLedARGB(int argb) {
        this.mLedARGB = argb;
    }

    /**
     * 获取设置呼吸灯显示时间
     */
    public int getLedOnMS() {
        return mLedOnMS;
    }

    /**
     * 设置手机的LED灯为蓝色并且灯亮2秒，熄灭1秒，达到灯闪烁的效果，不过这些效果在模拟器上是看不到的，
     * 需要将程序安装在真机上才能看到对应效果，如果不想设置这些通知提示效果，
     * 可以直接设置：setDefaults(Notification.DEFAULT_ALL);
     * 意味将通知的提示效果设置为系统的默认提示效果
     * <p>
     * argb  颜色 一般三种颜色：红，绿，蓝，经测试，小米支持黄色 Color.YELLOW Color.RED Color.GREEN
     *
     * @param onMs 显示时间
     *             offMs  消失时间
     */
    public void setLedOnMS(int onMs) {
        this.mLedOnMS = onMs;
    }

    /**
     * 获取设置呼吸灯消失时间
     */
    public int getLedOffMS() {
        return mLedOffMS;
    }

    /**
     * 设置手机的LED灯为蓝色并且灯亮2秒，熄灭1秒，达到灯闪烁的效果，不过这些效果在模拟器上是看不到的，
     * 需要将程序安装在真机上才能看到对应效果，如果不想设置这些通知提示效果，
     * 可以直接设置：setDefaults(Notification.DEFAULT_ALL);
     * 意味将通知的提示效果设置为系统的默认提示效果
     * <p>
     * argb  颜色 一般三种颜色：红，绿，蓝，经测试，小米支持黄色 Color.YELLOW Color.RED Color.GREEN
     * onMs  显示时间
     *
     * @param offMs 消失时间
     */
    public void setLedOffMS(int offMs) {
        this.mLedOffMS = offMs;
    }

    /**
     * 获取显示等级
     */
    public int getVisibility() {
        return mVisibility;
    }

    /**
     * android5.0加入了一种新的模式Notification的显示等级，共有三种
     * setVisibility() 方法共有三个选值：
     * 1.VISIBILITY_PRIVATE : 显示基本信息，如通知的图标，但隐藏通知的全部内容；
     * 2.VISIBILITY_PUBLIC : 显示通知的全部内容；
     * 3.VISIBILITY_SECRET : 不显示任何内容，包括图标。
     */
    public void setVisibility(int mVisibility) {
        this.mVisibility = mVisibility;
    }

    /**
     * 获取设置振动参数
     */
    public long[] getVibrate() {
        return vibrate;
    }

    /**
     * 自定义震动效果
     * 设置震动，用一个 long 的数组来表示震动状态，这里表示的是先震动1秒、静止1秒、再震动1秒，这里以毫秒为单位
     * 如果要设置先震动1秒，然后停止0.5秒，再震动2秒则可设置数组为：long[]{1000, 500, 2000}。
     *
     * @param vibrate
     */
    public void setVibrate(long[] vibrate) {
        this.vibrate = vibrate;
    }

    /**
     * 获取首次收到的时候，在状态栏中，图标的右侧显示的文字（设置之后可以显示悬停通知）
     */
    public String getTickerText() {
        return mTickerText;
    }

    /**
     * 首次收到的时候，在状态栏中，图标的右侧显示的文字（设置之后可以显示悬停通知）
     *
     * @param tickerText
     */
    public void setTickerText(String tickerText) {
        this.mTickerText = tickerText;
    }

    public boolean isStick() {
        return mIsStick;
    }

    /**
     * 设置通知悬停效果
     *
     * @param mIsStick true 悬停 false 不需要
     */
    public void setIsStick(boolean mIsStick) {
        this.mIsStick = mIsStick;
    }

    /**
     * 获取通知优先级 eg: NotificationCompat.PRIORITY_DEFAULT
     */
    public int getPriority() {
        return mPriority;
    }
    /**
     * 设置通知优先级
     *
     * @param mPriority NotificationCompat.PRIORITY_DEFAULT
     */
    public void setPriority(int mPriority) {
        this.mPriority = mPriority;
    }

    /**
     * 获取通知intent
     */
    public PendingIntent getPendingIntent() {
        return mPendingIntent;
    }

    /**
     * 设置处理通知的交互事件
     * example:
     * Intent intent = new Intent(mActivity,  MainActivity.class);
     * PendingIntent pendingIntent = PendingIntent.getActivity(mActivity, 2,
     * intent, PendingIntent.FLAG_UPDATE_CURRENT);
     */
    public void setPendingIntent(PendingIntent mPendingIntent) {
        this.mPendingIntent = mPendingIntent;
    }

    /**
     * 是否需要悬停效果
     */
    public boolean isHighPriority() {
        return isHighPriority;
    }
    /**
     * 设置全局悬停效果
     *
     * @param highPriority true 需要悬停 false 不需要
     */
    public void setHighPriority(boolean highPriority) {
        isHighPriority = highPriority;
    }

    /**
     * 获取设置渠道重要等级
     */
    public int getImportance() {
        return mImportance;
    }
    /**
     * 设置渠道重要性，用于NotificationChannel
     * example:
     * NotificationManager.IMPORTANCE_HIGH
     */
    public void setImportance(int mImportance) {
        this.mImportance = mImportance;
    }

    /**
     * 获取设置铃声
     */
    public Uri getSound() {
        return mSound;
    }
    /**
     * 设置通知声音
     *
     * @param sound eg:
     *              调用自己提供的铃声，位于 /res/values/raw 目录下
     *              Uri.parse("android.resource://packageName/" + R.raw.sound)
     */
    public void setSound(Uri sound) {
        this.mSound = sound;
    }

    /**
     * 是否绕过免打扰模式
     */
    public boolean isBypassDnd() {
        return bypassDnd;
    }
    /**
     * 设置绕过免打扰模式
     *
     * @param bypassDnd true 绕过免打扰 false 不绕过
     */
    public void setBypassDnd(boolean bypassDnd) {
        this.bypassDnd = bypassDnd;
    }

    /**
     * 是否显示右边角标
     */
    public boolean isShowBadge() {
        return showBadge;
    }
    /**
     * 设置是否显示通知右边角标
     *
     * @param showBadge true 显示 false 不显示
     */
    public void setShowBadge(boolean showBadge) {
        this.showBadge = showBadge;
    }

    public static final class Builder {
        /**
         * 通知渠道 适配于Android O 8.0以上系统有效
         */
        private String mChannelId = "defaultId";
        /**
         * 设置渠道名称
         */
        private String mChannelName = "系统通知";

        /**
         * 通知渠道组id
         */
        private String groupId = "group_001";
        /**
         * 通知渠道组名称
         */
        private String groupName = "系统通知";

        /**
         * 通知id
         */
        private int mNotificationId;
        /**
         * 通知tag
         */
        private String mNotificationTag;
        /**
         * 通知标题
         */
        private String mTitle;
        /**
         * 通知内容
         */
        private String mContentText;
        /**
         * 设置通知状态栏图标
         * 当 setSmallIcon() 与 setLargeIcon() 同时存在时, mSmallIcon 显示在通知的右下角, mLargeIcon 显示在左侧；
         * 当只设置 setSmallIcon() 时, mSmallIcon 显示在左侧。
         */
        private int mSmallIcon;
        /**
         * 通知图标
         */
        private int mLargeIcon;
        /**
         * 通知图标bitmap
         */
        private Bitmap mLargeIconBitmap;
        /**
         * 通知时间
         */
        private long mTimeMillis;
        /**
         * 点击通知后自动清除通知
         */
        private boolean isAutoCancel = true;
        /**
         * 打开呼吸灯，声音，震动，触发系统默认行为
         */
        private int mNotificationDefault;
        /**
         * 呼吸灯颜色
         */
        private int mLedARGB;
        /**
         * 呼吸灯唤醒时间
         */
        private int mLedOnMS;
        /**
         * 呼吸灯关闭时间
         */
        private int mLedOffMS;

        /**
         * android5.0加入了一种新的模式Notification的显示等级，共有三种
         * setVisibility() 方法共有三个选值：
         * 1.VISIBILITY_PRIVATE : 显示基本信息，如通知的图标，但隐藏通知的全部内容；
         * 2.VISIBILITY_PUBLIC : 显示通知的全部内容；
         * 3.VISIBILITY_SECRET : 不显示任何内容，包括图标。
         */
        private int mVisibility = NotificationCompat.VISIBILITY_PRIVATE;
        /**
         * 自定义震动效果
         * 设置震动，用一个 long 的数组来表示震动状态，这里表示的是先震动1秒、静止1秒、再震动1秒，这里以毫秒为单位
         * 如果要设置先震动1秒，然后停止0.5秒，再震动2秒则可设置数组为：long[]{1000, 500, 2000}。
         */
        private long[] vibrate = null;

        /**
         * 首次收到的时候，在状态栏中，图标的右侧显示的文字（设置之后可以显示悬停通知）
         */
        private String mTickerText;
        /**
         * 通知优先级
         */
        private int mPriority = NotificationCompat.PRIORITY_HIGH;

        /**
         * 处理通知的交互事件
         */
        private PendingIntent mPendingIntent;
//    /**
//     * 处理通知的交互事件可与 PendingIntent相同
//     */
//    private PendingIntent mFullScreenIntent;
        /**
         * 设置悬停 在5.0以上可以悬停之后可以正常收起，6.0以上会一直停留知道用户手动操作消失
         */
        private boolean isHighPriority = false;
        /**
         * 频道重要性
         */
        private int mImportance = NotificationManager.IMPORTANCE_HIGH;
        /**
         * 设置音效
         * 调用自己提供的铃声，位于 /res/values/raw 目录下
         * Uri.parse("android.resource://packageName/" + R.raw.sound)
         */
        private Uri mSound;
        /**
         * 设置绕过免打扰模式
         * true 绕过 false 不绕过
         */
        private boolean bypassDnd;
        /**
         * 设置是否显示通知右边角标
         */
        private boolean showBadge;
        /**
         * 是否悬停
         */
        private boolean mIsStick;

        private Builder() {

        }
        /**
         * 通知渠道 适配于Android O 8.0以上系统有效
         *
         * @param channelId 全局唯一
         */
        public Builder setChannelId(String channelId) {
            this.mChannelId = channelId;
            return this;
        }
        /**
         * 设置渠道名称
         * 在通知管理显示
         *
         * @param channelName 渠道名称
         */
        public Builder setChannelName(String channelName) {
            this.mChannelName = channelName;
            return this;
        }

        /**
         * 设置渠道组id
         *
         * @param groupId 组id
         */
        public Builder setGroupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        /**
         * 设置渠道组名称
         * 在通知管理显示
         *
         * @param groupName 组名
         */
        public Builder setGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        /**
         * 通知id
         */
        public Builder setNotificationId(int mNotificationId) {
            this.mNotificationId = mNotificationId;
            return this;
        }

        /**
         * 设置通知tag
         *
         * @param mNotificationTag
         */
        public Builder setNotificationTag(String mNotificationTag) {
            this.mNotificationTag = mNotificationTag;
            return this;
        }
        /**
         * 设置通知标题
         *
         * @param mTitle
         */
        public Builder setTitle(String mTitle) {
            this.mTitle = mTitle;
            return this;
        }
        /**
         * 设置通知内容
         *
         * @param mContentText
         */
        public Builder setContentText(String mContentText) {
            this.mContentText = mContentText;
            return this;
        }

        /**
         * 设置通知状态栏图标
         * 当 setSmallIcon() 与 setLargeIcon() 同时存在时, mSmallIcon 显示在通知的右下角, mLargeIcon 显示在左侧；
         * 当只设置 setSmallIcon() 时, mSmallIcon 显示在左侧。
         *
         * @param mSmallIcon 透明图层图标
         */
        public Builder setSmallIcon(int mSmallIcon) {
            this.mSmallIcon = mSmallIcon;
            return this;
        }

        /**
         * 设置通知图标，不设置时使用应用icon
         * 当 setSmallIcon() 与 setLargeIcon() 同时存在时, mSmallIcon 显示在通知的右下角, mLargeIcon 显示在左侧；
         * 当只设置 setSmallIcon() 时, mSmallIcon 显示在左侧。
         *
         * @param mLargeIcon
         */
        public Builder setLargeIcon(int mLargeIcon) {
            this.mLargeIcon = mLargeIcon;
            return this;
        }

        /**
         * 设置通知创建时间
         * 默认为系统发出通知的时间，通常可以不用设置
         *
         * @param timeMillis 时间戳 系统会自动格式化
         */
        public Builder setTimeMillis(long timeMillis) {
            this.mTimeMillis = timeMillis;
            return this;
        }

        /**
         * 设置点击通知后清除
         *
         * @param autoCancel true 清除 false 不清除
         */
        public Builder setAutoCancel(boolean autoCancel) {
            isAutoCancel = autoCancel;
            return this;
        }

        /**
         * 打开呼吸灯，声音，震动，触发系统默认行为
         * NotificationCompat.DEFAULT_VIBRATE     添加默认震动提醒  需要VIBRATE permission
         * NotificationCompat.DEFAULT_SOUND       添加默认声音提醒
         * NotificationCompat.DEFAULT_LIGHTS      添加默认三色灯提醒
         * NotificationCompat.DEFAULT_ALL         添加默认以上3种全部提醒
         */
        public Builder setNotificationDefault(int mNotificationDefault) {
            this.mNotificationDefault = mNotificationDefault;
            return this;
        }

        /**
         * 设置手机的LED灯为蓝色并且灯亮2秒，熄灭1秒，达到灯闪烁的效果，不过这些效果在模拟器上是看不到的，
         * 需要将程序安装在真机上才能看到对应效果，如果不想设置这些通知提示效果，
         * 可以直接设置：setDefaults(Notification.DEFAULT_ALL);
         * 意味将通知的提示效果设置为系统的默认提示效果
         *
         * @param argb 颜色 一般三种颜色：红，绿，蓝，经测试，小米支持黄色 Color.YELLOW Color.RED Color.GREEN
         *             onMs  显示时间
         *             offMs  消失时间
         */
        public Builder setLedARGB(int argb) {
            this.mLedARGB = argb;
            return this;
        }

        /**
         * 设置手机的LED灯为蓝色并且灯亮2秒，熄灭1秒，达到灯闪烁的效果，不过这些效果在模拟器上是看不到的，
         * 需要将程序安装在真机上才能看到对应效果，如果不想设置这些通知提示效果，
         * 可以直接设置：setDefaults(Notification.DEFAULT_ALL);
         * 意味将通知的提示效果设置为系统的默认提示效果
         * <p>
         * argb  颜色 一般三种颜色：红，绿，蓝，经测试，小米支持黄色 Color.YELLOW Color.RED Color.GREEN
         *
         * @param onMs 显示时间
         *             offMs  消失时间
         */
        public Builder setLedOnMS(int onMs) {
            this.mLedOnMS = onMs;
            return this;
        }

        /**
         * 设置手机的LED灯为蓝色并且灯亮2秒，熄灭1秒，达到灯闪烁的效果，不过这些效果在模拟器上是看不到的，
         * 需要将程序安装在真机上才能看到对应效果，如果不想设置这些通知提示效果，
         * 可以直接设置：setDefaults(Notification.DEFAULT_ALL);
         * 意味将通知的提示效果设置为系统的默认提示效果
         * <p>
         * argb  颜色 一般三种颜色：红，绿，蓝，经测试，小米支持黄色 Color.YELLOW Color.RED Color.GREEN
         * onMs  显示时间
         *
         * @param offMs 消失时间
         */
        public Builder setLedOffMS(int offMs) {
            this.mLedOffMS = offMs;
            return this;
        }

        /**
         * android5.0加入了一种新的模式Notification的显示等级，共有三种
         * setVisibility() 方法共有三个选值：
         * 1.VISIBILITY_PRIVATE : 显示基本信息，如通知的图标，但隐藏通知的全部内容；
         * 2.VISIBILITY_PUBLIC : 显示通知的全部内容；
         * 3.VISIBILITY_SECRET : 不显示任何内容，包括图标。
         */
        public Builder setVisibility(int mVisibility) {
            this.mVisibility = mVisibility;
            return this;
        }

        /**
         * 自定义震动效果
         * 设置震动，用一个 long 的数组来表示震动状态，这里表示的是先震动1秒、静止1秒、再震动1秒，这里以毫秒为单位
         * 如果要设置先震动1秒，然后停止0.5秒，再震动2秒则可设置数组为：long[]{1000, 500, 2000}。
         *
         * @param vibrate
         */
        public Builder setVibrate(long[] vibrate) {
            this.vibrate = vibrate;
            return this;
        }

        /**
         * 首次收到的时候，在状态栏中，图标的右侧显示的文字（设置之后可以显示悬停通知）
         *
         * @param tickerText
         */
        public Builder setTickerText(String tickerText) {
            this.mTickerText = tickerText;
            return this;
        }

        /**
         * 设置通知悬停效果
         *
         * @param mIsStick true 悬停 false 不需要
         */
        public Builder isStick(boolean mIsStick) {
            this.mIsStick = mIsStick;
            return this;
        }

        /**
         * 设置通知优先级
         *
         * @param mPriority NotificationCompat.PRIORITY_DEFAULT
         */
        public Builder setPriority(int mPriority) {
            this.mPriority = mPriority;
            return this;
        }

        /**
         * 设置处理通知的交互事件
         * example:
         * Intent intent = new Intent(mActivity,  MainActivity.class);
         * PendingIntent pendingIntent = PendingIntent.getActivity(mActivity, 2,
         * intent, PendingIntent.FLAG_UPDATE_CURRENT);
         */
        public Builder setPendingIntent(PendingIntent mPendingIntent) {
            this.mPendingIntent = mPendingIntent;
            return this;
        }

        /**
         * 设置全局悬停效果
         *
         * @param highPriority true 需要悬停 false 不需要
         */
        public Builder setHighPriority(boolean highPriority) {
            isHighPriority = highPriority;
            return this;
        }

        /**
         * 设置渠道重要性，用于NotificationChannel
         * example:
         * NotificationManager.IMPORTANCE_HIGH
         */
        public Builder setImportance(int mImportance) {
            this.mImportance = mImportance;
            return this;
        }


        /**
         * 设置通知声音
         *
         * @param sound eg:
         *              调用自己提供的铃声，位于 /res/values/raw 目录下
         *              Uri.parse("android.resource://packageName/" + R.raw.sound)
         */
        public Builder setSound(Uri sound) {
            this.mSound = sound;
            return this;
        }


        /**
         * 设置绕过免打扰模式
         *
         * @param bypassDnd true 绕过免打扰 false 不绕过
         */
        public Builder setBypassDnd(boolean bypassDnd) {
            this.bypassDnd = bypassDnd;
            return this;
        }

        /**
         * 设置是否显示通知右边角标
         *
         * @param showBadge true 显示 false 不显示
         */
        public Builder setShowBadge(boolean showBadge) {
            this.showBadge = showBadge;
            return this;
        }

        public NotifycationParams build() {
            return new NotifycationParams(this);
        }
    }
}
