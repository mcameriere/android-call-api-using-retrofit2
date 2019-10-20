package com.example.callapi;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-web-api.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IntenseTundraService service = retrofit.create(IntenseTundraService.class);

        service.listPlayers().enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {

                ArrayAdapter<Player> adapter = new ArrayAdapter<>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        response.body()
                );

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {

            }
        });
    }
}
