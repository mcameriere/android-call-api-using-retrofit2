package com.example.callapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IntenseTundraService {
    @GET("players")
    Call<List<Player>> listPlayers();
}
