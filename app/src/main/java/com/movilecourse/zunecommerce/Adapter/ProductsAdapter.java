package com.movilecourse.zunecommerce.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.movilecourse.zunecommerce.Domain.ProductDomain;
import com.movilecourse.zunecommerce.ProductDetailActivity;
import com.movilecourse.zunecommerce.R;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    ArrayList<ProductDomain> productsDomain;

    public ProductsAdapter(ArrayList<ProductDomain> productsDomain) {
        this.productsDomain = productsDomain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_viewholder, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productTitle.setText(productsDomain.get(position).getTitle());
        holder.productPrice.setText(String.valueOf(productsDomain.get(position).getPrice()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(productsDomain.get(position).getPicture(),"drawable", holder.itemView.getContext().getPackageName());
        holder.productImage.setImageResource(drawableResourceId);

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ProductDetailActivity.class);
                intent.putExtra("object", (Serializable) productsDomain.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsDomain.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView productTitle;
        ImageView productImage;
        ImageView btnAdd;
        TextView productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.productTitle);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);
            btnAdd = itemView.findViewById(R.id.btnAdd);
        }
    }
}
