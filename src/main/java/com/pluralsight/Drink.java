package com.pluralsight;

import com.pluralsight.Enums.DrinkSize;

public class Drink implements Product
{
    private DrinkSize size;

    public Drink(DrinkSize size)
    {
        this.size = size;
    }


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
}
