package com.example.android.sunshine.main.today;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.sunshine.databinding.TodayFragmentBinding;
import com.example.android.sunshine.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.controller.GitsController;
import id.gits.stroomheadapi.dao.WeatherDao;


public class TodayController extends GitsController<TodayFragmentVM, TodayFragmentBinding> {

    private WeatherDao.Details details;

    public TodayController(WeatherDao.Details details) {
        this.details = details;
    }


    @Override
    public TodayFragmentVM createViewModel(TodayFragmentBinding binding) {
        return new TodayFragmentVM(mActivity, this, binding);
    }

    public TodayFragmentVM createViewModel(AppCompatActivity activity, TodayFragmentBinding binding) {
        return new TodayFragmentVM(activity, this, binding);
    }

    @Override
    public void bindViewModel(TodayFragmentBinding binding, TodayFragmentVM viewModel) {
        binding.setVm(viewModel);
    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {

        String degree = "\u00B0";
        String w = details.weather.get(0).main;
        String w1 = MainActivity.iconWeather(w.toLowerCase());
        mViewModel.setHeader(w1, w, details.temp.max + degree, details.temp.min + degree);

    }

    public void onSaveInstanceState(Bundle outState) {

    }


}
