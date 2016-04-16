package com.example.android.sunshine.main.weather;

import android.content.Context;

import com.example.android.sunshine.databinding.WeatherRowBinding;
import com.example.android.sunshine.main.MainActivity;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import id.gits.stroomheadapi.dao.WeatherDao;

public class WeatherRowVM extends GitsRowVM<WeatherDao.Details, WeatherRowBinding> {

    public String bIcon;
    public String bMain;
    public String bDesc;
    public String bMax;
    public String bMin;

    public WeatherRowVM(Context activity, WeatherRowBinding binding, WeatherDao.Details weatherDao) {
        super(activity, binding, weatherDao);

        String degree = " \u00B0";
        String w = weatherDao.weather.get(0).main;
        String w1 = w.toLowerCase();

        bMain = w;
        bIcon = MainActivity.iconWeather(w1);

        bDesc = weatherDao.weather.get(0).description;
        bMax = weatherDao.temp.max + degree;
        bMin = weatherDao.temp.min + degree;


    }


}
