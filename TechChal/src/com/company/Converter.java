package com.company;

public class Converter implements RomanNumeralGenerator{

    private int single_roman_value(char ch) {
        // single_roman_value returns roman symbols value
        if (ch == 'I')
            return 1;
        if (ch == 'V')
            return 5;
        if (ch == 'X')
            return 10;
        if (ch == 'L')
            return 50;
        if (ch == 'C')
            return 100;
        if (ch == 'D')
            return 500;
        if (ch == 'M')
            return 1000;
        return -1;
    }

    @Override
    public void generate(int number) { // Convert from int -> roman
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // Only support numbers between 1 and 3999
        if (number < 1 || number > 3999) {
            System.out.println("Given number not supported");
        }else {
            // We get the number of thousands, hundreds, tens and units and add to the result the corresponding values from our arrays
            String result = thousands[number / 1000] + hundreds[(number % 1000) / 100] + tens[(number % 100) / 10] + units[number % 10];
            System.out.println(number + " = " + result);
        }
    }

    @Override
    public void parse(String roman_str) { // Convert from roman -> int
        int result = 0;
        for (int i = 0; i < roman_str.length(); i++) {
            // Getting value of every single symbol from roman number string
            int symbol1 = single_roman_value(roman_str.charAt(i));

            // We get the next symbol value if it exists
            if (i + 1 < roman_str.length()) {
                int symbol2 = single_roman_value(roman_str.charAt(i + 1));

                // Comparing both values
                if (symbol1 >= symbol2) {
                    // If value of current symbol is greater or equal to the next symbol we add it to the result
                    result = result + symbol1;
                }else {
                    // If value of current symbol is less than the next symbol we add (symbol2 - symbol1) to the result
                    result = result + symbol2 - symbol1;
                    i++;
                }
            }else {
                // If current symbol is the last of our roman number string we add its value to the result
                result = result + symbol1;
            }
        }
        System.out.println(roman_str + " = " + result);
    }
}
