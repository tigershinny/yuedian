package com.cc.repo.api;

import com.cc.repo.dao.GitHub;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiSourceService {

    @GET("/users/{username}")
    Observable<GitHub> getGitHubUser(@Path("username") String userName);

}
