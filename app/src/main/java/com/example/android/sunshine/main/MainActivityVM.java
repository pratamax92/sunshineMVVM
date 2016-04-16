package com.example.android.sunshine.main;

import android.databinding.ObservableField;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.android.sunshine.databinding.MainActivityBinding;
import com.example.android.sunshine.utils.MyTextWatcher;

import id.gits.mvvmcore.viewmodel.GitsVM;

public class MainActivityVM extends GitsVM<MainController, MainActivityBinding> {

    public String bZipCode;


    public MainActivityVM(AppCompatActivity activity, MainController controller, MainActivityBinding binding) {
        super(activity, controller, binding);


    }

    public void onClick(View view) {
        if(!TextUtils.isEmpty(bZipCode)) {
            mBinding.drawer.closeDrawers();
            mController.callWeatherApi(bZipCode);
        }else{
            Toast.makeText(mActivity,"Please input city zipcode",Toast.LENGTH_SHORT).show();
        }

    }

    public void openDrawer() {
        mBinding.drawer.closeDrawers();
        mBinding.drawer.openDrawer(GravityCompat.END);
    }

    public void closeDrawer() {
        mBinding.drawer.closeDrawers();
    }


    public boolean isDrawerOpen() {
        if (mBinding.drawer.isDrawerOpen(GravityCompat.START) || mBinding.drawer.isDrawerOpen(GravityCompat.END)) {
            return true;
        } else {
            return false;
        }
    }

    public MyTextWatcher bZipCodeWatcher = new MyTextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            bZipCode = s.toString();
        }
    };

}
