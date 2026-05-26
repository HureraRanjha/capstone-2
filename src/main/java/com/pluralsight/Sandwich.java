package com.pluralsight;

import com.pluralsight.Enums.*;

import java.util.HashSet;

public class Sandwich implements Product
{
    private Bread bread;
    private int sandwichSize;

    private Ingredients meat;
    private boolean hasExtraMeat;

    private Cheese cheese;
    private boolean hasExtraCheese;

    private HashSet<Toppings> toppings = new HashSet<Toppings>();
    private HashSet<Sauces> sauces = new HashSet<Sauces>();
    private HashSet<Sides> sides = new HashSet<Sides>();

    private boolean isToasted;

    public Sandwich(Bread bread, int sandwichSize, Ingredients meat, boolean hasExtraMeat, Cheese cheese, boolean hasExtraCheese, HashSet<Toppings> toppings, HashSet<Sauces> sauces, HashSet<Sides> sides, boolean isToasted)
    {
        this.bread = bread;
        this.sandwichSize = sandwichSize;
        this.meat = meat;
        this.hasExtraMeat = hasExtraMeat;
        this.cheese = cheese;
        this.hasExtraCheese = hasExtraCheese;
        this.toppings = toppings;
        this.sauces = sauces;
        this.sides = sides;
        this.isToasted = isToasted;
    }

    public Bread getBread()
    {
        return bread;
    }

    public int getSandwichSize()
    {
        return sandwichSize;
    }

    public Ingredients getMeat()
    {
        return meat;
    }

    public boolean isHasExtraMeat()
    {
        return hasExtraMeat;
    }

    public Cheese getCheese()
    {
        return cheese;
    }

    public boolean isHasExtraCheese()
    {
        return hasExtraCheese;
    }

    public HashSet<Toppings> getToppings()
    {
        return toppings;
    }

    public HashSet<Sauces> getSauces()
    {
        return sauces;
    }

    public HashSet<Sides> getSides()
    {
        return sides;
    }

    public boolean isToasted()
    {
        return isToasted;
    }

    //Check if this method needs duplicate toppings handling
    public void addTopping(Toppings topping)
    {
        toppings.add(topping);
    }

    public void addSauce(Sauces sauce)
    {
        sauces.add(sauce);
    }

    public void addSide(Sides side)
    {
        sides.add(side);
    }

    @Override
    public double getPrice()
    {
        double total = 0;
        switch(this.sandwichSize)
        {
            case 4:
                total += 5.50;
                if(meat != null) total += 1;
                if(hasExtraMeat) total += .5;
                if(cheese != null) total += 0.75;
                if(hasExtraCheese) total += 0.3;
            case 8:
                total += 7.0;
                if(meat != null) total += 2;
                if(hasExtraMeat) total += 1.0;
                if(cheese != null) total += 1.5;
                if(hasExtraCheese) total += 0.6;
            case 12:
                total += 8.50;
                if(meat != null) total += 3;
                if(hasExtraMeat) total += 1.5;
                if(cheese != null) total += 2.25;
                if(hasExtraCheese) total += 0.9;
        }
        return total;
    }
}
