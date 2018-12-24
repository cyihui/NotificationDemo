# NotificationDemo

通知工具类，简化构造通知流程

[GitHub主页](https://github.com/cyihui/NotificationDemo)

# 简介
- 链式调用
- 可自定义Notification Builder
- 适配Android O
- 可自定义NotificationChannel


# 调用

1、普通通知
```
NotificationUtils.with(mActivity)
                .setNotificationId(1)
                .setContentTitle("This is Common Title")
                .setContentText("This is Common Content")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .showNotify();
```

2、悬停通知
```
String title = "This is Stick Title";
String content = "This is Stick Content";
Intent intent = new Intent(mActivity,  MainActivity.class);
PendingIntent pendingIntent = PendingIntent.getActivity(mActivity, 2,
        intent, PendingIntent.FLAG_UPDATE_CURRENT);
NotificationUtils.with(mActivity)
        .setNotificationId(2)
        .setContentTitle(title)
        .setContentText(content)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setLargeIcon(R.mipmap.ic_launcher)
        .setTicker(title)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
        .showNotify();
```

3、折叠通知
```
String title = "This is fold Title";
String content = "This is fold Content";
Intent intent = new Intent(mActivity,  MainActivity.class);
PendingIntent pendingIntent = PendingIntent.getActivity(mActivity, 2,
        intent, PendingIntent.FLAG_UPDATE_CURRENT);
NotificationUtils.with(mActivity)
        .setNotificationId(4)
        .setContentTitle(title)
        .setContentText(content)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setLargeIcon(R.mipmap.ic_launcher)
        .setTicker(title)
        .setAutoCancel(true)
        .setCustomContentView(R.layout.notify_collapsed)
        .setCustomBigContentView(R.layout.notify_show)
        .setContentViewListener(new NotificationUtils.ContentViewListener() {
            @Override
            public void onContentView(RemoteViews collapsed) {
                collapsed.setTextViewText(R.id.mTvTitle, "This IS custom title");
            }

            @Override
            public void onBigContentView(RemoteViews show) {

            }
        })
        .setContentIntent(pendingIntent)
        .showNotify();
```

4、tag通知
```
String title = "This is Tag Title";
        String content = "This is Tag Content";
        NotificationUtils.with(mActivity)
                .setNotificationId(3)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(R.mipmap.ic_launcher)
                .setTicker(title)
                .setNotificationTag(NotiTag)
                .setAutoCancel(true)
                .showNotify();
```

5、取消普通通知
```
 NotificationUtils.with(mActivity).removeNotification(notificationId);
```

6、取消tag通知
```
NotificationUtils.with(mActivity).removeNotiWithTag(3, NotiTag);
```

7、取消全部通知
```
NotificationUtils.with(mActivity).removeAll();
```
