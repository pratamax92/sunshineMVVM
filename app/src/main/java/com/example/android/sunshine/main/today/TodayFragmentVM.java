package com.example.android.sunshine.main.today;

import android.support.v7.app.AppCompatActivity;

import com.example.android.sunshine.databinding.TodayFragmentBinding;

import id.gits.mvvmcore.viewmodel.GitsVM;


public class TodayFragmentVM extends GitsVM<TodayController, TodayFragmentBinding> {


    public String bIcon;
    public String bMain;
    public String bMax;
    public String bMin;


    public TodayFragmentVM(AppCompatActivity activity, TodayController controller, TodayFragmentBinding binding) {
        super(activity, controller, binding);

    }

    public void setHeader(String icon, String main, String max, String min) {
        bIcon = icon;
        bMain = main;
        bMax = max;
        bMin = min;
    }


}
