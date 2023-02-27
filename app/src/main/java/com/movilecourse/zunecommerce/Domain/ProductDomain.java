package com.movilecourse.zunecommerce.Domain;

import java.io.Serializable;

public class ProductDomain implements Serializable {
     private String title;
     private String picture;
     private String description;
     private Double price;
     private int rank;
     private String category;
     private int numberInCart;
     private String mainPicture;

     public ProductDomain(String title, String picture, String description, Double price, int rank, String category, String mainPicture) {
          this.title = title;
          this.picture = picture;
          this.description = description;
          this.price = price;
          this.rank = rank;
          this.category = category;
          this.mainPicture = mainPicture;
     }

     public String getMainPicture() {
          return mainPicture;
     }

     public void setMainPicture(String mainPicture) {
          this.mainPicture = mainPicture;
     }

     public int getNumberInCart() {
          return numberInCart;
     }

     public void setNumberInCart(int numberInCart) {
          this.numberInCart = numberInCart;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getPicture() {
          return picture;
     }

     public void setPicture(String picture) {
          this.picture = picture;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public Double getPrice() {
          return price;
     }

     public void setPrice(Double price) {
          this.price = price;
     }

     public int getRank() {
          return rank;
     }

     public void setRank(int rank) {
          this.rank = rank;
     }

     public String getCategory() {
          return category;
     }

     public void setCategory(String category) {
          this.category = category;
     }
}
