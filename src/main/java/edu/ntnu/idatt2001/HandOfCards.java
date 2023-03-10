package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.Collection;

public class HandOfCards {
    private final Collection<PlayingCard> hand;

    public HandOfCards() {
        this.hand = new DeckOfCards().drawHand(5);
    }

    public HandOfCards(Collection<PlayingCard> hand) {
        this.hand = hand;
    }

    public PlayingCard getCard(int index) {
        return (PlayingCard) hand.toArray()[index];
    }

    public int sumOfHand(){
        return hand.stream().mapToInt(PlayingCard::getFace).sum();
    }

    public int getNumberOfCards(){
        return hand.size();
    }


    public boolean checkSameType(ArrayList<PlayingCard> hand) {
        char suit = hand.get(0).getSuit(); // Get the suit of the first card in the hand
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getSuit() != suit) {
                return false; // If any other card has a different suit, return false
            }
        }
        return true; // All cards have the same suit, return true
    }





    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        for (PlayingCard card : hand) {
            handString.append(card.getAsString()).append(" ");
        }

        return handString.toString();
    }


    public String toSmallString(){
        return
                "Total value: " + sumOfHand() + "\n" + "Number of cards: " + getNumberOfCards() + "\n" + "Flush: " + checkSameType((ArrayList<PlayingCard>) hand);

    }



    public static void main(String[] args) {
        HandOfCards hand = new HandOfCards();
        System.out.println(hand);
        System.out.println(hand.toSmallString());
    }



}
