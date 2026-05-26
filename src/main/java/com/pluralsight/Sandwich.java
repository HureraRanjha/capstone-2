package com.pluralsight;

import com.pluralsight.Enums.*;

import java.util.HashSet;

public class Sandwich
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



}
