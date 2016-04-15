package com.cc.repo;

import com.cc.repo.dao.GitHub;

import rx.Observable;

/**
 * Created by tigershen on 16/4/14.
 */
public interface IDataProvider {

    Observable<GitHub> getGitHubUser(String userName);
}
