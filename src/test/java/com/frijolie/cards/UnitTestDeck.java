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

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class UnitTestDeck {

  Deck deck;
  Deck threeDecks;

  @BeforeEach
  void setUp() {
    deck = new Deck();
    threeDecks = new Deck(3);
  }

  @AfterEach
  void tearDown() {
    deck.clearDeck();
    threeDecks.clearDeck();
    deck = null;
    threeDecks = null;
  }

  @Test
  void testDeck_FullDeckShouldContain52Cards() {
    assertEquals(deck.numberOfCards(), 52,
        "The deck without jokers does not have 52 cards, it has " + deck.numberOfCards());
  }

  @Test
  void testDeck_ThreeDecksShouldContain156Cards() {
    assertEquals(threeDecks.numberOfCards(), 156,
        "3 decks without jokers does not have 156 (52x3) cards. It instead has: " + threeDecks
            .numberOfCards());
  }

  @Test
  void testDeck_AfterClearingDeckNumberOfCardsShouldBe0() {
    deck.clearDeck();
    assertEquals(deck.numberOfCards(), 0);
  }

  @Test
  void testDeck_FullDeckContainsAceOfDiamondsShouldBeTrue() {
    var aceOfDiamonds = new PlayingCard(Rank.ACE, Suit.DIAMONDS);
    assertTrue(deck.containsCard(aceOfDiamonds),
        "A full deck should contain a Ace of Diamonds");
  }

  @Test
  void testDeck_AfterRemovingCardFromFullDeckShouldNowEqual51Cards() {
    var aceOfDiamonds = new PlayingCard(Rank.ACE, Suit.DIAMONDS);
    assertTrue(deck.containsCard(aceOfDiamonds),
        "A full deck should contain a Ace of Diamonds");
    deck.removeCard(aceOfDiamonds);
    assertFalse(deck.containsCard(aceOfDiamonds),
        "After removing Ace of Diamonds, it should no longer be in the deck");
  }

  @Test
  void testDeck_AfterShufflingDeckIsShuffledShouldBeTrue() {
    deck.shuffle(3);
    assertTrue(deck.isShuffled(),
        "The deck should be shuffled, however it says: " + deck.isShuffled());
  }

  @Test
  void testRemoveCard_AfterRemoveACardInDeckShouldNotBeContainedInDeck() {
    var fiveOfHearts = new PlayingCard(Rank.FIVE, Suit.HEARTS);
    deck.removeCard(fiveOfHearts);
    assertFalse(deck.containsCard(fiveOfHearts),
        "The deck still contains the fiveOfHearts. This should not be true.");
  }

}