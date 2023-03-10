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


    public boolean checkSameType(ArrayList<PlayingCard> hand) {
        char suit = hand.get(0).getSuit(); // Get the suit of the first card in the hand
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getSuit() != suit) {
                return false; // If any other card has a different suit, return false
            }
        }
        return true; // All cards have the same suit, return true


    }


    public static boolean isSameColor(ArrayList<PlayingCard> hand) {
        int numRed = 0;
        int numBlack = 0;
        for (PlayingCard card : hand) {
            if (card.getSuit() == 'H' || card.getSuit() == 'D') {
                numRed++;
            } else {
                numBlack++;
            }
        }
        return numRed == 0 || numBlack == 0;
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
                sumOfHand()  + "\n" + isSameColor((ArrayList<PlayingCard>) hand)+ "\n"+ checkSameType((ArrayList<PlayingCard>) hand);

    }



    public static void main(String[] args) {
        HandOfCards hand = new HandOfCards();
        System.out.println(hand);
        System.out.println(hand.toSmallString());
    }



}
