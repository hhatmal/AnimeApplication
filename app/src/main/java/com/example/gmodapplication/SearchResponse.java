package com.example.gmodapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {
    @SerializedName("request_hash")
    @Expose
    private String request_hash;
    @SerializedName("request_cached")
    @Expose
    private Boolean request_cached;
    @SerializedName("request_cache_expiry")
    @Expose
    private String request_cache_expiry;
    @SerializedName("results")
    @Expose
    private List<Results> results;
    @SerializedName("last_page")
    @Expose
    private String last_page;

    public String getLast_page() {
        return last_page;
    }

    public String getRequest_hash() {
        return request_hash;
    }

    public Boolean getRequest_cached() {
        return request_cached;
    }

    public String getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public List<Results> getResults() {
        return results;
    }
}
