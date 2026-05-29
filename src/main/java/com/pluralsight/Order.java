package com.pluralsight;

import java.util.ArrayList;

public class Order
{

    private ArrayList<Product> products = new ArrayList<Product>();

    //Add products to the ArrayList
    public void addProduct(Product product)
    {
        this.products.add(product);
    }

    //Gets the total price of the order
    public double getOrderValue()
    {
        double price = 0;
        for(Product p: products)
        {
            price += p.getPrice();
        }
        return price;
    }

    //Checks if there is a Sandwich inside the order
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

    //Checks if there is a Chips or a Drink inside the order
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

    //This toString method is the heart of the receipt format. It takes in all products to output in the receipt
    @Override
    public String toString()
    {
        String thickSeperator = "========================================";
        String thinSeperator =  "----------------------------------------";

        String display = "";
        int itemNum = 1;     //Keep track of the itemNumber
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
