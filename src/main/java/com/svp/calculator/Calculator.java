package com.svp.calculator;

import java.io.IOException;
import java.util.Scanner;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Calculator 
{
    public static void main( String[] args ) throws IOException
    {
        try{           
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println( "Input expression, please:");
               
                if (!scanner.hasNextLine()){
                    scanner.close();
                    break;
                }

                String input = scanner.nextLine();      
                if (input.equalsIgnoreCase("exit")){
                    scanner.close();
                    break;
                }          
                System.out.printf("User input was: %s%n", input);
                

            }
        }catch(Exception err){
            System.out.printf("Error while running program: %s", err.getMessage());
        }

    }
}
