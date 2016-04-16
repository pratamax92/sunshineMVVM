package com.example.android.sunshine.main.today;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.sunshine.R;
import com.example.android.sunshine.databinding.TodayFragmentBinding;

import java.util.List;

import id.gits.mvvmcore.fragment.GitsFragment;
import id.gits.stroomheadapi.dao.WeatherDao;

public class TodayFragment extends GitsFragment<TodayController> {

    private WeatherDao.Details details;
    public TodayFragment() {
    }

    public TodayFragment(WeatherDao.Details details) {
        this.details = details;
    }


    public static TodayFragment newInstance(WeatherDao.Details details) {
        Bundle args = new Bundle();
        TodayFragment fragment = new TodayFragment(details);
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
        return R.layout.today_fragment;
    }


    protected ViewDataBinding createViewBinding(LayoutInflater inflater) {
        return TodayFragmentBinding.inflate(inflater);
    }

    @Override
    protected TodayController createController() {
        return new TodayController(details);
    }


}
