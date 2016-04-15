package com.cc.repo.dao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by tigershen on 16/4/14.
 */
public class MyDaoGen {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.cc.repo.dao");

        addNote(schema);

        new DaoGenerator().generateAll(schema,"/Users/tigershen/AndroidStudioProjects/com.cc.yuedian/repo/src/main/java");
    }

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("GitHub");
        note.addStringProperty("login").notNull();
        note.addIdProperty();
        note.addStringProperty("avatarUrl");
        note.addStringProperty("gravatarId");
        note.addStringProperty("url");
        note.addStringProperty("htmlUrl");
        note.addStringProperty("followersUrl");
        note.addStringProperty("followingUrl");
        note.addStringProperty("gistsUrl");
        note.addStringProperty("starredUrl");
        note.addStringProperty("subscriptionsUrl");
        note.addStringProperty("organizationsUrl");
        note.addStringProperty("reposUrl");
        note.addStringProperty("eventsUrl");
        note.addStringProperty("receivedEventsUrl");

        note.addStringProperty("type");
        note.addBooleanProperty("siteAdmin");
        note.addStringProperty("name");
        note.addStringProperty("company");
        note.addStringProperty("blog");
        note.addStringProperty("location");
        note.addStringProperty("email");
        note.addBooleanProperty("hireable");
        note.addStringProperty("bio");
        note.addIntProperty("publicRepos");
        note.addIntProperty("publicGists");
        note.addIntProperty("followers");
        note.addIntProperty("following");
        note.addStringProperty("createdAt");
        note.addStringProperty("updatedAt");
    }
}
