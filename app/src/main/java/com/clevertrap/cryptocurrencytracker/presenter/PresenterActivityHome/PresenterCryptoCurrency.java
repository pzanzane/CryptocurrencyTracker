package com.clevertrap.cryptocurrencytracker.presenter.PresenterActivityHome;

import android.util.Log;

import com.clevertrap.cryptocurrencytracker.client.clientcryptocurrency.CryptoResponse;
import com.clevertrap.cryptocurrencytracker.models.ModelCryptoCurrency;
import com.clevertrap.cryptocurrencytracker.pojo.PojoCryptoItem;
import com.clevertrap.cryptocurrencytracker.views.HomeView.IViewHome;

import java.util.List;

public class PresenterCryptoCurrency implements IPresenterHome{

    private IViewHome iView = null;

    @Override
    public void attach(IViewHome iView) {
        this.iView=iView;
    }

    @Override
    public void dettach() {
        iView = null;
    }

    @Override
    public void loadData() {
        if(iView== null){
            return;
        }

        //Todo: Load data

        new ModelCryptoCurrency().loadCryptocurrency(callBack);

        iView.showProgress();
    }

    private ModelCryptoCurrency.CallbackCryptoDownloaded callBack = new ModelCryptoCurrency.CallbackCryptoDownloaded() {
        @Override
        public void onCryptoLoaded(List<PojoCryptoItem> list) {

            Log.d("WASTE","List: "+list.size());

            iView.loadDataSuccess(list);
        }

        @Override
        public void onCryptoLoadFailed(String message) {
            Log.d("WASTE","Error Message: "+message);
            iView.loadDataFailed(message);
        }
    };
}
