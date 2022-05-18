package com.zhdj.bean;

import java.util.Date;

public class Collections {
    private int user_id;
    private int collection_id;
    private String type;

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "user_id=" + user_id +
                ", collection_id=" + collection_id +
                ", type='" + type + '\'' +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collections(int user_id, int collection_id, String type) {
        this.user_id = user_id;
        this.collection_id = collection_id;
        this.type = type;
    }

    private Date time;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }

}
