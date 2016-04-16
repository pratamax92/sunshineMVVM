package com.example.android.sunshine.main.weather;

import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.android.sunshine.R;
import com.example.android.sunshine.databinding.WeatherFragmentBinding;

import java.util.Arrays;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;


public class WeatherFragmentVM extends GitsVM<WeatherController,WeatherFragmentBinding> {

    public LinearLayoutManager bLayoutManager;
    public WeatherAdapter bAdapter;


    public WeatherFragmentVM(AppCompatActivity activity, WeatherController controller, WeatherFragmentBinding binding) {
        super(activity, controller, binding);

        bLayoutManager = new LinearLayoutManager(activity);
        bAdapter = new WeatherAdapter(controller.mListData);

    }

    public void adapterNotify() {
        bAdapter.notifyDataSetChanged();
    }



}
