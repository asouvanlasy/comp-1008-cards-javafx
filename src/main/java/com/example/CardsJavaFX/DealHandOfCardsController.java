package com.example.CardsJavaFX;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DealHandOfCardsController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView deckImageView;

    @FXML
    private VBox deckVbox;

    private DeckOfCards deck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new DeckOfCards();
    }

    @FXML
    private void dealCards() {
        ArrayList<Card> hand = new ArrayList<>();

        // Deal out the top 5 cards into the hand
        for (int i = 1; i < 5; i++) {
            Card card = deck.dealTopCard();
            hand.add(card);

            // Create new ImageView object and add to the anchor pane
            ImageView imageView = new ImageView();
            deckImageView.setFitWidth(190);
            deckImageView.setFitHeight(287);

            // Get coordinates of top-left corner of the card
            double deckPositionX = deckImageView.getLayoutX();
            double deckPositionY = deckImageView.getLayoutY();

            // Configure the new Card object to be positioned on top of the deck of cards
            imageView.setLayoutX(deckPositionX);
            imageView.setLayoutY(deckPositionY);

            // Add the image to the newly created Card
            imageView.setImage(card.getCardImage());
        }
    }
}