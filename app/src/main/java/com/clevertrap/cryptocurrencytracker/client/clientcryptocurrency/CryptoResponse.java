package com.clevertrap.cryptocurrencytracker.client.clientcryptocurrency;

import com.clevertrap.cryptocurrencytracker.pojo.PojoCryptoItem;

import java.util.List;

public class CryptoResponse {

    private List<PojoCryptoItem> listItems = null;

    public List<PojoCryptoItem> getListItems() {
        return listItems;
    }

    public void setListItems(List<PojoCryptoItem> listItems) {
        this.listItems = listItems;
    }
}
