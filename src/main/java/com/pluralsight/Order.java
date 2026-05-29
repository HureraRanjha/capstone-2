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

    public boolean containsSandwiches()
    {
        for(Product p: products)
        {
            if(p instanceof Sandwich)
            {
                return true;
            }
        }
        return false;
    }

    public boolean containsSmallItem()
    {
        for(Product p: products)
        {
            if(p instanceof Chips || p instanceof Drink)
            {
                return true;
            }
        }
        return false;
    }

    //Improve the output
    @Override
    public String toString()
    {
        String thickSeperator = "========================================";
        String thinSeperator =  "----------------------------------------";

        String display = "";
        int itemNum = 1;
        for(Product p: products)
        {
            display += itemNum + ") " + p;
        }

        return String.format("""
                %s
                            H & H NYC DELI
                                Receipt
                %s
                
                %s%s
                                      TOTAL:   $%.2f
                %S
                        Thank you for dropping by!
                %s
                """, thickSeperator, thickSeperator, display, thinSeperator, getOrderValue(), thickSeperator, thickSeperator);
    }


}
