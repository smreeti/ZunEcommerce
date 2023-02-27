package com.movilecourse.zunecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.movilecourse.zunecommerce.Adapter.CartListAdapter;
import com.movilecourse.zunecommerce.Helper.CartManagment;
import com.movilecourse.zunecommerce.Interface.ChangeNumberItemsListener;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private CartManagment cartManagment;
    private TextView txtTotal, txtDeliveryServices, txtTax, txtItemTotal, txtEmptyCard;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartManagment = new CartManagment(this);
        initView();
        initList();
        calculateCard();
        bottonNavigation();
    }

    private void bottonNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout checkOut = findViewById(R.id.checkoutBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, HomeActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, CartActivity.class));
            }
        });

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, CheckoutActivity.class));
            }
        });
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);

        adapter = new CartListAdapter(cartManagment.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);

        if(cartManagment.getListCart().isEmpty()){
            txtEmptyCard.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else{
            txtEmptyCard.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double percentageTax = 0.02; // change this for tax price
        double delivery = 10.00; // change this for delivery prices
        tax = Math.round((cartManagment.getTotalFee()*percentageTax) * 100.0)/ 100.0;
        double total = Math.round((cartManagment.getTotalFee() + tax + delivery) * 100.0) / 100.00;
        double itemTotal = Math.round(cartManagment.getTotalFee()*100.00) / 100.00;

        txtTotal.setText("$"+ total);
        txtTax.setText("$"+ tax);
        txtDeliveryServices.setText("$"+ delivery);
        txtItemTotal.setText("$"+ itemTotal);

    }

    private void initView() {
        txtTotal = findViewById(R.id.txtTotal);
        txtDeliveryServices = findViewById(R.id.txtDeliveryServices);
        txtTax = findViewById(R.id.txtTax);
        txtItemTotal = findViewById(R.id.txtItemTotal);
        recyclerViewList = findViewById(R.id.CartRecicleView);
        scrollView = findViewById(R.id.cardScrollView);
        txtEmptyCard = findViewById(R.id.txtEmptyCard);
    }
}