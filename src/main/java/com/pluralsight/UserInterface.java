package com.pluralsight;

import com.pluralsight.Enums.Bread;
import com.pluralsight.Enums.Ingredients;

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

        int sandwichSize = displaySandwichSize();

        Ingredients meat = displayMeat();

        boolean hasExtraMeat;
        if(meat != null) hasExtraMeat = displayExtraMeat();


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

    private int displaySandwichSize()
    {
        int userInput;
        do
        {
            System.out.println("""
                
                What size of bread do you want (4, 8, or 12 inches)?
                
                """);
            userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 4 || userInput == 8 || userInput == 12) return userInput;
            else System.err.println("Invalid Input. Try again");
        } while(true);
    }

    private Ingredients displayMeat()
    {
        String wantMeat;

        System.out.println("""
                Do you want meat? (yes/no)
                
                """);
        wantMeat = scanner.nextLine();
        if(wantMeat.equalsIgnoreCase("no")) return null;

        int userInput;
        do
        {
            System.out.println("""
                What type of meat do you want?
                1. Steak
                2. Ham
                3. Salami
                4. Roast_Beef
                5. Chicken
                6. Bacon
                
                """);
            userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 1) return Ingredients.STEAK;
            else if (userInput == 2) return Ingredients.HAM;
            else if (userInput == 3) return Ingredients.SALAMI;
            else if (userInput == 4) return Ingredients.ROAST_BEEF;
            else if (userInput == 5) return Ingredients.CHICKEN;
            else if (userInput == 6) return Ingredients.BACON;
            else System.err.println("Invalid Input. Try again");
        } while(true);
    }

    private boolean displayExtraMeat()
    {
        System.out.println("""
                Do you want extra meat? (yes/no)
                
                """);
        String wantExtraMeat = scanner.nextLine();

        return wantExtraMeat.equalsIgnoreCase("yes");
    }



    //private void displayProducts(Arra)
}
