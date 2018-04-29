/*
 * The MIT License
 *
 * Copyright (c) 2018 Frijolie.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.frijolie.cards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class UnitTestHand {

  TestHand hand;
  TestDeck deck;

  @BeforeEach
  void setUp() throws Exception {
    hand = new TestHand();
    deck = new TestDeck();
  }

  @AfterEach
  void tearDown() throws Exception {
    hand.clearHand();
    hand = null;
    deck = null;
  }

  public void setRoyalFlush() {
    // Royal Flush
    hand.addCard(new PlayingCard(Rank.ACE, Suit.HEARTS));
    hand.addCard(new PlayingCard(Rank.KING, Suit.HEARTS));
    hand.addCard(new PlayingCard(Rank.QUEEN, Suit.HEARTS));
    hand.addCard(new PlayingCard(Rank.JACK, Suit.HEARTS));
    hand.addCard(new PlayingCard(Rank.TEN, Suit.HEARTS));
  }

  public void setSampleHand() {
    hand.addCard(new PlayingCard(Rank.KING, Suit.HEARTS));
    hand.addCard(new PlayingCard(Rank.QUEEN, Suit.CLUBS));
    hand.addCard(new PlayingCard(Rank.SIX, Suit.SPADES));
    hand.addCard(new PlayingCard(Rank.TWO, Suit.DIAMONDS));
    hand.addCard(new PlayingCard(Rank.FOUR, Suit.HEARTS));
    hand.addCard(new PlayingCard(Rank.EIGHT, Suit.CLUBS));
    hand.addCard(new PlayingCard(Rank.ACE, Suit.SPADES));
    hand.addCard(new PlayingCard(Rank.NINE, Suit.DIAMONDS));
  }

  @Test
  void testDeckContains52Cards() {
    assertEquals(deck.numberOfCards(), 52,
        "The deck does not contain 52 cards, instead it has " + deck.numberOfCards());
  }

  @Test
  void testAddCard_TakeCardFromDeckAddToHand() {
    assertEquals(deck.numberOfCards(), 52,
        "The deck does not contain 52 cards, instead it has " + deck.numberOfCards());
    hand.addCard(deck.removeCard(new PlayingCard(Rank.ACE, Suit.SPADES)));
    assertEquals(deck.numberOfCards(), 51,
        "After removing a card, the deck should only have 51 cards.");
    assertEquals(hand.numberOfCards(), 1,
        "After receiving a card, the hand should have only one card.");
    assertTrue(hand.getCollection().contains(new PlayingCard(Rank.ACE, Suit.SPADES)));
    assertFalse(hand.getCollection().contains(new PlayingCard(Rank.NINE, Suit.CLUBS)));
  }

  @Test
  void testRemoveCard_ShouldNotContainEightOfDiamondsAfterItHasBeenRemoved() {
    hand.addCard(new PlayingCard(Rank.EIGHT, Suit.DIAMONDS));
    assertFalse(hand.getCollection().isEmpty());
    assertTrue(hand.getCollection().contains(new PlayingCard(Rank.EIGHT, Suit.DIAMONDS)));
  }

  @Test
  void testDisplayHand() {
    setRoyalFlush();
    assertFalse(hand.getCollection().isEmpty());
    assertEquals(hand.numberOfCards(), 5,
        "Hand should contain five cards, instead it has " + hand.numberOfCards());
  }

  @Test
  void testCalculateValue_RoyalFlushShouldBeWorth41Points() {
    setRoyalFlush();
    assertFalse(hand.getCollection().isEmpty());
    assertEquals(hand.numberOfCards(), 5,
        "Hand should contain five cards, instead it has " + hand.numberOfCards());
    // Ace = 1, King = 10, Queen = 10, Jack = 10, 10 = 10. HandValue should equal 41
    assertEquals(hand.calculateValue(), 41,
        "The value of the hand should be 41, instead it was " + hand.calculateValue());
  }

  @Test
  void testClearHand_ShouldBeEmtpyAfterAddingThenClearingHand() {
    setRoyalFlush();
    assertFalse(hand.getCollection().isEmpty());
    assertEquals(hand.numberOfCards(), 5,
        "Hand should contain five cards, instead it has " + hand.numberOfCards());
    hand.clearHand();
    assertTrue(hand.getCollection().isEmpty(),
        "After clearing the hand, it should be empty. However, it's not.");
  }

  @Test
  void testNumberOfCards_ShouldBeEqualTo5AfterAddingRoyalFlush() {
    setRoyalFlush();
    assertFalse(hand.getCollection().isEmpty());
    assertEquals(hand.numberOfCards(), 5,
        "Hand should contain five cards, instead it has " + hand.numberOfCards());
  }

  @Disabled
  @Test
  void testSortBySuit() {
    setSampleHand();
    assertFalse(hand.getCollection().isEmpty(), "The hand is empty, it should contain eight cards");
    assertEquals(hand.getCollection().size(), 8,
        "The hand could contain 8 cards, it has: " + hand.getCollection().size());
    System.out.println("\n------ Before SortBySuit -------");
    hand.displayHand();
    hand.sortBySuit();
    System.out.println("\n------ After SortBySuit [C,D,S,H] -------");
    hand.displayHand();
  }

  @Disabled
  @Test
  void testSortByColor() {
    setSampleHand();
    assertFalse(hand.getCollection().isEmpty(), "The hand is empty, it should contain eight cards");
    assertEquals(hand.getCollection().size(), 8,
        "The hand could contain 8 cards, it has: " + hand.getCollection().size());
    System.out.println("\n------ Before SortByColor -------");
    hand.displayHand();
    hand.sortByColor();
    System.out.println("\n------- After SortByColor [Red, Black] -------");
    hand.displayHand();
  }

  @Disabled
  @Test
  void testSortByRank() {
    setSampleHand();
    assertFalse(hand.getCollection().isEmpty(), "The hand is empty, it should contain eight cards");
    assertEquals(hand.getCollection().size(), 8,
        "The hand could contain 8 cards, it has: " + hand.getCollection().size());
    System.out.println("\n------ Before SortByRank -------");
    hand.displayHand();
    hand.sortByRank();
    System.out.println("\n------- After SortByRank [Ace -> King] -------");
    hand.displayHand();
  }

  @Disabled
  @Test
  void testSort() {
    setSampleHand();
    assertFalse(hand.getCollection().isEmpty(), "The hand is empty, it should contain eight cards");
    assertEquals(hand.getCollection().size(), 8,
        "The hand could contain 8 cards, it has: " + hand.getCollection().size());
    System.out.println("\n------ Before Sort -------");
    hand.displayHand();
    hand.sort();
    System.out.println("\n------- After Sort -------");
    hand.displayHand();
  }

}