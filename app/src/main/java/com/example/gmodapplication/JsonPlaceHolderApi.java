package com.example.gmodapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("search/anime/?score=8.7-10.0&order_by=score")
    Call<SearchResponse> getResponse(@Query("genre") String genres);
}
