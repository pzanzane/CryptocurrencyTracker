package com.clevertrap.cryptocurrencytracker.models;

import com.clevertrap.cryptocurrencytracker.client.ErrorBody;
import com.clevertrap.cryptocurrencytracker.client.RetrofitServiceCreator;
import com.clevertrap.cryptocurrencytracker.client.clientcryptocurrency.CryptoResponse;
import com.clevertrap.cryptocurrencytracker.client.clientcryptocurrency.CryptoRetroService;
import com.clevertrap.cryptocurrencytracker.pojo.PojoCryptoItem;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ModelCryptoCurrency {

    public interface CallbackCryptoDownloaded{
        void onCryptoLoaded(List<PojoCryptoItem> list);
        void onCryptoLoadFailed(String message);
    }

    private CallbackCryptoDownloaded callBack = null;
    private Converter<ResponseBody,ErrorBody> errorConvertor = null;

    public void loadCryptocurrency(CallbackCryptoDownloaded crytpoLoaded){

        errorConvertor = RetrofitServiceCreator.createErrorConvertor();

        callBack = crytpoLoaded;
        Retrofit retrofit = RetrofitServiceCreator.createService();
        CryptoRetroService cryptoRetroService = retrofit.create(CryptoRetroService.class);

        Call<List<PojoCryptoItem>> call = cryptoRetroService.getCryptos();

        call.enqueue(new Callback<List<PojoCryptoItem>>() {
            @Override
            public void onResponse(Call<List<PojoCryptoItem>> call, Response<List<PojoCryptoItem>> response) {

                if(response.isSuccessful()){
                    callBack.onCryptoLoaded(response.body());
                }else{

                    ErrorBody errorBody = null;
                    try {
                        errorBody = errorConvertor.convert(response.errorBody());
                    } catch (IOException e) {
                        e.printStackTrace();
                        errorBody = new ErrorBody(e.getMessage());
                    }

                    callBack.onCryptoLoadFailed(errorBody.getMessage());
                }

            }

            @Override
            public void onFailure(Call<List<PojoCryptoItem>> call, Throwable t) {
                callBack.onCryptoLoadFailed(t.getMessage());
            }
        });
    }
}
