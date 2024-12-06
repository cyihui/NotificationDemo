package com.cyh.demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    private int notificationId = 1;

    private MainActivity mActivity;

    String channelId = "notification_simple";
    String channelName = "系统通知";
    String title = "This is notification title";
    String content = "This is notification content";
    String notificationTag = "notifyTag";
    private BringToFrontReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().getDecorView().setForceDarkAllowed(false);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mActivity = this;
        receiver = new BringToFrontReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BringToFrontReceiver.ACTION_BRING_TO_FRONT);
        registerReceiver(receiver, intentFilter);
    }


    @OnClick({R.id.mBtnNotifyDemo1, R.id.mBtnNotifyDemo2})
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.mBtnNotifyDemo1:
                startActivity(new Intent(MainActivity.this, NotificationDemoActivity.class));
                break;


            case R.id.mBtnNotifyDemo2:
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;

            default:
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
