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
import org.junit.jupiter.api.Test;

/**
 * @author Frijolie
 * @version 0.1
 * @since 0.1
 */
public class UnitTestDeck {

  TestDeck td;
  List<Card> deck;

  @BeforeEach
  void setUp() throws Exception {
    td = new TestDeck();
    deck = new ArrayList<>(td.getCollection());
  }

  @AfterEach
  void tearDown() throws Exception {
    td = null;
    deck.clear();
    deck = null;
  }

  @Test
  void testdeck_FullDeckShouldContain52Cards() {
    assertEquals(deck.size(), 52,
        "The deck without jokers does not have 52 cards, it has " + deck.size());
  }

  @Test
  void PlayingCardsLeft_AfterRemovingACardFromFullDeckShouldEqual51Cards() {
    td.removeCard(new PlayingCard(Rank.ACE, Suit.DIAMONDS));
    assertEquals(td.numberOfCards(), 51,
        "test deck does not have 51 cards it has: " + td.numberOfCards());
  }

  @Test
  void testIsShuffled_ShouldBeTrue() {
    td.shuffle();
    assertTrue(td.isShuffled());
  }

  @Test
  void testRemoveCard_AfterRemoveACardInDeckShouldNotBeContainedInDeck() {
    var fiveOfHearts = new PlayingCard(Rank.FIVE, Suit.HEARTS);
    td.removeCard(fiveOfHearts);
    deck.clear();
    deck.addAll(td.getCollection());
    assertFalse(deck.contains(fiveOfHearts),
        "The deck still contains the fiveOfHearts. This should not be true.");
  }

}