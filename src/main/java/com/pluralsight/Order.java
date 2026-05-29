package com.pluralsight;

import java.util.ArrayList;

public class Order
{
    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProduct(Product product)
    {
        this.products.add(product);
    }

    public double getOrderValue()
    {
        double price = 0;
        for(Product p: products)
        {
            price += p.getPrice();
        }
        return price;
    }

    public void displayOrder()
    {
        String display = "";
        for(Product p: products)
        {
            display += p;
        }

        System.out.println(display);
    }


}
