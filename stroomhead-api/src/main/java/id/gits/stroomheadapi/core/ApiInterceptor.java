package id.gits.stroomheadapi.core;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithUserAgent = originalRequest.newBuilder()
                .build();
        System.out.println("API START "+chain.request().url().toString());
        return chain.proceed(requestWithUserAgent);
    }
}