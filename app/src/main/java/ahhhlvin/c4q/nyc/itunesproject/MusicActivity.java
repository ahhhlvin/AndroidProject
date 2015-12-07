package ahhhlvin.c4q.nyc.itunesproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.ResponseBody;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class MusicActivity extends AppCompatActivity {


    private final static String API = "https://itunes.apple.com";
    private ListView listView;
    private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listView);
        searchText = (EditText) findViewById(R.id.search_editText);
        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String searchable = searchText.getText().toString();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                iTunesService iTunes = retrofit.create(iTunesService.class);

                Call call = iTunes.getMusicResults(searchable);


                call.enqueue(new Callback<Result>() {

                    @Override
                    public void onResponse(Response<Result> response, Retrofit retrofit) {
                        Result result = response.body();

                        if (result == null) {
                            ResponseBody responseBody = response.errorBody();
                            Log.d("ALVIN", "ERROR: " + responseBody.toString());

                        }

                        // if GET request to API is successful
                        if (result != null) {

                            for (Music m : result.musicResults) {
                                Log.d("ALVIN", m.getSongName());
                            }

                            MusicBaseAdapter adapter = new MusicBaseAdapter(getApplicationContext(), result.musicResults);
                            listView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(MusicActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                    }

                });


            }
        });


    }


}
