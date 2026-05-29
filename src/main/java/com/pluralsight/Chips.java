package com.pluralsight;

public class Chips implements Product
{
    @Override
    public double getPrice()
    {
        return 1.5;
    }

    @Override
    public String toString()
    {
        return "Chips:          $" + getPrice() + "\n";
    }
}
