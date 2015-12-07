package ahhhlvin.c4q.nyc.itunesproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by alvin2 on 12/6/15.
 */


public class Result {
    @SerializedName("results")
    @Expose
    List<Music> musicResults;

}



