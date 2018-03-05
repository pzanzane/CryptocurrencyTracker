package com.clevertrap.cryptocurrencytracker.adapter;


import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clevertrap.cryptocurrencytracker.R;
import com.clevertrap.cryptocurrencytracker.pojo.PojoCryptoItem;

import java.util.List;

public class AdapterCryptocurrency extends RecyclerView.Adapter<AdapterCryptocurrency.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textName = null;
        private TextView textSymbol = null;
        private TextView txtPrice = null;
        private TextView txtOneHourChange = null;
        private TextView txtTwentyFourHourChange = null;

        public ViewHolder(View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.txtName);
            textSymbol = itemView.findViewById(R.id.txtSymbol);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtTwentyFourHourChange = itemView.findViewById(R.id.txt24HPriceChange);
            txtOneHourChange = itemView.findViewById(R.id.txt1HPriceChange);

        }
    }

    private List<PojoCryptoItem> listModels = null;
    public AdapterCryptocurrency(List<PojoCryptoItem> listModels){
            this.listModels = listModels;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cryto_item,null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PojoCryptoItem model = listModels.get(position);
        holder.textName.setText(model.getName());
        holder.textSymbol.setText(model.getSymbol());
        holder.txtPrice.setText("$ " + model.getPriceUsd());
        holder.txtTwentyFourHourChange.setText(model.getTwentyFourHourChange());
        holder.txtOneHourChange.setText(model.getOneHourChange());

        int colorFourtyHour = Double.parseDouble(model.getTwentyFourHourChange())<0?Color.RED:Color.GREEN;
        int colorOneHour = Double.parseDouble(model.getOneHourChange())<0?Color.RED:Color.GREEN;

        holder.txtTwentyFourHourChange.setTextColor(colorFourtyHour);
        holder.txtOneHourChange.setTextColor(colorOneHour);

    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }
}
