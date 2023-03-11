package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private final int[] face = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
    public ArrayList<PlayingCard> totalDeck = new ArrayList<>();

    public DeckOfCards() {
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < face.length; j++) {
                totalDeck.add(new PlayingCard(suit[i], face[j]));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < totalDeck.size(); i++) {
            int randomIndex = random.nextInt(totalDeck.size());
            PlayingCard temp = totalDeck.get(randomIndex);
            totalDeck.set(randomIndex, totalDeck.get(i));
            totalDeck.set(i, temp);
        }
    }

    public ArrayList<PlayingCard> drawHand(int n) {
        shuffle(); // Shuffle the deck
        ArrayList<PlayingCard> hand = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            hand.add(totalDeck.get(i)); // Add the first n cards from the shuffled deck
        }
        return hand;
    }
}