package com.example.CardsJavaFX;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DealHandOfCardsController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView deckImageView;

    @FXML
    private VBox deckVBox;

    private DeckOfCards deck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new DeckOfCards();
        deck.shuffle();
    }

    @FXML
    private void dealCards() {
        ArrayList<Card> hand = new ArrayList<>();

        // Deal out the top 5 cards into the hand
        for (int i = 1; i < 5; i++) {
            Card card = deck.dealTopCard();

            if (card == null) {
                deckImageView.setVisible(false);
                break;
            }

            hand.add(card);

            // Create new ImageView object and add to the anchor pane
            ImageView imageView = new ImageView();
            imageView.setFitWidth(190);
            imageView.setFitHeight(287);

            // Get coordinates of top-left corner of the card
            double deckPositionX = deckVBox.getLayoutX();
            double deckPositionY = deckVBox.getLayoutY();

            // Configure the new Card object to be positioned on top of the deck of cards
            imageView.setLayoutX(deckPositionX);
            imageView.setLayoutY(deckPositionY);

            // Add the image to the newly created Card
            imageView.setImage(new Image(getClass().getResource("images/redCardBack.png").toExternalForm()));

            // Add the new Card image to the anchor pane
            anchorPane.getChildren().add(imageView);

            // Animate the card to slide across the table
            TranslateTransition transition = new TranslateTransition();
            transition.setNode(imageView);
            transition.setDuration(Duration.millis(2000));
            transition.setByX(300 + (i * 50));
            transition.play();

            // Add an event handler for a mouse click on the imageview holding the card
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageView.setImage(card.getCardImage());
                }
            });
        }
    }
}