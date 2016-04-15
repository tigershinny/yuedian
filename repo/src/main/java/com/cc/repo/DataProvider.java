package com.cc.repo;

import android.content.Context;

import com.cc.repo.api.ApiSource;
import com.cc.repo.dao.DbSource;
import com.cc.repo.dao.GitHub;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by tigershen on 16/4/14.
 */
public class DataProvider implements IDataProvider {

    private Context context;

    public DataProvider(Context context){
        this.context = context;
    }

    @Override
    public Observable<GitHub> getGitHubUser(String userName) {

        Observable<GitHub> dBObservable =  DbSource.getInstance(context).getGitHubUser(userName)
                .subscribeOn(Schedulers.computation());

        Observable<GitHub> radioListApi = ApiSource.getGitHubUser(userName)
                .doOnNext(gitHub -> {
                    Observable.create(subscriber -> {
                        DbSource.getInstance(context).saveGitHubUser(gitHub);
                        subscriber.onCompleted();
                    }).subscribeOn(Schedulers.computation()).subscribe();
                })
                .subscribeOn(Schedulers.io());

        return Observable.concat(dBObservable, radioListApi).observeOn(AndroidSchedulers.mainThread());
    }
}
