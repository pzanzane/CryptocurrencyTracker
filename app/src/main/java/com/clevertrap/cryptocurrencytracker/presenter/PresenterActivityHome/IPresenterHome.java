package com.clevertrap.cryptocurrencytracker.presenter.PresenterActivityHome;


import com.clevertrap.cryptocurrencytracker.views.HomeView.IViewHome;
import com.clevertrap.cryptocurrencytracker.views.IView;

public interface IPresenterHome {

    void attach(IViewHome iView);
    void dettach();
    void loadData();
}
