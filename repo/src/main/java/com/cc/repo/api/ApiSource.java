package com.cc.repo.api;

import com.cc.repo.dao.GitHub;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ApiSource {
    private static final String ENDPOINT = "https://api.github.com";
    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private static final ApiSourceService apiManager = sRetrofit.create(ApiSourceService.class);


    public static Observable<GitHub> getGitHubUser(String userName) {
        Observable<GitHub> ss = apiManager.getGitHubUser(userName);
        return  ss;
    }
}
