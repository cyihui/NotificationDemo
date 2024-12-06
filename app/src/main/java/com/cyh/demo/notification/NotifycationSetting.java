package com.cyh.demo.notification;

import android.app.NotificationManager;

/**
 * Description:
 *
 * @Author: chenyihui
 * Date: 2021/2/22
 */
public class NotifycationSetting {
    /**
     * 通知渠道 适配于Android O 8.0以上系统有效
     */
    private String mDefaultChannelId = "0000001";
    /**
     * 设置渠道名称
     */
    private String mDefaultChannelName = "系统通知";

    private String mDefaultChannelDes = "状态栏";

    /**
     * 通知渠道组id
     */
    private String mDefaultGroupId = "group_001";
    /**
     * 通知渠道组名称
     */
    private String mDefaultGroupName = "系统通知";

    /**
     * 频道重要性
     */
    private int mDefaultImportance = NotificationManager.IMPORTANCE_HIGH;

    /**
     * 设置通知状态栏图标
     * 当 setSmallIcon() 与 setLargeIcon() 同时存在时, mSmallIcon 显示在通知的右下角, mLargeIcon 显示在左侧；
     * 当只设置 setSmallIcon() 时, mSmallIcon 显示在左侧。
     */
    private int mSmallIcon;
    /**
     * 设置通知状态栏图标背景色
     */
    private int mSmallIconBgColor;
    /**
     * 是否开启振动
     */
    private boolean isOpenVibrate;

    /**
     * 是否开启免打扰
     */
    private boolean isOpenDisturb;

    private NotifycationSetting(Builder builder) {
        setDefaultChannelId(builder.mDefaultChannelId);
        setDefaultChannelName(builder.mDefaultChannelName);
        setDefaultChannelDes(builder.mDefaultChannelDes);
        setDefaultGroupId(builder.mDefaultGroupId);
        setDefaultGroupName(builder.mDefaultGroupName);
        setDefaultImportance(builder.mImportance);
        setSmallIcon(builder.mSmallIcon);
        setSmallIconBgColor(builder.mSmallIconBgColor);
        setOpenVibrate(builder.isOpenVibrate);
        setOpenDisturb(builder.isOpenDisturb);
    }
    public String getDefaultChannelId() {
        return mDefaultChannelId;
    }

    public void setDefaultChannelId(String mDefaultChannelId) {
        this.mDefaultChannelId = mDefaultChannelId;
    }

    public String getDefaultChannelName() {
        return mDefaultChannelName;
    }

    public void setDefaultChannelName(String mDefaultChannelName) {
        this.mDefaultChannelName = mDefaultChannelName;
    }

    public String getDefaultChannelDes() {
        return mDefaultChannelDes;
    }

    public void setDefaultChannelDes(String mDefaultChannelDes) {
        this.mDefaultChannelDes = mDefaultChannelDes;
    }

    public String getDefaultGroupId() {
        return mDefaultGroupId;
    }

    public void setDefaultGroupId(String mDefaultGroupId) {
        this.mDefaultGroupId = mDefaultGroupId;
    }

    public String getDefaultGroupName() {
        return mDefaultGroupName;
    }

    public void setDefaultGroupName(String mDefaultGroupName) {
        this.mDefaultGroupName = mDefaultGroupName;
    }

    public int getSmallIcon() {
        return mSmallIcon;
    }

    public void setSmallIcon(int mSmallIcon) {
        this.mSmallIcon = mSmallIcon;
    }

    public int getSmallIconBgColor() {
        return mSmallIconBgColor;
    }

    public void setSmallIconBgColor(int mSmallIconBgColor) {
        this.mSmallIconBgColor = mSmallIconBgColor;
    }

    public boolean isOpenVibrate() {
        return isOpenVibrate;
    }

    public void setOpenVibrate(boolean openVibrate) {
        isOpenVibrate = openVibrate;
    }

    public boolean isOpenDisturb() {
        return isOpenDisturb;
    }

    public void setOpenDisturb(boolean openDisturb) {
        isOpenDisturb = openDisturb;
    }

    public int getDefaultImportance() {
        return mDefaultImportance;
    }

    public void setDefaultImportance(int mDefaultImportance) {
        this.mDefaultImportance = mDefaultImportance;
    }

    public static final class Builder {
        /**
         * 通知渠道 适配于Android O 8.0以上系统有效
         */
        private String mDefaultChannelId = "0000001";
        /**
         * 设置渠道名称
         */
        private String mDefaultChannelName = "系统通知";

        private String mDefaultChannelDes = "状态栏";

        /**
         * 通知渠道组id
         */
        private String mDefaultGroupId = "group_001";
        /**
         * 通知渠道组名称
         */
        private String mDefaultGroupName = "系统通知";
        /**
         * 频道重要性
         */
        private int mImportance = NotificationManager.IMPORTANCE_HIGH;
        /**
         * 设置通知状态栏图标
         * 当 setSmallIcon() 与 setLargeIcon() 同时存在时, mSmallIcon 显示在通知的右下角, mLargeIcon 显示在左侧；
         * 当只设置 setSmallIcon() 时, mSmallIcon 显示在左侧。
         */
        private int mSmallIcon;
        /**
         * 设置通知状态栏图标背景色
         */
        private int mSmallIconBgColor;
        /**
         * 是否开启振动
         */
        private boolean isOpenVibrate;

        /**
         * 是否开启免打扰
         */
        private boolean isOpenDisturb;

        private Builder() {

        }

        public Builder setDefaultChannelId(String defaultChannelId) {
            this.mDefaultChannelId = defaultChannelId;
            return this;
        }

        public Builder setDefaultChannelName(String defaultChannelName) {
            this.mDefaultChannelName = defaultChannelName;
            return this;
        }

        public Builder setDefaultChannelDes(String defaultChannelDes) {
            this.mDefaultChannelDes = defaultChannelDes;
            return this;
        }

        public Builder setDefaultGroupId(String defaultGroupId) {
            this.mDefaultGroupId = defaultGroupId;
            return this;
        }

        public Builder setDefaultGroupName(String defaultGroupName) {
            this.mDefaultGroupName = defaultGroupName;
            return this;
        }

        public Builder setDefaultImportance(int importance) {
            this.mImportance = importance;
            return this;
        }

        public Builder setSmallIcon(int smallIcon) {
            this.mSmallIcon = smallIcon;
            return this;
        }

        public Builder setSmallIconBgColor(int smallIconBgColor) {
            this.mSmallIconBgColor = smallIconBgColor;
            return this;
        }

        public Builder setOpenVibrate(boolean openVibrate) {
            isOpenVibrate = openVibrate;
            return this;
        }

        public Builder setOpenDisturb(boolean openDisturb) {
            isOpenDisturb = openDisturb;
            return this;
        }
        public NotifycationSetting build() {
            return new NotifycationSetting(this);
        }
    }
}
