package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecieptWriter
{
    String RECEIPT_PATH = "src/main/resources/";

    public void printReciept(Order order)
    {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedDateTime = today.format(formatter);
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(RECEIPT_PATH + formattedDateTime + ".txt"));

            bufferedWriter.write(order.toString());
            bufferedWriter.close();
        }
        catch(IOException e)
        {
            System.err.println("There was an I/O error");
        }
    }
}
