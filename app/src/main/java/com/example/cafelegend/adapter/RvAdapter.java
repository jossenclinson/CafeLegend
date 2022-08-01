package com.example.cafelegend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafelegend.R;
import com.example.cafelegend.model.ItemList;

import java.util.Vector;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{
    Context context;
    Vector<ItemList> itemList;

    public RvAdapter(Context context, Vector<ItemList> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder holder, int position) {
        holder.itemNameTV.setText(itemList.get(position).getItemName());
        holder.itemPriceTV.setText(itemList.get(position).getItemPrice());
//        holder.itemImageIV.setImageResource(itemList.get(position).getItemImage());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageIV;
        private TextView itemNameTV, itemPriceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageIV = itemView.findViewById(R.id.itemImageIV);
            itemNameTV = itemView.findViewById(R.id.itemNameTV);
            itemPriceTV = itemView.findViewById(R.id.itemPriceTV);
        }
    }

}

//public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
//    private Context context;
//    private Vector<ItemList> itemVector;
//
//    public void setItemVector(Vector<ItemList> itemVector) {
//        this.itemVector = itemVector;
//    }
//
//    public RvAdapter(Context context) {
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder holder, int position) {
//        ItemList item = itemVector.get(position);
//        holder.itemNameTV.setText(item.getItemName());
//        holder.itemPriceTV.setText("IDR" + item.getItemPrice());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return itemVector.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView itemNameTV, itemPriceTV;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            itemNameTV = itemView.findViewById(R.id.itemNameTV);
//            itemPriceTV = itemView.findViewById(R.id.itemPriceTV);
//        }
//    }
//}
