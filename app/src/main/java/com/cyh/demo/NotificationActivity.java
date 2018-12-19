package com.cyh.demo;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RemoteViews;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {

    private NotificationActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        mActivity = this;
    }

    @OnClick({R.id.mBtnSendCommonNotify, R.id.mBtnSendStickNotify, R.id.mBtnSendFoldNotify,
            R.id.mBtnSendTagNotify, R.id.mBtnCancelNotification, R.id.mBtnCancelNotificationTag,
            R.id.mBtnCancelStickNotification, R.id.mBtnCancelFoldNotification,
            R.id.mBtnCancelAll})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.mBtnSendCommonNotify:
                sendCommonNotify();
                break;

            case R.id.mBtnSendStickNotify:
                sendStickNotify();
                break;

            case R.id.mBtnSendFoldNotify:
                sendFoldNotify();
                break;

            case R.id.mBtnSendTagNotify:
                sendTagNotify();
                break;

            case R.id.mBtnCancelNotification:
                NotificationUtils.with(mActivity).removeNotification(1);
                break;

            case R.id.mBtnCancelStickNotification:
                NotificationUtils.with(mActivity).removeNotification(2);
                break;
            case R.id.mBtnCancelFoldNotification:
                NotificationUtils.with(mActivity).removeNotification(4);
                break;

            case R.id.mBtnCancelNotificationTag:
                NotificationUtils.with(mActivity).removeNotiWithTag(3, NotiTag);
                break;

            case R.id.mBtnCancelAll:
                NotificationUtils.with(mActivity).removeAll();
                break;
            default:
                break;
        }
    }

    String NotiTag = "notiTag";
    private void sendTagNotify() {
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
    }

    private void sendFoldNotify() {
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
    }

    private void sendStickNotify() {
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
    }

    public void sendCommonNotify(){
        NotificationUtils.with(mActivity)
                .setNotificationId(1)
                .setContentTitle("This is Common Title")
                .setContentText("This is Common Content")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .showNotify();
    }
}
