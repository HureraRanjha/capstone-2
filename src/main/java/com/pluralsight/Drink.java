package com.pluralsight;

import com.pluralsight.Enums.DrinkSize;

public class Drink implements Product
{
    private DrinkSize size;

    //Drink constructor only takes DrinkSize enum
    public Drink(DrinkSize size)
    {
        this.size = size;
    }

    //Drink uses the enum to set the price so the user doesnt set a wrong price
    @Override
    public double getPrice()
    {
        double price;
        return price = switch(this.size)
        {
            case SMALL -> 2.0;
            case MEDIUM -> 2.5;
            case LARGE -> 3.0;
        };
    }

    //toString method is used to output to the receipt
    @Override
    public String toString()
    {
        return String.format("""
                Drink:           %.2f
                    Size: %s
                    
                """,
                getPrice(),
                size
        );
    }
}
