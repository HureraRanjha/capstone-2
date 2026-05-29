package com.pluralsight;

import com.pluralsight.Enums.*;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterface
{
    private Order order;
    Scanner scanner = new Scanner(System.in);
    RecieptWriter recieptWriter = new RecieptWriter();

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
                case 2 -> displayDrinkScreen();
                case 3 -> displayChipsScreen();
                case 4 ->
                {
                    if (!order.containsSandwiches() && !order.containsSmallItem())
                    {
                        System.err.println("If you dont buy a sandwich you MUST purchase a drink or a chips bag");
                    }
                    else displayCheckoutScreen();
                }
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

        boolean hasExtraMeat = false;
        if(meat != null) hasExtraMeat = displayExtraMeat();

        Cheese cheese = displayCheese();

        boolean hasExtraCheese = false;
        if(cheese != null) hasExtraCheese = displayExtraCheese();

        HashSet<Toppings> toppings = displayToppings();

        HashSet<Sauces> sauces = displaySauces();

        HashSet<Sides> sides = displaySides();

        boolean isToasted = displayWantToasted();

        Sandwich sandwich = new Sandwich(bread, sandwichSize, meat, hasExtraMeat, cheese, hasExtraCheese, toppings, sauces, sides, isToasted);

        order.addProduct(sandwich);

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

    private Cheese displayCheese()
    {
        String wantCheese;

        System.out.println("""
                Do you want cheese? (yes/no)
                """);
        wantCheese = scanner.nextLine();
        if(wantCheese.equalsIgnoreCase("no")) return null;

        int userInput;
        do
        {
            System.out.println("""
                What type of cheese do you want?
                1. American
                2. Provolone
                3. Cheddar
                4. Swiss
                """);
            userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 1) return Cheese.AMERICAN;
            else if (userInput == 2) return Cheese.PROVOLONE;
            else if (userInput == 3) return Cheese.CHEDDAR;
            else if (userInput == 4) return Cheese.SWISS;
            else System.err.println("Invalid Input. Try again");
        } while(true);
    }

    private boolean displayExtraCheese()
    {
        System.out.println("""
                Do you want extra cheese? (yes/no)
                
                """);
        String wantExtraCheese = scanner.nextLine();

        return wantExtraCheese.equalsIgnoreCase("yes");
    }

    private HashSet<Toppings> displayToppings()
    {
        HashSet<Toppings> toppings = new HashSet<>();
        String wantToppings;

        System.out.println("""
                Do you want toppings? (yes/no)
                
                """);
        wantToppings = scanner.nextLine();
        if(wantToppings.equalsIgnoreCase("no")) return toppings;

        int userInput;
        do
        {
            System.out.println("""
                What type of toppings do you want?
                1. Lettuce
                2. Peppers
                3. Onions
                4. Tomatoes
                5. Jalapenos
                6. Cucumbers
                7. Pickles
                8. Guacamole
                9. Mushrooms
                0. Done
                """);

            userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 1) toppings.add(Toppings.LETTUCE);
            else if (userInput == 2)  toppings.add(Toppings.PEPPERS);
            else if (userInput == 3)  toppings.add(Toppings.ONIONS);
            else if (userInput == 4)  toppings.add(Toppings.TOMATOES);
            else if (userInput == 5)  toppings.add(Toppings.JALAPENOS);
            else if (userInput == 6)  toppings.add(Toppings.CUCUMBERS);
            else if (userInput == 7)  toppings.add(Toppings.PICKLES);
            else if (userInput == 8)  toppings.add(Toppings.GUACAMOLE);
            else if (userInput == 9)  toppings.add(Toppings.MUSHROOMS);
            else if (userInput == 0) return toppings;
            else System.err.println("Invalid Input. Try again");
        } while(true);
    }

    private HashSet<Sauces> displaySauces()
    {
        HashSet<Sauces> sauces = new HashSet<>();
        String wantSauces;

        System.out.println("""
                Do you want sauces? (yes/no)
                
                """);
        wantSauces = scanner.nextLine();
        if(wantSauces.equalsIgnoreCase("no")) return sauces;

        int userInput;
        do
        {
            System.out.println("""
                What type of sauces do you want?
                1. Mayo
                2. Mustard
                3. Ketchup
                4. Ranch
                5. Thousand_Islands
                6. Vinaigrette
                0. Done
                """);

            userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 1) sauces.add(Sauces.MAYO);
            else if (userInput == 2)  sauces.add(Sauces.MUSTARD);
            else if (userInput == 3)  sauces.add(Sauces.KETCHUP);
            else if (userInput == 4)  sauces.add(Sauces.RANCH);
            else if (userInput == 5)  sauces.add(Sauces.THOUSAND_ISLANDS);
            else if (userInput == 6)  sauces.add(Sauces.VINAIGRETTE);
            else if (userInput == 0) return sauces;
            else System.err.println("Invalid Input. Try again");
        } while(true);
    }

    private HashSet<Sides> displaySides()
    {
        HashSet<Sides> sides = new HashSet<>();
        String wantSides;

        System.out.println("""
                Do you want sides? (yes/no)
                
                """);
        wantSides = scanner.nextLine();
        if(wantSides.equalsIgnoreCase("no")) return sides;

        int userInput;
        do
        {
            System.out.println("""
                What type of sides do you want?
                1. Au jus
                2. Sauce
                0. Done
                """);

            userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 1) sides.add(Sides.AU_JUS);
            else if (userInput == 2)  sides.add(Sides.SAUCE);
            else if (userInput == 0) return sides;
            else System.err.println("Invalid Input. Try again");
        } while(true);
    }

    private boolean displayWantToasted()
    {
        System.out.println("""
                Would you like the sandwich toasted?? (yes/no)
                
                """);
        String wantToasted = scanner.nextLine();

        return wantToasted.equalsIgnoreCase("yes");
    }

    private void displayDrinkScreen()
    {
        System.out.println("""
            What size drink do you want?
            1. Small
            2. Medium
            3. Large
            0. Cancel
            """);

        int userInput = Integer.parseInt(scanner.nextLine());

        if (userInput == 1) order.addProduct(new Drink(DrinkSize.SMALL));
        else if (userInput == 2)  order.addProduct(new Drink(DrinkSize.MEDIUM));
        else if (userInput == 3)  order.addProduct(new Drink(DrinkSize.LARGE));
        else if (userInput == 0) {}
        else System.err.println("Invalid Input. Try again");
    }

    private void displayChipsScreen()
    {
        String wantChips;

        System.out.println("""
                Do you want chips? (yes/no)
                
                """);
        wantChips = scanner.nextLine();
        if(wantChips.equalsIgnoreCase("yes")) order.addProduct(new Chips());
    }

    private void displayCheckoutScreen()
    {
        System.out.println(order);
        System.out.println("This is the current order. Are you ok with it? (yes/no) ");
        String userInput = scanner.nextLine();

        if(userInput.equalsIgnoreCase("no")) return;

        recieptWriter.printReciept(order);
    }
    //private void displayProducts(Arra)
}
