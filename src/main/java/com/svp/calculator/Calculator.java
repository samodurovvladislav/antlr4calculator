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
                if (input.equalsIgnoreCase("exit") || input.isEmpty()) {
                    System.out.println("Goodbye, my love!");
                    scanner.close();
                    break;
                }

                CharStream expression = CharStreams.fromString(input);
                CalculatorLexer lexer = new CalculatorLexer(expression);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                CalculatorParser parser = new CalculatorParser(tokens);
                ParseTree tree = parser.start();
                CalculatorFinalVisitor calculator = new CalculatorFinalVisitor();
                Double result = calculator.visit(tree);
                System.out.printf("Calculation result: %.2f%n%n", result);
            }
        }catch(Exception err){
            System.out.printf("Error while running program: %s", err.getMessage());
        }

    }
}
