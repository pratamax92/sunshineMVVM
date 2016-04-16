package id.gits.stroomheadapi.repository;

import id.gits.stroomheadapi.core.StroomheadApi;
import id.gits.stroomheadapi.dao.WeatherDao;
import rx.Observable;


public class WeatherRepository {
    StroomheadApi mStroomheadApi;
    String q;
    String appid;

    public WeatherRepository(StroomheadApi stroomheadApi,String q, String appid) {
        mStroomheadApi = stroomheadApi;
        this.q = q;
        this.appid = appid;
    }

    public Observable<WeatherDao> getData() {
        return mStroomheadApi.getApiService().getWeather(q,appid);
    }
}
