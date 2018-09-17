package com.frijolie.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayingCardTest {

  private PlayingCard aceOfHearts;
  private PlayingCard nineOfDiamonds;
  private PlayingCard aceOfSpades;

  @BeforeEach
  void setUp() {
    aceOfHearts = new PlayingCard(Rank.ACE, Suit.HEARTS);
    nineOfDiamonds = new PlayingCard(Rank.NINE, Suit.DIAMONDS);
    aceOfSpades = new PlayingCard(Rank.ACE, Suit.SPADES);
  }

  @AfterEach
  void tearDown() {
    aceOfHearts = null;
    nineOfDiamonds = null;
    aceOfSpades = null;
  }

  @Test
  void testGetSuit_AceOfHeartsSuitShouldBeSuit_HEARTS() {
    assertEquals(Suit.HEARTS, aceOfHearts.getSuit(),
        "Was expecting Suit.HEARTS, instead received: " + aceOfHearts.getSuit());
  }

  @Test
  void testGetColor_AceOfHeartsColorShouldBeColor_Red() {
    assertEquals(CardColor.RED, aceOfHearts.getColor(),
        "Was expecting CardColor.RED, instead color was: " + aceOfHearts.getColor());
  }

  @Test
  void testGetRank_AceOfHeartsRankShouldBeACE() {
    assertEquals(Rank.ACE, aceOfHearts.getRank(),
        "Was expecting Rank.ACE, instead rank was: " + aceOfHearts.getRank());
  }

  @Test
  void testGetRankLetter_AceOfHeartsRankLetterShouldBeA() {
    assertEquals('A', aceOfHearts.getRankLetter(),
        "Was expecting 'A', instead rank letter was: " +
            aceOfHearts.getRankLetter());
  }

  @Test
  void testGetRankName_AceOfHeartsRankNameShouldBeAce() {
    assertEquals("Ace", aceOfHearts.getRankName(),
        "Was expecting 'Ace', instead rank name was: " + aceOfHearts.getRankName());
  }

  @Test
  void testToString_AceOfHeartsShouldReturnAce_Of_Hearts() {
    assertEquals("A" + aceOfHearts.getSymbol(), aceOfHearts.toString(),
        "Was expecting 'A♥', instead it was : " + aceOfHearts.toString());
  }

  @Test
  void testGetValue_AceOfHeartsShouldReturnInt_1() {
    assertEquals(1, aceOfHearts.getValue(),
        "Was expecting the value to be 1. Instead it is: " + aceOfHearts.getValue());
  }

  @Test
  void testCompareTo_AceOfHeartsComparedToNineOfDiamondsShouldReturnPositive2() {
    // Hearts suit.ordinal = 3, Diamonds suit.ordinal = 1. 3 - 1 = 2. Should return '2'
    assertEquals(2, aceOfHearts.compareTo(nineOfDiamonds),
        "Was expecting the difference to be 2, instead it is: " +
            aceOfHearts.compareTo(nineOfDiamonds));
  }

  @Test
  void testCompareTo_NineOfDiamondsComparedToAceOfHeartsShouldReturnNegative2() {
    // Diamonds suit.ordinal = 1, Hearts suit.ordinal = 3. 1 - 3 = -2. Should return '-2'
    assertEquals(-2, nineOfDiamonds.compareTo(aceOfHearts),
        "Was expecting the difference to be -2, instead it is: " +
            nineOfDiamonds.compareTo(aceOfHearts));
  }

  @Test
  void testCompareTo_AceOfHeartsComparedToAceOfSpadesShouldReturnPositive1() {
    // Ace has a value of 1. rank is equal (1 = 1). Now need to compare suits.
    // ♥ ordinal + 1 = 4, ♠ ordinal + 1 = 3. ♥(4) > ♠(3). compareTo should return 1
    assertEquals(1, aceOfHearts.compareTo(aceOfSpades),
        "Was expecting the difference to be 1, instead it is: " +
            aceOfHearts.compareTo(aceOfSpades));
  }

  @Test
  void testEquals_AceOfHeartsEqualToAceOfSpacesShouldBeFalse() {
    assertFalse(aceOfHearts.equals(aceOfSpades),
        "An AceOfHarts should not equal an AceOfSpades");
  }

  @Test
  void testEquals_AceOfHeartsEqualToAceOfHeartsShouldBeTrue() {
    assertEquals(aceOfHearts, aceOfHearts, "An AceOfHearts should equal another AceOfHearts");
  }

}