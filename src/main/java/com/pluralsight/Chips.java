package com.pluralsight;

public class Chips implements Product
{
    //This is an overriden method to get the price of a chips bag which is always 1.50
    @Override
    public double getPrice()
    {
        return 1.5;
    }

    //This toString Method helps output to the txt and console
    @Override
    public String toString()
    {
        return "Chips:          $" + getPrice() + "\n";
    }
}
