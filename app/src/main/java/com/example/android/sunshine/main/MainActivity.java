package com.example.android.sunshine.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.android.sunshine.R;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import id.gits.mvvmcore.activity.GitsActivity;
import id.gits.stroomheadapi.dao.WeatherDao;

public class MainActivity extends GitsActivity<MainController> {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Menu")
                .setIcon(new IconDrawable(this, FontAwesomeIcons.fa_bars).colorRes(R.color.white).actionBarSize())
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mController.openNavDrawer();
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected int getResLayout() {
        return R.layout.main_activity;
    }

    protected Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    protected ViewDataBinding createContentViewBinding() {
        return DataBindingUtil.setContentView(this, R.layout.main_activity);

    }

    @Override
    protected MainController createController() {
        return new MainController();
    }


    public static void startThisActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static String iconWeather(String w1) {
        if (w1.contains("rain")) {
            return "{wi_rain}";
        } else if (w1.contains("cloud")) {
            return "{wi_cloud}";
        } else if (w1.contains("sun") || w1.contains("clear")) {
            return "{wi_day_sunny_overcast}";
        } else {
            return "";
        }

    }

    @Override
    public void finish() {
        if (mController.finish()) {
            finish();
        }
    }


}
