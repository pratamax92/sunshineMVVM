package com.example.android.sunshine.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.sunshine.App;
import com.example.android.sunshine.R;
import com.example.android.sunshine.databinding.MainActivityBinding;
import com.example.android.sunshine.main.today.TodayFragment;
import com.example.android.sunshine.main.weather.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.controller.GitsController;
import id.gits.stroomheadapi.core.MyObserver;
import id.gits.stroomheadapi.dao.WeatherDao;
import id.gits.stroomheadapi.repository.WeatherRepository;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainController extends GitsController<MainActivityVM, MainActivityBinding> {

    List<WeatherDao.Details> mListData = new ArrayList<>();

    public MainController() {

    }

    @Override
    public MainActivityVM createViewModel(MainActivityBinding binding) {
        return new MainActivityVM(mActivity, this, binding);
    }

    public MainActivityVM createViewModel(AppCompatActivity activity, MainActivityBinding binding) {
        return new MainActivityVM(activity, this, binding);
    }

    @Override
    public void bindViewModel(MainActivityBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {
        mActivity.setTitle(" SunShine MVVM");
        mActivity.getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        callWeatherApi("94043");
    }

    public void onSaveInstanceState(Bundle outState) {

    }

    public void callWeatherApi(final String zipCode) {
        mActivity.getSupportActionBar().setSubtitle(" "+zipCode);
        WeatherRepository mWeatherRepository = new WeatherRepository(App.getApi(), zipCode, "eeccee48ca9437fce0c49fdcbbc8955a");
        addSubscription(mWeatherRepository.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<WeatherDao>() {
                    @Override
                    public void onApiResultCompleted() {
                    }

                    @Override
                    public void onApiResultError(String message) {
                        Toast.makeText(mActivity, "Data Not Found", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onApiResultOk(WeatherDao weatherApiDao) {

                        if (mListData.size() > 0) {
                            mListData.clear();
                            for (int i = 1; i < weatherApiDao.list.size(); i++) {
                                mListData.add(weatherApiDao.list.get(i));
                            }
                            mActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, WeatherFragment.newInstance(mListData)).commit();
                            mActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frameTodayLayout, TodayFragment.newInstance(weatherApiDao.list.get(0))).commit();
                        } else {
                            for (int i = 1; i < weatherApiDao.list.size(); i++) {
                                mListData.add(weatherApiDao.list.get(i));
                            }
                            mActivity.getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, WeatherFragment.newInstance(mListData)).commit();
                            mActivity.getSupportFragmentManager().beginTransaction().add(R.id.frameTodayLayout, TodayFragment.newInstance(weatherApiDao.list.get(0))).commit();
                        }

                    }

                })
        );

    }

    public void openNavDrawer() {
        mViewModel.openDrawer();
    }

    public void closeNavDrawer() {
        mViewModel.closeDrawer();
    }


    public boolean finish() {
        if (mViewModel.isDrawerOpen()) {
            mViewModel.closeDrawer();
            return false;
        } else {
            return true;
        }
    }


}
