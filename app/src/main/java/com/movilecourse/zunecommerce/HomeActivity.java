package com.movilecourse.zunecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.movilecourse.zunecommerce.Adapter.CategoryAdapter;
import com.movilecourse.zunecommerce.Adapter.ProductsAdapter;
import com.movilecourse.zunecommerce.Domain.CategoryDomain;
import com.movilecourse.zunecommerce.Domain.ProductDomain;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView.Adapter categorieAdapter, recommendedAdapter;
    private RecyclerView recyclerViewCategoryList, reciclerViewRecomendedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewCategory();
        recyclerViewRecommended();
        bottonNavigation();
    }

    private void bottonNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout checkOut = findViewById(R.id.checkoutBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CartActivity.class));
            }
        });

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CheckoutActivity.class));
            }
        });
    }

    private void recyclerViewRecommended(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        reciclerViewRecomendedList = findViewById(R.id.recommendedView);
        reciclerViewRecomendedList.setLayoutManager(linearLayoutManager);

        ArrayList<ProductDomain> products = new ArrayList<>();
        products.add(new ProductDomain(
                "Nike Air Max",
                "nike_air_max", "helps keeps your legs fresh late into the fourth quarter for better individual performances and team wins. Sneakers such as the Nike Air Zoom G.T. Run stacks a React footbed on top of a React midsole and Zoom Air in the forefoot to provide shock absorption and a responsive ride.",
                130.99, 5, "Nike", "nike_air_max"));

        products.add(new ProductDomain(
                "Nike Jordan",
                "nike_jordan", "The Jordan' Why Not?' line proves that speed is the most important factor on the court. With two stacked Zoom Air units in the forefoot for responsive cushioning, they help you harness more of your own speed to change the game.",
                179.99, 4, "Food", "nike_jordan"));

        products.add(new ProductDomain(
                "Air Jordan Nike",
                "air_jordan", "This shoes are all about speed and power. They have a full-length Zoom Air unit and Max Air in the heel to absorb impact and return energy. And the KnitPosite 2.0 upper provides a secure fit to help you move with confidence.",
                528.99, 4, "Food", "air_jordan"));

        products.add(new ProductDomain(
                "Basketball Nike",
                "basketball_nike", "Nike KD basketball shoes have a durable upper that uses minimal material for a broken-in feel. Full-length Zoom Air cushioning",
                310.99, 4, "Food", "basketball_nike"));

        products.add(new ProductDomain(
                "Nike AIR Jordan 6 Retro",
                "red_black_nike", "Designed by the legendary Tinker Hatfield, the sixth Air Jordan edition had everything fans loved previous models for.",
                799.99, 4, "Food", "red_black_nike"));

        products.add(new ProductDomain(
                "Nike Blazers",
                "nike_blazer", "Nike Women's W Blazer Low LX Red Stardust Sneakers, Rubber sole, Leather upper for durability and premium comfort, Autoclave construction fuses the outsole to the midsole for a streamlined look, Rubber outsole in a herringbone pattern for traction and durability.",
                499.99, 4, "Food", "nike_blazer"));

        products.add(new ProductDomain(
                "Nike Classic",
                "nike_classic", "The Nike Classic Cortez Leather is the original Nike running shoe perfected by an innovative, ultra-soft cushioning system. The shoe is made with a premium leather upper for comfort and durability and with the EVA wedge midsole for lightweight cushioning. Rubber sole provides unbeatable traction and resistance.",
                99.99, 4, "Food", "nike_classic"));

        recommendedAdapter = new ProductsAdapter(products);
        reciclerViewRecomendedList.setAdapter(recommendedAdapter);

    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.categorieView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categories = new ArrayList<>();
        categories.add(new CategoryDomain("Casual", "casual_cat"));
        categories.add(new CategoryDomain("Running", "running_cat"));
        categories.add(new CategoryDomain("Walking", "walking_cat"));
        categories.add(new CategoryDomain("Basketball", "basketball_cat"));
        categories.add(new CategoryDomain("Lifestyle", "lifestyle_cat"));
        categories.add(new CategoryDomain("Football", "football_cat"));

        categorieAdapter = new CategoryAdapter(categories);
        recyclerViewCategoryList.setAdapter(categorieAdapter);

    }
}