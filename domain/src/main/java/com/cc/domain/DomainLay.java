package com.cc.domain;

import android.content.Context;

import com.cc.repo.DataProvider;
import com.cc.repo.IDataProvider;
import com.cc.repo.dao.GitHub;

import rx.Observable;

/**
 * Created by tigershen on 16/4/13.
 */
public class DomainLay {

    private Context context;

    private IDataProvider dataProvider;

    private DomainLay(Context context){
        this.context = context;
        dataProvider = new DataProvider(context);
    }


    private static DomainLay INSTANCE;

    public static DomainLay getInstance(Context context) {
        if(INSTANCE == null)
            INSTANCE = new DomainLay(context);
        return INSTANCE;
    }

    public Observable<GitHub> getGitHubUser(String userName){
       return dataProvider.getGitHubUser(userName);
    }
}
