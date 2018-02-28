package com.clevertrap.cryptocurrencytracker.client;


import com.clevertrap.cryptocurrencytracker.constant.Constants;

import java.lang.annotation.Annotation;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceCreator {


    public static Converter<ResponseBody,ErrorBody> createErrorConvertor(){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.API)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        Converter<ResponseBody,ErrorBody> retrofitConvertor =
                retrofit.responseBodyConverter(ErrorBody.class,new Annotation[0]);

        return retrofitConvertor;
    }
    public static Retrofit createService(){

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        okBuilder.addInterceptor(LoggingInterceptor.getSingleton());

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okBuilder.build());

        Retrofit client = builder.build();

        return client;
    }
}
