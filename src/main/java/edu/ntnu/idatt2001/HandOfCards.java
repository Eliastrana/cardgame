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
        char suit = hand.get(0).getSuit();
        for (int i = 1; i < hand.size(); i++) {
            if (hand.get(i).getSuit() != suit) {
                return false;
            }
        }
        return true;
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

    public String getHeartsString() {
        StringBuilder heartsString = new StringBuilder();
        for (PlayingCard card : hand) {
            if (card.getSuit() == 'H') {
                heartsString.append(card.getAsString()).append(" ");
            }
        }
        return heartsString.toString();
    }

    public boolean checkForQueenSpade() {
        StringBuilder heartsString = new StringBuilder();
        for (PlayingCard card : hand) {
            if (card.getSuit() == 'S' && card.getFace() == 12){
                heartsString.append(card.getAsString()).append(" ");
                return true;
            }
        }
        return false;
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
        return sumOfHand()  + "\n" + isSameColor((ArrayList<PlayingCard>) hand) + "\n"
                + checkSameType((ArrayList<PlayingCard>) hand) + "\n" + getHeartsString() + "\n" + checkForQueenSpade();
    }

    public static void main(String[] args) {
        HandOfCards hand = new HandOfCards();
        System.out.println(hand);
        System.out.println(hand.toSmallString());
    }
}
