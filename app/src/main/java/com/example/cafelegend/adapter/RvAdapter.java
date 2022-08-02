package com.example.cafelegend.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafelegend.Item;
import com.example.cafelegend.ItemDetail;
import com.example.cafelegend.R;
import com.example.cafelegend.model.ItemList;

import java.util.Vector;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{
    Context context;
    Vector<ItemList> itemListVector;
    Dialog dialog;

    public RvAdapter(Context context, Vector<ItemList> itemListVector){
        this.context = context;
        this.itemListVector = itemListVector;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.listItemLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemList item = itemListVector.get(viewHolder.getAdapterPosition());
                Intent intent = new Intent(context, ItemDetail.class);
                intent.putExtra("detailImage", item.getItemImage());
                intent.putExtra("detailName", item.getItemName());
                intent.putExtra("detailPrice", item.getItemPrice());
                intent.putExtra("detailDesc", item.getItemDesc());
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder holder, int position) {
        ItemList item = itemListVector.get(position);
        holder.itemImageIV.setImageResource(item.getItemImage());
        holder.itemNameTV.setText(item.getItemName());
        holder.itemPriceTV.setText("IDR " + item.getItemPrice());
    }

    @Override
    public int getItemCount() {
        return itemListVector.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout listItemLL;
        private ImageView itemImageIV;
        private TextView itemNameTV, itemPriceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemLL = itemView.findViewById(R.id.listItemLL);
            itemImageIV = itemView.findViewById(R.id.itemImageIV);
            itemNameTV = itemView.findViewById(R.id.itemNameTV);
            itemPriceTV = itemView.findViewById(R.id.itemPriceTV);
        }
    }

}
