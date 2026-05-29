# H & H NYC Deli #

## Description
This is a CLI app that allows users to create orders, 
add sandwiches, drinks, and chips. The user can customize their deli order however they see fit. Then the user can see the total price of their order and print out a receipt in a txt file.

## Features
- Build custom sandwiches 
- Add drinks and chips to any order
- Auto-generated timestamped receipts saved as a txt

## UML Diagram (outdated)
![Capstone-2 UML Diagram](/Capstone-2%20UML.png)

## Running the code
- Open the project using Intellij
- Run 'Main.java'

## The Code I'm Most Proud of
I am proud of the scanInt() function as that solve a problem that I had in 10 places in my program. 
Whenever I asked the user for a integer to select the correct option out of the given and they typed strings I would get a NumberFormatException. 
Instead of writing multiple lines of the try and catch statement I made a method that i could call every time that i wanted to run the method. 

```java
private int scanInt()
    {
        while(true)
        {
            try
            {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e)
            {
                System.err.println("Invalid Input. Enter a number! ");
            }
        }
    }

```

## My Personal Challenges 
During this week we had Monday off and I had EID so I couldnt give the capstone the attention that I wanted to. But I still think I satisfied the criteria. 
I believe finding the right planning tool to make the UML diagram was a difficult challenge. My friend Ahmad suggested using excel and he was right it was so much easier. 
I also spent too much time thinking over the implementation in the diagram when a lot of methods I didnt use and the way i thought i was going to strucutre it changed over time. 

## Next time...
I want to be able to make a GUI for the selections so that the user doesnt have to manually type everything in when it could all be buttons. 