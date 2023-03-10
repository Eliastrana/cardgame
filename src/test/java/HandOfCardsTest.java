import edu.ntnu.idatt2001.HandOfCards;
import edu.ntnu.idatt2001.PlayingCard;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

    private final PlayingCard aceOfSpades = new PlayingCard('S', 1);
    private final PlayingCard fiveOfHearts = new PlayingCard('H', 5);
    private final PlayingCard kingOfDiamonds = new PlayingCard('D', 13);
    private final PlayingCard nineOfClubs = new PlayingCard('C', 9);

    @Test
    void testGetCard() {
        Collection<PlayingCard> hand = Arrays.asList(aceOfSpades, fiveOfHearts, kingOfDiamonds, nineOfClubs);
        HandOfCards handOfCards = new HandOfCards(hand);

        assertEquals(aceOfSpades, handOfCards.getCard(0));
        assertEquals(fiveOfHearts, handOfCards.getCard(1));
        assertEquals(kingOfDiamonds, handOfCards.getCard(2));
        assertEquals(nineOfClubs, handOfCards.getCard(3));
    }

    @Test
    void testSumOfHand() {
        Collection<PlayingCard> hand = Arrays.asList(aceOfSpades, fiveOfHearts, kingOfDiamonds, nineOfClubs);
        HandOfCards handOfCards = new HandOfCards(hand);

        assertEquals(28, handOfCards.sumOfHand());
    }

    @Test
    void testCheckSameType() {
        Collection<PlayingCard> handWithSameType = Arrays.asList(aceOfSpades, kingOfDiamonds);
        Collection<PlayingCard> handWithDifferentType = Arrays.asList(aceOfSpades, fiveOfHearts);

        HandOfCards handOfCards = new HandOfCards(handWithSameType);
        assertTrue(handOfCards.checkSameType((ArrayList<PlayingCard>) handWithSameType));

        handOfCards = new HandOfCards(handWithDifferentType);
        assertFalse(handOfCards.checkSameType((ArrayList<PlayingCard>) handWithDifferentType));
    }

    @Test
    void testIsSameColor() {
        Collection<PlayingCard> handWithSameColor = Arrays.asList(aceOfSpades, kingOfDiamonds);
        Collection<PlayingCard> handWithDifferentColor = Arrays.asList(aceOfSpades, fiveOfHearts);

        assertTrue(HandOfCards.isSameColor((ArrayList<PlayingCard>) handWithSameColor));
        assertFalse(HandOfCards.isSameColor((ArrayList<PlayingCard>) handWithDifferentColor));
    }

    @Test
    void testToString() {
        Collection<PlayingCard> hand = Arrays.asList(aceOfSpades, fiveOfHearts, kingOfDiamonds, nineOfClubs);
        HandOfCards handOfCards = new HandOfCards(hand);

        assertEquals("AS 5H KD 9C ", handOfCards.toString());
    }

    @Test
    void testToSmallString() {
        Collection<PlayingCard> hand = Arrays.asList(aceOfSpades, fiveOfHearts, kingOfDiamonds, nineOfClubs);
        HandOfCards handOfCards = new HandOfCards(hand);

        assertEquals("28\nfalse\nfalse\n", handOfCards.toSmallString());
    }
}
