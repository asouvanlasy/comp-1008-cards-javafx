package com.example.CardsJavaFX;

public class SimpleValidation {
    public static void main(String[] args) {
        String name = " Johnny";

        // trim() removes spaces
        // matches() checks that the first character is uppercase
        // and the rest is lowercase
        if (name.trim().matches("[A-Z][a-z]*"))
            System.out.println("Successful validation for: " + name);
        else
            System.out.println("Failed validation for: " + name);

        String areaCode = "416";
        if (areaCode.matches("[2-9][0-9][0-9]"))
            System.out.println("Valid phone number: " + name);
        else
            System.out.println("Invalid phone number: " + name);
    }
}
