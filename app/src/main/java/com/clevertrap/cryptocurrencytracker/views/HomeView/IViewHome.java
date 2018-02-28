package com.clevertrap.cryptocurrencytracker.views.HomeView;

import com.clevertrap.cryptocurrencytracker.pojo.PojoCryptoItem;
import com.clevertrap.cryptocurrencytracker.views.IView;

import java.util.List;

public interface IViewHome extends IView {

    void loadDataSuccess(List<PojoCryptoItem> list);
    void loadDataFailed(String message);
}
