package com.pluralsight;

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
                case 1 -> displayOrderScreen();
                case 2 -> repeat = false;
                default -> System.out.println("Invalid Input. Try again");
            }
        }
        while(repeat);
    }

    private void displayOrderScreen()
    {
    }

    //private void displayProducts(Arra)
}
