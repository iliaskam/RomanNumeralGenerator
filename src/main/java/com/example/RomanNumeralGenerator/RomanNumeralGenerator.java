package com.example.RomanNumeralGenerator;

public interface RomanNumeralGenerator {
    public String generate(int int_num); // convert from int -> roman
    public int parse(String roman_num); // convert from roman -> int
}
