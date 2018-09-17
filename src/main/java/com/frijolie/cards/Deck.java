package com.frijolie.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Deck represents a collection of {@link PlayingCard}s. A standard deck of playing cards contains
 * 52 cards. A deck is an enumeration of cards for every rank within every suit.
 * <p>
 * The default no-arg constructor will create a single deck of unshuffled cards. There is also an
 * overloaded constructor which allows the creation of multiple decks of cards and the ability to
 * shuffle the deck after instantiation.
 *
 * @author Frijolie
 * @version 0.1
 * @see {@link PlayingCard}
 */
public class Deck {

  /**
   * A List to contain all of the cards in the deck.
   */
  private final List<Card> deck;

  /**
   * Default zero-arg constructor. Will instantiate a single unshuffled deck of cards.
   */
  public Deck() {
    this(1, false);
  }

  /**
   * Overloaded constructor. Allows for multiple decks and the ability to have it shuffled after it
   * has been created.
   *
   * @param numOfDecks the number of decks to create
   * @param shuffled {@code true} if you wish to shuffle the deck
   */
  public Deck(int numOfDecks, boolean shuffled) {
    deck = new ArrayList<>();
    for (int i = 0; i < numOfDecks; i++) {
      populateDeck();
    }
    if (shuffled) {
      shuffle();
    }
  }

  /**
   * Populates the deck with one of every rank within every suit. Will add 52 unique cards to the
   * deck
   */
  private void populateDeck() {
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        deck.add(new PlayingCard(rank, suit));
      }
    }
  }

  /**
   * Returns an unmodifiable copy of the current deck of cards.
   * @return the current deck of cards.
   */
  public List<Card> getDeck() {
    return List.copyOf(deck);
  }

  /**
   * Shuffles the current deck of cards
   */
  private void shuffle() {
    Collections.shuffle(deck);
  }

}