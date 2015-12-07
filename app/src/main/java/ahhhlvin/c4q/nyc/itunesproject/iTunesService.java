package ahhhlvin.c4q.nyc.itunesproject;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by alvin2 on 12/6/15.
 */
public interface iTunesService {
        @GET("/search?media=music")
        Call<Result> getMusicResults(
                @Query("term") String searchableMusic);

//    @GET("/search?media=software&term=")
//    Call<Software> getSoftwareResults(
//            @Query("searchableSoftware") String searchableSoftware);

    }

