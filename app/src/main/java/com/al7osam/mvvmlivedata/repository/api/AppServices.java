package com.al7osam.mvvmlivedata.repository.api;

import com.al7osam.mvvmlivedata.model.SpeciesList;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import io.reactivex.Observable;

/**
 * Created by eman.eraqi on 12/30/2018.
 */

public class AppServices {
    public static final String Domain_Url = "http://swapi.co/api/";
    public static final String Base_Url = Domain_Url + "api/Mobile/";

    public interface AppAPI {
        @GET("species/")
        Call<SpeciesList> getSpecies();

        @GET("species/")
        Observable<SpeciesList> getAllSpecies();

//        @GET("search/tweets.json")
//        Flowable<SearchResponse> searchTweets(@Query("q") String query);
//
//        @GET("trends/place.json")
//        Observable<List<TrendsResponse>> getTrends( String placeId);
    }

    public AppAPI getApi() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(260, TimeUnit.SECONDS)
                .connectTimeout(460, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Domain_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(AppAPI.class);
    }
}


