package com.pluralsight;

import com.pluralsight.Enums.Bread;

import java.util.Scanner;

public class UserInterface
{
    private Order order;
    Scanner scanner = new Scanner(System.in);

    public void display()
    {
        displayHomeScreen();
    }

    private void displayHomeScreen()
    {
        boolean repeat = true;
        int userInput;
        do
        {
            System.out.println("""
                    1. New Order
                    2. Exit 
                    """);

            userInput = Integer.parseInt(scanner.nextLine());

            switch(userInput)
            {
                case 1 -> {
                    order = new Order();
                    displayOrderScreen();
                }
                case 2 -> repeat = false;
                default -> System.err.println("Invalid Input. Try again");
            }
        }
        while(repeat);
    }

    private void displayOrderScreen()
    {
        boolean repeat = true;
        int userInput;
        do
        {
            System.out.println("""
                    1. Add Sandwich
                    2. Add Drink
                    3. Add Chips
                    4. Checkout
                    0. Cancel Order 
                    """);

            userInput = Integer.parseInt(scanner.nextLine());

            switch(userInput)
            {
                case 1 -> displaySandwichScreen();
//                case 2 -> displayDrinkScreen();
//                case 3 -> displayChipsScreen();
//                case 4 -> displayCheckoutScreen();
                case 0 -> repeat = false;
                default -> System.err.println("Invalid Input. Try again");
            }
        }
        while(repeat);
    }

    private void displaySandwichScreen()
    {
        Bread bread = displayBread();
        //Sandwich sandwich = new Sandwich(bread)
    }

    private Bread displayBread()
    {
        int userInput;
        do
        {
            System.out.println("""
                What type of bread do you want?
                1. White
                2. Wheat
                3. Rye
                4. Wrap
                """);
            userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 1) return Bread.WHITE;
            else if (userInput == 2) return Bread.WHEAT;
            else if (userInput == 3) return Bread.RYE;
            else if (userInput == 4) return Bread.WRAP;
            else System.err.println("Invalid Input. Try again");
        } while(true);
    }

    //private void displayProducts(Arra)
}
