package edu.HW1;

import java.io.File;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //read a file
        try{  
            File file=new File("C:\\Users\\User\\Documents\\Eclipse\\PhoneBookApplication\\src\\edu\\HW1\\prizeList.txt");    //creates a new file instance 
            Scanner sc = new Scanner(file);//file to be scanned 
            String FinalStringArray[]=new String[0];  
            int PricesArray[]=new int[0];    
            while (sc.hasNextLine()) {       //returns true if and only if scanner has another token  
                String LineData[]=sc.nextLine().split("\t"); 
                if(LineData.length == 2){
                    //creates a new array that is longer than the original array
                    String[] TemporaryStringArray = new String[FinalStringArray.length + 1];
                    for (int i = 0; i < FinalStringArray.length; i++){
                        TemporaryStringArray[i] = FinalStringArray[i];
                    }
                    TemporaryStringArray[TemporaryStringArray.length - 1] = LineData[0];
                    FinalStringArray = TemporaryStringArray;
                    
                    int[] TemporaryIntegerArray = new int[PricesArray.length + 1];
                    for (int i = 0; i < PricesArray.length; i++){
                        TemporaryIntegerArray[i] =PricesArray[i];
                    }
                    TemporaryIntegerArray[TemporaryIntegerArray.length - 1] = Integer.parseInt(LineData[1]);
                    PricesArray = TemporaryIntegerArray;
                }
            }
            
            //randomly generate 5 numbers, between 0 and the length of the array
            int[] randomNumbers = new int[5];
            for (int i = 0; i < randomNumbers.length; i++){
                randomNumbers[i] = (int)(Math.random() * FinalStringArray.length);
            }
            
            //print the prizes corresponding to the random numbers
            //get user input
            Scanner input = new Scanner(System.in);
            
            for (int i = 0; i < randomNumbers.length; i++){
                System.out.println("#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#");
                System.out.println("The object is... " + FinalStringArray[randomNumbers[i]] + "!");
                System.out.println("Enter your guess for the price! ");
                String guess = input.nextLine();
                if (Integer.parseInt(guess)<=PricesArray[randomNumbers[i]]&&Integer.parseInt(guess)>=PricesArray[randomNumbers[i]]-1000){
                    System.out.println("You guessed correctly! You win!");
                }
                else{
                    System.out.println("You guessed incorrectly! You lose!");
                }
                System.out.println(FinalStringArray[randomNumbers[i]]+" Actual Price is: $" + PricesArray[randomNumbers[i]]);
            }
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }
}
