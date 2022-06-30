package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RomanNumeralGenerator convert; // Setting up converter
        convert = new Converter();

        while (true) {

            Scanner scan = new Scanner(System.in);
            System.out.print("Enter 1 for generate, 2 for parse and 0 for exit: ");
            // Scan user input. 1 for generate, 2 for parse and 0 for exit
            int input = scan.nextInt();

            if (input == 1) { // If input = 1, we scan integer number from user and call generate
                System.out.println("Enter integer: ");
                int number = scan.nextInt();
                convert.generate(number);
            } else if(input == 2) { // If input = 2, we scan roman number string from user and call parse
                scan.nextLine();
                System.out.println("Enter roman character: ");
                String roman = scan.nextLine();
                convert.parse(roman);
            } else if(input == 0) { // If input = 0, we end our program
                System.out.println("Exit");
                scan.close();
                break;
            } else { // User give us wrong input, so we print 'wrong input' and continue to our loop
                System.out.println("Wrong input");
            }
        }

    }
}
