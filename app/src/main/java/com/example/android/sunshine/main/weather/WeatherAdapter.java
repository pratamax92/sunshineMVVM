package com.example.android.sunshine.main.weather;

import android.support.v7.app.AppCompatActivity;

import com.example.android.sunshine.BR;
import com.example.android.sunshine.R;
import com.example.android.sunshine.databinding.WeatherRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.gits.stroomheadapi.dao.WeatherDao;


public class WeatherAdapter extends GitsAdapter<WeatherDao.Details, WeatherRowVM, WeatherRowBinding> {
    WeatherRowVM mViewModel;

    public WeatherAdapter(List<WeatherDao.Details> collection) {
        super(collection);
    }

    @Override
    public WeatherRowVM createViewModel(AppCompatActivity activity, WeatherRowBinding binding, WeatherDao.Details item) {
        return null;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.weather_row;
    }

    @Override
    public void render(WeatherRowBinding binding, WeatherRowVM viewModel, WeatherDao.Details item) {
        mViewModel = new WeatherRowVM(mContext, binding, item);
        binding.setVariable(BR.vm, mViewModel);
        binding.executePendingBindings();

    }


    @Override
    public void onRowClick(WeatherDao.Details data, int position) {

    }
}
