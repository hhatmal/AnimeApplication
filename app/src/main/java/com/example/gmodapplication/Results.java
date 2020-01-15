package com.example.gmodapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Results implements Serializable {
    @SerializedName("mal_id")
    @Expose
    private String mal_id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image_url")
    @Expose
    private String image_url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("airing")
    @Expose
    private Boolean airing;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("episodes")
    @Expose
    private int episodes;
    @SerializedName("score")
    @Expose
    private float score;
    @SerializedName("start_date")
    @Expose
    private String start_date;
    @SerializedName("end_date")
    @Expose
    private String end_date;
    @SerializedName("members")
    @Expose
    private int members;
    @SerializedName("rated")
    @Expose
    private String rated;

    public String getMal_id() {
        return mal_id;
    }

    public String getUrl() {
        return url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getAiring() {
        return airing;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getType() {
        return type;
    }

    public int getEpisodes() {
        return episodes;
    }

    public float getScore() {
        return score;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public int getMembers() {
        return members;
    }

    public String getRated() {
        return rated;
    }
}
