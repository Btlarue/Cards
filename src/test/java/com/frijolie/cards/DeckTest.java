package com.frijolie.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {

  private Deck deck;

  @BeforeEach
  void setUp() {
    deck = new Deck();
  }

  @AfterEach
  void tearDown() {
    deck = null;
  }

  @Test
  void testDefaultConstructor_SingleDeckShouldContain52Cards() {
    assertEquals(52, deck.getDeck().size(),
        "A single deck should contain exactly 52 cards. Instead it has: "
            + deck.getDeck().size());
  }

  @Test
  void testOverloadedConstructor_TwoDecksShouldContain104Cards() {
    Deck twoDecks = new Deck(2, false);
    assertEquals(104, twoDecks.getDeck().size(),
        "Two decks should contain exactly 104 cards. Instead it has: "
            + twoDecks.getDeck().size());
  }


}