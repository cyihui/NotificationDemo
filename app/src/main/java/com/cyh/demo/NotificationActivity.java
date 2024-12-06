package com.cyh.demo;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RemoteViews;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {

    private NotificationActivity mActivity;

    @BindView(R.id.mLlContainer)
    LinearLayout mLlContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        initRefreshRate();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
//        BringToFrontReceiver receiver = new BringToFrontReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(BringToFrontReceiver.ACTION_BRING_TO_FRONT);
//        registerReceiver(receiver, intentFilter);
        ButterKnife.bind(this);
        mActivity = this;

        if (!CommonUtils.checkNotificationReadPermission(this)) {
            Snackbar.make(mLlContainer, getText(R.string.no_read_notification_promission), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getText(R.string.action_settings), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                            startActivity(intent);
                        }
                    })
                    .show();
        } else {
        }
    }

    private void initRefreshRate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Display.Mode[] supportedModes = getWindow().getWindowManager().getDefaultDisplay().getSupportedModes();
            Arrays.sort(supportedModes);
            for (int i = 0; i < supportedModes.length; i++) {
                Log.e("NotificationActivity", "initRefreshRate sort:"+supportedModes[i]);
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.preferredDisplayModeId = supportedModes[0].getModeId();
        }
    }

    @OnClick({R.id.mBtnSendCommonNotify, R.id.mBtnSendStickNotify, R.id.mBtnSendFoldNotify,
            R.id.mBtnSendTagNotify, R.id.mBtnCancelNotification, R.id.mBtnCancelNotificationTag,
            R.id.mBtnCancelStickNotification, R.id.mBtnCancelFoldNotification,
            R.id.mBtnCancelAll, R.id.mBtnActiveNotification})
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
            case R.id.mBtnActiveNotification:
                break;
            default:
                break;
        }
    }

    String NotiTag = "notiTag";

    private void sendTagNotify() {
        String title = "This is Tag Title";
        String content = "This is Tag Content";
        Intent intent = new Intent(BringToFrontReceiver.ACTION_BRING_TO_FRONT);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mActivity, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationUtils.with(mActivity)
                .setNotificationId(3)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(R.drawable.ic_fog_ground)
                .setTicker(title)
                .setNotificationTag(NotiTag)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .showNotify();
    }

    private void sendFoldNotify() {
        String title = "This is fold Title";
        String content = "This is fold Content";
        Intent intent = new Intent(mActivity, MainActivity.class);
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
//        Intent intent = new Intent(mActivity, MainActivity.class);
        Intent intent = getTopIntent();
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setAction(Intent.ACTION_MAIN);
        intent.setFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
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

    public void sendCommonNotify() {
        NotificationUtils.with(mActivity)
                .setNotificationId(1)
                .setContentTitle("This is Common Title")
                .setContentText("This is Common Content")
                .setSmallIcon(R.drawable.ic_fog_ground)
                .setLargeIcon(R.drawable.ic_fog_ground)
                .setAutoCancel(true)
                .showNotify();
    }

    private Intent getTopIntent() {
        //获取ActivityManager
        ActivityManager mAm = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        //获得当前运行的task
        List<ActivityManager.RunningTaskInfo> taskList = mAm.getRunningTasks(100);
        Intent resultIntent = null;
        for (ActivityManager.RunningTaskInfo rti : taskList) {
            //找到当前应用的task，并启动task的栈顶activity，达到程序切换到前台
            if (rti.topActivity.getPackageName().equals(getPackageName())) {
                try {
                    Log.e("Notify", "class name:" + rti.topActivity.getClassName());
                    resultIntent = new Intent(mActivity, Class.forName(rti.topActivity.getClassName()));
                    resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return resultIntent;
            }
        }
        return resultIntent;
    }

    private void startMain() {
        Intent intent = new Intent(mActivity, MainActivity.class);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setAction(Intent.ACTION_MAIN);
        intent.setFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
