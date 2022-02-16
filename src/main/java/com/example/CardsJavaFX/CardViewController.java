package com.example.CardsJavaFX;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class CardViewController implements Initializable {

    //@FXML is an "annotation" - what this is doing is allowing a private variable to be shared between 2 files
    @FXML
    private Label cardNameLabel;

    @FXML
    private Label faceNameLabel;

    @FXML
    private Label suitLabel;

    @FXML
    private Label cardValueLabel;

    @FXML
    private ImageView imageView;

    private DeckOfCards deck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new DeckOfCards();
        deck.shuffle();
        showNextCard();
    }

    /**
     * This method will show the next card in the deck
     */
    @FXML
    private void showNextCard() {
        Card card = deck.dealTopCard();
        cardNameLabel.setText(card.toString());
        faceNameLabel.setText(card.getFaceName());
        suitLabel.setText(card.getSuit());
        cardValueLabel.setText(Integer.toString(card.getCardValue()));
        imageView.setImage(card.getCardImage());
    }
}
