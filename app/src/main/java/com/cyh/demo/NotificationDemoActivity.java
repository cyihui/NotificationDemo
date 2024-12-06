package com.cyh.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 *
 * @Author: chenyihui
 * Date: 2019-09-25
 */
public class NotificationDemoActivity extends AppCompatActivity {
    private int notificationId = 1;

    private NotificationDemoActivity mActivity;

    String channelId = "notification_simple";
    String channelName = "默认";
    String title = "This is notification title";
    String content = "This is notification content";
    String notificationTag = "notifyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
        ButterKnife.bind(this);
        mActivity = this;
    }


    @OnClick({R.id.mBtnSendNomalNotify, R.id.mBtnSendStickNotify, R.id.mBtnSendFoldNotify,
            R.id.mBtnSendTagNotify, R.id.mBtnCancelNotification, R.id.mBtnCancelNotificationTag,
            R.id.mBtnCancelAll, R.id.mBtnNewUtil})
    public void onViewClick(View v) {
        Intent skipIntent = new Intent(mActivity, MainActivity.class);
        switch (v.getId()) {
            case R.id.mBtnSendNomalNotify:
                NotificationUtil.with(mActivity).showNotification(skipIntent, notificationId,
                        channelId, channelName, title, content, false);
//                notificationId++;
                break;


            case R.id.mBtnSendStickNotify:
                NotificationUtil.with(mActivity).showNotification(skipIntent, notificationId,
                        channelId, channelName, title, content, true);
//                notificationId++;
                break;

            case R.id.mBtnSendFoldNotify:
                NotificationUtil.with(mActivity).showRemoteNotification(skipIntent, notificationId, "",
                        channelId, channelName, title, content, true);
//                notificationId++;
                break;

            case R.id.mBtnSendTagNotify:
                NotificationUtil.with(mActivity).showNotification(skipIntent, notificationId, notificationTag,
                        channelId, channelName, title, content, false);
//                notificationId++;
                break;
            case R.id.mBtnCancelNotificationTag:
//                notificationId--;
                NotificationUtil.with(mActivity).removeNotiWithTag(notificationId, notificationTag);
                break;

            case R.id.mBtnCancelNotification:
//                notificationId--;
                NotificationUtil.with(mActivity).removeNotification(notificationId);
                break;

            case R.id.mBtnCancelAll:
//                notificationId = 1;
                NotificationUtil.with(mActivity).removeAll();
                break;

            case R.id.mBtnNewUtil:
                startActivity(new Intent(mActivity, NotificationActivity.class));
                break;
            default:
                break;

        }
    }
}
