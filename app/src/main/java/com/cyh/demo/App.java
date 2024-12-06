package com.cyh.demo;

import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

/**
 * Description:
 *
 * @Author: chenyihui
 * Date: 2019-09-25
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UiModeManager uiModeManager = (UiModeManager)
                getSystemService(Context.UI_MODE_SERVICE);
        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
