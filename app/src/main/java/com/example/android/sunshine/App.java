package com.example.android.sunshine;

import android.app.Application;
import com.google.gson.Gson;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.WeathericonsModule;

import id.gits.stroomheadapi.core.StroomheadApi;


public class App extends Application {
    static StroomheadApi sMStroomheadApi = new StroomheadApi();
    static Gson sGson = new Gson();

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new FontAwesomeModule());
        Iconify.with(new WeathericonsModule());
    }

    public static StroomheadApi getApi() {
        return sMStroomheadApi;
    }

    public static Gson getGson() {
        return sGson;
    }


}
