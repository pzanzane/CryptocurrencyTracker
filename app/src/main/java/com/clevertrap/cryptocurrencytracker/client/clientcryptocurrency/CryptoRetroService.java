package com.clevertrap.cryptocurrencytracker.client.clientcryptocurrency;

import com.clevertrap.cryptocurrencytracker.constant.Constants;
import com.clevertrap.cryptocurrencytracker.pojo.PojoCryptoItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoRetroService {

    @GET(Constants.API)
    Call<List<PojoCryptoItem>> getCryptos();

}
