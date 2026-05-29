package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter
{
    String RECEIPT_PATH = "src/main/resources/receipts/";    //Updated Receipts Folder Path

    public void printReceipt(Order order)
    {
        LocalDateTime today = LocalDateTime.now();     //Get the current date time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"); //Add a formatter for the file name
        String formattedDateTime = today.format(formatter);
        try{
            File receiptsFolder = new File(RECEIPT_PATH);
            if(!receiptsFolder.exists()) receiptsFolder.mkdirs(); //Check if the receipts folder exits otherwise create it

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
