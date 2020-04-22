package com.modori.smartclassna.model;

import com.google.gson.annotations.SerializedName;

public class WordCloud {

    @SerializedName("url")
    private
    String url;

    @SerializedName("length")
    private
    String length;

    @SerializedName("target")
    private
    String target;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
