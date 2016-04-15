package com.cc.repo.dao;

import android.content.Context;

import de.greenrobot.dao.query.Query;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by tigershen on 16/4/15.
 */
public class DbSource {

    private static DbSource INSTANCE;

    public static DbSource getInstance(Context context) {
        if(INSTANCE == null)
            INSTANCE = new DbSource(context);
        return INSTANCE;
    }


    private static GitHubDao gitHubDao;

    private DbSource(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "github-db", null);
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        gitHubDao = daoSession.getGitHubDao();
    }



    public Observable<GitHub> getGitHubUser(final String userName) {
        Observable<GitHub> ss = Observable.create(new Observable.OnSubscribe<GitHub>() {
            @Override
            public void call(Subscriber<? super GitHub> subscriber) {
                Query<GitHub> query = gitHubDao.queryBuilder().where(GitHubDao.Properties.Login.eq(userName))
                        .orderAsc(GitHubDao.Properties.Id).build();
                if(query.list().size() > 0){
                    subscriber.onNext(query.list().get(0));
                }
                subscriber.onCompleted();
            }
        });
        return  ss;
    }

    public Observable<Long> saveGitHubUser(final GitHub gitHub) {
        Observable<Long> ss = Observable.create(new Observable.OnSubscribe<Long>() {
            @Override
            public void call(Subscriber<? super Long> subscriber) {
               long rowId = gitHubDao.insert(gitHub);
                subscriber.onNext(Long.valueOf(rowId));
                subscriber.onCompleted();
            }
        });
        return ss;
    }
}
