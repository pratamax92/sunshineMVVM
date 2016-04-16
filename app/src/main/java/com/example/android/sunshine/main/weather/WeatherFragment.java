package com.example.android.sunshine.main.weather;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.sunshine.R;
import com.example.android.sunshine.databinding.WeatherFragmentBinding;

import java.util.List;

import id.gits.mvvmcore.fragment.GitsFragment;
import id.gits.stroomheadapi.dao.WeatherDao;

public class WeatherFragment extends GitsFragment<WeatherController> {


    List<WeatherDao.Details> list;

    public WeatherFragment() {
    }

    public WeatherFragment(List<WeatherDao.Details> list) {
        this.list = list;
    }

    public static WeatherFragment newInstance(List<WeatherDao.Details> list) {
        Bundle args = new Bundle();
        WeatherFragment fragment = new WeatherFragment(list);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.weather_fragment;
    }


    protected ViewDataBinding createViewBinding(LayoutInflater inflater) {
        return WeatherFragmentBinding.inflate(inflater);
    }

    @Override
    protected WeatherController createController() {
        return new WeatherController(list);
    }


}
