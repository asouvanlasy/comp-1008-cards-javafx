package com.example.CardsJavaFX;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    private ArrayList<Card> deck;

    /**
     * This is a constructor. Since we're building a generic deck of cards,
     * we do not need any args
     */
    public DeckOfCards() {
        deck = new ArrayList<>();

        // We need all the cards for each suit and each face name
        for (String suit : Card.getValidSuits()) {
            for (String faceName : Card.getValidFaceNames()) {
                // Create new Card object
                Card newCard = new Card(faceName,suit);
                deck.add(newCard);
            }
        }
    }

    /**
     * This method will deal the top card from the deck
     */
    public Card dealTopCard() {
        if (deck.size()>0) {
            return deck.remove(0);
        }
        else {
            return null;
        }
    }

    /**
     * This method will shuffle the deck
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
}
