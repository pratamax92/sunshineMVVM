package id.gits.stroomheadapi;

import id.gits.stroomheadapi.dao.WeatherDao;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface ApiService {
    @GET("forecast/daily?mode=json&units=metric&cnt=7")
    Observable<WeatherDao> getWeather(@Query("q") String q,
                                      @Query("APPID") String appid);
}