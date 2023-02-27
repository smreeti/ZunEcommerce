package com.movilecourse.zunecommerce.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.movilecourse.zunecommerce.CartActivity;
import com.movilecourse.zunecommerce.CheckoutActivity;
import com.movilecourse.zunecommerce.Domain.CartDomain;
import com.movilecourse.zunecommerce.Domain.CategoryDomain;
import com.movilecourse.zunecommerce.Domain.ProductDomain;
import com.movilecourse.zunecommerce.Helper.CartManagment;
import com.movilecourse.zunecommerce.Interface.ChangeNumberItemsListener;
import com.movilecourse.zunecommerce.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    List<CartDomain> productsSelected;
    private CartManagment cartManagment;
    ChangeNumberItemsListener changeNumberItemsListener;


    public CartListAdapter(List<CartDomain> productsSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.productsSelected = productsSelected;
        cartManagment = new CartManagment(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_viewholder, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(productsSelected.get(position).getProductName());
        holder.feeEachItem.setText("$"+productsSelected.get(position).getProductUnitPrice());
        holder.totalEachItem.setText("$"+ Math.round(productsSelected.get(position).getProductQuantity() * productsSelected.get(position).getProductUnitPrice()));
        holder.num.setText(String.valueOf(productsSelected.get(position).getProductQuantity()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(productsSelected.get(position).getProductImage(),"drawable", holder.itemView.getContext().getPackageName());
        holder.pic.setImageResource(drawableResourceId);

        holder.deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartManagment.deleteItemFromCart(productsSelected.get(holder.getAdapterPosition()));
                view.getContext().startActivity(new Intent(view.getContext(), CartActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, feeEachItem;
        ImageView pic, deleteImage;
        TextView totalEachItem, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtproductTitle);
            pic = itemView.findViewById(R.id.imageView4);
            feeEachItem = itemView.findViewById(R.id.txtFeeEachItem);
            totalEachItem = itemView.findViewById(R.id.txtTotalEachItem);
            num = itemView.findViewById(R.id.txtNumberItem);
            deleteImage = itemView.findViewById(R.id.btnDeleteProductCart);
        }
    }
}
