package com.clevertrap.cryptocurrencytracker.views.HomeView;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.clevertrap.cryptocurrencytracker.pojo.PojoCryptoItem;
import com.clevertrap.cryptocurrencytracker.R;
import com.clevertrap.cryptocurrencytracker.presenter.PresenterActivityHome.PresenterCryptoCurrency;

import java.util.List;

public class ActivityHome extends AppCompatActivity implements IViewHome {

    PresenterCryptoCurrency presenterCryptoCurrency = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        presenterCryptoCurrency = new PresenterCryptoCurrency();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        presenterCryptoCurrency.attach(this);
        presenterCryptoCurrency.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterCryptoCurrency.dettach();
    }

    @Override
    public void showProgress() {
        //Todo: SHow Progress
        Log.d("WASTE","showProgress");
    }

    @Override
    public void hideProgress() {
        //Todo: Hide Progress

        Log.d("WASTE","hideProgress");
    }

    @Override
    public void loadDataSuccess(List<PojoCryptoItem> list) {
        //Todo: adapter attach
        Log.d("WASTE","loadDataSuccess : "+list.size());
    }

    @Override
    public void loadDataFailed(String message) {
        //Todo: Show Toast
        Log.d("WASTE","loadDataFailed");
    }
}
