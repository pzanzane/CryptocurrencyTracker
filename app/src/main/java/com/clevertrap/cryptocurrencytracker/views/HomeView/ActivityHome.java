package com.clevertrap.cryptocurrencytracker.views.HomeView;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.clevertrap.cryptocurrencytracker.adapter.AdapterCryptocurrency;
import com.clevertrap.cryptocurrencytracker.pojo.PojoCryptoItem;
import com.clevertrap.cryptocurrencytracker.R;
import com.clevertrap.cryptocurrencytracker.presenter.PresenterActivityHome.PresenterCryptoCurrency;

import java.util.List;

public class ActivityHome extends AppCompatActivity implements IViewHome {

    private PresenterCryptoCurrency presenterCryptoCurrency = null;
    private AdapterCryptocurrency adapter = null;

    private RecyclerView recycleView = null;
    private ProgressBar progressBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recycleView = findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.addItemDecoration(getDivider(DividerItemDecoration.VERTICAL));

        progressBar = findViewById(R.id.progressBar);
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
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        //Todo: Hide Progress

        Log.d("WASTE","hideProgress");
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loadDataSuccess(List<PojoCryptoItem> list) {
        //Todo: adapter attach
        Log.d("WASTE","loadDataSuccess : "+list.get(0).getName());
        adapter = new AdapterCryptocurrency(list);
        recycleView.setAdapter(adapter);
        recycleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadDataFailed(String message) {
        //Todo: Show Toast
        Log.d("WASTE","loadDataFailed");
    }

    private DividerItemDecoration getDivider(int orientation){

        return new DividerItemDecoration(this,orientation);
    }
}
