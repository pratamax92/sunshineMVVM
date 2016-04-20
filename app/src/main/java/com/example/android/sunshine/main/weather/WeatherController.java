package com.example.android.sunshine.main.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.android.sunshine.databinding.WeatherFragmentBinding;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.controller.GitsController;
import id.gits.stroomheadapi.dao.WeatherDao;

public class WeatherController extends GitsController<WeatherFragmentVM, WeatherFragmentBinding> {

    List<WeatherDao.Details> mListData = new ArrayList<>();

    public WeatherController() {

    }

    public WeatherController(List<WeatherDao.Details> mListData) {
        this.mListData = mListData;
    }

    @Override
    public WeatherFragmentVM createViewModel(WeatherFragmentBinding binding) {
        return new WeatherFragmentVM(mActivity, this, binding);
    }

    public WeatherFragmentVM createViewModel(AppCompatActivity activity, WeatherFragmentBinding binding) {
        return new WeatherFragmentVM(activity, this, binding);
    }

    @Override
    public void bindViewModel(WeatherFragmentBinding binding, WeatherFragmentVM viewModel) {
        binding.setVm(viewModel);
    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {
        mViewModel.adapterNotify();
    }

    public void onSaveInstanceState(Bundle outState) {

    }


}
