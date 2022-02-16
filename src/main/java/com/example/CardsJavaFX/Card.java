package com.example.CardsJavaFX;

import javafx.scene.image.Image;
import java.util.Arrays;
import java.util.List;

public class Card {
    private String faceName, suit;
    private Image cardImage;

    /**
     * This is a constructor. It's different from a method for 2 reasons:
     * 1. No return type
     * 2. The name is the class name
     * @param faceName
     * @param suit
     */
    public Card(String faceName, String suit) {
        setFaceName(faceName);
        setSuit(suit);
        String fileName = String.format("images/%s_of_%s.png",faceName,suit);
        cardImage = new Image(getClass().getResource(fileName).toExternalForm());
    }

    public Image getCardImage() {
        return cardImage;
    }

    public String getFaceName() {
        return faceName;
    }

    /**
     * This method validates if the arg is a valid face name
     * @param faceName ex. "2", "3", "jack", "queen"
     */
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();
        if (getValidFaceNames().contains(faceName)) {
            this.faceName = faceName;
        }
        else {
            throw new IllegalArgumentException("Valid face names are: " + getValidFaceNames());
        }
    }

    public String getSuit() {
        return suit;
    }

    /**
     * This method validates an arg as one of the valid suits
     * (hearts, spades, clubs, diamonds)
     * @param suit
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase(); // Convert args into lowercase

        if (getValidSuits().contains(suit)) {
            this.suit = suit;
        }
        else {
            throw new IllegalArgumentException("Valid suits are: " + getValidSuits());
        }
    }

    /**
     * This is a static method, which means that it can be called without an instance
     * of the Card class.
     * It returns a list with all the valid suits.
     * @return
     */
    public static List<String> getValidSuits() {
        return Arrays.asList("spades","clubs","hearts","diamonds");
    }

    /**
     * This method returns a list of valid face names on regular playing cards
     * @return
     */
    public static List<String> getValidFaceNames() {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen","king","ace");
    }

    // Override toString method so it prints properly
    @Override
    public String toString() {
        return String.format("%s of %s",faceName,suit);
    }

    /**
     * This method returns the value of the card assuming that aces are high
     * 2=2, 3=3, 4=4, ..., 10=10, jack=11, queen=12, king=13, ace=14
     *
     * getValidFaceNames = "1","2","3","4","5","6","7","8","9","10","jack","queen","king","ace"
     * index position =     0   1   2   3   4   5   6   7   8   9     10     11      12    13
     */
    public int getCardValue() {
        return getValidFaceNames().indexOf(faceName) + 2;
    }
}
