package com.medtrack.medtrack;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mauriciofs on 17/09/16.
 */
public interface Api {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("users/{userId}")
    Call<List<Resource>> getResources(@Path("userId") String userId);
}
