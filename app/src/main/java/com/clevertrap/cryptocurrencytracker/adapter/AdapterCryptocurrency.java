package com.clevertrap.cryptocurrencytracker.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clevertrap.cryptocurrencytracker.R;
import com.clevertrap.cryptocurrencytracker.pojo.PojoCryptoItem;

import java.util.List;

public class AdapterCryptocurrency extends RecyclerView.Adapter<AdapterCryptocurrency.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView = null;
        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txtName);

        }
    }

    private List<PojoCryptoItem> listModels = null;
    public AdapterCryptocurrency(List<PojoCryptoItem> listModels){
            this.listModels = listModels;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder holder = new ViewHolder(parent.inflate(parent.getContext(), R.layout.view_cryto_item,parent));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        PojoCryptoItem model = listModels.get(position);
        holder.textView.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }
}
