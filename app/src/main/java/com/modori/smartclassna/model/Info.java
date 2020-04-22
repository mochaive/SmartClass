package com.modori.smartclassna.model;

import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("id")
    int id;

    @SerializedName("boardTitle")
    String boardTitle;

    @SerializedName("users")
    String users;

    @SerializedName("subject")
    String subject;

    @SerializedName("school")
    String school;

    @SerializedName("type")
    String type;

    @SerializedName("createdAt")
    String createAt;

    @SerializedName("updatedAt")
    String updateAt;

    public int getId() {
        return id;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public String getUsers() {
        return users;
    }

    public String getSubject() {
        return subject;
    }

    public String getSchool() {
        return school;
    }

    public String getType() {
        return type;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }
}