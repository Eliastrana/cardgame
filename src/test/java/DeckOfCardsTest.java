import static org.junit.jupiter.api.Assertions.*;


import edu.ntnu.idatt2001.HandOfCards;
import edu.ntnu.idatt2001.PlayingCard;
import edu.ntnu.idatt2001.HandOfCards;
import edu.ntnu.idatt2001.DeckOfCards;
import edu.ntnu.idatt2001.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckOfCardsTest {

    private DeckOfCards deck;

    @BeforeEach
    public void setUp() {
        deck = new DeckOfCards();
    }

    @Test
    public void testDeckCreation() {
        assertEquals(52, deck.totalDeck.size());
        Set<PlayingCard> uniqueCards = new HashSet<>(deck.totalDeck);
        assertEquals(52, uniqueCards.size());
    }

    @Test
    public void testShuffle() {
        DeckOfCards deck1 = new DeckOfCards();
        DeckOfCards deck2 = new DeckOfCards();
        deck1.shuffle();
        deck2.shuffle();
        assertNotEquals(deck1.totalDeck, deck2.totalDeck);
    }

    @Test
    public void testDrawHand() {
        ArrayList<PlayingCard> hand = deck.drawHand(5);
        assertEquals(5, hand.size());
        Set<PlayingCard> uniqueCards = new HashSet<>(hand);
        assertEquals(5, uniqueCards.size());
    }
}
