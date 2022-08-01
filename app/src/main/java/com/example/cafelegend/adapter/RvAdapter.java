package com.example.cafelegend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafelegend.R;
import com.example.cafelegend.model.ItemList;

import java.util.Vector;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private Vector<ItemList> itemVector;

    public void setItemVector(Vector<ItemList> itemVector) {
        this.itemVector = itemVector;
    }

    public RvAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder holder, int position) {
        ItemList item = itemVector.get(position);
        holder.itemNameTV.setText(item.getItemName());
        holder.itemPriceTV.setText("IDR" + item.getItemPrice());

    }

    @Override
    public int getItemCount() {
        return itemVector.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTV, itemPriceTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemNameTV = itemView.findViewById(R.id.itemNameTV);
            itemPriceTV = itemView.findViewById(R.id.itemPriceTV);
        }
    }
}
