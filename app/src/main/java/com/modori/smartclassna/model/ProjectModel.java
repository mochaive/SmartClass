package com.modori.smartclassna.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectModel {

    @SerializedName("info")
    List<Info> info;


    public List<Info> getInfo() {
        return info;
    }


}

