package com.cyh.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Description:
 *
 * @Author: chenyihui
 * Date: 2019-09-25
 */
public class BringToFrontReceiver extends BroadcastReceiver {
    public static final String ACTION_BRING_TO_FRONT ="neal.pushtest.action.BringToFront";
    public BringToFrontReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent resultIntent = new Intent(context, MainActivity.class);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setAction(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(resultIntent);
    }
}
